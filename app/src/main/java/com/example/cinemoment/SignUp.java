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

public class SignUp extends AppCompatActivity {

    EditText txtfname, txtlname, txtemail, txtpassword, txtconNum;
    Button btnReg;
    DatabaseReference dbRef;
    CustomerCm cus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtfname = findViewById(R.id.fname);
        txtlname = findViewById(R.id.lname);
        txtconNum = findViewById(R.id.num);
        txtemail  = findViewById(R.id.email4);
        txtpassword = findViewById(R.id.password);

        btnReg = findViewById(R.id.btnReg);

        cus = new CustomerCm();



        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                dbRef = FirebaseDatabase.getInstance("https://cinemoment-32807-default-rtdb.firebaseio.com/").getReference().child("CustomerCm");
                try{
                    if (TextUtils.isEmpty(txtfname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter First Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtlname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Last Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtconNum.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Contact Number", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtemail.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter An Valid Email", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtpassword.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_SHORT).show();
                    else{
                        //take inputs from the user and assigning
                        cus.setFname(txtfname.getText().toString().trim());
                        cus.setLname(txtlname.getText().toString().trim());
                        cus.setConNum(Integer.parseInt(txtconNum.getText().toString().trim()));
                        cus.setEmail(txtemail.getText().toString().trim());
                        cus.setPassword(txtpassword.getText().toString().trim());

                        dbRef.push().setValue(cus);
                        Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                        clearControls();

                        Intent Intent = new Intent(SignUp.this, SignIn.class);
                        startActivity(Intent);

                    }
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                }

            }
            private void clearControls(){
                txtfname.setText("");
                txtlname.setText("");
                txtemail.setText("");
                txtpassword.setText("");
                txtconNum.setText("");
            }


        });
    }






}