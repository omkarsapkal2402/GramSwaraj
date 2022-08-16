package com.example.loginapplicationnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ApplicationViewOne extends AppCompatActivity {

    TextView viewappID,viewappSubmitDt,viewappName,viewappMother,viewappFather,viewappDob,viewappGender,viewappPlace,viewappTaluka,viewappDist;
    Button btnBack;

    FirebaseDatabase firebaseDatabase;

    // creating a variable for our
    // Database Reference for Firebase.
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_view_one);

        String key = getIntent().getStringExtra("key");

        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get
        // reference for our database.
        databaseReference = firebaseDatabase.getReference("applicants").child(key);

        viewappID = findViewById(R.id.viewappID);
        viewappSubmitDt = findViewById(R.id.viewappSubmitDt);
        viewappName = findViewById(R.id.viewappName);
        viewappMother = findViewById(R.id.viewappMother);
        viewappFather = findViewById(R.id.viewappFather);
        viewappDob = findViewById(R.id.viewappDob);
        viewappGender = findViewById(R.id.viewappGender);
        viewappPlace = findViewById(R.id.viewappPlace);
        viewappTaluka = findViewById(R.id.viewappTaluka);
        viewappDist = findViewById(R.id.viewappDist);

        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(ApplicationViewOne.this, ApplicationList.class);
                startActivity(i);
            }
        });

        getdata();
    }

    private void getdata() {

        // calling add value event listener method
        // for getting the values from database.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String application_id = snapshot.child("application_id").getValue(String.class);
                String submit_date = snapshot.child("submit_date").getValue(String.class);
                String name = snapshot.child("name").getValue(String.class);
                String mother_name = snapshot.child("mother_name").getValue(String.class);
                String father_name = snapshot.child("father_name").getValue(String.class);
                String dob = snapshot.child("dob").getValue(String.class);
                String gender = snapshot.child("gender").getValue(String.class);
                String village = snapshot.child("village").getValue(String.class);
                String taluka = snapshot.child("taluka").getValue(String.class);
                String district = snapshot.child("district").getValue(String.class);

                viewappID.setText(application_id);
                viewappSubmitDt.setText(submit_date);
                viewappName.setText(name);
                viewappMother.setText(mother_name);
                viewappFather.setText(father_name);
                viewappDob.setText(dob);
                viewappGender.setText(gender);
                viewappPlace.setText(village);
                viewappTaluka.setText(taluka);
                viewappDist.setText(district);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(ApplicationViewOne.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}