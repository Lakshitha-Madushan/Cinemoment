package com.example.cinemoment;

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

public class ViewPk extends AppCompatActivity {

    TextView txtPkType;
    TextView txtPkName;
    TextView txtPkDescription;
    TextView txtPkAmount;
    TextView txtNoOfCam;
    TextView txtDrone;
    Button pkDeleteBtn;

    DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pk);

        txtPkType = findViewById(R.id.textViewPkType);
        txtPkName = findViewById(R.id.textViewPkName);
        txtPkDescription = findViewById(R.id.textViewPkDescription);
        txtPkAmount = findViewById(R.id.textViewPkAmount);
        txtNoOfCam = findViewById(R.id.textViewNoOfCam);
        txtDrone = findViewById(R.id.textViewDrone);
        pkDeleteBtn = findViewById(R.id.pkDeleteBtn);

        dbRef = FirebaseDatabase.getInstance().getReference().child("Package");

        String PkKey = getIntent().getStringExtra("PkKey");
        dbRef = FirebaseDatabase.getInstance().getReference().child("Package").child(PkKey);

        dbRef.child(PkKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {
                    String pkType =dataSnapshot.child("pkType").getValue().toString();
                    String pkName =dataSnapshot.child("pkName").getValue().toString();
                    String pkDescription=dataSnapshot.child("pkDescription").getValue().toString();
                    String pkAmount =dataSnapshot.child("pkAmount").getValue().toString();
                    String noOfCam =dataSnapshot.child("noOfCam").getValue().toString();
                    String drone =dataSnapshot.child("drone").getValue().toString();

                    txtPkType.setText(pkType);
                    txtPkName.setText(pkName);
                    txtPkDescription.setText(pkDescription);
                    txtPkAmount.setText(pkAmount);
                    txtNoOfCam.setText(noOfCam);
                    txtDrone.setText(drone);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        pkDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbRef.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Successfully Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),PkList.class));

                    }
                });
            }
        });

    }
}