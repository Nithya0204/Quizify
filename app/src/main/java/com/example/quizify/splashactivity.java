package com.example.quizify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class splashactivity extends AppCompatActivity {
    Button startq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);
        startq=findViewById(R.id.start_btn);
        startq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iHome = new Intent(splashactivity.this, MainActivity.class);
                startActivity(iHome);
            }
        });




    }
}