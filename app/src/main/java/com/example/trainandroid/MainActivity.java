package com.example.trainandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText number1;
    EditText number2;
    TextView result;
    Button addButton;
    Button showButton;
    ImageView image;
    Button like_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        result = findViewById(R.id.result_View);
        addButton = findViewById(R.id.addButton);
        showButton = findViewById(R.id.show);
        image = findViewById(R.id.tanya);
        like_button = findViewById(R.id.like_button);

        showButton.setOnClickListener(new View.OnClickListener() {
            boolean showMode = false;
            @Override
            public void onClick(View v) {
                        if(showMode){
                            image.setVisibility(View.INVISIBLE);
                            like_button.setVisibility(View.INVISIBLE);
                            showButton.setText("Показать кису");
                            showMode=false;
                        } else {
                            image.setVisibility(View.VISIBLE);
                            showButton.setText("Спрятать кису");
                            like_button.setVisibility(View.VISIBLE);
                            showMode = true;
                        }
        }
    });
        addButton.setOnClickListener(v -> {
            if (number1.getText().toString().isEmpty()||number2.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "Введите числа",Toast.LENGTH_SHORT).show();
                return;
            }
            float numberOne = Float.parseFloat(number1.getText().toString());
            float numberTwo = Float.parseFloat(number2.getText().toString());
            float resultNumber = numberTwo+numberOne;
            result.setText(String.valueOf(resultNumber));
            Toast.makeText(MainActivity.this, "Результат: "+resultNumber, Toast.LENGTH_SHORT).show();
        });
        like_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfo("А что ты выберешь, а?","Погладишь киску?))", "Канешна",
                        "Ты хороший кожаный", "Нихотю чёта", "Ну и нинада..." );
            }
        });
    }
    private void showInfo(String title,String message, String positive, String posCon,
                          String negative,String negCon){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.setPositiveButton(positive, (dialog, which) -> Toast.makeText(MainActivity.this,posCon,Toast.LENGTH_LONG).show());
            builder.setNegativeButton(negative, (dialog, which) -> {
                Toast.makeText(MainActivity.this, negCon,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, sad_cat_activity.class);
                startActivity(intent);
            });
                    AlertDialog dialog = builder.create();
            dialog.show();
    }

}