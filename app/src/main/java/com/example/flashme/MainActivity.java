package com.example.flashme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String QUESTION = "com.example.flashme.QUESTION";
    public static final String ANSWER = "com.example.flashme.ANSWER";
    private static final String TAG = "MainActivity";
    private static final String mypreference = "mypref";
    private static final String question = "saveQuestion";
    private static final String answer = "saveAnswer";

    private String q;
    private String a;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Called when the user taps on the Display Scripture button
    public void displayCard(View view){
        //Convert the text from the Plain Text box to a String
        EditText ans = (EditText) findViewById(R.id.answer1);
        EditText ques = (EditText) findViewById(R.id.question1); //Place this line in another activity to show "the back of the card" or answer

        //Display a Debug Logging message
        Log.d(TAG, "========================= About to create intent with the question");

        //Create intent
        Intent intent = new Intent (this, DisplayQuestion.class);
        intent.putExtra(ANSWER, ans.getText().toString());
        intent.putExtra(QUESTION, ques.getText().toString());

        startActivity(intent);
    }


    //Save in the Shared Preferences file
    public void saveCard(View view) {
        SharedPreferences sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(question, q);
        editor.putString(answer, a);
        editor.commit();

        //Create a Toast
        Toast toast = Toast.makeText(getApplicationContext(), "Card Saved Successfully",
                Toast.LENGTH_SHORT);
        toast.show();
    }

}
