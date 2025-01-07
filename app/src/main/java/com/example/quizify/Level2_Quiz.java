package com.example.quizify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Level2_Quiz extends AppCompatActivity implements View.OnClickListener{
    TextView totalQuestionsTextView2;
    TextView questionTextView2;
    Button ansA2,ansB2,ansC2,ansD2;
    Button submitBtn2;

    int score=0;
    int totalQuestion2 = QuestionAnswer.questions2.length;

    int currentQuestionIndex2 = 0;
    String selectedAnswer2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2_quiz);
        totalQuestionsTextView2 = findViewById(R.id.total_question2);
        questionTextView2 = findViewById(R.id.question2);
        ansA2 = findViewById(R.id.ans_A2);
        ansB2= findViewById(R.id.ans_B2);
        ansC2 = findViewById(R.id.ans_C2);
        ansD2 = findViewById(R.id.ans_D2);
        submitBtn2 = findViewById(R.id.submit_btn2);

        ansA2.setOnClickListener(this);
        ansB2.setOnClickListener(this);
        ansC2.setOnClickListener(this);
        ansD2.setOnClickListener(this);
        submitBtn2.setOnClickListener(this);

        totalQuestionsTextView2.setText("Total Questions : "+totalQuestion2);

        loadNewQuestion2();
    }

    @Override
    public void onClick(View v) {

        ansA2.setBackgroundColor(Color.WHITE);
        ansB2.setBackgroundColor(Color.WHITE);
        ansC2.setBackgroundColor(Color.WHITE);
        ansD2.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn2) {
            if (selectedAnswer2.equals(QuestionAnswer.correctanswers2[currentQuestionIndex2])){
                score++;
            }
            currentQuestionIndex2++;
            loadNewQuestion2();


        }else{
            //choices button clicked
            selectedAnswer2 = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }


    }



    void loadNewQuestion2(){

        if (currentQuestionIndex2== totalQuestion2){
            finishQuiz2();
            return;
        }
        questionTextView2.setText(QuestionAnswer.questions2[currentQuestionIndex2]);
        ansA2.setText(QuestionAnswer.choices2[currentQuestionIndex2][0]);
        ansB2.setText(QuestionAnswer.choices2[currentQuestionIndex2][1]);
        ansC2.setText(QuestionAnswer.choices2[currentQuestionIndex2][2]);
        ansD2.setText(QuestionAnswer.choices2[currentQuestionIndex2][3]);
    }

    void finishQuiz2() {
        String passStatus = "";
        if (score > totalQuestion2 * 0.60) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }
        Intent intent2=new Intent(Level2_Quiz.this,Final_Score.class);


        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score +" out of "+ totalQuestion2)
                .setPositiveButton("Finish",((dialogInterface, i) -> startActivity(intent2)))
                .setCancelable(false)
                .show();



    }



}
