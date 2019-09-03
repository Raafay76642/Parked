package com.example.parked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BookingMain extends AppCompatActivity {
String key,longi,lati;
TextView tbooknow,tnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_main);
        Intent intent= getIntent();
        key=intent.getStringExtra("key");
        longi=intent.getStringExtra("longi");
        lati=intent.getStringExtra("lati");
        tbooknow=findViewById(R.id.tbooknow);
        tbooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbooknow();
            }
        });
        tnv=findViewById(R.id.tnav);
        tnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_navigate();
            }
        });

    }
    public void openbooknow(){
        Intent intent= new Intent(this,BookNow.class);
        intent.putExtra("key",key);

        startActivity(intent);
    }
    public void open_navigate(){
        Intent intent= new Intent(this,Map.class);
        intent.putExtra("Parent_Activity","Booking");
        intent.putExtra("longi",longi);
        intent.putExtra("lati",lati);
        startActivity(intent);
    }
}
