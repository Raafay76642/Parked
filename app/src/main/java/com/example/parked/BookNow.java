package com.example.parked;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Dialog;

public class BookNow extends AppCompatActivity {

    Button makebooking;
    EditText hoursE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);
        hoursE = findViewById(R.id.H);

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
                double price = (hour *60)+50 ;
                Bill.setText(""+price);
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
}


