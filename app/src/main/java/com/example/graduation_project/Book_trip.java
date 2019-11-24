package com.example.graduation_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Book_trip extends AppCompatActivity {

    Spinner mySpinner1,mySpinner2,mySpinner3,mySpinner4,mySpinner5,mySpinner6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_trip);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        startActivity(new Intent(Book_trip.this,home_page.class));
                        break;
                    case R.id.action_req:
                        startActivity(new Intent(Book_trip.this,Requests.class));
                        break;
                    case R.id.action_set:
                        startActivity(new Intent(Book_trip.this,Setting.class));
                        break;
                }
                return true;
            }
        });
         mySpinner1 =findViewById(R.id.spinner1);
        /*ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Region));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);*/


         mySpinner2 =findViewById(R.id.spinner2);
       /* ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.StartPoint));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);*/


         mySpinner3 =findViewById(R.id.spinner3);
       /* ArrayAdapter<String> myAdapter3=new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.TimetoGo));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter3);*/

         mySpinner4 =findViewById(R.id.spinner4);
        /*ArrayAdapter<String> myAdapter4=new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.AccessPoint));
        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner4.setAdapter(myAdapter4);*/

         mySpinner5 =findViewById(R.id.spinner5);
        /*ArrayAdapter<String> myAdapter5=new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.NumberofPassengers));
        myAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner5.setAdapter(myAdapter5);*/

         mySpinner6 =findViewById(R.id.spinner6);
        /*ArrayAdapter<String> myAdapter6=new ArrayAdapter<String>(Book_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Rallypoint));
        myAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner6.setAdapter(myAdapter6);*/

    }
    public void tv(View V){
        Toast.makeText(Book_trip.this, "Searching for available trips", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,Trips_Available.class);

        String mySpinner_1 =(String) mySpinner1.getSelectedItem();//Region

        i.putExtra("Region", mySpinner_1);
        String mySpinner_2 = (String) mySpinner2.getSelectedItem();;//StartPoint
        i.putExtra("StartPoint", mySpinner_2);
        String mySpinner_3 = (String) mySpinner3.getSelectedItem();//TimetoGo

        i.putExtra("TimetoGo", mySpinner_3);
        String mySpinner_4 =(String) mySpinner4.getSelectedItem();//AccessPoint

        i.putExtra("AccessPoint", mySpinner_4);
        String mySpinner_5 =(String) mySpinner5.getSelectedItem();//NumberofPassengers

       // i.putExtra("NumberofPassengers", mySpinner_5);

        String mySpinner_6 =(String) mySpinner6.getSelectedItem();//Rallypoint

        i.putExtra("Rallypoint", mySpinner_6);
        startActivity(i);
    }

}

