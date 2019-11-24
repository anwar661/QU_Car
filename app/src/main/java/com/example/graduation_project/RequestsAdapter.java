package com.example.graduation_project;

import android.content.Context;
import android.content.Intent;
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
    Context context;
    String user_id;
    CallBack callBack;

    public CallBack getCallBack() {
        return callBack;
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public  RequestsAdapter(Context context){
        super(callback);
        user_id= FirebaseAuth.getInstance().getCurrentUser().getUid();
        this.context=context;
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
                    .child("Trips").child(model.getTo()).addListenerForSingleValueEvent(new ValueEventListener() {
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
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(model.getState()==1){
                        Intent intent=new Intent(context,Passenger_information.class);
                        intent.putExtra("from",model.getFrom());
                        intent.putExtra("rally",holder.message.getText().toString());
                        context.startActivity(intent);
                    }

                }
            });





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
            if(model.getState()==0){
                holder.message.setText("Pending");
            }

            if(model.getState()==1){
                holder.message.setText("Your Request Accepted");
            }

            if(model.getState()==2){
                holder.message.setText("Your Request Rejected .. please Select another Driver");
            }

            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(model.getState()==1 && model.getFrom().equals(user_id)){
                        Intent intent=new Intent(context,Driver_information.class);
                        intent.putExtra("id",model.to);

                        context.startActivity(intent);
                    }

                    if(model.getState()==1 && model.getTo().equals(user_id)){
                        Intent intent=new Intent(context,Passenger_information.class);
                        intent.putExtra("from",model.getFrom());
                        intent.putExtra("rally",holder.message.getText().toString());
                        context.startActivity(intent);
                    }

                }
            });

        }
        holder.btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(callBack!=null){
                   callBack.onAccept(model,"accpet");
               }


            }
        });

        holder.btn_reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             if(callBack!=null){
                 callBack.onAccept(model,"reject");
             }

            }
        });


    }

    class RequstsViewHolder extends RecyclerView.ViewHolder{

        TextView car_type,message,name;
        Button btn_reject,btn_accept;
        LinearLayout layout;
        View view;

        public RequstsViewHolder(@NonNull View itemView) {
            super(itemView);
            car_type=itemView.findViewById(R.id.car_type);
            message=itemView.findViewById(R.id.message);
            name=itemView.findViewById(R.id.name);
            btn_accept=itemView.findViewById(R.id.btn_accept);
            layout=itemView.findViewById(R.id.layout);
            btn_reject=itemView.findViewById(R.id.btn_reject);
            view=itemView;
        }
    }

    interface  CallBack {
        void  onAccept(RequestModel requestModel,String from);

    }
}
