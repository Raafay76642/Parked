package com.example.parked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



}
    public void openvehicalInformation(View view)
    {
        Intent i = new Intent(this,VehicalsInformation.class);
        startActivity(i);
    }
    public void openprofile(View view)
    {
        Intent i = new Intent(this,Profile.class);
        startActivity(i);
    }
    public void openaboutapp(View view)
    {
        Intent i = new Intent(this,AboutApp.class);
        startActivity(i);
    }
    public void opennearlocation(View view)
    {
        Intent i = new Intent(this,Map.class);
        startActivity(i);
    }



}