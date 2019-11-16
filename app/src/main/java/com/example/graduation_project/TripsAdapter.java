package com.example.graduation_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.TripsViewHolder> {
    private Context mCtx;
    private List<Trips_class> tripstList;
    public TripsAdapter(Context mCtx, List<Trips_class>
            tripstList) {
        this.mCtx = mCtx;
        this.tripstList = tripstList;
    }
    @NonNull
    @Override
    public TripsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.cards, parent, false);
        return new TripsViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull TripsViewHolder holder,
                                 int position) {
        final Trips_class trips = tripstList.get(position);
        holder.textViewName.setText("Name: " +trips.name);
        holder.textViewCar.setText("Car Type: " + trips.getCar());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final String user_id= FirebaseAuth.getInstance().getCurrentUser().getUid();

                FirebaseDatabase.getInstance().getReference("Users").child(user_id).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        User user=dataSnapshot.getValue(User.class);
                       final RequestModel requestModel=new RequestModel();
                        requestModel.setFrom(user_id);
                        requestModel.setState(0);
                        requestModel.setTo(trips.getDriver_id());
                        requestModel.setName(user.name);
                        requestModel.setTypeCar(trips.getCar());
                        requestModel.setMessge("new Request");
                        requestModel.setTrip_id(trips.getTrip_id());
                        DatabaseReference push = FirebaseDatabase.getInstance().getReference("Requests").push();
                        String req_id=push.getKey();
                        requestModel.setRequest_id(req_id);
                                push.setValue(requestModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){

                                }
                            }
                        });


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }
    @Override
    public int getItemCount() {
        return tripstList.size();
    }
    class TripsViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewCar;
        View view;
        public TripsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewCar = itemView.findViewById(R.id.text_view_car_type);
            view=itemView;
        }
    }


}
