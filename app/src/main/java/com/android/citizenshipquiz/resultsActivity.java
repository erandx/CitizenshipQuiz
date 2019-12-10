package com.android.citizenshipquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class resultsActivity extends AppCompatActivity {
    // All Global Variables
    private final String USER_SCORE = "SCORE";
    private final String FINAL_PLAYER_NAME = "PLAYER_NAME";
    int score = 0;
    private String playerName;
    private TextView nameTextView;
    private TextView scoreTextView;
    private TextView outOfTextView;
    private int totalCorrectAnswers;

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
     * Creates the Final Score with User Input and displays it.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        playerName = intent.getStringExtra(FINAL_PLAYER_NAME);
        totalCorrectAnswers = intent.getIntExtra(USER_SCORE, 0);
        nameTextView = findViewById(R.id.textCongrats);
        scoreTextView = findViewById(R.id.theScore);
        outOfTextView = findViewById(R.id.outOf);
        finalOutput();
    }

    /**
     * Method that Congratulates and gives the user total score and how many question are right.
     */
    private void finalOutput() {
        String congrats = getString(R.string.congrats);
        nameTextView.setText(String.format(congrats, playerName));

        score = 0;
        if (totalCorrectAnswers > 0)
            score = totalCorrectAnswers * 10;
        scoreTextView.setText(score + "");

        outOfTextView.setText(String.format(getString(R.string.out_of), totalCorrectAnswers, 7));
    }

    /**
     * Connects the user to the Main activity
     */
    public void startNewGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}