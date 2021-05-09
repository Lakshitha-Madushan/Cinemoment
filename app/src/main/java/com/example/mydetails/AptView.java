package com.example.mydetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AptView extends AppCompatActivity {
    TextView textView;
    Button btnDelete;

    DatabaseReference dbRef,DataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apt_view);

        textView=findViewById(R.id.textView_single_aptview);
        btnDelete=findViewById(R.id.btnDelete);

        dbRef = FirebaseDatabase.getInstance().getReference().child("Appointment");

        String aptKey = getIntent().getStringExtra("aptKey");
        DataRef = FirebaseDatabase.getInstance().getReference().child("Appointment").child(aptKey);

        dbRef.child(aptKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    String apDate = dataSnapshot.child("apDate").getValue().toString();

                    textView.setText(apDate);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataRef.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Successfully Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), AptList.class));
                    }

                });
            }
        });
    }


}