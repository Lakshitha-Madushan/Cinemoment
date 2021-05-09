package com.example.cinemoment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuCm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void Sign(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
    public void Feedback(View view){
        Intent i = new Intent(this,CustomerFeedback.class);
        startActivity(i);

    }


   }

