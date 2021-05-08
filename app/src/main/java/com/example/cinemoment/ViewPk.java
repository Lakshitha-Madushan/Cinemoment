package com.example.cinemoment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


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

        dbRef = FirebaseDatabase.getInstance().getReference().child("Package");

        String PkKey = getIntent().getStringExtra("PkKey");

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

    }
}