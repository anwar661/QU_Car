package com.example.graduation_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.os.Bundle;

public class Driver_information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_information);
    }
    public void Call (View view){
        Intent Call =new Intent(Intent.ACTION_CALL);
        Call.setData(Uri.parse("tel:9961907453"));
        if (ActivityCompat.checkSelfPermission(Driver_information.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(Call);
    }

}
