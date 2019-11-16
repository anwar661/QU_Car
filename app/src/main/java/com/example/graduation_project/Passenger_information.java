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
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Passenger_information extends AppCompatActivity {

    TextView name,rally,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_information);
        name=findViewById(R.id.name);
        rally=findViewById(R.id.rally);
        phone=findViewById(R.id.phone);
        Intent intent=getIntent();
        if(intent.hasExtra("from")){
            String id=intent.getStringExtra("from");
            String rallyPoint=intent.getStringExtra("rally");
            rally.setText(rallyPoint);
            FirebaseDatabase.getInstance().getReference("Users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    User user=dataSnapshot.getValue(User.class);
                    name.setText(user.name);
                    phone.setText(user.phone);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
    public void Call (View view){
        Intent Call =new Intent(Intent.ACTION_CALL);
        Call.setData(Uri.parse("tel:"+phone.getText().toString()));
        if (ActivityCompat.checkSelfPermission(Passenger_information.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(Call);
    }

}

