package com.example.android.yellowstonequizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String typedText;
    int scoreQ1;
    int scoreQ2;
    int scoreQ3;
    int scoreQ4;
    int score;
    int clickCounterCalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void onRadioButtonQ1Click(View view) {
//        RadioButton geyser = (RadioButton) findViewById(R.id.geyser);
//        RadioButton supervolcano = (RadioButton) findViewById(R.id.supervolcano);
//        RadioButton mountain = (RadioButton) findViewById(R.id.mountain);
//        geyser.isClickable();
//        supervolcano.isClickable();
//        mountain.isClickable();
//    }

//    public void onCheckBoxQ2Click(View view) {
//        CheckBox wyoming = (CheckBox) findViewById(R.id.wyoming);
//        CheckBox idaho = (CheckBox) findViewById(R.id.idaho);
//        CheckBox montana = (CheckBox) findViewById(R.id.montana);
//        CheckBox colorado = (CheckBox) findViewById(R.id.colorado);
//        CheckBox utah = (CheckBox) findViewById(R.id.utah);
//        wyoming.isClickable();
//        idaho.isClickable();
//        montana.isClickable();
//        colorado.isClickable();
//        utah.isClickable();
//    }

//    public void onRadioButtonQ3Click(View view) {
//        RadioButton a1 = (RadioButton) findViewById(R.id.a1);
//        RadioButton a2 = (RadioButton) findViewById(R.id.a2);
//        RadioButton a3 = (RadioButton) findViewById(R.id.a3);
//        RadioButton a4 = (RadioButton) findViewById(R.id.a4);
//        RadioButton a5 = (RadioButton) findViewById(R.id.a5);
//        a1.isClickable();
//        a2.isClickable();
//        a3.isClickable();
//        a4.isClickable();
//        a5.isClickable();
//    }

    public void onScoreButtonClick(View view) {
        EditText employee = (EditText) findViewById(R.id.employee);
        typedText = employee.getText().toString();
        clickCounterCalculateButton++;

        //Q1
        RadioButton supervolcano = (RadioButton) findViewById(R.id.supervolcano);
        if (supervolcano.isChecked()) {
            scoreQ1 = 1;
        }

        //Q2
        CheckBox wyoming = (CheckBox) findViewById(R.id.wyoming);
        CheckBox idaho = (CheckBox) findViewById(R.id.idaho);
        CheckBox montana = (CheckBox) findViewById(R.id.montana);
        CheckBox colorado = (CheckBox) findViewById(R.id.colorado);
        CheckBox utah = (CheckBox) findViewById(R.id.utah);
        if (wyoming.isChecked() & idaho.isChecked() & montana.isChecked()) {
            scoreQ2 = 1;
            if (colorado.isChecked()) {
                scoreQ2 = 0;
            } else if (utah.isChecked()) {
                scoreQ2 = 0;
            }
        }

        //Q3
        RadioButton a4 = (RadioButton) findViewById(R.id.a4);
        if (a4.isChecked()) {
            scoreQ3 = 1;
        }

        //Q4
        if (typedText.toLowerCase().equals("ranger")) {
            scoreQ4 = 1;
        }

        score = scoreQ1 + scoreQ2 + scoreQ3 + scoreQ4;

        if (clickCounterCalculateButton == 1) {
            Toast.makeText(this, getString(R.string.toast_start) + String.valueOf(score) + getString(R.string.toast_end), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.too_many_clicks), Toast.LENGTH_LONG).show();
        }

    }

    public void onResetButtonClick(View view) {
        scoreQ1 = 0;
        scoreQ2 = 0;
        scoreQ3 = 0;
        scoreQ4 = 0;
        clickCounterCalculateButton = 0;
        score = 0;

        RadioGroup radioGroupOne = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroupOne.clearCheck();

        CheckBox wyoming = (CheckBox) findViewById(R.id.wyoming);
        wyoming.setChecked(false);

        CheckBox montana = (CheckBox) findViewById(R.id.montana);
        montana.setChecked(false);

        CheckBox idaho = (CheckBox) findViewById(R.id.idaho);
        idaho.setChecked(false);

        CheckBox utah = (CheckBox) findViewById(R.id.utah);
        utah.setChecked(false);

        CheckBox colorado = (CheckBox) findViewById(R.id.colorado);
        colorado.setChecked(false);

        RadioGroup radioGroupTwo = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroupTwo.clearCheck();

        EditText ranger = (EditText) findViewById(R.id.employee);
        ranger.getText().clear();
    }
}