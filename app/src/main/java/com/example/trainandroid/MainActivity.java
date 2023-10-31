package com.example.trainandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button showButton;
    private ImageView image;
    private Button like_button;
    private FrameLayout frameLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showButton = findViewById(R.id.show);
        image = findViewById(R.id.tanya);
        like_button = findViewById(R.id.like_button);
        frameLayout = findViewById(R.id.frameLayout);

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
        like_button.setOnClickListener(v -> showInfo("А что ты выберешь, а?","Погладишь киску?))", "Канешна",
                "Ты хороший кожаный", "Нихотю чёта", "Ну и нинада..." ));
        KissCatFrag kissCatFrag = new KissCatFrag();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), kissCatFrag);
        fragmentTransaction.commit();

    }
    private void showInfo(String title,String message, String positive, String posCon,
                          String negative,String negCon){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.setPositiveButton(positive, (dialog, which) -> Toast.makeText(MainActivity.this,posCon,Toast.LENGTH_LONG).show());
            builder.setNegativeButton(negative, (dialog, which) -> {
                Toast.makeText(MainActivity.this, negCon,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SadCatAct.class);
                startActivity(intent);
            });
                    AlertDialog dialog = builder.create();
            dialog.show();
    }

}