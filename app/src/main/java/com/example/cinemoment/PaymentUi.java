package com.example.cinemoment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class PaymentUi extends AppCompatActivity {
    private static final int REQUEST_CODE_IMAGE =101 ;
    private ImageView imageViewAdd;
    private EditText inputName3;
    private TextView textViewProgress;
    private ProgressBar progressBar;
    private Button btnUpload;
    Uri imageUri;
    boolean isImageAdded = false;
    DatabaseReference dbRef;
    StorageReference storageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_ui);

        imageViewAdd = findViewById(R.id.imageViewAdd);
        inputName3 = findViewById(R.id.inputName3);
        textViewProgress = findViewById(R.id.textViewProgress);
        progressBar = findViewById(R.id.progressBar);
        btnUpload = findViewById(R.id.btnUpload);

        textViewProgress.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);

        dbRef = FirebaseDatabase.getInstance("https://cinemoment-8c5c9-default-rtdb.firebaseio.com/").getReference().child("Payment");
        storageRef = FirebaseStorage.getInstance("gs://cinemoment-8c5c9.appspot.com/").getReference().child("PaySlip");



        imageViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,REQUEST_CODE_IMAGE);
            }
        });
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String payer = inputName3.getText().toString();
                if (isImageAdded != false && payer != null)
                {
                    uploadImage(payer);
                }

            }
        });


    }

    private void uploadImage(final String payer) {
        textViewProgress.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        final String key = dbRef.push().getKey();
        storageRef.child(key+".jpg").putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                storageRef.child(key+".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("PayerName",payer);
                        hashMap.put("ImageUrl",uri.toString());

                        dbRef.child(key).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(PaymentUi.this, "Payment Method Successfully", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (taskSnapshot.getBytesTransferred()*100)/taskSnapshot.getTotalByteCount();
                progressBar.setProgress((int) progress);
                textViewProgress.setText(progress+" %");

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_IMAGE && data != null){
            imageUri = data.getData();
            isImageAdded = true;
            imageViewAdd.setImageURI(imageUri);
        }

    }
    public void successful(View view)
    {
        Intent i =new Intent(this,BookingSuccess.class);
        startActivity(i);
    }
}