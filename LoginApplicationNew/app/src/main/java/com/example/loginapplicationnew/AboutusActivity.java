package com.example.loginapplicationnew;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class AboutusActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    DrawerLayout drawerLayout;
    Dialog dialogwin,dialogwin2 ;
    Button feed_button,contact_button;
    EditText et,win_mob,win_feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        mAuth = FirebaseAuth.getInstance();

        NavigationView navigationView=findViewById(R.id.navigation_view);
        ImageView RightIcon=findViewById(R.id.right_icon);
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        MaterialToolbar toolbar=findViewById(R.id.topAppbar);

        RightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id)
                {
                    case R.id.nav_home:
                        Intent i1=new Intent(AboutusActivity.this,MainActivity.class);
                        startActivity(i1);
                        finish();
                        break;
                    case R.id.about_us:
                        Intent i2=new Intent(AboutusActivity.this,AboutusActivity.class);
                        startActivity(i2);
                        break;
                    case R.id.yojna:
                        Intent i3=new Intent(AboutusActivity.this,YojnaActivity.class);
                        startActivity(i3);
                        break;
                    case R.id.forms:
                        Intent i5=new Intent(AboutusActivity.this, FormsActivity.class);
                        startActivity(i5);
                        break;
                    case R.id.gallery:
                        Intent i4=new Intent(AboutusActivity.this, GalleryActivity.class);
                        startActivity(i4);
                        break;
                    case R.id.feedback:
                        open_feedback();
                        break;
                    case R.id.logout:
                        mAuth.signOut();
                        startActivity(new Intent(AboutusActivity.this, LoginPage.class));
                        break;
                    case R.id.contact:
                        open_contact();
                        break;
                    default:
                        Toast.makeText(AboutusActivity.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });

    }

    public void open_feedback()
    {
        dialogwin=new Dialog(AboutusActivity.this);
        dialogwin.setContentView(R.layout.popup);
        dialogwin.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogwin.show();
        //POPUP
        feed_button =(Button)dialogwin.findViewById(R.id.feed_button);
        et = (EditText)dialogwin.findViewById(R.id.win_name);
        win_mob=(EditText) dialogwin.findViewById(R.id.win_mob);
        win_feedback=(EditText) dialogwin.findViewById(R.id.win_feedback);
        //POPUP
        feed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  str=et.getText().toString();
                String str2=win_mob.getText().toString();
                String str3=win_feedback.getText().toString();
                if(str.equalsIgnoreCase(""))
                {
                    et.setHint("please enter your name");//it gives user to hint
                    et.setError("please enter your name");//it gives user to info message //use any one //
                }
                else
                {
                    String name=et.getText().toString();
                    //FirebaseDatabase.getInstance().getReference().child("hii").child("hello").setValue("abc");
                    Toast.makeText(AboutusActivity.this,name+" your Feedback has been submitted!!",Toast.LENGTH_LONG).show();
                    dialogwin.dismiss();
                }
            }
        });
    }

    public void open_contact()
    {
        //POPUP
        dialogwin2=new Dialog(this);
        dialogwin2.setContentView(R.layout.popup_contact);
        dialogwin2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogwin2.show();
        contact_button =(Button)dialogwin2.findViewById(R.id.contact_button);
        contact_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogwin2.dismiss();
            }
        });
    }

}