package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class item_activity extends AppCompatActivity {

    ImageView flag;
    TextView name,popu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        flag=findViewById(R.id.imageView1);
        name=findViewById(R.id.name22);
        popu=findViewById(R.id.popu);
        Intent intent=getIntent();
        QUOCGIA quocgia= (QUOCGIA)intent.getSerializableExtra("quocgia");
        flag.setImageResource(intent.getIntExtra("flag",R.drawable.argentina));
        name.setText(intent.getStringExtra("name"));
        popu.setText(intent.getStringExtra("popu"));
    }
}