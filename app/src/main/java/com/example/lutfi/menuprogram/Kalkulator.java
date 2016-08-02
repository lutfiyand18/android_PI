package com.example.lutfi.menuprogram;

import android.app.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.name;
import static android.R.id.list;

public class Kalkulator extends Activity {
    EditText ed_nama, ed_tb, ed_bb, ed_jk, ed_umur;
    Spinner sp_akt, sp_jekel;
    TextView tvHasil;
    double laki2[] = {1.56, 1.76, 2.10};
    double cewe2[] = {1.55, 1.70, 2.00};
    String arrayspinner[] = {"ringan", "sedang", "berat"};
    String jekel[] = {"Pria", "Wanita"};
    Button bt_cek;


    String tampungJekel = null;
    String nilAktf;
    String totalkalori;
    double hasilNaktif;

    String ambilNama;
    String ambilberat_badan, ambiltinggi_badan, ambilUmur ;
    double hitungAMB, hitungKalori,hitungIMT;

    int aum,abb,atb;

    List<StudentsModel> list = new ArrayList<StudentsModel>();
    DatabaseHelper helper=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);
        ed_nama = (EditText) findViewById(R.id.nama);
        ed_bb = (EditText) findViewById(R.id.bb);
        ed_tb = (EditText) findViewById(R.id.tb);
        ed_umur = (EditText) findViewById(R.id.umur);
        sp_akt = (Spinner) findViewById(R.id.spinaktivitas);
        sp_jekel = (Spinner) findViewById(R.id.spin_Jekel);
        bt_cek = (Button) findViewById(R.id.btncek);
        tvHasil = (TextView)findViewById(R.id.tvshow);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayspinner);
        sp_akt.setAdapter(adapter);

        ArrayAdapter<String> adapterJekel = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jekel);
        sp_jekel.setAdapter(adapterJekel);

        helper = new DatabaseHelper(this);

        bt_cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ambilNama = ed_nama.getText().toString();
                ambilUmur = ed_umur.getText().toString();
                ambilberat_badan = ed_bb.getText().toString();
                ambiltinggi_badan = ed_tb.getText().toString();

                aum= Integer.parseInt(ambilUmur);
                abb= Integer.parseInt(ambilberat_badan);
                atb = Integer.parseInt(ambiltinggi_badan);
                //mengambil data nilai aktifitas
                nilAktf = sp_akt.getSelectedItem().toString();

                // mengambil data jenis kelamin


                tampungJekel = sp_jekel.getSelectedItem().toString();




                //ringan dan laki2
                if (nilAktf.equals(arrayspinner[0]) && tampungJekel.equals(jekel[0])) {

                    hasilNaktif = laki2[0];

                }
                //sedang dan laki2
                else if (nilAktf.equals(arrayspinner[1]) && tampungJekel.equals(jekel[0])){

                    hasilNaktif = laki2[1];
                }
                //berat dan laki2
                else if (nilAktf.equals(arrayspinner[2] ) && tampungJekel.equals(jekel[0])) {

                    hasilNaktif = laki2[2];

                }
                //ringan dan wanita
                else if (nilAktf.equals(arrayspinner[0]) && tampungJekel.equals(jekel[1]))
                {
                    hasilNaktif = cewe2[0];
                }
                //sedang dan wanita
                else if (nilAktf.equals(arrayspinner[1]) && tampungJekel.equals(jekel[1])){

                    hasilNaktif = cewe2[1];
                }

                else if (nilAktf.equals(arrayspinner[2]) && tampungJekel.equals(jekel[1])){

                    hasilNaktif = cewe2[2];
                }

                 hitungIMT = abb / ((atb/100) * (atb/100));


                if (tampungJekel.equals(jekel[0]))
                {

                    hitungAMB= 66.5+(13.7*abb)+(5.0*atb)-(6.8*aum);
                    //hitung AMB wanita

                }

                else if(tampungJekel.equals(jekel[1]))

                {

                     hitungAMB= 655+(9.6*abb)+(1.8*atb)-(4.7*aum);

                }


                hitungKalori= hasilNaktif * hitungAMB;

                totalkalori = Double.toString(hitungKalori);

              //  tvHasil.setText(" Nilai IMT =" + hitungIMT + "Nilai Kalori =" + hitungKalori);

              //  Toast.makeText(getApplicationContext(), totalkalori, Toast.LENGTH_LONG ).show();
            /*   StudentsModel student = new StudentsModel(1,"aadsfdsf","tester");
                db.addStudentDetail(student);

                List<StudentsModel> list2a = new ArrayList<StudentsModel>();
                try {
                    list2a = db.getAllStudentsList();
                } catch (NullPointerException e){
                    Log.e("Error DB Luthfi Null :",e.getMessage());
                }
                print(list);
                */

                masukkanevent(ambilNama,ambilberat_badan,ambiltinggi_badan,ambilUmur,totalkalori);

                  loaddata();

            }
        });



    }


/*    private void print(List<StudentsModel> list) {

        String value = "";
        for(StudentsModel sm : list){
            value = value+"id: "+sm.id+", name: "+sm.name+" Ph_no: "+sm.phone_number+"\n";
        }
        Log.e("Hasilnya adalah : ",value);
        tvHasil.setText(value);
    }*/

    public void loaddata(){

      //  helper.insert("a","a","a","b");
        Cursor c = helper.getAll();
        String tampil= "";
        if (c.moveToFirst()) {
            do {
                tampil+=c.getString(1) + c.getString(2) + c.getString(3) + c.getString(4)+ c.getString(5) +"\n";

                Log.e("tes",c.getString(0));
            } while (c.moveToNext());
        } else {
            tvHasil.setText("Tidak dieksekusi");
        }

        tvHasil.setText(tampil);
        c.close();

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent keMenuDataGizi = new Intent(Kalkulator.this, DisplayActivity.class);
                        startActivity(keMenuDataGizi);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        Intent keMenuUtama = new Intent(Kalkulator.this, Menu1.class);
                        startActivity(keMenuUtama);
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Mau lihat data penggunaan kalkulator?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();



    }


    public void masukkanevent(String a, String b, String c, String d, String e){

       helper.insert(a,b,c,d,e);

        Toast.makeText(this, a+b+c+d, Toast.LENGTH_LONG).show();


    }

    }
