package com.example.trainandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Experimental extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experimental);
        Button back = findViewById(R.id.back_btn);
        FragmentContainerView containerView = findViewById(R.id.fragmentContainerView);
        back.setOnClickListener(v -> finish());
    }
}