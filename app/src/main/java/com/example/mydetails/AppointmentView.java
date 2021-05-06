package com.example.mydetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AppointmentView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_view);
    }
    public void EditAppointment(View view){
        Intent i =new Intent(this,EditAppoinment.class);
        startActivity(i);
    }
    public void addReminder(View view){
        Intent i =new Intent(this,addreminder.class);
        startActivity(i);
    }

}