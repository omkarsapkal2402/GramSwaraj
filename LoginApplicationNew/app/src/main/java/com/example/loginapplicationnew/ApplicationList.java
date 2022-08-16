package com.example.loginapplicationnew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ApplicationList extends AppCompatActivity {

    // creating a variable for
    // our Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our
    // Database Reference for Firebase.
    DatabaseReference databaseReference1;
    DatabaseReference databaseReference2;
    DatabaseReference databaseReference3;


    // variable for Text view.
    private TextView RetrieveappID1,RetrieveappName1,RetrievesubmitDate1,RetrieveappID2,RetrieveappName2,RetrievesubmitDate2,RetrieveappID3,RetrieveappName3,RetrievesubmitDate3;
    Button btnApprove1, btnApprove2, btnApprove3;
    Button btnView1, btnView2, btnView3;
    Button btnReject1,btnReject2,btnReject3;

    String key1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_list);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference1 = firebaseDatabase.getReference("applicants").child("-N7eS_U4pk77d8zKlqwf");
        databaseReference2 = firebaseDatabase.getReference("applicants").child("-N5Y90KYAm0pSj3pHNHl");
        databaseReference3 = firebaseDatabase.getReference("applicants").child("-N5Vmpt5Miw1Tth3EYtu");

        RetrieveappID1 = findViewById(R.id.RetrieveappID1);
        RetrieveappName1 = findViewById(R.id.RetrieveappName1);
        RetrievesubmitDate1 = findViewById(R.id.RetrievesubmitDate1);

        RetrieveappID2 = findViewById(R.id.RetrieveappID2);
        RetrieveappName2 = findViewById(R.id.RetrieveappName2);
        RetrievesubmitDate2 = findViewById(R.id.RetrievesubmitDate2);


        RetrieveappID3 = findViewById(R.id.RetrieveappID3);
        RetrieveappName3 = findViewById(R.id.RetrieveappName3);
        RetrievesubmitDate3 = findViewById(R.id.RetrievesubmitDate3);

        btnApprove1 = findViewById(R.id.btnApprove1);
        btnApprove2 = findViewById(R.id.btnApprove2);
        btnApprove3 = findViewById(R.id.btnApprove3);

        btnView1 = findViewById(R.id.btnView1);
        btnView2 = findViewById(R.id.btnView2);
        btnView3 = findViewById(R.id.btnView3);

        btnReject1 = findViewById(R.id.btnReject1);
        btnReject2 =findViewById(R.id.btnReject2);
        btnReject3 = findViewById(R.id.btnReject3);

        getdata();

        btnApprove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference1.child("application_status").setValue("Approved");
                alertDialog1();
                btnApprove1.setText("Approved");
            }
        });
        btnApprove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference2.child("application_status").setValue("Approved");
                alertDialog1();
                btnApprove2.setText("Approved");
            }
        });
        btnApprove3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference3.child("application_status").setValue("Approved");
                alertDialog1();
                btnApprove3.setText("Approved");
            }
        });

        btnReject1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference1.child("application_status").setValue("Rejected");
                alertDialog2();
                btnReject1.setText("Rejected");
            }
        });
        btnReject2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference2.child("application_status").setValue("Rejected");
                alertDialog2();
                btnReject2.setText("Rejected");
            }
        });
        btnReject3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference2.child("application_status").setValue("Rejected");
                alertDialog2();
                btnReject2.setText("Rejected");
            }
        });

        btnView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println(key1);
                String key1 = databaseReference1.getKey();
                Intent i = new Intent(ApplicationList.this, ApplicationViewOne.class);
                i.putExtra("key", key1);
                startActivity(i);
            }
        });
        btnView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key2 = databaseReference2.getKey();
                Intent i = new Intent(ApplicationList.this, ApplicationViewOne.class);
                i.putExtra("key", key2);
                startActivity(i);
            }
        });
        btnView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key3 = databaseReference3.getKey();
                Intent i = new Intent(ApplicationList.this, ApplicationViewOne.class);
                i.putExtra("key", key3);
                startActivity(i);
            }
        });
    }
    public void getdata() {

        // calling add value event listener method
        // for getting the values from database.

       databaseReference1.orderByKey().limitToLast(1).addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                   key1 = dataSnapshot.getKey().toString();

                   String application_id1 = dataSnapshot.child("application_id").getValue(String.class);
                   String name1 = dataSnapshot.child("name").getValue(String.class);
                   String submit_date1 = dataSnapshot.child("submit_date").getValue(String.class);

                   RetrieveappID1.setText(application_id1);
                   RetrieveappName1.setText(name1);
                   RetrievesubmitDate1.setText(submit_date1);
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });



        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String application_id2 = snapshot.child("application_id").getValue(String.class);
                String name2 = snapshot.child("name").getValue(String.class);
                String submit_date2 = snapshot.child("submit_date").getValue(String.class);
                // after getting the value we are setting
                // our value to our text view in below line.
                RetrieveappID2.setText(application_id2);
                RetrieveappName2.setText(name2);
                RetrievesubmitDate2.setText(submit_date2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(ApplicationList.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });

        databaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String application_id3 = snapshot.child("application_id").getValue(String.class);
                String name3 = snapshot.child("name").getValue(String.class);
                String submit_date3 = snapshot.child("submit_date").getValue(String.class);
                // after getting the value we are setting
                // our value to our text view in below line.
                RetrieveappID3.setText(application_id3);
                RetrieveappName3.setText(name3);
                RetrievesubmitDate3.setText(submit_date3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(ApplicationList.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void alertDialog1() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure want to approve the application ?");
        //dialog.setTitle("Application");
        dialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Toast.makeText(getApplicationContext(),"Approved",Toast.LENGTH_LONG).show();
                    }
                });
        dialog.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Cancled",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog1=dialog.create();
        alertDialog1.show();
    }

    private void alertDialog2() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure want to reject the application ?");
        //dialog.setTitle("Application");
        dialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Toast.makeText(getApplicationContext(),"Rejected",Toast.LENGTH_LONG).show();
                    }
                });
        dialog.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Cancled",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog2=dialog.create();
        alertDialog2.show();
    }
}