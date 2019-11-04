package com.example.graduation_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

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

        Spinner mySpinner6 =findViewById(R.id.spinner6);
        ArrayAdapter<String> myAdapter6=new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Rallypoint));
        myAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner6.setAdapter(myAdapter6);

        String mySpinner_1 = mySpinner1.getItemAtPosition(mySpinner1.getSelectedItemPosition())
                        .toString();
        Intent i1 = new Intent(this, Trips_Available.class);
        i1.putExtra("mySpinner1", mySpinner_1);
        String mySpinner_2 = mySpinner2.getItemAtPosition(mySpinner2.getSelectedItemPosition())
                        .toString();
        Intent i2 = new Intent(this, Trips_Available.class);
        i2.putExtra("mySpinner2", mySpinner_2);
        String mySpinner_3 = mySpinner3.getItemAtPosition(mySpinner3.getSelectedItemPosition())
                        .toString();
        Intent i3 = new Intent(this, Trips_Available.class);
        i3.putExtra("mySpinner3", mySpinner_3);
        String mySpinner_4 = mySpinner4.getItemAtPosition(mySpinner4.getSelectedItemPosition())
                        .toString();
        Intent i4 = new Intent(this, Trips_Available.class);
        i4.putExtra("mySpinner4", mySpinner_4);
        String mySpinner_5 =
                mySpinner5.getItemAtPosition(mySpinner5.getSelectedItemPosition())
                        .toString();
        Intent i5 = new Intent(this, Trips_Available.class);
        i5.putExtra("mySpinner5", mySpinner_5);
    }
    public void tv(View V){
        Toast.makeText(Book_trip.this, "Searching for available trips", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,Trips_Available.class);
        startActivity(i);
    }

}

