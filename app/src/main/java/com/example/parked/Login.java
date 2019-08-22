package com.example.parked;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText lEi ,lPassword ;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lEi = findViewById(R.id.loginEmail);
        lPassword = findViewById(R.id.LoginPassword);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        if(firebaseAuth.getCurrentUser() != null)
        {
            finish();
            openmain();

        }

    }
    public void opensignup(View view)
    {
        Intent i = new Intent(this,signup.class);
        startActivity(i);
    }
    public void openmain()
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void userLogin(View view)
    {
        String Email = lEi.getText().toString().trim();
        String Pass = lPassword.getText().toString().trim();
        if(TextUtils.isEmpty(Email))
        {
            //email is empty
            Toast.makeText(this,"Email Can't be left Blank",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(Pass))
        {
            //email is empty
            Toast.makeText(this,"Enter the Password",Toast.LENGTH_LONG).show();
            return;
        }
        //both the edit text are not empty
        progressDialog.setMessage("loging in ...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(Email,Pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    finish();
                    openmain();
                } else {

                    final String TAG = Login.class.getName();
                    Log.w(TAG, "signInWithEmail:failed", task.getException());
                    Toast.makeText(Login.this, "User Authentication Failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();

                }



            }
        });

    }
}
