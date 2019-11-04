package com.example.graduation_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        Trips_class trips = tripstList.get(position);
        holder.textViewName.setText("Name: " +trips.name);
        holder.textViewCar.setText("Car Type: " + trips.car);
    }
    @Override
    public int getItemCount() {
        return tripstList.size();
    }
    class TripsViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewCar;
        public TripsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewCar = itemView.findViewById(R.id.text_view_car_type);
        }
    }


}
