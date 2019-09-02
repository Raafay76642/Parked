package com.example.parked;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
EditText coname,coage,cln;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog mProgressBarsaving;
    DatabaseReference databaseprofile;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        coname=findViewById(R.id.co_name);
        coage=findViewById(R.id.co_age);
        cln=findViewById(R.id.cln);
        databaseprofile= FirebaseDatabase.getInstance().getReference();
        mProgressBarsaving = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        id = FirebaseAuth.getInstance().getCurrentUser().getUid();

        getdata();

    }

    public void logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        finish();
        openLogin();

    }
    public void updateProfile(View view){
        mProgressBarsaving.setMessage("Saving. . .!");
        mProgressBarsaving.show();
        databaseprofile=FirebaseDatabase.getInstance().getReference ("CUsers");
        id = FirebaseAuth.getInstance().getCurrentUser().getUid();
        String Coname=coname.getText().toString();
        String Coage=coage.getText().toString();
        String Cln=cln.getText().toString();
            Model_Class model_class = new Model_Class(Coname,Coage,Cln);
            databaseprofile.child(id).setValue(model_class).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    mProgressBarsaving.cancel();
                    final Toast toast = Toast.makeText(Profile.this, "Data is Saved", Toast.LENGTH_LONG);
                    toast.show();
                }
            });
//        databaseprofile.child(id).child("COname").setValue(Coname);
//        databaseprofile.child(id).child("COage").setValue(Coage);
//        databaseprofile.child(id).child("CLN").setValue(Cln);

    }
    public void getdata(){
        databaseprofile=databaseprofile.child("CUsers");
        databaseprofile.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()){
                Model_Class model_class=dataSnapshot.getValue(Model_Class.class);
                coname.setText(model_class.getCOname());
                cln.setText(model_class.getCLN());
                coage.setText(model_class.getCOage());
            }
            else {
                Toast.makeText(Profile.this, "Please update your Profile", Toast.LENGTH_SHORT).show();
            }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public  void openLogin()
    {
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }


}
