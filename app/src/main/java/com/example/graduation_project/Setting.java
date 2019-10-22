package com.example.graduation_project;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Setting extends AppCompatActivity implements View.OnClickListener {
    Button ed;
    EditText usr;
    EditText eml;
    EditText pwd;
    EditText car;
    EditText phn;
    EditText id;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ed = findViewById(R.id.edit);
        usr = findViewById(R.id.usrInp);
        eml = findViewById(R.id.em);
        pwd = findViewById(R.id.pwdInp);
        car = findViewById(R.id.car);
        phn = findViewById(R.id.phnum);
        id= findViewById(R.id.idn);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        ed.setOnClickListener(this);
    }@Override
    public void onClick(View v) {
        if (v == ed) {
            editData();
        }
    }private void editData(){
        final String idnu = id.getText().toString().trim();
        final String name = usr.getText().toString().trim();
        final String email = eml.getText().toString().trim();
        final String password = pwd.getText().toString().trim();
        final String phone = phn.getText().toString().trim();
        final String ca = car.getText().toString().trim();
        Query editQuery = mDatabase.orderByChild("idnumber").equalTo(idnu);
        editQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot edtData: dataSnapshot.getChildren()){
                    edtData.getRef().child("name").setValue(name);
                }
                for(DataSnapshot edtData: dataSnapshot.getChildren()){
                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        eml.setError(getString(R.string.input_error_email_invalid));
                        eml.requestFocus();
                        return;
                    }
                    edtData.getRef().child("email").setValue(email);
                }
                for(DataSnapshot edtData: dataSnapshot.getChildren()){
                    if (phone.length() != 10) {
                        phn.setError(getString(R.string.input_error_phone_invalid));
                        phn.requestFocus();
                        return;
                    }
                    edtData.getRef().child("phone").setValue(phone);
                }
                for(DataSnapshot edtData: dataSnapshot.getChildren()){
                    if (password.length() < 6) {
                        pwd.setError(getString(R.string.input_error_password_length));
                        pwd.requestFocus();
                        return;
                    }
                    edtData.getRef().child("password").setValue(password);
                }
                //for(DataSnapshot edtData: dataSnapshot.getChildren()){

                //    edtData.getRef().child("car").setValue(ca);
               // }
                Toast.makeText(Setting.this,"Data Edited",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Setting.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
