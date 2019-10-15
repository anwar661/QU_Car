package com.example.graduation_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends Activity implements View.OnClickListener {
    ProgressBar progressBar;
    Button singup;
    EditText usr;
    EditText eml;
    EditText pwd;
    EditText idn;
    EditText phn;
    FirebaseAuth mAuth;
    Toolbar toolbar;
    DatabaseReference userdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        progressBar = findViewById(R.id.progressBar);
        singup = findViewById(R.id.btnSingUp);
        usr = findViewById(R.id.usrInp);
        eml = findViewById(R.id.em);
        pwd = findViewById(R.id.pwdInp);
        idn = findViewById(R.id.idnum);
        phn = findViewById(R.id.phnum);

        userdatabase = FirebaseDatabase.getInstance().getReference("Users");

        progressBar.setVisibility(View.GONE);

        mAuth = FirebaseAuth.getInstance();

        singup.setOnClickListener(this);

        if (mAuth.getCurrentUser() != null) {
            //handle the already login user
           // Toast.makeText(this, "This user already registered", Toast.LENGTH_LONG).show();
        }

    }@Override
    public void onClick(View v) {
        if (v == singup) {
            registerUser();
        }
    }
    private void registerUser() {
        final String name = usr.getText().toString().trim();
        final String email = eml.getText().toString().trim();
        final String password = pwd.getText().toString().trim();
        final String phone = phn.getText().toString().trim();
        final String idnumber = idn.getText().toString().trim();

        if (name.isEmpty()) {
        usr.setError(getString(R.string.input_error_name));
        usr.requestFocus();
        return;
    }

        if (email.isEmpty()) {
        eml.setError(getString(R.string.input_error_email));
        eml.requestFocus();
        return;
    }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        eml.setError(getString(R.string.input_error_email_invalid));
        eml.requestFocus();
        return;
    }

        if (password.isEmpty()) {
        pwd.setError(getString(R.string.input_error_password));
        pwd.requestFocus();
        return;
    }

        if (password.length() < 6) {
        pwd.setError(getString(R.string.input_error_password_length));
        pwd.requestFocus();
        return;
    }

        if (phone.isEmpty()) {
        phn.setError(getString(R.string.input_error_phone));
        phn.requestFocus();
        return;
    }

        if (phone.length() != 10) {
        phn.setError(getString(R.string.input_error_phone_invalid));
        phn.requestFocus();
        return;
    }
        if (idnumber.isEmpty()) {
            Toast.makeText(this, "Please enter your ID number", Toast.LENGTH_LONG).show();
            idn.requestFocus();
            return;
        }
       // if (!idnumber.isEmpty()) {
         //   userdatabase.push().getKey();
        //}
        if (idnumber.length() != 9) {
            Toast.makeText(this, "Your ID number is invalid", Toast.LENGTH_LONG).show();
            idn.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(Register.this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            User user = new User(
                                    name,
                                    email,
                                    phone,
                                    idnumber,
                                    password
                            );
                            userdatabase.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(Register.this,new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(getApplicationContext(), home_page.class));
                                        finish();
                                    } else {
                                        Toast.makeText(Register.this, "Can't Register", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                        } else {
                            Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
 }
    
