package com.example.loginapplicationnew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class trackApplicationActivity extends AppCompatActivity{

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    EditText etTrackApplicationId;
    TextView tvId, tvStatus, tvTrackSubmitDate, tvTrackName;
    Button btnTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_application);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("applicants");

        etTrackApplicationId = findViewById(R.id.etTrackApplicationId);
        tvId = findViewById(R.id.tvId);
        tvStatus = findViewById(R.id.tvStatus);
        tvTrackSubmitDate = findViewById(R.id.tvTrackSubmitDate);
        tvTrackName = findViewById(R.id.tvTrackName);

        btnTrack = findViewById(R.id.btnTrack);

        btnTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                track();
            }
        });
    }

    public void track(){
        databaseReference.orderByChild("application_id").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Applicants applicants = snapshot.getValue(Applicants.class);
                if (applicants.application_id.equals(etTrackApplicationId.getText().toString())){
                    tvId.setText(applicants.application_id);
                    tvTrackName.setText(applicants.name);
                    tvStatus.setText(applicants.application_status);
                    tvTrackSubmitDate.setText(applicants.submit_date);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(trackApplicationActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}