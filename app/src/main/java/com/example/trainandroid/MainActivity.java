package com.example.trainandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button showButton;
    private ImageView image;
    private Button like_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        showButton = findViewById(R.id.show);
        Button contactsButton = findViewById(R.id.contacts);
        image = findViewById(R.id.tanya);
        like_button = findViewById(R.id.like_button);
        FrameLayout frameLayout = findViewById(R.id.frameLayout);

        contactsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CatsAct.class);
            startActivity(intent);
        });

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
        like_button.setOnClickListener(v -> showInfo(
        ));
        KissCatFrag kissCatFrag = new KissCatFrag();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), kissCatFrag);
        fragmentTransaction.commit();

    }
    private void showInfo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("А что ты выберешь, а?");
            builder.setMessage("Погладишь киску?))");
            builder.setPositiveButton("Канешна", (dialog, which) -> Toast.makeText(MainActivity.this, "Ты хороший кожаный",Toast.LENGTH_LONG).show());
            builder.setNegativeButton("Нихотю чёта", (dialog, which) -> {
                Toast.makeText(MainActivity.this, "Ну и нинада...",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SadCatAct.class);
                startActivity(intent);
            });
                    AlertDialog dialog = builder.create();
            dialog.show();
    }

}