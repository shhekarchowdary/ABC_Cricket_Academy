package com.arr.abccricketacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.ContentValues;
import android.content.Intent;
import android.opengl.GLDebugHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_player extends AppCompatActivity {
    EditText Playerid, Firstname,Lastname, Dob,Height,Weight,Skill,Houseno,Street,City,Zipcode;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        Playerid = findViewById(R.id.Playerid);
        Firstname = findViewById(R.id.viewdata);
        Lastname = findViewById(R.id.viewdata);
        Dob = findViewById(R.id.update);
        Height = findViewById(R.id.viewdata);
        Weight = findViewById(R.id.viewdata);
        Skill = findViewById(R.id.viewdata);
        Houseno = findViewById(R.id.viewdata);
        Street= findViewById(R.id.viewdata);
        City = findViewById(R.id.viewdata);
        Zipcode = findViewById(R.id.viewdata);

        Addfields = findViewById(R.id.delete);
        DB = new DBHelper(this);
        Addfields.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String idTXT = Playerid.getText().toString();
                String firstnameTXT = Firstname.getText().toString();
                String lastnameTXT = Lastname.getText().toString();
                String dobTXT = Dob.getText().toString();
                String heightTXT = Height.getText().toString();
                String weightTXT = Weight.getText().toString();
                String skillTXT = Skill.getText().toString();
                String housenoTXT = Houseno.getText().toString();
                String streetTXT = Street.getText().toString();
                String cityTXT = City.getText().toString();
                String zipcodeTXT = Zipcode.getText().toString();
                Boolean checkinsertdata = DB.insertuserdata(idTXT, firstnameTXT,lastnameTXT, dobTXT,heightTXT,weightTXT,weightTXT,skillTXT,housenoTXT,streetTXT,cityTXT, zipcodeTXT);
                if (checkinsertdata == true)
                    Toast.makeText(add_player.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(add_player.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();


            }
        });
    }
}

