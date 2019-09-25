package com.example.tutorial07;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, dbname.DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(dbname.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(new StringBuilder().append("DROP TABLE IF EXISTS ").append(dbname.CREATE_TABLE).toString());
        onCreate(db);
    }

    public long addData(String uname,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbname.UNAME,uname);
        values.put(dbname.PASSWORD,pass);

        long id = db.insert(dbname.TABLE_NAME,null,values);
        db.close();
        return id;
    }
    public boolean getData(String uname,String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(dbname.TABLE_NAME, dbname.columns, dbname.selection, new String[]{uname, pass},
                null, null, null);


        if (c.moveToFirst()){
            return true;
        }
        if (c != null) {
            c.close();
        }
        return false;

    }
    public List<dbname> getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<dbname> dn = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM "+ dbname.TABLE_NAME,null);

        while(c.moveToNext())
        {
            dbname d = new dbname();
            d.setId(c.getInt(c.getColumnIndex(dbname.ID)));

            d.setUname(c.getString(c.getColumnIndex(dbname.UNAME)));
            Log.d("test-->",d.getUname());
            d.setPass(c.getString(c.getColumnIndex(dbname.PASSWORD)));
            Log.d("test-->",d.getPass());
            dn.add(d);
        }
        for (dbname test : dn) {
            Log.d("count",String.valueOf(dn.size()));
            String log = "Id: " + test.getId() + " ,Name: " + test.getUname() + " ,password : " + test.getPass();
            Log.d("Name: ", log);
        }
        return dn;
    }
}
