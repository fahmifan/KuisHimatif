package com.rz.kuishimatif.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rz.kuishimatif.R;
import com.rz.kuishimatif.model.Question;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView question;

    Button trueButton;
    Button falseButton;
    Button nextButton;

    private int mCurrentIndex = 0;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.q_ketua_himatif, true),
            new Question(R.string.q_ketua_devcom, false),
            new Question(R.string.q_kaprodi, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //text view
        question = findViewById(R.id.question);
        int questionResId = mQuestionBank[mCurrentIndex].getTextResId();
        question.setText(questionResId);
        //button
        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        //listener
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.true_button:
                showToastMsg("BENAR!");
                break;

            case R.id.false_button:
                showToastMsg("SALAH DIG!");
                break;
        }
    }

    public void showToastMsg(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
