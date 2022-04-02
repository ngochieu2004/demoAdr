package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class demoRecycleView extends AppCompatActivity {

    RecyclerView recycleview;
    ArrayList<QUOCGIA> data=new ArrayList<>();
    QUOCGIA_AD_RV quocgiaadpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_recycle_view);

        recycleview=findViewById(R.id.recycleview);
        //tao data
        data.add(new QUOCGIA(R.drawable.vietnam,"VIET NAM","100000000"));
        data.add(new QUOCGIA(R.drawable.usa,"HOA KY","100000000"));
        data.add(new QUOCGIA(R.drawable.argentina,"ARGENTINA","1089700000"));
        data.add(new QUOCGIA(R.drawable.brazil,"BRAZIL","249483624"));
        data.add(new QUOCGIA(R.drawable.singapore,"SINGAPORE","249579503"));
        data.add(new QUOCGIA(R.drawable.switzerland,"SWITZERLAND","61001745"));
        data.add(new QUOCGIA(R.drawable.cambodia,"CAMBODIA","9037483"));
        //tao apdater
        quocgiaadpter=new QUOCGIA_AD_RV(this,data);
        //gan adapter vao view
        recycleview.setAdapter(quocgiaadpter);
        //hien thi view
        recycleview.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

//        recycleview.addOnItemTouchListener(new RecyclerTouchListener(this, recycleview, new RecyclerTouchListener.ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                Intent intent=new Intent(demoRecycleView.this, item_activity.class);
//                QUOCGIA quocgia= data.get(position);
//                intent.putExtra("flag", quocgia.flag);
//                intent.putExtra("name", quocgia.name);
//                intent.putExtra("popu", quocgia.population);
//                startActivity(intent);
//            }
//
////            @Override
////            public void onLongClick(View view, int position) {
////
////            }
//        }));

    }
}

class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

    //tao interface de goi ham
    public static interface ClickListener {
        public void onClick(View view, int position);
        //public void onLongClick(View view, int position);
    }

    private ClickListener   clicklistener;

    //Đối tượng để phát hiện ra onLongPress trên phần tử
    //clicklistener.onLongClick
    //private GestureDetector gestureDetector;

    public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener){

        this.clicklistener=clicklistener;

//        gestureDetector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
//            @Override
//            public boolean onSingleTapUp(MotionEvent e) {
//                return true;
//            }
//
//            @Override
//            public void onLongPress(MotionEvent e) {
//                View child=recycleView.findChildViewUnder(e.getX(),e.getY());
//                if(child!=null && clicklistener!=null){
//                    clicklistener.onLongClick(child,recycleView.getChildAdapterPosition(child));
//                }
//            }
//        });
    }
    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        View child=rv.findChildViewUnder(e.getX(),e.getY());
        //TH chi co click
        if(child!=null && clicklistener!=null){
            clicklistener.onClick(child,rv.getChildAdapterPosition(child));
        }
        //TH co longclick
//        if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
//            clicklistener.onClick(child,rv.getChildAdapterPosition(child));
//        }

        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}