package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ADAPTERQUOCGIA extends BaseAdapter {

    Context context;
    ArrayList<QUOCGIA> data;

    public ADAPTERQUOCGIA(Context context, ArrayList<QUOCGIA> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view= LayoutInflater.from(context).inflate(R.layout.item_layout,null);
        ImageView img=view.findViewById(R.id.flag);
        TextView name=view.findViewById(R.id.name);
        TextView popu=view.findViewById(R.id.subtitle);
        QUOCGIA quocgia=data.get(i);
        img.setImageResource(quocgia.flag);
        name.setText(quocgia.name);
        popu.setText(quocgia.population);
        return view;
    }
}
