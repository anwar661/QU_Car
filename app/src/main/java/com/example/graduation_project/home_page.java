package com.example.graduation_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home_page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        startActivity(new Intent(home_page.this,home_page.class));
                        break;
                    case R.id.action_req:
                        startActivity(new Intent(home_page.this,Requests.class));
                        break;
                    case R.id.action_set:
                        startActivity(new Intent(home_page.this,Setting.class));
                        break;
                }
                return true;
            }
        });
    }
    public void findt(View V){
        Intent i=new Intent(this,Book_trip.class);
        startActivity(i);
    }
    public void addt(View V){
        Intent i=new Intent(this,Create_trip.class);
        startActivity(i);
    }
}