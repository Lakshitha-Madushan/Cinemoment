package com.example.cinemoment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerFeedback extends AppCompatActivity {

    EditText txtfeedback;
    Button btnSubmit;
    DatabaseReference dbRef;
    CustomerCm cus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_feedback);

        txtfeedback = findViewById(R.id.editTextTextMultiLine);
        btnSubmit = findViewById(R.id.feedbackSubmit);

        cus = new CustomerCm();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance("https://cinemoment-32807-default-rtdb.firebaseio.com/").getReference().child("CustomerCm");

                    if (TextUtils.isEmpty(txtfeedback.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter your Feedback", Toast.LENGTH_SHORT).show();
                    else {
                        cus.setFeedback(txtfeedback.getText().toString().trim());
                        dbRef.push().setValue(cus);
                        Toast.makeText(getApplicationContext(), "Thank you for your Feedback", Toast.LENGTH_SHORT).show();
                        clearControls();

                    }


            }
            private void clearControls() {
                txtfeedback.setText("");
            }
        });


    }
}