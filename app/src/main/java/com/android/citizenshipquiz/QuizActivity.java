package com.android.citizenshipquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    // All Global Variables
    private final String FINAL_PLAYER_NAME = "PLAYER_NAME";
    private final String USER_SCORE = "SCORE";
    RadioButton solution1;
    RadioButton solution2;
    RadioButton solution3;
    RadioButton solution4;
    RadioButton solution5;
    CheckBox harvardCheckBox;
    CheckBox debtCheckBox;
    CheckBox deadliestCheckBox;
    CheckBox secretServiceCheckBox;
    EditText nameEditText;
    private int score;
    private String playerName;

    /**
     * Saves the user Input
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(FINAL_PLAYER_NAME, playerName);
    }

    /**
     * Restores the user Input
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        playerName = savedInstanceState.getString(FINAL_PLAYER_NAME);
    }

    /**
     * Stores all Questions CheckBoxes, RadioButton and Editable.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        solution1 = findViewById(R.id.radio1c);
        solution2 = findViewById(R.id.radio2c);
        solution3 = findViewById(R.id.radio3c);
        solution4 = findViewById(R.id.radio4b);
        solution5 = findViewById(R.id.radio5c);

        harvardCheckBox = findViewById(R.id.question_e1);
        debtCheckBox = findViewById(R.id.question_e2);
        deadliestCheckBox = findViewById(R.id.question_e3);
        secretServiceCheckBox = findViewById(R.id.question_e4);

        nameEditText = findViewById(R.id.donald_trump);
        initialStates();
    }

    /**
     * Method that stores Player Name.
     */
    private void initialStates() {
        playerName = getIntent().getStringExtra(FINAL_PLAYER_NAME);
    }

    /**
     * Submit the score of the quiz
     */
    public void submitScore(View view) {
        score = finalScore();

        if (score == 0) {
            Toast.makeText(this, getString(R.string.noAnswer), Toast.LENGTH_SHORT).show();

            return;
        }
        Intent intent = new Intent(this, resultsActivity.class);
        intent.putExtra(FINAL_PLAYER_NAME, playerName);
        intent.putExtra(USER_SCORE, score);
        startActivity(intent);
    }

    /**
     * Calculates the score of the quiz
     */
    private int finalScore() {
        score = 0;
        if (solution1.isChecked()) {
            score += 1;
        }
        if (solution2.isChecked()) {
            score += 1;
        }
        if (solution3.isChecked()) {
            score += 1;
        }
        if (solution4.isChecked()) {
            score += 1;
        }
        if (solution5.isChecked()) {
            score += 1;
        }
        if (harvardCheckBox.isChecked() && deadliestCheckBox.isChecked()) {
            score += 1;

        }
        if (nameEditText.getText().toString().equals("donald trump")) {
            score += 1;
        }
        return score;
    }
}


