package com.example.cinemoment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PaymentUi extends AppCompatActivity {

    ListView listView;
    FirebaseDatabase database;
    DatabaseReference dbRef;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Package aPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_ui);

        aPackage = new Package();
        listView = (ListView) findViewById(R.id.ListV);
        database = FirebaseDatabase.getInstance();
        dbRef = database.getReference();
        dbRef = database.getReference("Package");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.package_info,R.id.packageInfo,list);

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds: snapshot.getChildren())
                {
                    aPackage = ds.getValue(Package.class);
                    list.add(" Package: " +aPackage.getName().toString()+ " Price: " +aPackage.getPrice().toString()+ "Advance Percentage: " +aPackage.getAdvance().toString());


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}