package com.example.graduation_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
import java.util.HashMap;
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
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        dbTrips = database.getReference("Users");

        // dbTrips = FirebaseDatabase.getInstance().getReference("Trips");
        Intent intent = getIntent();
        final String Region = intent.getStringExtra("Region");
        final String StartPoint = intent.getStringExtra("StartPoint");
        final String TimetoGo = intent.getStringExtra("TimetoGo");
        final String AccessPoint = intent.getStringExtra("AccessPoint");
        //final String NumberofPassengers = intent.getStringExtra("NumberofPassengers");
        final String Rallypoint = intent.getStringExtra("Rallypoint");


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tripsList = new ArrayList<>();
        adapter = new TripsAdapter(this, tripsList);
        recyclerView.setAdapter(adapter);

        Query query1 = FirebaseDatabase.getInstance().getReference("Users");
        query1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot child : dataSnapshot.getChildren()) {

                    final String key=child.getKey();

                    FirebaseDatabase.getInstance().
                            getReference("Users").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot2) {
                            final User user=dataSnapshot2.getValue(User.class);
                            Log.d("QU",user.getName());
                            if(active){
                                FirebaseDatabase.getInstance().
                                        getReference("Users").child(key)
                                        .child("Trips").child(key).addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
                                        if(dataSnapshot1.exists()){

                                            final Trips  trips=dataSnapshot1.getValue(Trips.class);

                                            if(trips.rallyPoint.equals(Rallypoint)
                                                    &&Integer.parseInt(trips.getpNumber())>0
                                                    &&trips.getEndPoint().equals(AccessPoint)
                                                    &&trips.getStratPoint().equals(StartPoint)
                                                    &&trips.getRegion().equals(Region)
                                                    &&trips.getTime().equals(TimetoGo)){

                                                Trips_class trips_class=new Trips_class();
                                                trips_class.setName(user.name);
                                                trips_class.setCar(trips.cars.getCarTyps());
                                                trips_class.setDriver_id(key);
                                                trips_class.setTrip_id(trips.getTrip_id());
                                                tripsList.add(trips_class);
                                                adapter.notifyDataSetChanged();
                                                adapter.setNumberOfPassenger(trips.getpNumber());
                                                adapter.notifyDataSetChanged();
                                            }
                                        }
                                    }
                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                }) ;
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public static boolean  active=false;

    @Override
    protected void onStart() {
        super.onStart();
        active=true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        active=false;

    }
}

