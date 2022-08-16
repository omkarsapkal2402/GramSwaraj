package com.example.loginapplicationnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FormsActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView cardView1, cardView2, cardView3;
    Intent i1,i2,i3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);

        cardView1=(CardView) findViewById(R.id.cardView1);
        cardView2=(CardView) findViewById(R.id.cardView2);
        cardView3=(CardView) findViewById(R.id.cardView3);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cardView1:
                i1=new Intent(FormsActivity.this,PMGAYActivity.class);
                startActivity(i1);
                break;
            case R.id.cardView2:
                i2=new Intent(FormsActivity.this,PMGAYActivity.class);
                startActivity(i2);
                break;
            case R.id.cardView3:
                i3=new Intent(FormsActivity.this,PMGAYActivity.class);
                startActivity(i3);
                break;
        }
    }
}