package com.example.cinemoment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewBookingActivity extends AppCompatActivity {
    TextView textView,textView2,textView3,textView4,textView5,textView6,textView7;
    Button btnDelete;

    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booking);

        textView = findViewById(R.id.textView_single_view_activity);
        textView2 = findViewById(R.id.textView_single_view_activity2);
        textView3 = findViewById(R.id.textView_single_view_activity3);
        textView4 = findViewById(R.id.textView_single_view_activity4);
        textView5 = findViewById(R.id.textView_single_view_activity5);
        textView6 = findViewById(R.id.textView_single_view_activity6);
        textView7 = findViewById(R.id.textView_single_view_activity7);
        btnDelete = findViewById(R.id.btnDelete);
        String BookingKey = getIntent().getStringExtra("BookingKey");
        dbRef = FirebaseDatabase.getInstance("https://cinemoment-8c5c9-default-rtdb.firebaseio.com/").getReference().child("Booking");

        dbRef.child(BookingKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String grmName = dataSnapshot.child("grmName").getValue().toString();
                String brdName = dataSnapshot.child("brdName").getValue().toString();
                String contact = dataSnapshot.child("contact").getValue().toString();
                String date = dataSnapshot.child("date").getValue().toString();
                String time = dataSnapshot.child("time").getValue().toString();
                String address = dataSnapshot.child("address").getValue().toString();
                String agenda = dataSnapshot.child("agenda").getValue().toString();

                textView.setText(grmName);
                textView2.setText(brdName);
                textView3.setText(contact);
                textView4.setText(date);
                textView5.setText(time);
                textView6.setText(address);
                textView7.setText(agenda);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}