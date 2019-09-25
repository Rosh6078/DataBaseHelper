package com.example.tutorial07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class welcome extends AppCompatActivity {
    TextView lbl;
    DatabaseHelper mydb;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        lbl = findViewById(R.id.lblview);
        mydb =  new DatabaseHelper(this);

        sp =  getSharedPreferences("foram", Context.MODE_PRIVATE);
        String uname = sp.getString("username",null);
        lbl.setText("Welcome " + uname);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem item = menu.findItem(R.id.back);
        item.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.mylogout:
                sp.edit().clear().commit();
                Intent in = new Intent(welcome.this,MainActivity.class);
                startActivity(in);
                finish();
                break;
            case R.id.about:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}