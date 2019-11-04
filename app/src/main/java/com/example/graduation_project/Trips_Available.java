package com.example.graduation_project;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Trips_Available extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TripsAdapter adapter;
    private List<Trips_class> tripsList;

    DatabaseReference dbTrips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips__available);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        dbTrips = database.getReference("Users");
        dbTrips.orderByChild("Users").addValueEventListener(valueEventListener);
       // dbTrips = FirebaseDatabase.getInstance().getReference("Trips");
        Intent intent1 = getIntent();
        String mySpinner_1 = intent1.getStringExtra("mySpinner1");
        Intent intent2 = getIntent();
        String mySpinner_2 = intent2.getStringExtra("mySpinner2");
        Intent intent3 = getIntent();
        String mySpinner_3 = intent3.getStringExtra("mySpinner3");
        Intent intent4 = getIntent();
        String mySpinner_4 = intent4.getStringExtra("mySpinner4");
        Intent intent5 = getIntent();
        String mySpinner_5 = intent5.getStringExtra("mySpinner5");
        Intent intent6 = getIntent();
        String mySpinner_6 = intent6.getStringExtra("mySpinner6");
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tripsList = new ArrayList<>();
        adapter = new TripsAdapter(this, tripsList);
        recyclerView.setAdapter(adapter);

        Query query1 = FirebaseDatabase.getInstance().getReference("Users").child("Users").child("Trips")
                .orderByChild("Region")
                .equalTo(mySpinner_1);
        query1.addListenerForSingleValueEvent(valueEventListener);
        Query query2 = FirebaseDatabase.getInstance().getReference("Users").child("Users").child("Trips")
                .orderByChild("StartPoint")
                .equalTo(mySpinner_2);
        query2.addListenerForSingleValueEvent(valueEventListener);
        Query query3 = FirebaseDatabase.getInstance().getReference("Users").child("Users").child("Trips")
                .orderByChild("Time")
                .equalTo(mySpinner_3);
        query3.addListenerForSingleValueEvent(valueEventListener);
        Query query4 = FirebaseDatabase.getInstance().getReference("Users").child("Users").child("Trips")
                .orderByChild("EndPoint")
                .equalTo(mySpinner_4);
        query4.addListenerForSingleValueEvent(valueEventListener);
        Query query5 = FirebaseDatabase.getInstance().getReference("Users").child("Users").child("Trips")
                .orderByChild("Number")
                .equalTo(mySpinner_5);
        query5.addListenerForSingleValueEvent(valueEventListener);
        Query query6 = FirebaseDatabase.getInstance().getReference("Users").child("Users").child("Trips")
                .orderByChild("RallyPoint")
                .equalTo(mySpinner_6);
        query6.addListenerForSingleValueEvent(valueEventListener);


    }
    ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    tripsList.clear();
                    if (dataSnapshot.exists()) {
                        for (DataSnapshot snapshot :
                                dataSnapshot.getChildren()) {
                            Trips_class trips =
                                    snapshot.getValue(Trips_class.class);
                            tripsList.add(trips);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            };


}

