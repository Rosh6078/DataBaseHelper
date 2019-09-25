package com.example.tutorial07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText user,pass;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user = findViewById(R.id.ruser);
        pass = findViewById(R.id.rpass);
        db = new DatabaseHelper(this);
    }
    public void login(View view){
        Intent intent = new Intent(register.this,MainActivity.class);
        startActivity(intent);
    }
    public void register(View view){
        String u = user.getText().toString();
        String p = pass.getText().toString();

        long id = db.addData(u,p);
        if(id>0){
            Toast.makeText(register.this, "Data Sucessfully Inserted !!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(register.this,MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(register.this, "Error !!", Toast.LENGTH_SHORT).show();
        }
    }
}
