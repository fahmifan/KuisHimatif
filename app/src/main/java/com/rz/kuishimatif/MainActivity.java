package com.rz.kuishimatif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView question;
    Button trueButton;
    Button falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = (TextView) findViewById(R.id.question);
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
//        trueButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "BENAR!", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        falseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "SALAH DIG!", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.true_button:
                Toast.makeText(MainActivity.this, "BENAR!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.false_button:
                Toast.makeText(MainActivity.this, "SALAH DIG!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
