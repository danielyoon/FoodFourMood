package com.danielyoon.foodfourmood;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionActivity extends AppCompatActivity {

    private Questions mQuestions = new Questions();

    public static int numOfReds = 0;
    public static int numOfBlues = 0;
    public static int numOfYellows = 0;
    public static int numOfWhites = 0;
    public static int questionNum = 0;

    private String redValue = "##ff4747";
    private String blueValue = "#0471ff";
    private String yellowValue = "#fff943";
    private String whiteValue = "#ffffff";

    private TextView question;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;

    XMLReader changeColors = new XMLReader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        final ConstraintLayout questionBackground = findViewById(R.id.activity_question);

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
                    changeColors.editColors(redValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer1.getText().toString()).equals("b")) {
                    numOfBlues++;
                    changeColors.editColors(blueValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer1.getText().toString()).equals("y")) {
                    numOfYellows++;
                    changeColors.editColors(yellowValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                } else {
                    numOfWhites++;
                    changeColors.editColors(whiteValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestions.getColor(answer2.getText().toString()).equals("r")) {
                    numOfReds++;
                    changeColors.editColors(redValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer2.getText().toString()).equals("b")) {
                    numOfBlues++;
                    changeColors.editColors(blueValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer2.getText().toString()).equals("y")) {
                    numOfYellows++;
                    changeColors.editColors(yellowValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                } else {
                    numOfWhites++;
                    changeColors.editColors(whiteValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestions.getColor(answer3.getText().toString()).equals("r")) {
                    numOfReds++;
                    changeColors.editColors(redValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer3.getText().toString()).equals("b")) {
                    numOfBlues++;
                    changeColors.editColors(blueValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer3.getText().toString()).equals("y")) {
                    numOfYellows++;
                    changeColors.editColors(yellowValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                } else {
                    numOfWhites++;
                    changeColors.editColors(whiteValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestions.getColor(answer4.getText().toString()).equals("r")) {
                    numOfReds++;
                    changeColors.editColors(redValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer4.getText().toString()).equals("b")) {
                    numOfBlues++;
                    changeColors.editColors(blueValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer4.getText().toString()).equals("y")) {
                    numOfYellows++;
                    changeColors.editColors(yellowValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
                    updateQuestion();
                } else {
                    numOfWhites++;
                    changeColors.editColors(whiteValue);
                    questionBackground.setBackgroundResource(R.drawable.gradient_background);
                    colorChecker();
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

    public void colorChecker() {
        if (numOfBlues == 7 || numOfYellows == 7 || numOfWhites == 7 || numOfReds == 7) {
            startActivity(new Intent(QuestionActivity.this, MapsActivity.class));
        } else if (numOfReds + numOfWhites + numOfYellows + numOfBlues == 10) {
            startActivity(new Intent(QuestionActivity.this, MapsActivity.class));
        } else {
            return;
        }
    }
}
