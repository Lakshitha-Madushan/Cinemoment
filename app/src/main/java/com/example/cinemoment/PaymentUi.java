package com.example.cinemoment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PaymentUi extends AppCompatActivity {

    TextView pName,pPrice,pAdvance;
    private DatabaseReference dbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_ui);

        pName = findViewById(R.id.pName);
        pPrice = findViewById(R.id.pPrice);
        pAdvance = findViewById(R.id.pAdvance);
        Button viewPD = findViewById(R.id.viewPD);

        dbRef = FirebaseDatabase.getInstance("https://cinemoment-8c5c9-default-rtdb.firebaseio.com/").getReference().child("Package");

        viewPD.setOnClickListener(v -> dbRef.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Package aPackage=dataSnapshot.getValue(Package.class);

                assert aPackage != null;
                pName.setText("Package:  "+aPackage.getPName());
                pPrice.setText("Price:  "+aPackage.getPPrice());
                pAdvance.setText("Advance:  "+aPackage.getPAdvance());



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }));
    }
}