package com.example.flashme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DisplayQuestion extends AppCompatActivity {
    private static final String TAG = "DisplayQuestion";
    public static final String ANSWER = "com.example.flashme.ANSWER2";
    private static final String mypreference = "mypref";
    private static final String question = "saveQuestion";
    private static final String answer = "saveAnswer";
    Intent _intent;
    private String q;
    private String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_question);

        //Get the intent that started this activity
        _intent = getIntent();
        q = _intent.getStringExtra(MainActivity.QUESTION);

        //Capture the layout's TextView
        TextView pregunta = findViewById(R.id.displayQuestion);
        pregunta.setText(q);

        //Debug Logging
        Log.d(TAG, "=================================== Intent with " + q + " received");
    }
    //Called when the user taps on the Display Scripture button
    public void displayAnswer(View view){
        a = _intent.getStringExtra(MainActivity.ANSWER);

        //Display a Debug Logging message
        Log.d(TAG, "========================= About to create intent with the question");

        //Create intent
        Intent intent = new Intent (this, DisplayAnswer.class);
        intent.putExtra(ANSWER, a);

        startActivity(intent);
    }

}
