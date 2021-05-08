package com.example.cinemoment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PkList extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton floatingbtnpk;
    FirebaseRecyclerOptions<Package> options;
    FirebaseRecyclerAdapter<Package,PkViewHolder> adapter;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pk_list);

        dbRef = FirebaseDatabase.getInstance().getReference().child("Package");
        recyclerView = findViewById(R.id.pkRecyclerView);
        floatingbtnpk = findViewById(R.id.floatingbtnpk);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        floatingbtnpk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddPackage.class));
            }
        });

        LoadData();

    }

    private void LoadData() {
        options = new FirebaseRecyclerOptions.Builder<Package>().setQuery(dbRef,Package.class).build();
        adapter = new FirebaseRecyclerAdapter<Package, PkViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull PkViewHolder holder, final int i, @NonNull Package model) {
                holder.textView.setText(model.getPkName());
                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PkList.this,ViewPk.class);
                        intent.putExtra("PkKey",getRef(i).getKey());
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public PkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);
                return new PkViewHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

}