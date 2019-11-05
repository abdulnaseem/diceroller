package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {
    //final EditText userInput = (EditText) findViewById(R.id.input); Used initially with the ArrayList method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final Button save = (Button) findViewById(R.id.save);// save button that returns to main page
        final Button cancel = (Button) findViewById(R.id.cancel);// cancel button that returns to main page

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainActivity();//method that returns back to he main page once the button is clicked
                //addNewDBreakers();method to store the users statement
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainActivity();//method that returns back to he main page once the button is clicked
            }
        });
    }

    public void mainActivity() {
        Intent intent2 = new Intent(this, MainActivity.class);
        //intent initialised to communicate with the two activities
        startActivity(intent2);//navigates the user to the next activity
    }

    /*
     *The method below was merely an experiment to test my own skills.
     *The ArrayList used as a record storage for each new statement saved.
     *This method was to be called upon through the save button.
     *However, I have yet to learn how to randomly display the messages stored
     *within the ArrayList

    public ArrayList<String> addNewDBreakers() {
        ArrayList<String> text = new <String>ArrayList();
        text.add(userInput.getText().toString());
        return text;
    }

     */

}
