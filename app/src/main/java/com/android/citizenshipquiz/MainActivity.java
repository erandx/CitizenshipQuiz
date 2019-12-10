package com.android.citizenshipquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // All Global Variables
    private final String FINAL_PLAYER_NAME = "PLAYER_NAME";
    private EditText userEditText;
    private String playerName;

    /**
     * Saves the user Input
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(FINAL_PLAYER_NAME, userEditText.getText().toString());
    }

    /**
     * Restores the user Input
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        playerName = savedInstanceState.getString(FINAL_PLAYER_NAME);
        userEditText.setText(playerName);
    }

    /**
     * Creates User Name
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialStates();
    }

    /**
     * Method to findViewById
     */
    private void initialStates() {
        userEditText = findViewById(R.id.name);

    }

    /**
     * Gets User Name and starts Quiz Activity
     */
    public void start(View view) {
        boolean valid = true;
        playerName = userEditText.getText().toString();
        if (valid) {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            intent.putExtra(FINAL_PLAYER_NAME, playerName);
            startActivity(intent);

        } else if (playerName.equals("")) {
            valid = false;
            Toast.makeText(this, R.string.emptyName, Toast.LENGTH_SHORT).show();
        }
    }

}