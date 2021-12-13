package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase_Helper extends SQLiteOpenHelper {

    public DataBase_Helper(Context context){
        super(context,"Userdata.db",null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("Create Table Userdetails(username TEXT primary key,email TEXT,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table is exists Userdetails");

    }

    public Boolean insertUserdata(String username, String email, String password)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Kullanıcı adı" , username);
        contentValues.put("Mail" , email);
        contentValues.put("Şifre" , password);
        long result = DB.insert("Userdetails",null,contentValues);

        if (result== -1){
            return false;

        }else{
            return true;
        }

    }
}
