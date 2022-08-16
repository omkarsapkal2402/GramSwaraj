package com.example.loginapplicationnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ApplyCertificateListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_certificate_list);

    }

    public void openBirthForm(View view) {
        Intent i= new Intent(ApplyCertificateListActivity.this, BirthRegForm.class);
        startActivity(i);
    }
}