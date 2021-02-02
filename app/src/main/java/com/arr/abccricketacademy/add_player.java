package com.arr.abccricketacademy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_player extends AppCompatActivity {
    EditText mPlayerid, mFirstname,mLastname,mDob,mHeight,mWeight,mSkill,mHouseno,mStreet,mCity,mZipcode,mAcademyId,mCoachId,mTeamId;
    Button mAdd_Button;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        mAdd_Button = findViewById(R.id.add_button);

        mPlayerid = findViewById(R.id.player_id);
        mFirstname = findViewById(R.id.f_name);
        mLastname = findViewById(R.id.l_name);
        mDob = findViewById(R.id.dob);
        mHeight = findViewById(R.id.height);
        mWeight = findViewById(R.id.weight);
        mSkill = findViewById(R.id.skill);
        mHouseno = findViewById(R.id.h_no);
        mStreet= findViewById(R.id.street);
        mCity = findViewById(R.id.city);
        mZipcode = findViewById(R.id.zip_code);
        mAcademyId = findViewById(R.id.academy_id);
        mCoachId = findViewById((R.id.coach_id));
        mTeamId = findViewById(R.id.team_id);


        DB = new DBHelper(this);

        mAdd_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String idTXT = mPlayerid.getText().toString();
                String firstnameTXT = mFirstname.getText().toString();
                String lastnameTXT = mLastname.getText().toString();
                String dobTXT = mDob.getText().toString();
                String heightTXT = mHeight.getText().toString();
                String weightTXT = mWeight.getText().toString();
                String skillTXT = mSkill.getText().toString();
                String housenoTXT = mHouseno.getText().toString();
                String streetTXT = mStreet.getText().toString();
                String cityTXT = mCity.getText().toString();
                String zipcodeTXT = mZipcode.getText().toString();
                String academyIdTXT = mAcademyId.getText().toString();
                String coachIdTXT = mCoachId.getText().toString();
                String teamIdTXT = mTeamId.getText().toString();

                Boolean checkinsertdata = DB.insertplayerdata(idTXT,firstnameTXT,lastnameTXT,dobTXT,heightTXT,weightTXT,skillTXT,housenoTXT,streetTXT,cityTXT,zipcodeTXT,academyIdTXT,coachIdTXT,teamIdTXT);

                if (checkinsertdata) {
                    ///Toast.makeText(add_player.this, "Player Added Successfully", Toast.LENGTH_SHORT).show();

                    mPlayerid.setText(null);
                    mFirstname.setText(null);
                    mLastname.setText(null);
                    mDob.setText(null);
                    mHeight.setText(null);
                    mWeight.setText(null);
                    mSkill.setText(null);
                    mHouseno.setText(null);
                    mStreet.setText(null);
                    mCity.setText(null);
                    mZipcode.setText(null);
                    mAcademyId.setText(null);
                    mCoachId.setText(null);
                    mTeamId.setText(null);


                    StringBuffer buffer = new StringBuffer();

                    buffer.append("Player Id: " + idTXT + "\n");
                    buffer.append("First Name: " + firstnameTXT + "\n");
                    buffer.append("Last Name: " + lastnameTXT + "\n");
                    buffer.append("Dob: " + dobTXT + "\n");
                    buffer.append("Height: " + heightTXT + "\n");
                    buffer.append("Weight: " + weightTXT + "\n");
                    buffer.append("Skill: " + skillTXT + "\n");
                    buffer.append("House No: " + housenoTXT + "\n");
                    buffer.append("Street: " + streetTXT + "\n");
                    buffer.append("City: " + cityTXT + "\n");
                    buffer.append("Zip Code: " + zipcodeTXT + "\n");
                    buffer.append("Academy Id: " + academyIdTXT + "\n");
                    buffer.append("Coach Id: " + coachIdTXT + "\n");
                    buffer.append("Team Id: " + teamIdTXT + "\n\n\n");


                    AlertDialog.Builder builder = new AlertDialog.Builder(add_player.this);
                    builder.setCancelable(true);
                    builder.setTitle("Player Added Successfully");
                    builder.setMessage(buffer.toString());
                    builder.show();
                }
                else {
                    ///Toast.makeText(add_player.this, "Player already Exists\nPlease use Update Player", Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder builder = new AlertDialog.Builder(add_player.this);
                    builder.setCancelable(true);
                    builder.setTitle("Error Adding Player");
                    builder.setMessage("Player already Exists\nPlease use Update Player");
                    builder.show();



                }
            }
        });
    }
}

