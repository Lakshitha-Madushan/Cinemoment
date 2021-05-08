package com.example.cinemoment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void addPackage(View view){
        Intent i =new Intent(this, AddPackage.class);
        startActivity(i);
    }


    public void WeddingPackages(View view){
        Intent i =new Intent(this,PkList.class);
        startActivity(i);
    }

    public void HcPackages(View view){
        Intent i =new Intent(this,HcPkList.class);
        startActivity(i);
    }


}