package com.example.lutfi.menuprogram;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayActivity extends ActionBarActivity {
    public SQLiteDatabase dataBase=null;
    private DatabaseHelper helper=null;
    private ArrayList<String> userNama = new ArrayList<String>();
    private ArrayList<String> user_bb = new ArrayList<String>();
    private ArrayList<String> user_tb = new ArrayList<String>();
    private ArrayList<String> user_umur = new ArrayList<String>();
    private ArrayList<String> user_kalori = new ArrayList<String>();
    private ArrayList<String> userId = new ArrayList<String>();
    private AlertDialog.Builder build;

    ListView userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_display);
        helper = new DatabaseHelper(this);
        userList = (ListView) findViewById(R.id.List);
        displayData();


        userList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           final int arg2, long arg3) {



                build = new AlertDialog.Builder(DisplayActivity.this);
                build.setTitle("Delete " + userId.get(arg2) + " "
                        + userNama.get(arg2));
                build.setMessage("Do you want to delete ?");
                build.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog,
                                                int which) {

                                Toast.makeText(
                                        getApplicationContext(),
                                        userId.get(arg2) + " "
                                                + userNama.get(arg2)
                                                + " is deleted.", 3000).show();

                                dataBase.delete(
                                        DatabaseHelper.TABLE_NAME,
                                        DatabaseHelper.KEY_ID + "="
                                                + userId.get(arg2), null);
                                displayData();
                                dialog.cancel();
                            }
                        });

                build.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = build.create();
                alert.show();

                return true;
            }
        });



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
