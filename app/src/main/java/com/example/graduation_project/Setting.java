package com.example.graduation_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Setting extends AppCompatActivity implements View.OnClickListener {
    Button ed,up,us;
    EditText usr;
    EditText eml;
    EditText pwd,oldpwd;
    EditText carc,carp,cart;
    EditText phn;
    EditText id;
    FirebaseUser user;
    DatabaseReference mDatabase,mDatabase1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ed = findViewById(R.id.edit);
        us= findViewById(R.id.updatuser);
        up = findViewById(R.id.updatpass);
        usr = findViewById(R.id.usrInp);
        eml = findViewById(R.id.em);
        oldpwd = findViewById(R.id.oldpwdInp);
        pwd = findViewById(R.id.pwdInp);
        carc = findViewById(R.id.carc);
        carp = findViewById(R.id.carpn);
        cart = findViewById(R.id.cart);
        phn = findViewById(R.id.phnum);
        id= findViewById(R.id.idn);
        user = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        mDatabase1 = FirebaseDatabase.getInstance().getReference("Users").child("Users").child("Cars");
        ed.setOnClickListener(this);
    }@Override
    public void onClick(View v) {
        if (v == up) {
            updatePassword();
        }}public void updatuser(View V){
            updateUser();
    }public void updatcar(View V){
        editData();
    }
    private void editData(){
        final String cac = carc.getText().toString().trim();
        final String cap = carp.getText().toString().trim();
        final String cat = cart.getText().toString().trim();
        Query editQuery1 = mDatabase1.orderByChild(FirebaseAuth.getInstance().getCurrentUser().getUid());
        Query editQuery2 = mDatabase1.orderByChild(FirebaseAuth.getInstance().getCurrentUser().getUid());
        Query editQuery3 = mDatabase1.orderByChild(FirebaseAuth.getInstance().getCurrentUser().getUid());
        editQuery1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot edtData: dataSnapshot.getChildren()){
                    edtData.getRef().child("CarTyps").setValue(cat);
                }
                Toast.makeText(Setting.this,"Data Edited",Toast.LENGTH_LONG).show();
                }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Setting.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
                });
        editQuery2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot edtData: dataSnapshot.getChildren()){
                    edtData.getRef().child("CarCollor").setValue(cac);
                }
                Toast.makeText(Setting.this,"Data Edited",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Setting.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        editQuery3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot edtData: dataSnapshot.getChildren()){
                    edtData.getRef().child("CarPlate").setValue(cap);
                }
                Toast.makeText(Setting.this,"Data Edited",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Setting.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });}
                private void updateUser(){
        final String idnu = id.getText().toString().trim();
        final String name = usr.getText().toString().trim();
        final String phone = phn.getText().toString().trim();
                    Query editQuery = mDatabase.orderByChild(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    Query editQuery4 = mDatabase.orderByChild(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    Query editQuery5 = mDatabase.orderByChild(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    editQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot edtData: dataSnapshot.getChildren()){
                                edtData.getRef().child("name").setValue(name);
                            }
                            Toast.makeText(Setting.this,"Data Edited",Toast.LENGTH_LONG).show();
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(Setting.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });editQuery4.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot edtData: dataSnapshot.getChildren()){
                                if (idnu.length() != 9) {
                                    id.setError(getString(R.string.input_error_id_length));
                                    id.requestFocus();
                                    return;
                                }
                                edtData.getRef().child("idnumber").setValue(idnu);
                            }
                            Toast.makeText(Setting.this,"Data Edited",Toast.LENGTH_LONG).show();
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(Setting.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });editQuery5.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot edtData: dataSnapshot.getChildren()){
                                if (phone.length() != 10) {
                                    phn.setError(getString(R.string.input_error_phone_invalid));
                                    phn.requestFocus();
                                    return;
                                }
                                edtData.getRef().child("phone").setValue(phone);
                            }
                            Toast.makeText(Setting.this,"Data Edited",Toast.LENGTH_LONG).show();
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(Setting.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });

    }
    private void updatePassword(){
        final String emai = user.getEmail();
        final String oldpassword = oldpwd.getText().toString().trim();
        final String password = pwd.getText().toString().trim();
        AuthCredential credential = EmailAuthProvider.getCredential(emai,oldpassword);

        user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    user.updatePassword(password).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Setting.this, "Something went wrong. Please try again later",Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(Setting.this, "Password Successfully Modified",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else {
                    Toast.makeText(Setting.this,"Authentication Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
            }}