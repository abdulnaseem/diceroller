package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private int ran;//stores random numbers globally between 1-6
    //Activity2 saveText = new Activity2(); to be used to store users statements

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView cong = (TextView) findViewById(R.id.cong);//for every guess that's correct, display message
        final EditText pick = (EditText) findViewById(R.id.pick);//the user to type a number between 1-6
        final TextView ranNum = (TextView) findViewById(R.id.ranNum);//this displays the random dice numbers
        final TextView points = (TextView) findViewById(R.id.points);//increment points if user guesses correct number as the dice
        final Button button = (Button)findViewById(R.id.randGen);//random dice generator
        final Button Letsplay = (Button)findViewById(R.id.LetsPlay);//D-Breaker button that displays statements based on random dice generator
        final TextView message = (TextView)findViewById(R.id.message);//D-Breaker statements displayed
        final Button createNew = (Button)findViewById(R.id.createNew);//Navigate to activity2 class

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                rollTheDice();//random dice generator method called
                String roller = Integer.toString(ran);//random number generator for dice roll
                ranNum.setText("" + roller);//displays the random numbers

                String a = "Well Done!";
                String input = pick.getText().toString();//converts the users input to string

                if (input.equals(roller)) {
                    cong.setText(a);//displays string a

                    int countPoints = Integer.parseInt(points.getText().toString());//converts the TextView into an integer object
                    int addPoints = countPoints + 1;//increment the points by 1
                    points.setText("Points: " + addPoints );//display the points
                }
                else {
                    cong.setText(" ");//empty display
                }
            }
        });
        Letsplay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //saveText.addNewDBreakers();
                /*We test the ran variable condition in switch statement that has been initialised globally,
                 *the random numbers have been set a particular statement.
                 */
                switch(ran){
                    case 1: {
                        //displays the message on the message TextView
                        message.setText("If you could go anywhere in the world, where would you go?");
                        break;
                    }
                    case 2: {
                        message.setText("If you were stranded on a desert island, what three things would you want to take with you?");
                        break;
                    }
                    case 3: {
                        message.setText("If you could eat only one food for the rest of your life, what would that be?");
                        break;
                    }
                    case 4: {
                        message.setText("If you won a million dollars, what is the first thing you would buy?");
                        break;
                    }
                    case 5: {
                        message.setText("If you could spend the day with one fictional character, who would it be?");
                        break;
                    }
                    case 6: {
                        message.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
                        break;
                    }
                }
            }
        });
        createNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDBreaker();//method to navigate to activity2 on button click
            }
        });
    }
    public void addDBreaker(){
        Intent intent = new Intent(this, Activity2.class);//communicates with activity2
        startActivity(intent);//navigates the user to the next activity
    }
    public int rollTheDice(){
        Random random = new Random();//random number generator
        ran = random.nextInt((6-1)+1)+1;//maximum value of 6, minimum value of 1
        return ran;//returns value
    }

}
