package com.example.lutfi.menuprogram;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * adapter to populate listview with data
 * @author ketan(Visit my <a
 *         href="http://androidsolution4u.blogspot.in/">blog</a>)
 */
public class DisplayAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> id;
    private ArrayList<String> nama;
    private ArrayList<String> beratbadan;
    private ArrayList<String> tinggibadan;

    private ArrayList<String> umur;
    private ArrayList<String> kalori;





    public DisplayAdapter(Context c, ArrayList<String> id,ArrayList<String> nama, ArrayList<String> beratbadan,ArrayList<String> tinggibadan,
                          ArrayList<String> umur, ArrayList<String> kalori
    ) {

        this.mContext=c;
        this.id = id;
        this.nama = nama;
        this.beratbadan = beratbadan;
        this.tinggibadan = tinggibadan;
        this.umur=umur;
        this.kalori=kalori;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return id.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int pos, View child, ViewGroup parent) {
        Holder mHolder;
        LayoutInflater layoutInflater;
        if (child == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.listcell, null);
            mHolder = new Holder();
            mHolder.txt_id = (TextView) child.findViewById(R.id.txt_id);
            mHolder.txt_Nam = (TextView) child.findViewById(R.id.txt_nama);
            mHolder.txt_BB= (TextView) child.findViewById(R.id.txt_bb);
            mHolder.txt_TB= (TextView) child.findViewById(R.id.txt_tb);
            mHolder.txt_Umur= (TextView) child.findViewById(R.id.txt_umur);
            mHolder.txt_Kalor= (TextView) child.findViewById(R.id.txt_kalori);




            child.setTag(mHolder);
        } else {
            mHolder = (Holder) child.getTag();
        }
        mHolder.txt_id.setText(id.get(pos));
        mHolder.txt_Nam.setText(nama.get(pos));
        mHolder.txt_BB.setText(beratbadan.get(pos));
        mHolder.txt_TB.setText(tinggibadan.get(pos));
        mHolder.txt_Umur.setText(umur.get(pos));
        mHolder.txt_Kalor.setText(kalori.get(pos));


        return child;
    }

    public class Holder {
        TextView txt_id;
        TextView txt_Nam;
        TextView txt_BB;
        TextView txt_TB;
        TextView txt_Umur;
        TextView txt_Kalor;

    }

}