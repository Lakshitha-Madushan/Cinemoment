package com.example.cinemoment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddPackage extends AppCompatActivity {

    EditText pkName, pkDescription, pkAmount;
    Spinner pkType, noOfCam;
    RadioButton yes,no;
    RadioGroup droneGroup;
    DatabaseReference dbRef;
    Package pk;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_package);

        pkType = findViewById(R.id.pkType);
        pkName = findViewById(R.id.pkName);
        noOfCam = findViewById(R.id.noOfCam);
        yes = findViewById(R.id.droneYes);
        no = findViewById(R.id.droneNo);
        droneGroup = findViewById(R.id.droneGroup);
        pkDescription = findViewById(R.id.pkDescription);
        pkAmount = findViewById(R.id.pkAmount);

        pk = new Package();
    }



    public void insertPackage (View view){

        String d1 = yes.getText().toString();
        String d2 = no.getText().toString();

        dbRef = FirebaseDatabase.getInstance().getReference().child("Package");


        try {


            if(TextUtils.isEmpty(pkType.getSelectedItem().toString()))
                Toast.makeText(getApplicationContext(), "Please Select Package Type", Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(pkName.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter Package Name", Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(pkDescription.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter Package Details", Toast.LENGTH_SHORT).show();
            else if(TextUtils.isEmpty(pkAmount.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter Package Amount", Toast.LENGTH_SHORT).show();
            else {

                pk.setPkType(pkType.getSelectedItem().toString().trim());
                pk.setPkName(pkName.getText().toString().trim());
                pk.setNoOfCam(Integer.parseInt(noOfCam.getSelectedItem().toString().trim()));

                if (yes.isChecked()) {
                    pk.setDrone(d1);
                } else {
                    pk.setDrone(d2);
                }

                pk.setPkDescription(pkDescription.getText().toString().trim());
                pk.setPkAmount(Integer.parseInt(pkAmount.getText().toString().trim()));


                dbRef.push().setValue(pk);

                Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show();
                clearControls();


                    Intent i =new Intent(this,PkList.class);
                    startActivity(i);



            }
        }
        catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Invalid Amount",Toast.LENGTH_SHORT).show();
        }

    }

    private void clearControls() {

        pkType.setSelection(0);
        pkName.setText("");
        noOfCam.setSelection(0);
        yes.setChecked(false);
        no.setChecked(false);
        pkDescription.setText("");
        pkAmount.setText("");
    }



}