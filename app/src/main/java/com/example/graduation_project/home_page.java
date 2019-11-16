package com.example.graduation_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class home_page extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        FirebaseUser user = mAuth.getCurrentUser();
        mAuth = FirebaseAuth.getInstance();
    }
        public void findt(View V){
        Intent i=new Intent(this,Book_trip.class);
        startActivity(i);
    }
    public void addt(View V){
        Intent i=new Intent(this,Create_trip.class);
        startActivity(i);
    }
    public void out(View V){
       mAuth.signOut();
        Intent i=new Intent(this,Loginn.class);
        startActivity(i);
        finish();
    }public void set(View V){
        Intent i=new Intent(this,Setting.class);
        startActivity(i);
    }

    public void req(View view) {
        startActivity(new Intent(home_page.this,Requests.class));
    }
}