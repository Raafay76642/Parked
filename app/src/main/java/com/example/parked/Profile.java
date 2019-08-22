package com.example.parked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

    }
    public void logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        finish();
        openLogin();

    }

    public  void openLogin()
    {
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }

}
