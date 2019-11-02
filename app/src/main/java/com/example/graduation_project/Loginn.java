package com.example.graduation_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.content.ContentValues.TAG;


public class Loginn  extends Activity implements View.OnClickListener{
    Button button;
    EditText email;
    EditText password;
    ProgressBar progressBar;
    TextView txtV;
    TextView txtf;
    FirebaseAuth mAuth;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            email =findViewById(R.id.em);
            password =findViewById(R.id.pwdInp);
            button =findViewById(R.id.logInBtn);
            txtV =findViewById(R.id.txtvSignUp);
            txtf =findViewById(R.id.forg);
            progressBar = findViewById(R.id.progressBar);
            mAuth = FirebaseAuth.getInstance();
            button.setOnClickListener(this);
            txtV.setOnClickListener(this);

        }
    public void fog(View V){
        Intent i=new Intent(this,ResetPassword.class);
        startActivity(i);
    }
        @Override
        public void onClick(View v) {
            if ( v == button){
                userLogIn();}
            if( v== txtV){
                Intent i=new Intent(this,Register.class);
                startActivity(i);
            }
        }

        private void userLogIn() {
           final String eml = email.getText().toString().trim();
            final String pass = password.getText().toString().trim();
            if (eml.isEmpty()) {
                email.setError(getString(R.string.input_error_email));
                email.requestFocus();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(eml).matches()) {
                email.setError(getString(R.string.input_error_email_invalid));
                email.requestFocus();
                return;
            }

            if (pass.isEmpty()) {
                password.setError(getString(R.string.input_error_password));
                password.requestFocus();
                return;
            }

            if (pass.length() < 6) {
                password.setError(getString(R.string.input_error_password_length));
                password.requestFocus();
                return;
            }
          progressBar.setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(eml,pass)
                .addOnCompleteListener(Loginn.this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithEmail:success");
                            startActivity( new Intent(getApplicationContext(),home_page.class));
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(Loginn.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        }}
