package com.example.cinemoment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }
    public void Register(View view) {
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }
    public void LogIn(View view) {
        Intent i = new Intent(this, MyProfile.class);
        startActivity(i);
    }

    }