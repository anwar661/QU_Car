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
            email = (EditText) findViewById(R.id.em);
            password = (EditText) findViewById(R.id.pwdInp);
            button = (Button) findViewById(R.id.logInBtn);
            txtV = (TextView) findViewById(R.id.txtvSignUp);
            txtf = (TextView) findViewById(R.id.forg);
            mAuth = FirebaseAuth.getInstance();
            button.setOnClickListener(this);
            txtV.setOnClickListener(this);
        }
    public void fog(View V){
        Intent i=new Intent(this,ResetPassword.class);
        startActivity(i);
        finish();
    }
        @Override
        public void onClick(View v) {
            if ( v == button){
                userLogIn();}
            if( v== txtV){
                Intent i=new Intent(this,Register.class);
                startActivity(i);
                finish();
            }
        }

        private void userLogIn() {
           final String eml = email.getText().toString().trim();
            final String pass = password.getText().toString().trim();
            if (eml.isEmpty()) {
                Toast.makeText(this,"Please enter your Email", Toast.LENGTH_LONG).show();
                email.requestFocus();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(eml).matches()) {
                Toast.makeText(this,"Your Email is invalid", Toast.LENGTH_LONG).show();
                email.requestFocus();
                return;
            }

            if (pass.isEmpty()) {
                Toast.makeText(this,"Please enter your password", Toast.LENGTH_LONG).show();
                password.requestFocus();
                return;
            }

            if (pass.length() < 6) {
                Toast.makeText(this,"Your password is invalid", Toast.LENGTH_LONG).show();
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
                            Toast.makeText(Loginn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        }}
