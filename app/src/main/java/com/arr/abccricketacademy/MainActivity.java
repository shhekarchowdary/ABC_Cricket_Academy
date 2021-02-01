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

                Intent intent = new Intent(getApplicationContext(), add_player.class);
                startActivity(intent);

            }
        });

        mView_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), activity_view_delete_update.class);
                startActivity(intent);

            }
        });

        mUpdate_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), activity_view_delete_update.class);
                startActivity(intent);

            }
        });

        mDelete_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), activity_view_delete_update.class);
                startActivity(intent);
            }
        });


    }
}