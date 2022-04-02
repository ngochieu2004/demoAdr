package com.example.demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    int requestcode = 2004;
    TextView usn_login, pwd_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //anh xa
        usn_login=findViewById(R.id.usn_login);
        pwd_login=findViewById(R.id.pwd_login);

    }
    public  void register(View view){
        Intent intent =new Intent(Welcome.this, Register.class);
        startActivityForResult(intent,requestcode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==requestcode && resultCode==RESULT_OK)
        {
            usn_login.setText(data.getStringExtra("usn"));
            pwd_login.setText(data.getStringExtra("pwd"));
        }
    }
    public  void login(View view)
    {
        if(usn_login.getText()=="ngochieu2004"&&pwd_login.getText()=="ngochieu2004")
        {
            Intent intent = new Intent(Welcome.this,HomePage.class);
            intent.putExtra("usn",usn_login.getText());
            startActivity(intent);

        }
    }
}