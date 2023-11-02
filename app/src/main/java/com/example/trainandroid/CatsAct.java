package com.example.trainandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import android.widget.Toast;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CatsAct extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cats);

        hideSystemBtns();

        Button addBtn = findViewById(R.id.cats_act_add_btn);
        Button backBtn = findViewById(R.id.cats_act_home_btn);

        LinearLayout addLayout = findViewById(R.id.add_layout);
        Button confirmBtn = findViewById(R.id.confirm_btn);
        EditText nameEditText = findViewById(R.id.editName);

        ListView listView = findViewById(R.id.cats_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.cats_item, R.id.cats_item_name,getCatList());
        listView.setAdapter(adapter);

        updateView(listView);

        addBtn.setOnClickListener(v -> {
            listView.setVisibility(View.INVISIBLE);
            addLayout.setVisibility(View.VISIBLE);
            nameEditText.setText("");

        });
        confirmBtn.setOnClickListener(v -> {
            if (nameEditText.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "Введите имя", Toast.LENGTH_SHORT).show();
            } else {
                addContact(nameEditText.getText().toString());
                Toast.makeText(getApplicationContext(), "Контакт добавлен", Toast.LENGTH_SHORT).show();
                addLayout.setVisibility(View.INVISIBLE);
                listView.setVisibility(View.VISIBLE);
                updateView(listView);
            }
            hideSystemBtns();
        });
        backBtn.setOnClickListener(v -> {
            finish();
        });

    }

    private void hideSystemBtns() {
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private List<String> getCatList(){
        try {
            if (!new File(getApplicationContext().getFilesDir(), "cats_list").exists()){
                FileOutputStream out = openFileOutput("cats_list", MODE_PRIVATE);
                out.close();
            }
            FileInputStream dataFile = openFileInput("cats_list");
            BufferedReader reader = new BufferedReader(new InputStreamReader(dataFile));
            List<String> data = new ArrayList<>();
            while (reader.ready()){
                data.add(reader.readLine());
                }
            reader.close();
            dataFile.close();
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void addContact (String name){
        List<String> contacts = getCatList();
        contacts.add(name);
        contacts.sort(Comparator.naturalOrder());
        updateData(contacts);
    }
    private void updateData(List<String> data){
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter
                    (openFileOutput("cats_list",MODE_PRIVATE)));
            for (String line : data){
                writer.write(line+"\n");
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void updateView(ListView listView){
        listView.setAdapter(new CatItemAdapter(this, getCatList()));
    }
    private void deleteData(String... names){
        List<String> data = getCatList();
        for (String name : names){
            data.remove(name);
        }
        updateData(data);
        updateView(findViewById(R.id.cats_list));
    }
    public void getNameForDeleting(String name){
        this.deleteData(name);
    }
    @Override
    public void onBackPressed() {
        if (true){
        } else{
            super.onBackPressed();
        }

    }
}