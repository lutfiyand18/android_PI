package com.example.lutfi.menuprogram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteException;
import android.util.Log;


/**
 * Created by johan on 16/07/16.
 */

public class DatabaseHelper extends  SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pengguna.db";
    private static final int SCHEMA_VERSION= 1;
    public static final String TABLE_NAME="pengguna";
    public static final String KEY_NAME="nama";
    public static final String KEY_TB="tinggibadan";
    public static final String KEY_BB="beratbadan";
    public static final String KEY_UMUR="umur";
    public static final String KEY_KALORI="kalori";

    public static final String KEY_ID="id";


    public DatabaseHelper(Context contex){
            super(contex, DATABASE_NAME, null, SCHEMA_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE pengguna  (id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, tinggibadan TEXT, beratbadan TEXT, umur TEXT , kalori TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public Cursor getAll(){

        //return  (getReadableDatabase().rawQuery(" SELECT * FROM pengguna ",null));
        //this.insert("Johan","Johan","Johan","Johan");
       return getReadableDatabase().rawQuery("SELECT * FROM pengguna",null);


    }

    public void insert(String snama, String stinggibadan, String sberatbadan, String umur, String kalori){
        try {
           // String sql = "INSERT INTO pengguna VALUES(null,'" + snama + "','" + stinggibadan + "','" + sberatbadan + "','" + snama + "');";
            //getWritableDatabase().rawQuery(sql, null);
            ContentValues values = new ContentValues();
            values.put("nama",snama);
            values.put("tinggibadan",stinggibadan);
            values.put("beratbadan",sberatbadan);
            values.put("umur",umur);
            values.put("kalori",kalori);
            this.getWritableDatabase().insert("pengguna",null,values);
            Log.e("Sqlnya: ",values.toString());
        } catch (Exception e){
            Log.e("error databasenya",e.getMessage());
        }
    }

    public String getNama(Cursor c){

         return  (c.getString(1));
    }


    public String getTinggiBadan(Cursor c){

        return  (c.getString(2));
    }

    public String getBeratBadan(Cursor c){


        return  (c.getString(3));
    }

    public String getUmur(Cursor c){

        return  (c.getString(4));
    }
}
