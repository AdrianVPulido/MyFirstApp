package com.example.adria.ftapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonAll; // We declare all buttons
    Button buttonOne;
    Button buttonID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAll = (Button) findViewById(R.id.buttonAll); //We look for the Button for its id
        buttonAll.setOnClickListener(new View.OnClickListener() { // We put a listener
            @Override
            public void onClick(View view) {
                AllView(); //We send it to the method
            }
        });


        buttonOne = (Button) findViewById(R.id.buttonOne); //We look for the Button for its id
        buttonOne.setOnClickListener(new View.OnClickListener() { // Le ponemos un listener
            @Override
            public void onClick(View view) {
                one(); // We send it to the method
            }
        });

        buttonID = (Button) findViewById(R.id.buttonID); //We look for the Button for its id
        buttonID.setOnClickListener(new View.OnClickListener() { // Le ponemos un listener
            @Override
            public void onClick(View view) {
                ViewID(); // We send it to the method
            }
        });
    }


    private void AllView() {
        Intent intent = new Intent(getApplicationContext(), AllActivity.class);
        startActivity(intent);
    }

    private void one() {
        Intent intent2 = new Intent(getApplicationContext(), OneActivity.class);
        startActivity(intent2);
    }

    private void ViewID() {
        Intent intent3 = new Intent(getApplicationContext(), IDActivity.class);
        startActivity(intent3);
    }

    }
