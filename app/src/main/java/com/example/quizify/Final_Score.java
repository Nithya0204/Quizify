package com.example.quizify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Final_Score extends AppCompatActivity {
    TextView textView,text;
    LottieAnimationView trohpyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        textView=findViewById(R.id.textView2);
        text=findViewById(R.id.textView3);
        trohpyc=findViewById(R.id.lottie);
        textView.animate().translationY(1400).setDuration(2700).setStartDelay(0);
        text.animate().translationY(1400).setDuration(2700).setStartDelay(0);
        trohpyc.animate().translationX(2000).setDuration(2000).setStartDelay(2900);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        },80000);
    }
}