package com.example.parked;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Mainparkingpin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainparkingpin);
    }
    public void openparkingpin(View view)
    {
        Intent i = new Intent(this,ParkingPin.class);
        startActivity(i);
    }
    public void openfindmycar(View view)
    {
        String ParentActivity = "ParkingPin";
        Intent intent = new Intent(this, Map.class);
        intent.putExtra("Parent_Activity", ParentActivity);
        startActivity(intent);
    }
}
