package com.example.lutfi.menuprogram;

import android.app.Activity;
import android.database.Cursor;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class DataGizi extends Activity {
TextView tv;
Button loadme;
    DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_gizi);
        tv=(TextView)findViewById(R.id.tvhasil);
        loadme = (Button)findViewById(R.id.loadButton);


        loadme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadaja();
            }
        });

    }
    public void loadaja(){

        //  helper.insert("a","a","a","b");
        Cursor c = helper.getAll();
        String tampil= "";
        if (c.moveToFirst()) {
            do {
                tampil+=c.getString(1) + c.getString(2) + c.getString(3) + c.getString(4)+"\n";

                Log.e("tes",c.getString(0));
            } while (c.moveToNext());
        } else {
            tv.setText("Tidak dieksekusi");
        }

        tv.setText(tampil);
        c.close();
    }
}
