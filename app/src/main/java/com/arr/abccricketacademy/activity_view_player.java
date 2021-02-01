package com.arr.abccricketacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_view_player extends AppCompatActivity {
    EditText mPlayerid, mFirstname,mLastname,mDob,mHeight,mWeight,mSkill,mHouseno,mStreet,mCity,mZipcode,mAcademyId,mCoachId,mTeamId,mSearchId;
    Button mUpdateButton,mDeleteButton,mGetButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_player);

        mUpdateButton = findViewById(R.id.update_button);
        mDeleteButton = findViewById(R.id.delete_button);
        mGetButton = findViewById(R.id.get_button);

        mSearchId = findViewById(R.id.search);
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


        mGetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        mUpdateButton.setOnClickListener(new View.OnClickListener() {
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
                Boolean checkupdatedata = DB.updateuserdata(idTXT, firstnameTXT,lastnameTXT, dobTXT,heightTXT,weightTXT,skillTXT,housenoTXT,streetTXT,cityTXT,zipcodeTXT,academyIdTXT,coachIdTXT,teamIdTXT);

                if(checkupdatedata==true)
                    Toast.makeText(activity_view_player.this, "Player Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(activity_view_player.this, "Player Not Updated", Toast.LENGTH_SHORT).show();

            }
        });


        mDeleteButton.setOnClickListener(new View.OnClickListener() {
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

                Boolean checkdeletedata = DB.deleteuserdata(idTXT, firstnameTXT,lastnameTXT, dobTXT,heightTXT,weightTXT,skillTXT,housenoTXT,streetTXT,cityTXT,zipcodeTXT,academyIdTXT,coachIdTXT,teamIdTXT);
                if(checkdeletedata==true)
                    Toast.makeText(activity_view_player.this, "Player Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(activity_view_player.this, "Player Not Deleted", Toast.LENGTH_SHORT).show();


            }
        });





    }
}