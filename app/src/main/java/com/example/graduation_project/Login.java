package com.example.graduation_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;


    public class Login  extends Activity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            TextView txtV= (TextView) findViewById(R.id.txtvSignUp);
            txtV.setOnClickListener(new View.OnClickListener(){
                public void onClick(View V){
                    Intent it = new Intent(getApplicationContext(),Register.class);
                    startActivity(it);
                    finish();
                }

            });

        }
        public void usrLogIn(View V){

            EditText userName = (EditText) findViewById(R.id.nameInp);
            EditText passInput = (EditText) findViewById(R.id.pwdInp);

            String user = userName.getText().toString();
            String pass = passInput.getText().toString();

            SharedPreferences usrAccounts = getSharedPreferences("UsersAccounts", 0);


            if(!usrAccounts.contains(user)){
                Toast.makeText(getApplicationContext(),"The user account is not existent",Toast.LENGTH_LONG).show();
                return;
            }


            if( (usrAccounts.getString(user,null)).equals(pass))

                Toast.makeText(getApplicationContext(),"The access is authenticated",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"The password entered is wrong",Toast.LENGTH_LONG).show();

        }

    }
