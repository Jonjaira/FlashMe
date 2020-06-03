package com.example.flashme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayAnswer extends AppCompatActivity {
    private static final String TAG = "DisplayAnswer";
    private static final String mypreference = "mypref";
    private static final String answer = "saveAnswer";

    private String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_answer);

        //Get the intent that started this activity
        Intent intent = getIntent();
        a = intent.getStringExtra(DisplayQuestion.ANSWER);

        //Capture the layout's TextView
        TextView pregunta = findViewById(R.id.displayAnswer);
        pregunta.setText(a);

        //Debug Logging
        Log.d(TAG, "=================================== Intent with " + a + " received");
    }

}
