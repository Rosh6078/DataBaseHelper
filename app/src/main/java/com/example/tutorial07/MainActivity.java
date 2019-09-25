package com.example.tutorial07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtusername,edtpassword;
    DatabaseHelper db;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtusername = findViewById(R.id.username);
        edtpassword = findViewById(R.id.password);
        db = new DatabaseHelper(this);
        sp = getSharedPreferences("foram", Context.MODE_PRIVATE);
    }
    public void login(View view) {
        String valUsername = edtusername.getText().toString();
        String valPassword = edtpassword.getText().toString();
        boolean b =db.getData(valUsername,valPassword);
        if(b == true){
            Toast.makeText(MainActivity.this, "Sucessfully Login !!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,welcome.class);
            startActivity(intent);
            finish();
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("username",valUsername);
            editor.commit();
        }else{
            Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }
    }
    public void regi(View view){
        Intent intent = new Intent(MainActivity.this,register.class);
        startActivity(intent);
        finish();
    }


}

