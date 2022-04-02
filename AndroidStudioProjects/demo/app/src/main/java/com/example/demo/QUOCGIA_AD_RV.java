package com.example.demo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//tao khung nhin truoc khi extend adapter
public class QUOCGIA_AD_RV extends RecyclerView.Adapter<KHUNGNHIN> {

    public QUOCGIA_AD_RV(Context context, ArrayList<QUOCGIA> data) {
        this.context = context;
        this.data = data;
    }

    //truyen ngu canh, du lieu
    Context context;
    ArrayList<QUOCGIA> data;
    @NonNull
    @Override
    public KHUNGNHIN onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_layout,null);
        return new KHUNGNHIN(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KHUNGNHIN holder, int position) {
        QUOCGIA quocgia = data.get(position);
        holder.flag.setImageResource(quocgia.flag);
        holder.name.setText(quocgia.name);
        holder.popu.setText(quocgia.population);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, item_activity.class);
                QUOCGIA quocgia= data.get(position);
                intent.putExtra("flag", quocgia.flag);
                intent.putExtra("name", quocgia.name);
                intent.putExtra("popu", quocgia.population);
                intent.putExtra("quocgia",quocgia);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
class KHUNGNHIN extends RecyclerView.ViewHolder //khong duoc xai public
{
    //khai bao cac thuoc tinh trong khung nhin
    ImageView flag;
    TextView name, popu;
    //khai bao contructer auto
    public KHUNGNHIN(@NonNull View itemView) {
        super(itemView);
        flag= itemView.findViewById(R.id.flag);
        name=itemView.findViewById(R.id.name);
        popu=itemView.findViewById(R.id.subtitle);
    }
}
