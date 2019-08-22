package com.example.parked;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AboutApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        TextView aboutapp = findViewById(R.id.aboutapp);
        String i ="Finding a place to park the car has always been a risky business and difficult to find and after parking the vehicle people also forget at some piont where they parked the car accoding to to a website confused .com almost 56 % of the drivers at some piont forget where they park their car that can be very irritating and also can cost u money as well.To resolve the problem we are going to make an andriod app that will help the user to find the parking place on the google map  select the nearest parking place available and then chose a free parking slot to park his car and then book the slot in advane so later in the specific time he can park his vehicle.";
        aboutapp.setText(i);

    }

}
