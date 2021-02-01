package com.arr.abccricketacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Add;
    Button ViewData;
    Button Update;
    Button Delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Add=findViewById(R.id.add);
        ViewData=findViewById(R.id.viewdata);
        Update=findViewById(R.id.update);
        Delete=findViewById(R.id.delete);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent=new Intent(MainActivity.this,Add.class);
                startActivity(intent);
            }
        });
        ViewData.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Intent intentview=new Intent(MainActivity.this,ViewData.class);
                        startActivity(intentview);
                    }

        } );
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intentupdate=new Intent(MainActivity.this,Update.class);
                startActivity(intentupdate);
            }

        } );
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intentdelete=new Intent(MainActivity.this,Delete.class);
                startActivity(intentdelete);
            }

        } );
    }
}