package com.example.lutfi.menuprogram;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayActivity extends Activity {
    private SQLiteDatabase dataBase;
    private DatabaseHelper helper=null;
    private ArrayList<String> userNama = new ArrayList<String>();
    private ArrayList<String> user_bb = new ArrayList<String>();
    private ArrayList<String> user_tb = new ArrayList<String>();
    private ArrayList<String> user_umur = new ArrayList<String>();
    private ArrayList<String> user_kalori = new ArrayList<String>();
    private ArrayList<String> userId = new ArrayList<String>();

    ListView userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);



        userList = (ListView) findViewById(R.id.List);
        displayData();
    }

    public void displayData() {

        helper = new DatabaseHelper(this);

        Cursor c = helper.getAll();

  /*      userNama.clear();
        user_bb.clear();
        user_tb.clear();
        user_umur.clear();
        user_kalori.clear();*/

        if (c.moveToFirst()) {
            do {
                userId.add(c.getString(0));
                userNama.add(c.getString(1));
                user_bb.add(c.getString(2));
                user_tb.add(c.getString(3));
                user_umur.add(c.getString(4));
                user_kalori.add(c.getString(5));
            } while (c.moveToNext());
        }
        DisplayAdapter disadpt = new DisplayAdapter(DisplayActivity.this,userId, userNama, user_bb, user_tb, user_umur, user_kalori);
        userList.setAdapter(disadpt);
        c.close();
    }

}
