package com.example.loginapplicationnew;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewApplicationId extends AppCompatActivity {

    // creating a variable for
    // our Firebase Database.
    FirebaseDatabase firebaseDatabase;

    public  String id_key;
    String application_id, submit_date;

    // creating a variable for our
    // Database Reference for Firebase.
    DatabaseReference databaseReference;

    // variable for Text view.
    private TextView retrieveTV1, retrieveTV2;
    Button btnBackHomeScr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_application_id);

        id_key = getIntent().getStringExtra("key");

        // below line is used to get the instance
        // of our Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get
        // reference for our database.
        databaseReference = firebaseDatabase.getReference("applicants").child(id_key);

        // initializing our object class variable.
        retrieveTV1 = findViewById(R.id.tvApplicationId);
        retrieveTV2 = findViewById(R.id.tvSubmitDate);
        btnBackHomeScr = findViewById(R.id.btnBackHomeScr);

        btnBackHomeScr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(ViewApplicationId.this, MainActivity.class);
                i.putExtra("key",id_key);
                startActivity(i);
            }
        });

        // calling method
        // for getting data.
        getdata();
    }

    private void getdata() {

        // calling add value event listener method
        // for getting the values from database.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                application_id = snapshot.child("application_id").getValue(String.class);
                submit_date = snapshot.child("submit_date").getValue(String.class);
                // after getting the value we are setting
                // our value to our text view in below line.
                retrieveTV1.setText(application_id);
                retrieveTV2.setText(submit_date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(ViewApplicationId.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        return;
    }
}