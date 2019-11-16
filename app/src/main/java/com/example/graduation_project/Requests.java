package com.example.graduation_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Requests extends AppCompatActivity {

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
        requestsAdapter=new RequestsAdapter();
        requests.setAdapter(requestsAdapter);



    }

    @Override
    protected void onStart() {
        super.onStart();
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
