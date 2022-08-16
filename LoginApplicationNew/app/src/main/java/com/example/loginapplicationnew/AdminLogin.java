package com.example.loginapplicationnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AdminLogin extends AppCompatActivity {

    TextInputEditText etLoginUsername;
    TextInputEditText etLoginPassword;
    TextView tvHomePage;
    Button btnAdminLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        etLoginUsername = findViewById(R.id.etLoginUsername);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        tvHomePage = findViewById(R.id.tvHomePage);
        btnAdminLogin = findViewById(R.id.btnAdminLogin);

        tvHomePage.setOnClickListener(view ->{
            startActivity(new Intent(AdminLogin.this, LoginPage.class));
        });


        btnAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String adminUsername = etLoginUsername.getText().toString();
                String adminPassword = etLoginPassword.getText().toString();

                if ((adminUsername.equals("admin")) && (adminPassword.equals("admin"))){
                    Toast.makeText(AdminLogin.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AdminLogin.this, AdminHome.class));
                }
                else{
                    Toast.makeText(AdminLogin.this, "Log in Error: " , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}