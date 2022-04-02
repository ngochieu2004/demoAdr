package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class demoFragment extends AppCompatActivity {

    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragment.onCreate();
        setContentView(R.layout.activity_demo_fragment);


    }
    public void open_fragment(View view)
    {

        int id= view.getId();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        switch (id)
        {
            case R.id.fragmentA:
                fragment=new FragmentA();
                break;
            case R.id.fragmentB:
                fragment=new FragmentB();
                break;
        }
        transaction.replace(R.id.frame_host,fragment);
        transaction.commit();
    }
}
