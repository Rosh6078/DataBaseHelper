package com.example.tutorial07;

public class dbname {
    public static final String DATABASE_NAME = "login.db";
    public static final String TABLE_NAME = "login";
    public static final String ID = "id";
    public static final String UNAME = "uname";
    public static final String PASSWORD = "password";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UNAME + " VARCHAR,"
            + PASSWORD + " VARCHAR"+ ")";
    public static final String[] columns = {UNAME,PASSWORD};
    public static final String selection = UNAME + "=? AND "+ PASSWORD + "=?";

    private int id;
    private String uname;
    private String pass;

    public dbname() {
    }

    public dbname(int id, String uname, String pass) {
        this.id = id;
        this.uname = uname;
        this.pass = pass;
    }

    public dbname(String uname, String pass) {

        this.uname = uname;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
