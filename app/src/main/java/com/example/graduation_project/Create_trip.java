package com.example.graduation_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Create_trip extends Activity implements View.OnClickListener{
    TextView Sregoin;
    Spinner Regoinn;
    TextView Sstart;
    Spinner startpoint;
    TextView Stime;
    Spinner Timee;
    TextView Srally;
    Spinner Rally;
    TextView Send;
    Spinner End;
    TextView Snumber;
    Spinner numberP;
    Button create;
    EditText carType, carColor, pNumper;
    DatabaseReference databaseTrips;
    Toolbar toolbar;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trip);
        Regoinn = (Spinner) findViewById(R.id.spinner1);
        startpoint = (Spinner) findViewById(R.id.spinner2);
        Timee = (Spinner) findViewById(R.id.spinner3);
        Rally = (Spinner) findViewById(R.id.spinner6);
        End = (Spinner) findViewById(R.id.spinner4);
        numberP = (Spinner) findViewById(R.id.spinner5);
        create = (Button) findViewById(R.id.ct);
        carType = findViewById(R.id.edt);
        carColor = findViewById(R.id.edt1);
        pNumper = findViewById(R.id.edt2);
        progressBar = findViewById(R.id.progressBar);


        Spinner mySpinner1 =findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(Create_trip.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Region));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);


        Spinner mySpinner2 =findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(Create_trip.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.StartPoint));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);

        Spinner mySpinner3 =findViewById(R.id.spinner3);
        ArrayAdapter<String> myAdapter3=new ArrayAdapter<String>(Create_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.TimetoGo));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter3);

        Spinner mySpinner4 =findViewById(R.id.spinner4);
        ArrayAdapter<String> myAdapter4=new ArrayAdapter<String>(Create_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.AccessPoint));
        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner4.setAdapter(myAdapter4);

        Spinner mySpinner5 =findViewById(R.id.spinner5);
        ArrayAdapter<String> myAdapter5=new ArrayAdapter<String>(Create_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.NumberofPassengers));
        myAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner5.setAdapter(myAdapter5);

        Spinner mySpinner6 =findViewById(R.id.spinner6);
        ArrayAdapter<String> myAdapter6=new ArrayAdapter<String>(Create_trip.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Rallypoint));
        myAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner6.setAdapter(myAdapter6);
           progressBar.setVisibility(View.GONE);

    mAuth = FirebaseAuth.getInstance();

        create.setOnClickListener((View.OnClickListener) this);

}
    @Override
    public void onClick(View v) {
        if (v == create) {
            createTrip();
        }
    }
    private void createTrip() {
        final String Region = Regoinn.getSelectedItem().toString();
        final String StratPoint = startpoint.getSelectedItem().toString();
        final String Time = Timee.getSelectedItem().toString();
        final String RallyPoint = Rally.getSelectedItem().toString();
        final String EndPoint = End.getSelectedItem().toString();
        final String PNumber = numberP.getSelectedItem().toString();
        final String CarTyps = carType.getText().toString().trim();
        final String CarCollor = carColor.getText().toString().trim();
        final String Carplate = pNumper.getText().toString().trim();

        if (TextUtils.isEmpty(Region)) {
            Toast.makeText(this, "Regoin is required", Toast.LENGTH_LONG).show();
        }
        if (TextUtils.isEmpty(StratPoint)) {
            Toast.makeText(this, "Strat Point is required", Toast.LENGTH_LONG).show();
        }
        if (TextUtils.isEmpty(RallyPoint)) {
            Toast.makeText(this, "Rally Point is required", Toast.LENGTH_LONG).show();
        }
        if (TextUtils.isEmpty(EndPoint)) {
            Toast.makeText(this, "End Pointis required", Toast.LENGTH_LONG).show();
        }

        if (TextUtils.isEmpty(Time)) {
            Toast.makeText(this, "Time is required", Toast.LENGTH_LONG).show();
        }

        if (TextUtils.isEmpty(PNumber)) {
            Toast.makeText(this, "Number of passenger is required", Toast.LENGTH_LONG).show();
        }
        progressBar.setVisibility(View.VISIBLE);


        Trips trips = new Trips(
                Region,
                StratPoint,
                Time,
                RallyPoint,
                EndPoint,
                PNumber
        );
        FirebaseDatabase.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()) .child("Trips")
                .push().setValue(trips).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task){
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(Create_trip.this, "Trip added", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Create_trip.this, "Can't add  ", Toast.LENGTH_LONG).show();
                }
            }
        });

        if (CarTyps.isEmpty()) {
            Toast.makeText(this, "Car Typ is required", Toast.LENGTH_LONG).show();
            carType.requestFocus();
            return;
        }if (CarCollor.isEmpty()) {
            Toast.makeText(this, "Car Collor is required", Toast.LENGTH_LONG).show();
            carColor.requestFocus();
            return;
        }if (Carplate.isEmpty()) {
            Toast.makeText(this, "Plate Number is required", Toast.LENGTH_LONG).show();
            pNumper.requestFocus();
            return;
        }
        Cars cars = new Cars(
                CarTyps,
                CarCollor,
                Carplate
        );
        FirebaseDatabase.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Cars")
                .push().setValue(cars).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task){
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(Create_trip.this, "Car information added", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Create_trip.this, "Can't add Car info ", Toast.LENGTH_LONG).show();
                }
            }
        });

            Toast.makeText(Create_trip.this, "Trip is created", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), Requests.class));
            finish();




    }
}



