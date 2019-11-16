package com.example.graduation_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Driver_information extends AppCompatActivity {

    TextView name,phone,car_type,car_color,car_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_information);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        car_type=findViewById(R.id.car_type);
        car_color=findViewById(R.id.car_color);
        car_number=findViewById(R.id.car_number);
        Intent intent=getIntent();
        if(intent.hasExtra("id")){
            final String id=intent.getStringExtra("id");
            FirebaseDatabase.getInstance().getReference("Users").child(id).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        User user=dataSnapshot.getValue(User.class);
                        name.setText(user.name);
                        phone.setText(user.phone);
                        FirebaseDatabase.getInstance().
                                getReference("Users")
                                .child(id).child("Trips")
                                .child(id).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                Trips trips=dataSnapshot.getValue(Trips.class);
                                Cars cars=trips.cars;
                                car_color.setText(cars.carCollor);
                                car_number.setText(cars.carPlate);
                                car_type.setText(cars.carTyps);
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
    }
    public void Call (View view){
        Intent Call =new Intent(Intent.ACTION_CALL);
        Call.setData(Uri.parse("tel:9961907453"));
        if (ActivityCompat.checkSelfPermission(Driver_information.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(Call);
    }

}
