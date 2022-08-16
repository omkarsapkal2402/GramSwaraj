package com.example.loginapplicationnew;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class YojnaActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    Dialog dialogwin,dialogwin2 ;
    Button feed_button,contact_button;
    EditText et,win_mob,win_feedback;

    private ListView mListView;
    private ArrayAdapter aAdapter;
    private String[] yojna = { "प्रधानमंत्री किसान सम्मान निधि योजना", "प्रधान मंत्री कृषि सिंचाई योजना (पीएमकेएसवाई)", "ग्रामीण भंडारण योजना", "राष्ट्रीय पशुधन मिशन (एनएलएम)", "राष्ट्रीय गोकुल मिशन (आरजीएम)", "पशुधन किसानों को किसान क्रेडिट कार्ड (केसीसी)","पशुपालन अवसंरचना विकास निधि","राष्ट्रीय पशु रोग नियंत्रण कार्यक्रम","प्रधानमंत्री किसान सम्मान निधि योजना","पशुपालन अवसंरचना विकास निधि","पशुपालन अवसंरचना विकास निधि"};
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yojna);

        //For logout button
        mAuth = FirebaseAuth.getInstance();

        mListView = (ListView) findViewById(R.id.userlist);
        aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, yojna);
        mListView.setAdapter(aAdapter);

        ImageView RightIcon=findViewById(R.id.right_icon);
        NavigationView navigationView=findViewById(R.id.navigation_view);
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        MaterialToolbar toolbar=findViewById(R.id.topAppbar);

        RightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open_menu();
                DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(yojna[position]=="प्रधानमंत्री किसान सम्मान निधि योजना") {
                    open_web1("https://pmkisan.gov.in/");
                }
                if(yojna[position]=="प्रधान मंत्री कृषि सिंचाई योजना (पीएमकेएसवाई)") {
                    open_web1("https://pmksy.gov.in/");
                }
                if(yojna[position]=="ग्रामीण भंडारण योजना") {
                    open_web1("https://www.nabard.org/hindi/content1.aspx?id=593&catid=23&mid=530");
                }
                if(yojna[position]=="राष्ट्रीय पशुधन मिशन (एनएलएम)") {
                    open_web1("https://dahd.nic.in/hi/national_livestock_mission");
                }
                if(yojna[position]=="राष्ट्रीय गोकुल मिशन (आरजीएम)") {
                    open_web1("https://dahd.nic.in/hi/rgm");
                }
                if(yojna[position]=="पशुधन किसानों को किसान क्रेडिट कार्ड (केसीसी)") {
                    open_web1("https://dahd.nic.in/hi/kcc");
                }
                if(yojna[position]=="पशुपालन अवसंरचना विकास निधि") {
                    open_web1("https://dahd.nic.in/hi/ahidf");
                }
                if(yojna[position]=="राष्ट्रीय पशु रोग नियंत्रण कार्यक्रम") {
                    open_web1("https://dahd.nic.in/hi");
                }
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
                        Intent i1=new Intent(YojnaActivity.this,MainActivity.class);
                        startActivity(i1);
                        finish();
                        break;
                    case R.id.about_us:
                        Intent i2=new Intent(YojnaActivity.this,AboutusActivity.class);
                        startActivity(i2);
                        break;
                    case R.id.yojna:
                        Intent i3=new Intent(YojnaActivity.this,YojnaActivity.class);
                        startActivity(i3);
                        break;
                    case R.id.forms:
                        Intent i5=new Intent(YojnaActivity.this, FormsActivity.class);
                        startActivity(i5);
                        break;
                    case R.id.gallery:
                        Intent i4=new Intent(YojnaActivity.this, GalleryActivity.class);
                        startActivity(i4);
                        break;
                    case R.id.feedback:
                        open_feedback();
                        break;
                    case R.id.contact:
                        open_contact();
                        break;
                    case R.id.logout:
                        mAuth.signOut();
                        startActivity(new Intent(YojnaActivity.this, LoginPage.class));
                        break;
                    default:
                        Toast.makeText(YojnaActivity.this, "Hii", Toast.LENGTH_SHORT).show();

                }
                return true;
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
    public void open_feedback()
    {
        dialogwin=new Dialog(YojnaActivity.this);
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
                    Toast.makeText(YojnaActivity.this,name+" your Feedback has been submitted!!",Toast.LENGTH_LONG).show();
                    dialogwin.dismiss();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(YojnaActivity.this, LoginPage.class));
        }
    }

    public void open_web1(String url){
        setContentView(R.layout.activity_webview);
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }




}