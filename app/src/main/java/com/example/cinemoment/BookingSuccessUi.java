package com.example.cinemoment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BookingSuccessUi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_success);
    }
    public void BookComplete(View view)
    {
        Intent intent = new Intent(BookingSuccessUi.this,MyBookingsUi.class);
        startActivity(intent);
    }
}