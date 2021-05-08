package com.example.mydetails;

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

public class AddAppointment extends AppCompatActivity {

    EditText txtCpName, txtCpConNo, txtApDate, txtApTime, txtApReason, txtApNote;
    Button addApBtn;
    DatabaseReference dbRef;
    Appointment ap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);

        txtCpName = findViewById(R.id.cpName);
        txtCpConNo = findViewById(R.id.cpConNo);
        txtApDate = findViewById(R.id.apDate);
        txtApTime = findViewById(R.id.apTime);
        txtApReason = findViewById(R.id.apReason);
        txtApNote = findViewById(R.id.apNote);

        addApBtn = findViewById(R.id.addApBtn);

        ap = new Appointment();
    }


            public void addAppointment (View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Appointment");
                try{
                    if(TextUtils.isEmpty(txtCpName.getText().toString()))
                        Toast.makeText(getApplicationContext(),  "please enter Couple Name", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtCpConNo.getText().toString()))
                        Toast.makeText(getApplicationContext(),  "please enter Contact Number", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtApDate.getText().toString()))
                        Toast.makeText(getApplicationContext(),  "please enter Appointment Date", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtApTime.getText().toString()))
                        Toast.makeText(getApplicationContext(),  "please enter Time", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtApReason.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter Reason", Toast.LENGTH_SHORT).show();


                    else{
                        ap.setName(txtCpName.getText().toString().trim());
                        ap.setConNo(Integer.parseInt(txtCpConNo.getText().toString().trim()));
                        ap.setDate(txtApDate.getText().toString().trim());
                        ap.setTime(txtApTime.getText().toString().trim());
                        ap.setReason(txtApReason.getText().toString().trim());
                        ap.setNote(txtApNote.getText().toString().trim());

                        dbRef.push().setValue(ap);
                        Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                        clearControls();

                        Intent i =new Intent(this, AppointmentList.class);
                        startActivity(i);
                    }

                }
                catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Entry", Toast.LENGTH_SHORT).show();
                }
            }



    private void clearControls(){
        txtCpName.setText("");
        txtCpConNo.setText("");
        txtApDate.setText("");
        txtApTime.setText("");
        txtApReason.setText("");
        txtApNote.setText("");
    }



    public void MyAppointment(View view){
        Intent i =new Intent(this,MyAppointments.class);
        startActivity(i);
    }

}