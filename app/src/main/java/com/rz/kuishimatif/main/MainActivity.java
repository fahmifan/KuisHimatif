package com.rz.kuishimatif.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rz.kuishimatif.R;
import com.rz.kuishimatif.model.Question;
import com.rz.kuishimatif.repository.QuizRepo;
import com.rz.kuishimatif.repository.QuizRepoImpl;

public class MainActivity extends AppCompatActivity implements
        MainContract.View, View.OnClickListener {

    // Dependencies
    MainContract.Presenter presenter;
    QuizRepo quizRepo;

    TextView question;

    Button trueButton;
    Button falseButton;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizRepo =  new QuizRepoImpl();

        // we did a DI (dependency injection)
        // `this` is refer to implementor of MainContract.View
        presenter = new MainPresenter(this, quizRepo);

        //text view
        question = findViewById(R.id.question);
        presenter.showQuestion();

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
                presenter.checkAnswer(true);
                break;

            case R.id.false_button:
                presenter.checkAnswer(false);
                break;

            case R.id.next_button:
                presenter.showQuestion();
                break;
        }
    }

    @Override
    public void showQuestion(Question question) {
        this.question.setText(question.getTextResId());
    }

    @Override
    public void showAnswerResponse(boolean correct) {
        int msgID = correct ? R.string.correct_toast : R.string.incorrect_toast;

        Toast.makeText(MainActivity.this, msgID, Toast.LENGTH_SHORT).show();
    }
}
