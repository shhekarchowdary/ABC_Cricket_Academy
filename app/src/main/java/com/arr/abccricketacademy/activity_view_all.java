package com.arr.abccricketacademy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class activity_view_all extends AppCompatActivity {

    Button mView_all_button,mView_individual_button;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        mView_all_button = findViewById(R.id.view_all_button);
        mView_individual_button = findViewById(R.id.view_individual_button);
        DB = new DBHelper(this); //calling DBHelper constructor

        mView_all_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ///Toast.makeText(activity_update_delete_player.this, "Searching Database", Toast.LENGTH_SHORT).show();
                Cursor res = DB.viewall();
                //Calling viewall function to select all data from Database using DBHelper

                if (res.getCount() == 0) {
                    Toast.makeText(activity_view_all.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Player Id: " + res.getString(0)+"\n");
                    buffer.append("First Name: " + res.getString(1)+"\n");
                    buffer.append("Last Name: " + res.getString(2)+"\n");
                    buffer.append("Dob: " + res.getString(3)+"\n");
                    buffer.append("Height: " + res.getString(4)+"\n");
                    buffer.append("Weight: " + res.getString(5)+"\n");
                    buffer.append("Skill: " + res.getString(6)+"\n");
                    buffer.append("House No: " + res.getString(7)+"\n");
                    buffer.append("Street: " + res.getString(8)+"\n");
                    buffer.append("City: " + res.getString(9)+"\n");
                    buffer.append("Zip Code: " + res.getString(10)+"\n");
                    buffer.append("Academy Id: " + res.getString(11)+"\n");
                    buffer.append("Coach Id: " + res.getString(12)+"\n");
                    buffer.append("Team Id: " + res.getString(13)+"\n\n\n");

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(activity_view_all.this);
                builder.setCancelable(true);
                builder.setTitle("All Players");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

        mView_individual_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent2 = new Intent(getApplicationContext(), activity_update_delete_player.class);
                    startActivity(intent2);

            }
        });

    }
}