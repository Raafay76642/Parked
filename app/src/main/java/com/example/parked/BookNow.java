package com.example.parked;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Dialog;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BookNow extends AppCompatActivity {

    Button makebooking;
    EditText hoursE;
    String key;
    DatabaseReference mref;
    FirebaseAuth firebaseAuth;
    String uid;
    String price;
    String hour;
    EditText estime;
    String stime;
    String pname,coname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);
        mref=FirebaseDatabase.getInstance().getReference();
        firebaseAuth=FirebaseAuth.getInstance();
        uid=firebaseAuth.getCurrentUser().getUid();
        hoursE = findViewById(R.id.H);
        estime=findViewById(R.id.estime);
        Intent intent= getIntent();
        key=intent.getStringExtra("key");
        getpname();
        getuname();
        makebooking = findViewById(R.id.makebooking);
        makebooking.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                final Dialog dialog = new Dialog(BookNow.this);
                dialog.setContentView(R.layout.billdialouge);
                Button dialogButton = (Button) dialog.findViewById(R.id.applydioloudefilter);
                TextView Bill = (TextView) dialog.findViewById(R.id.Bill);
                Double hour = Double.parseDouble(hoursE.getText().toString());

                 price= String.valueOf((hour *60)+50) ;
                Bill.setText(""+price);
                book();
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
    public void book(){
        mref=FirebaseDatabase.getInstance().getReference("Bookings");
        String bid=mref.push().getKey();
        hour=hoursE.getText().toString();
        stime=estime.getText().toString();
        Model_Booking model_booking= new Model_Booking(key,uid,price,hour,stime,bid,pname,coname);
        mref.child(bid).setValue(model_booking).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(BookNow.this, "Successfully Booked", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getpname(){
        mref=FirebaseDatabase.getInstance().getReference("Admin Parkings");
        mref.child(key).child("P_name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    pname=dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void getuname(){
        mref=FirebaseDatabase.getInstance().getReference("CUsers");
        mref.child(uid).child("coname").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    coname=dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}


