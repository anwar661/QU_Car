package com.example.graduation_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
                        name.setText("Name: "+user.name);
                        phone.setText("Phone Number: "+user.phone);
                        FirebaseDatabase.getInstance().
                                getReference("Users")
                                .child(id).child("Trips")
                                .child(id).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                Trips trips=dataSnapshot.getValue(Trips.class);
                                Cars cars=trips.cars;
                                car_color.setText("Car Collor: "+cars.carCollor);
                                car_number.setText("Car Plate Number: "+cars.carPlate);
                                car_type.setText("Car Type: "+cars.carTyps);
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
    public void dial(View V) {
        EditText ed = (EditText) findViewById(R.id.phoneNumInp);
        String num = "tel:" + ed.getText().toString();
        Intent ite = new Intent(Intent.ACTION_DIAL, Uri.parse(num));
        startActivity(ite);

    }

    public void sendSMS(View V) {
        EditText ed = (EditText) findViewById(R.id.phoneNumInp);
        String url = "smsto:" + ed.getText().toString();
        Uri uri = Uri.parse(url);
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(it);

    }
    public void cost(View V) {;
        Intent i=new Intent(this,Cost_calculation.class);
        startActivity(i);

    }

}
