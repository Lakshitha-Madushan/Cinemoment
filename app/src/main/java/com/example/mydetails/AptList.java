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


public class AptList extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Appointment> options;
    FirebaseRecyclerAdapter<Appointment, AptViewHolder> adapter;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apt_list);

        dbRef = FirebaseDatabase.getInstance().getReference().child("Appointment");
        recyclerView = findViewById(R.id.aptRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

    LoadData();
}
        private void LoadData(){
        options = new FirebaseRecyclerOptions.Builder<Appointment>().setQuery(dbRef,Appointment.class).build();
        adapter = new FirebaseRecyclerAdapter<Appointment, AptViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull AptViewHolder holder, final int i, @NonNull Appointment model) {
                holder.textView.setText(model.getApDate());
                holder.v.setOnClickListener(new View.OnClickListener(){
              @Override
                    public void onClick(View v){
                     Intent intent = new Intent(AptList.this,AptView.class);
                     intent.putExtra("aptKey", getRef(i).getKey());
                     startActivity(intent);
              }
                });
            }

            @NonNull
            @Override
            public AptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_aptview,parent,false);

                return new AptViewHolder(v);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

}