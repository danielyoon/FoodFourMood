package com.danielyoon.foodfourmood;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionActivity extends AppCompatActivity {

    private Questions mQuestions = new Questions();

    private static int numOfReds = 0;
    private static int numOfBlues = 0;
    private static int numOfYellows = 0;
    private static int numOfWhites = 0;
    private static int questionNum = 0;
    private static int[] colors = new int[4];

    private String redValue = "#800000";
    private String blueValue = "#003366";
    private String yellowValue = "#ffff66";
    private String whiteValue = "#ffffff";

    private TextView question;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;


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

        final Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        answer1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if (mQuestions.getColor(answer1.getText().toString()).equals("r")) {
                    numOfReds++;
                    questionBackground.setBackground(changeBackground(redValue));
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer1.getText().toString()).equals("b")) {
                    numOfBlues++;
                    questionBackground.setBackground(changeBackground(blueValue));
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer1.getText().toString()).equals("y")) {
                    numOfYellows++;
                    questionBackground.setBackground(changeBackground(yellowValue));
                    colorChecker();
                    updateQuestion();
                } else {
                    numOfWhites++;
                    questionBackground.setBackground(changeBackground(whiteValue));
                    colorChecker();
                    updateQuestion();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if (mQuestions.getColor(answer2.getText().toString()).equals("r")) {
                    numOfReds++;
                    questionBackground.setBackground(changeBackground(redValue));
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer2.getText().toString()).equals("b")) {
                    numOfBlues++;
                    questionBackground.setBackground(changeBackground(blueValue));
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer2.getText().toString()).equals("y")) {
                    numOfYellows++;
                    questionBackground.setBackground(changeBackground(yellowValue));
                    colorChecker();
                    updateQuestion();
                } else {
                    numOfWhites++;
                    questionBackground.setBackground(changeBackground(whiteValue));
                    colorChecker();
                    updateQuestion();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if (mQuestions.getColor(answer3.getText().toString()).equals("r")) {
                    numOfReds++;
                    questionBackground.setBackground(changeBackground(redValue));
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer3.getText().toString()).equals("b")) {
                    numOfBlues++;
                    questionBackground.setBackground(changeBackground(blueValue));
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer3.getText().toString()).equals("y")) {
                    numOfYellows++;
                    questionBackground.setBackground(changeBackground(yellowValue));
                    colorChecker();
                    updateQuestion();
                } else {
                    numOfWhites++;
                    questionBackground.setBackground(changeBackground(whiteValue));
                    colorChecker();
                    updateQuestion();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if (mQuestions.getColor(answer4.getText().toString()).equals("r")) {
                    numOfReds++;
                    questionBackground.setBackground(changeBackground(redValue));
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer4.getText().toString()).equals("b")) {
                    numOfBlues++;
                    questionBackground.setBackground(changeBackground(blueValue));
                    colorChecker();
                    updateQuestion();
                } else if (mQuestions.getColor(answer4.getText().toString()).equals("y")) {
                    numOfYellows++;
                    questionBackground.setBackground(changeBackground(yellowValue));
                    colorChecker();
                    updateQuestion();
                } else {
                    numOfWhites++;
                    questionBackground.setBackground(changeBackground(whiteValue));
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

        ++questionNum;
        if (questionNum == 10) {
            startActivity(new Intent(QuestionActivity.this, MapsActivity.class));
        }
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

    public static String combineColors(String previousColor, String currentColor) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < 3; i++) {
            String sub1 = previousColor.substring(1 + 2 * i, 3 + 2 * i);
            String sub2 = currentColor.substring(1 + 2 * i, 3 + 2 * i);
            int v1 = Integer.parseInt(sub1, 16);
            int v2 = Integer.parseInt(sub2, 16);
            int v = (v1 + v2) / 2;
            String sub = String.format("%02X", v);
            sb.append(sub);
        }
        String result = sb.toString();
        return result;
    }

    public GradientDrawable changeBackground(String newColor) {
        if (questionNum == 0) {
            colors[0] = Color.parseColor(whiteValue);
            colors[1] = Color.parseColor(newColor);
            colors[2] = Color.parseColor(whiteValue);

            GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TR_BL, colors);

            return gd;
        } else {
            String hexColor = String.format("#%06X", (0xFFFFFF & colors[1]));
            colors[0] = Color.parseColor(newColor);
            colors[2] = colors[1];
            colors[1] = Color.parseColor(combineColors(hexColor, newColor));

            GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TR_BL, colors);

            return gd;
        }
    }
}
