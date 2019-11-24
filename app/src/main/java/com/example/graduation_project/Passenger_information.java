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
                    name.setText("Name: "+user.name);
                    phone.setText("Phone Number: "+user.phone);
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

