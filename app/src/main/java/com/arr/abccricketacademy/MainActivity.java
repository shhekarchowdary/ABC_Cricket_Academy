package com.arr.abccricketacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mAdd_Button;
    Button mView_Button;
    Button mUpdate_Button;
    Button mDelete_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdd_Button = findViewById(R.id.add_button);
        mView_Button = findViewById(R.id.view_button);
        mUpdate_Button = findViewById(R.id.update_button);
        mDelete_Button = findViewById(R.id.delete_button);

        mAdd_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent5 = new Intent(getApplicationContext(), add_player.class);
                startActivity(intent5);

            }
        });

        mView_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(), activity_view_player.class);
                startActivity(intent1);

            }
        });

        mUpdate_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(getApplicationContext(), activity_view_player.class);
                startActivity(intent2);

            }
        });

        mDelete_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent3 = new Intent(getApplicationContext(), activity_view_player.class);
                startActivity(intent3);
            }
        });


    }
}