package com.example.graduation_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Book_trip extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_trip);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Region));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);


        Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.StartPoint));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);

        Spinner mySpinner3 = (Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<String> myAdapter3=new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.TimetoGo));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter3);

        Spinner mySpinner4 = (Spinner)findViewById(R.id.spinner4);
        ArrayAdapter<String> myAdapter4=new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.AccessPoint));
        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner4.setAdapter(myAdapter4);

        Spinner mySpinner5 = (Spinner)findViewById(R.id.spinner5);
        ArrayAdapter<String> myAdapter5=new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.NumberofPassengers));
        myAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner5.setAdapter(myAdapter5);
    }public void openActivity2(){
        Intent intent = new Intent(this, Trips_Available.class);
        startActivity(intent);


    }
}

