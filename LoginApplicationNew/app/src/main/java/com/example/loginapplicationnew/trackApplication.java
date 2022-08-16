package com.example.loginapplicationnew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class trackApplication extends AppCompatActivity {


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
        databaseReference.orderByKey().limitToLast(1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    //key1 = dataSnapshot.getKey().toString();

                    String application_id = dataSnapshot.child("application_id").getValue(String.class);
                    String name = dataSnapshot.child("name").getValue(String.class);
                    String submit_status = dataSnapshot.child("application_status").getValue(String.class);
                    String submit_date = dataSnapshot.child("submit_date").getValue(String.class);

                    tvId.setText(application_id);
                    tvTrackName.setText(name);
                    tvStatus.setText(submit_status);
                    tvTrackSubmitDate.setText(submit_date);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}