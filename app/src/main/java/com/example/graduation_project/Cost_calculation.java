package com.example.graduation_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Cost_calculation extends AppCompatActivity {
    public String mySpinner_1, mySpinner_2, mySpinner_3, cost_String;
    Spinner mySpinner1, mySpinner2,mySpinner3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_calculation);
        mySpinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter1 = new
                ArrayAdapter<String>(Cost_calculation.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.Rallypoint));

        myAdapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner1.setAdapter(myAdapter1);
        mySpinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new
                ArrayAdapter<String>(Cost_calculation.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.AccessPoint));

        myAdapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner2.setAdapter(myAdapter2);
        mySpinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<String> myAdapter3 = new
                ArrayAdapter<String>(Cost_calculation.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.NumberofPassengers));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner3.setAdapter(myAdapter3);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        startActivity(new Intent(Cost_calculation.this,home_page.class));
                        break;
                    case R.id.action_req:
                        startActivity(new Intent(Cost_calculation.this,Requests.class));
                        break;
                    case R.id.action_set:
                        startActivity(new Intent(Cost_calculation.this,Setting.class));
                        break;
                }
                return true;
            }
        });
    }
    public void on(View V){
        TextView TextView =findViewById(R.id.cost);
        if(mySpinner1.getSelectedItem().toString().equals("King Abdullah Park(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("40 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("King Abdullah Park(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("20 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("King Abdullah Park(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("13 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("King Abdullah Park(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("10 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlOthaim Mall(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("20 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlOthaim Mall(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("10 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlOthaim Mall(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("7 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlOthaim Mall(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Rasheed Dome Market(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("35 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Rasheed Dome Market(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("17.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Rasheed Dome Market(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("11.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Rasheed Dome Market(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("26 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlBusar Park(Buraydah") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("25 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlBusar Park(Buraydah") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("12.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlBusar Park(Buraydah") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("8 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlBusar Park(Buraydah") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("6.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("King Khalid Park(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("28 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("King Khalid Park(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("14 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("King Khalid Park(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("9 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("King Khalid Park(Buraydah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("7 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Unaizah Mall") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("40 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Unaizah Mall") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("20 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Unaizah Mall") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("13 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Unaizah Mall") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("10 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlDanube Supermarket(Unaizah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("45 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlDanube Supermarket(Unaizah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("22.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlDanube Supermarket(Unaizah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("15 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlDanube Supermarket(Unaizah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("11 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Unaizah House for Folklores") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("35 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Unaizah House for Folklores") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("17.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Unaizah House for Folklores") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("11.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Unaizah House for Folklores") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("8.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlOthaim Mall(Unaizah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("50 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlOthaim Mall(Unaizah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("25 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlOthaim Mall(Unaizah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("16.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("AlOthaim Mall(Unaizah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("12.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Ghada Park(Unaizah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("40 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Ghada Park(Unaizah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("20 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Ghada Park(Unaizah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("13 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Ghada Park(Unaizah)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("10 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Oasis Mall(Alrass)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("60 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Oasis Mall(Alrass)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("30 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Oasis Mall(Alrass)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("20 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Oasis Mall(Alrass)") && mySpinner2.getSelectedItem().toString().equals("Qussaim university") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("15 SR");}


        if(mySpinner1.getSelectedItem().toString().equals("Qussaim university") && mySpinner2.getSelectedItem().toString().equals("King Abdullah Park(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("40 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university") && mySpinner2.getSelectedItem().toString().equals("King Abdullah Park(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("20 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university") && mySpinner2.getSelectedItem().toString().equals("King Abdullah Park(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("13 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university") && mySpinner2.getSelectedItem().toString().equals("King Abdullah Park(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("10 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlOthaim Mall(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("20 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlOthaim Mall(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("10 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlOthaim Mall(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("7 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlOthaim Mall(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university") && mySpinner2.getSelectedItem().toString().equals("Rasheed Dome Market(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("35 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university") && mySpinner2.getSelectedItem().toString().equals("Rasheed Dome Market(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("17.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university") && mySpinner2.getSelectedItem().toString().equals("Rasheed Dome Market(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("11.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university") && mySpinner2.getSelectedItem().toString().equals("Rasheed Dome Market(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("26 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlBusar Park(Buraydah") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("25 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlBusar Park(Buraydah") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("12.5 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlBusar Park(Buraydah") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("8 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlBusar Park(Buraydah") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("6.5 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("King Khalid Park(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("28 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("King Khalid Park(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("14 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("King Khalid Park(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("9 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("King Khalid Park(Buraydah)") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("7 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Unaizah Mall") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("40 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Unaizah Mall") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("20 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Unaizah Mall") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("13 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Unaizah Mall") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("10 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlDanube Supermarket(Unaizah)")  && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("45 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlDanube Supermarket(Unaizah)")  && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("22.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlDanube Supermarket(Unaizah)")  && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("15 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlDanube Supermarket(Unaizah)")  && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("11 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Unaizah House for Folklores") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("35 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Unaizah House for Folklores") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("17.5 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Unaizah House for Folklores") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("11.5 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Unaizah House for Folklores") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("8.5 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlOthaim Mall(Unaizah)") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("50 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlOthaim Mall(Unaizah)") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("25 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlOthaim Mall(Unaizah)") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("16.5 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("AlOthaim Mall(Unaizah)") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("12.5 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Ghada Park(Unaizah)")  && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("40 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Ghada Park(Unaizah)")  && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("20 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Ghada Park(Unaizah)")  && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("13 SR");}
        else if(mySpinner1.getSelectedItem().toString().equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Ghada Park(Unaizah)")  && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("10 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Oasis Mall(Alrass)") && mySpinner3.getSelectedItem().toString().equals("1") ){
            TextView.setText("60 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Oasis Mall(Alrass)") && mySpinner3.getSelectedItem().toString().equals("2") ){
            TextView.setText("30 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Oasis Mall(Alrass)") && mySpinner3.getSelectedItem().toString().equals("3") ){
            TextView.setText("20 SR");}
        else if(mySpinner1.getSelectedItem().toString(). equals("Qussaim university")&& mySpinner2.getSelectedItem().toString().equals("Oasis Mall(Alrass)") && mySpinner3.getSelectedItem().toString().equals("4") ){
            TextView.setText("15 SR");}
    }
}


