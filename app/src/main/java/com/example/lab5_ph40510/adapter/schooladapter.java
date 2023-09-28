package com.example.lab5_ph40510.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab5_ph40510.R;
import com.example.lab5_ph40510.model.school;

import java.util.ArrayList;

public class schooladapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<school> list;

    public schooladapter(Context context, ArrayList<school> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        view=inflater.inflate(R.layout.item_bai1, viewGroup,false);

        ImageView imghinh = view.findViewById(R.id.imghinh);
        TextView txtcoso = view.findViewById(R.id.txtcoso);

         imghinh.setImageResource(list.get(i).getHinh());
         txtcoso.setText(list.get(i).getTencs());

        return view;
    }
}
