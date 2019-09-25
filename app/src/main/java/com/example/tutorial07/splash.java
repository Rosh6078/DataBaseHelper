package com.example.tutorial07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class splash extends AppCompatActivity {

    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        sp = getSharedPreferences("foram", Context.MODE_PRIVATE);
        String unam =  sp.getString("username",null);

        if(unam != null){
            Intent intent = new Intent(splash.this, welcome.class);
            startActivity(intent);
            finish();
        }else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(splash.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }, 2000);
        }
        setContentView(R.layout.activity_splash);
    }
}
