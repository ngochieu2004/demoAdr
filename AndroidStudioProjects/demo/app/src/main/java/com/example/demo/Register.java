package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText usn_create;
    EditText pwd_create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //anh xa view qua activity
        usn_create=findViewById(R.id.usn_create);
        pwd_create=findViewById(R.id.pwd_create);

    }
    public  void signin(View view)
    {
        //truyen du lieu qua intent
        Intent intent=getIntent();
        intent.putExtra("usn",usn_create.getText().toString());
        intent.putExtra("pwd",pwd_create.getText().toString());

        setResult(RESULT_OK,intent);//tra ket qua
        this.finish();//dong man hinh
    }

    public  void cancel(View view)
    {
        Intent intent=getIntent();
        setResult(RESULT_OK,intent);//tra ket qua
        this.finish();//dong man hinh
    }
}