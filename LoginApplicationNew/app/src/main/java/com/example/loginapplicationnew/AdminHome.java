package com.example.loginapplicationnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class AdminHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        //Toolbar
        ImageView leftIcon=findViewById(R.id.left_icon);
        ImageView RightIcon=findViewById(R.id.right_icon);
        TextView title=findViewById(R.id.toolbar_title);
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout2);
        MaterialToolbar toolbar=findViewById(R.id.topAppbar2);
        NavigationView navigationView=findViewById(R.id.navigation_view2);

        //Drawer
        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdminHome.this,"You Clicked on logo!!",Toast.LENGTH_SHORT).show();
            }
        });
        RightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open_menu();
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
                        Intent i1=new Intent(AdminHome.this,AdminHome.class);
                        startActivity(i1);
                        finish();
                        break;/*
                    case R.id.about_us:
                        Intent i2=new Intent(MainActivity.this,aboutus_activity.class);
                        startActivity(i2);
                        break;
                    case R.id.yojna:
                        Intent i3=new Intent(MainActivity.this, YojnaActivity.class);
                        startActivity(i3);
                        break;
                    case R.id.gallery:
                        Intent i4=new Intent(MainActivity.this, GalleryActivity.class);
                        startActivity(i4);
                        break;
                    case R.id.feedback:
                        open_feedback();
                        break;
                    case R.id.contact:
                        open_contact();
                        break;*/
                    case R.id.logout:
                        startActivity(new Intent(AdminHome.this, AdminLogin.class));
                        break;
                    default:
                        Toast.makeText(AdminHome.this, "Hii", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    public void openApplicationList(View view) {
        Intent i = new Intent(AdminHome.this, ApplicationList.class);
        startActivity(i);
    }
}