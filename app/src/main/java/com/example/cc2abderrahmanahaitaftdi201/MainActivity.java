package com.example.cc2abderrahmanahaitaftdi201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View view) {
        Intent i = null;
        switch(view.getId()){
            case R.id.btn1: i=new Intent(MainActivity.this,ajouter_entreprise.class);break;
            case R.id.btn2: i=new Intent(MainActivity.this,editer_entreprise.class);break;
            case R.id.btn3: i=new Intent(MainActivity.this,list_entreprise.class);break;
        }
        startActivity(i);
    }
}