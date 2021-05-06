package com.example.cinemoment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class PackageList<Firebase> extends AppCompatActivity {

    ArrayList<String> pkArrayList = new ArrayList<>();
    ListView pkListView;
    Firebase myFirebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_list);

    }
}