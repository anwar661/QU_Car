package com.example.graduation_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;

public class RequestsAdapter extends ListAdapter<RequestModel, RequestsAdapter.RequstsViewHolder> {

    public static DiffUtil.ItemCallback<RequestModel> callback =new DiffUtil.ItemCallback<RequestModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull RequestModel oldItem, @NonNull RequestModel newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull RequestModel oldItem, @NonNull RequestModel newItem) {
            return oldItem.getTrip_id().equals(newItem.getTrip_id());
        }
    };
    String user_id;
    public  RequestsAdapter(){
        super(callback);
        user_id= FirebaseAuth.getInstance().getCurrentUser().getUid();
    }



    @NonNull
    @Override
    public RequstsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RequstsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.request_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final RequstsViewHolder holder, int position) {
        final RequestModel model=getItem(position);



        if(model.getTo().equals(user_id)){
            // driver
            holder.layout.setVisibility(View.VISIBLE);
            FirebaseDatabase.getInstance().getReference("Users").child(model.getFrom()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    User user=dataSnapshot.getValue(User.class);
                    holder.name.setText("Passenger Name  :"+user.name);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            FirebaseDatabase.getInstance().
                    getReference("Users").child(model.to)
                    .child("Trips").child(model.getTrip_id()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Trips trips=dataSnapshot.getValue(Trips.class);
                    holder.message.setText("Rally Point :"+trips.getRallyPoint());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            holder.car_type.setVisibility(View.GONE);


        }else {
            // passenger

            FirebaseDatabase.getInstance().getReference("Users").child(model.getTo()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    User user=dataSnapshot.getValue(User.class);
                    holder.name.setText("Driver Name  :"+user.name);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            holder.car_type.setText("Car Type : "+model.getTypeCar());
            holder.message.setVisibility(View.GONE);
        }
        holder.btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> map=new HashMap<>();
                map.put("state",1);
                map.put("message"," Accepted");
                FirebaseDatabase.getInstance().getReference("Requests").child(model.getRequest_id()).updateChildren(map);

            }
        });

        holder.btn_reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> map=new HashMap<>();
                map.put("state",2);
                map.put("message"," Rejected");
                FirebaseDatabase.getInstance().getReference("Requests").child(model.getRequest_id()).updateChildren(map);

            }
        });

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
