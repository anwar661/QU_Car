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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class Requests extends AppCompatActivity {

    RecyclerView requests;
    FirebaseRecyclerOptions<RequestModel> options;
    FirebaseRecyclerAdapter<RequestModel,RequstsViewHolder> adapter;
    String user_id;
    Query query;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
        requests=findViewById(R.id.requests);
        requests.setLayoutManager(new LinearLayoutManager(this));
        user_id= FirebaseAuth.getInstance().getCurrentUser().getUid();
        query= FirebaseDatabase.getInstance().getReference("Requests").child(user_id);
        options=new FirebaseRecyclerOptions.Builder<RequestModel>().setQuery(query,RequestModel.class).build();
        adapter=new FirebaseRecyclerAdapter<RequestModel, RequstsViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull RequstsViewHolder holder, final int position, @NonNull final RequestModel model) {
                holder.car_type.setText(model.getTypeCar());
                holder.message.setText(model.getMessge());
                holder.name.setText(model.name);

                if(model.getTo().equals(user_id)){
                    holder.layout.setVisibility(View.VISIBLE);

                }
                holder.btn_accept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HashMap<String,Object> map=new HashMap<>();
                        map.put("state",1);
                        map.put("message"," Accepted");
                      FirebaseDatabase.getInstance().getReference("Requests").child(user_id).updateChildren(map);
                        FirebaseDatabase.getInstance().getReference("Requests").child(model.getFrom()).updateChildren(map);
                    }
                });

                holder.btn_reject.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HashMap<String,Object> map=new HashMap<>();
                        map.put("state",2);
                        map.put("message"," Rejected");
                        FirebaseDatabase.getInstance().getReference("Requests").child(user_id).updateChildren(map);
                        FirebaseDatabase.getInstance().getReference("Requests").child(model.getFrom()).updateChildren(map);
                    }
                });

            }

            @NonNull
            @Override
            public RequstsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new RequstsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.request_row,parent,false));
            }
        };
        requests.setAdapter(adapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    class RequstsViewHolder extends RecyclerView.ViewHolder{

        TextView car_type,message,name;
        Button btn_reject,btn_accept;
        LinearLayout layout;

        public RequstsViewHolder(@NonNull View itemView) {
            super(itemView);
            car_type=itemView.findViewById(R.id.car_type);
            message=itemView.findViewById(R.id.message);
            name=itemView.findViewById(R.id.name);
            btn_accept=itemView.findViewById(R.id.btn_accept);
            layout=itemView.findViewById(R.id.layout);
            btn_reject=itemView.findViewById(R.id.btn_reject);
        }
    }
}
