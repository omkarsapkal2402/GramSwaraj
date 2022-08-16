package com.example.loginapplicationnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BirthRegForm extends AppCompatActivity {

    EditText etName, etMotherName, etFatherName, etDob, etVillage;
    Spinner spinnerDistrict, spinnerTaluka;
    RadioGroup RGgender;
    Button submit;

    DatabaseReference birthRegRef, birthRegRefMain, blanckRecordRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_reg_form);


        etName = findViewById(R.id.etName);
        etMotherName = findViewById(R.id.etMotherName);
        etFatherName = findViewById(R.id.etFatherName);
        etDob = findViewById(R.id.etDob);
        RGgender = findViewById(R.id.RGgender);
        //etAadharNo = findViewById(R.id.etAadharNo);
        spinnerDistrict = findViewById(R.id.spinnerDistrict);
        spinnerTaluka = findViewById(R.id.spinnerTaluka);
        etVillage = findViewById(R.id.etVillage);

        submit = findViewById(R.id.submit);

        birthRegRefMain = FirebaseDatabase.getInstance().getReference().child("applicants");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertApplicantData();
            }
        });
    }

    public void insertApplicantData(){

        String name = etName.getText().toString();
        String mother_name = etMotherName.getText().toString();
        String father_name = etFatherName.getText().toString();
        String dob = etDob.getText().toString();
        //String aadhar = etAadharNo.getText().toString();

        //Login to create applicatin id using candidate name + date of birth
        String application_id = name+dob;

        // get selected radio button from radioGroup
        int selectedId = RGgender.getCheckedRadioButtonId();

        // find the radio button by returned id
        RadioButton genderId = (RadioButton) findViewById(selectedId);
        String gender = (String) genderId.getText();

        String district = spinnerDistrict.getSelectedItem().toString();
        String taluka = spinnerTaluka.getSelectedItem().toString();

        String village = etVillage.getText().toString();

        //Login to get the current date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime dateNow = LocalDateTime.now();
        final String submit_date = dtf.format(dateNow);

        String application_status = new String("Submitted");


        Applicants applicants = new Applicants(application_id, name, mother_name, father_name, dob, gender, district, taluka, village, submit_date, application_status );

        blanckRecordRef = birthRegRefMain;
        birthRegRef = blanckRecordRef.push();
        String id_key = birthRegRef.getKey();

        birthRegRef.setValue(applicants);

        Toast.makeText(BirthRegForm.this, "Data inserted", Toast.LENGTH_SHORT).show();


        Intent i = new Intent(BirthRegForm.this, ViewApplicationId.class);
        i.putExtra("key",id_key);
        startActivity(i);
    }


}