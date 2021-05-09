package com.example.cinemoment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyBookingsUi extends AppCompatActivity {

    EditText inputSearch;
    RecyclerView recyclerView;
    FloatingActionButton floatingbtn;
    FirebaseRecyclerOptions<BookingModel> options;
    FirebaseRecyclerAdapter<BookingModel,MyViewHolder>adapter;
    DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);
        dbRef = FirebaseDatabase.getInstance("https://cinemoment-8c5c9-default-rtdb.firebaseio.com/").getReference().child("Booking");

        inputSearch = findViewById(R.id.inputSearch);
        recyclerView = findViewById(R.id.recyclerView);
        floatingbtn = findViewById(R.id.floatingbtn);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        floatingbtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),MainActivity.class)));

        LoadData();
    }

    private void LoadData() {
        options = new FirebaseRecyclerOptions.Builder<BookingModel>().setQuery(dbRef,BookingModel.class).build();
        adapter = new FirebaseRecyclerAdapter<BookingModel, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull BookingModel model) {
                holder.textView.setText(model.getDate());

            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);

                return new MyViewHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
}