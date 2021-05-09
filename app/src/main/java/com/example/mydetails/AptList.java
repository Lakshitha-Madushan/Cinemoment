package com.example.mydetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import AptView.AptView;

public class AptList extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Appointment> options;
    FirebaseRecyclerAdapter<Appointment, AptView> adapter;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apt_list);

        dbRef = FirebaseDatabase.getInstance().getReference().child("Appointment");
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        startActivity(new Intent(getApplicationContext().Addappointments).class));

    });

    LoadData()
        private void LoadData(){

        options = new FirebaseRecyclerOptions.Builder<Appointment>().setQuery(Dataref,Appointment).build();
        adapter = new FirebaseRecyclerAdapter<Appointment, AptView>(options) {
            @Override
            protected void onBindViewHolder(@NonNull AptView aptView, int i, @NonNull Appointment appointment) {
                holder.textView.setText(model.getAppointmentDate);

            }

            @NonNull
            @Override
            public AptView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_aptview,parent,false);

                return new AptView(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

}