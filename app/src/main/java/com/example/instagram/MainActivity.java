package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
 ProgressBar progressBar;
 int timeout =3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progres);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent=new Intent(MainActivity.this,login.class);
                startActivity(homeintent);
                finish();
            }
        },timeout);
    }
}
