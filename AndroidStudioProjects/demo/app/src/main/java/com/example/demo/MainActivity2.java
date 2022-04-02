package com.example.demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView listview;
    ArrayList<QUOCGIA> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listview=findViewById(R.id.listview);
        data.add(new QUOCGIA(R.drawable.vietnam,"VIET NAM","100000000"));
        data.add(new QUOCGIA(R.drawable.usa,"HOA KY","100000000"));
        data.add(new QUOCGIA(R.drawable.argentina,"ARGENTINA","1089700000"));
        data.add(new QUOCGIA(R.drawable.brazil,"BRAZIL","249483624"));
        data.add(new QUOCGIA(R.drawable.singapore,"SINGAPORE","249579503"));
        data.add(new QUOCGIA(R.drawable.switzerland,"SWITZERLAND","61001745"));
        data.add(new QUOCGIA(R.drawable.cambodia,"CAMBODIA","9037483"));
        ListAdapter quocgiaadap=new ADAPTERQUOCGIA(this,data);
        listview.setAdapter(quocgiaadap);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity2.this, item_activity.class);
                QUOCGIA quocgia= data.get(i);
                intent.putExtra("flag", quocgia.flag);
                intent.putExtra("name", quocgia.name);
                intent.putExtra("popu", quocgia.population);
                startActivity(intent);
            }
        });


//        String[] data={"Data Row 1","Data Row 2","Data Row 3","Data Row 4","Data Row 5","Data Row 6","Data Row 7","Data Row 8"};
//        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data){
//            @NonNull
//            @Override
//            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//                View view= super.getView(position, convertView, parent);
//                TextView text= view.findViewById(android.R.id.text1);
//                text.setTextColor(Color.BLUE);
//                text.setTextSize(25);
//                text.setGravity(1);
//                text.setPadding(15,15,15,15);
//                return view;
//            }
//        };
//
//        listview.setAdapter(adapter);
    }

}