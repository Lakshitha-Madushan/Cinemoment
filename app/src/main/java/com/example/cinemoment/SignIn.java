package com.example.cinemoment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password1);
        btnLogin = findViewById(R.id.btn2);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("lahiru@gmail.com") && password.getText().toString().equals("12345")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            SignIn.this
                    );
                    builder.setTitle("Log In Successfull");

                    builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                    Intent Intent = new Intent(SignIn.this, MyProfile.class);
                    startActivity(Intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid Username or Password" , Toast.LENGTH_SHORT).show();

                }

                }


        });



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