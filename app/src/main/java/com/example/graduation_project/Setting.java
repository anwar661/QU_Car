package com.example.graduation_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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
    Button up,us,delete;
    EditText usr;
    EditText eml;
    EditText pwd,oldpwd;
    EditText phn;
    EditText id;
    FirebaseUser user;
    DatabaseReference mDatabase;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        us= findViewById(R.id.updatuser);
        up = findViewById(R.id.updatpass);
        usr = findViewById(R.id.usrInp);
        eml = findViewById(R.id.em);
        oldpwd = findViewById(R.id.oldpwdInp);
        pwd = findViewById(R.id.pwdInp);
        phn = findViewById(R.id.phnum);
        id= findViewById(R.id.idn);
        delete= findViewById(R.id.del);
        mAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        startActivity(new Intent(Setting.this,home_page.class));
                        break;
                    case R.id.action_req:
                        startActivity(new Intent(Setting.this,Requests.class));
                        break;
                    case R.id.action_set:
                        startActivity(new Intent(Setting.this,Setting.class));
                        break;
                }
                return true;
            }
        });
    }@Override
    public void onClick(View v) {
        if (v == up) {
            updatePassword();
        }}
    public void updatuser(View V){
        updateUser();
    }

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
    }
    public void deleteAccount(View V) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        currentUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Setting.this, "Delete Account is Successfully", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Setting.class));
                    finish();
                } else {
                    Toast.makeText(Setting.this, "Something is wrong!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }public void out(View V){
        mAuth.signOut();
        Intent i=new Intent(this,Loginn.class);
        startActivity(i);
        finish();
    }
}