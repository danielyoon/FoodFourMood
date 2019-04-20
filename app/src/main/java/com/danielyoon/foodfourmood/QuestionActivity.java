package com.danielyoon.foodfourmood;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionActivity extends AppCompatActivity {

    private Questions mQuestions = new Questions();

    public static int numOfReds = 0;
    public static int numOfBlues = 0;
    public static int numOfYellows = 0;
    public static int numOfWhites = 0;
    public static int questionNum = 0;

    private TextView question;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        question = findViewById(R.id.question);
        answer1 = findViewById(R.id.Q1);
        answer2 = findViewById(R.id.Q2);
        answer3 = findViewById(R.id.Q3);
        answer4 = findViewById(R.id.Q4);

        Typeface champagne = Typeface.createFromAsset(getAssets(), "Jua-Regular.ttf");
        answer1.setTypeface(champagne);
        answer2.setTypeface(champagne);
        answer3.setTypeface(champagne);
        answer4.setTypeface(champagne);

        updateQuestion();

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestions.getColor(answer1.getText().toString()).equals("r")) {
                    numOfReds++;
                    updateQuestion();
                } else if (mQuestions.getColor(answer1.getText().toString()).equals("b")) {
                    numOfBlues++;
                    updateQuestion();
                } else if (mQuestions.getColor(answer1.getText().toString()).equals("y")) {
                    numOfYellows++;
                    updateQuestion();
                } else {
                    numOfWhites++;
                    updateQuestion();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestions.getColor(answer2.getText().toString()).equals("r")) {
                    numOfReds++;
                    updateQuestion();
                } else if (mQuestions.getColor(answer2.getText().toString()).equals("b")) {
                    numOfBlues++;
                    updateQuestion();
                } else if (mQuestions.getColor(answer2.getText().toString()).equals("y")) {
                    numOfYellows++;
                    updateQuestion();
                } else {
                    numOfWhites++;
                    updateQuestion();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestions.getColor(answer3.getText().toString()).equals("r")) {
                    numOfReds++;
                    updateQuestion();
                } else if (mQuestions.getColor(answer3.getText().toString()).equals("b")) {
                    numOfBlues++;
                    updateQuestion();
                } else if (mQuestions.getColor(answer3.getText().toString()).equals("y")) {
                    numOfYellows++;
                    updateQuestion();
                } else {
                    numOfWhites++;
                    updateQuestion();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestions.getColor(answer4.getText().toString()).equals("r")) {
                    numOfReds++;
                    updateQuestion();
                } else if (mQuestions.getColor(answer4.getText().toString()).equals("b")) {
                    numOfBlues++;
                    updateQuestion();
                } else if (mQuestions.getColor(answer4.getText().toString()).equals("y")) {
                    numOfYellows++;
                    updateQuestion();
                } else {
                    numOfWhites++;
                    updateQuestion();
                }
            }
        });


    }

    public void updateQuestion() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            randomNumbers.add(i);
        }

        Collections.shuffle(randomNumbers);

        question.setText(mQuestions.getQuestion(questionNum));
        answer1.setText(mQuestions.getChoices(questionNum, randomNumbers.get(0)));
        answer2.setText(mQuestions.getChoices(questionNum, randomNumbers.get(1)));
        answer3.setText(mQuestions.getChoices(questionNum, randomNumbers.get(2)));
        answer4.setText(mQuestions.getChoices(questionNum, randomNumbers.get(3)));

        questionNum++;
    }
}
