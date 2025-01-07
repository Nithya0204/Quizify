package com.example.quizify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion = QuestionAnswer.question.length;

    int currentQuestionIndex = 0;
    String selectedAnswer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionsTextView = findViewById(R.id.total_question2);
        questionTextView = findViewById(R.id.question2);
        ansA = findViewById(R.id.ans_A2);
        ansB = findViewById(R.id.ans_B2);
        ansC = findViewById(R.id.ans_C2);
        ansD = findViewById(R.id.ans_D2);
        submitBtn = findViewById(R.id.submit_btn2);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total Questions : "+totalQuestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View v) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) v;
        if (clickedButton.getId()==R.id.submit_btn2) {
            if (selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            //choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }


    }



    void loadNewQuestion(){

        if (currentQuestionIndex== totalQuestion){
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }

    void finishQuiz() {
        String passStatus = "";
        if (score > totalQuestion * 0.60) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }
        Intent intent=new Intent(getApplicationContext(),Level2_Quiz.class);
        intent.putExtra("score",score);


        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score +" out of "+ totalQuestion)
                .setNegativeButton("Quit",(dialogInterface,i) -> restartQuiz())
                .setPositiveButton("Next Level",((dialogInterface, i) -> startActivity(intent)))
                .setCancelable(false)
                .show();



    }


    void restartQuiz(){
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }

}