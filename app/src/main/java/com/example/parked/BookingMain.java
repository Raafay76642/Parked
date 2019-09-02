package com.example.parked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BookingMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_main);
    }
    public void openbookings(View view){
        Intent intent= new Intent(this,NearBy.class);
        startActivity(intent);
    }
    public void open_nearby(View view){
        Intent intent= new Intent(this,NearBy.class);
        startActivity(intent);
    }
}
