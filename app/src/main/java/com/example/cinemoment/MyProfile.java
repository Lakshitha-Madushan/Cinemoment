package com.example.cinemoment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyProfile extends AppCompatActivity {
    EditText txtfname, txtlname, txtemail, txtconNum;
    Button btnView;
    DatabaseReference dbRef;
    CustomerCm cus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);













    }



    public void Edit(View view) {
        Intent i = new Intent(this, UpdateProfile.class);
        startActivity(i);
    }

}