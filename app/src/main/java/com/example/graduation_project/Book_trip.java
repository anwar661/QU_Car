package com.example.graduation_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Book_trip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_trip);
        Spinner mySpinner1 =findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Region));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);


        Spinner mySpinner2 =findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.StartPoint));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);

        Spinner mySpinner3 =findViewById(R.id.spinner3);
        ArrayAdapter<String> myAdapter3=new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.TimetoGo));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter3);

        Spinner mySpinner4 =findViewById(R.id.spinner4);
        ArrayAdapter<String> myAdapter4=new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.AccessPoint));
        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner4.setAdapter(myAdapter4);

        Spinner mySpinner5 =findViewById(R.id.spinner5);
        ArrayAdapter<String> myAdapter5=new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.NumberofPassengers));
        myAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner5.setAdapter(myAdapter5);

    }public void tv(View V){
        Intent i=new Intent(this,Trips_Available.class);
        startActivity(i);
    }
}

