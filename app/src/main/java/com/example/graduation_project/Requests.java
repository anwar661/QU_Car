package com.example.graduation_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Requests extends AppCompatActivity implements RequestsAdapter.CallBack {

    RecyclerView requests;
    RequestsAdapter requestsAdapter;
    String user_id;
    Query query;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
        requests=findViewById(R.id.requests);
        requests.setLayoutManager(new LinearLayoutManager(this));
        user_id= FirebaseAuth.getInstance().getCurrentUser().getUid();
        query= FirebaseDatabase.getInstance().getReference("Requests");
        requestsAdapter=new RequestsAdapter(this);
        requestsAdapter.setCallBack(this);
        requests.setAdapter(requestsAdapter);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        startActivity(new Intent(Requests.this,home_page.class));
                        break;
                    case R.id.action_req:
                        startActivity(new Intent(Requests.this,Requests.class));
                        break;
                    case R.id.action_set:
                        startActivity(new Intent(Requests.this,Setting.class));
                        break;
                }
                return true;
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        activeReuests=true;
        if(activeReuests){
            final List<RequestModel> requestModels=new ArrayList<>();
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    requestModels.clear();
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        RequestModel requestModel=child.getValue(RequestModel.class);
                        if(requestModel.getTo().equals(user_id)|| requestModel.getFrom().equals(user_id)){
                            requestModels.add(requestModel);
                            requestsAdapter.submitList(requestModels);
                        }
                    }




                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


    }


    public static boolean  activeReuests=false;



    @Override
    protected void onStop() {
        super.onStop();
        activeReuests=false;

    }
    DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
    boolean isChange=true;
ValueEventListener acceptListener=new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
           if(isChange){
               isChange=false;
               if (dataSnapshot.exists()) {
                   Trips trips1 = dataSnapshot.getValue(Trips.class);
                   int numberOfPassenger = Integer.parseInt(trips1.getpNumber());
                   HashMap<String, Object> map = new HashMap<>();
                   map.put("pNumber", String.valueOf(numberOfPassenger - 1));
                   dataSnapshot.getRef().updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           if (task.isSuccessful()) {
                               Toast.makeText(Requests.this, "Accpted", Toast.LENGTH_SHORT).show();

                               Log.d("MUTEE", "ACCEPTED");
                               dataSnapshot.getRef().removeEventListener(acceptListener);


                           }
                       }
                   });
               }
           }

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
};

    @Override
    public void onAccept(RequestModel model, String from) {
        if(from.equals("accpet")&&activeReuests){
            HashMap<String,Object> map=new HashMap<>();
            map.put("state",1);
            map.put("message"," Accepted");
            FirebaseDatabase.getInstance().getReference("Requests").child(model.getRequest_id()).updateChildren(map);
            requestsAdapter.notifyDataSetChanged();

            databaseReference.child("Users").child(model.getTo()).child("Trips").child(model.getTrip_id()).addValueEventListener(acceptListener);
        }


        if(from.equals("reject")&&activeReuests){
            HashMap<String,Object> map=new HashMap<>();
            map.put("state",2);
            map.put("message"," Wait another");
            FirebaseDatabase.getInstance().getReference("Requests").child(model.getRequest_id()).updateChildren(map);
            requestsAdapter.notifyDataSetChanged();
            rejectRef.child("Users").child(model.getTo()).child("Trips").child(model.getTrip_id()).addValueEventListener(rejectListner);
        }
    }

    DatabaseReference rejectRef=FirebaseDatabase.getInstance().getReference();
    boolean rejectChange=true;

    ValueEventListener rejectListner=new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if(rejectChange){
                rejectChange=false;
                if (dataSnapshot.exists()) {

                    Trips trips1 = dataSnapshot.getValue(Trips.class);
                    int numberOfPassenger = Integer.parseInt(trips1.getpNumber());
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("pNumber", String.valueOf(numberOfPassenger + 1));
                    dataSnapshot.getRef().updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Requests.this, "Rejected", Toast.LENGTH_SHORT).show();
                                rejectRef.removeEventListener(rejectListner);
                            }
                        }
                    });
                }
            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };


}
