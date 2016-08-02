package com.example.lutfi.menuprogram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu1 extends AppCompatActivity {
    Button bt_seputar;
    Button bt_kalkulator;
    Button bt_datagizi;
    Button bt_keluar;
    Button bt_bantuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);
        bt_seputar = (Button) findViewById(R.id.btnseputar);
        bt_datagizi = (Button) findViewById(R.id.btndatgizi);
        bt_kalkulator = (Button) findViewById(R.id.btnkalgizi);
        bt_keluar=(Button)findViewById(R.id.btnkembali);
        bt_bantuan=(Button)findViewById(R.id.btnbantuan);
        bt_keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Keluar dari Aplikasi", Toast.LENGTH_LONG).show();
              System.exit(1);
            }
        });
        bt_seputar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keMenuSeputar = new Intent(Menu1.this, InfoGizi.class);
                startActivity(keMenuSeputar);
            }
        });
        bt_kalkulator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keMenuKalkulator = new Intent(Menu1.this, Kalkulator.class);
                startActivity(keMenuKalkulator);
            }
        });
        bt_datagizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keMenuDataGizi = new Intent(Menu1.this, DisplayActivity.class);
                startActivity(keMenuDataGizi);
            }
        });




    }

}
