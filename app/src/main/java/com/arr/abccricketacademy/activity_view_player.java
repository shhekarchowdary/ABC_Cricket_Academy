package com.arr.abccricketacademy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_view_player extends AppCompatActivity {
    EditText mPlayerid, mFirstname,mLastname,mDob,mHeight,mWeight,mSkill,mHouseno,mStreet,mCity,mZipcode,mAcademyId,mCoachId,mTeamId;
    Button mUpdateButton,mDeleteButton,mGetButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_player);

        mUpdateButton = findViewById(R.id.update_button);
        mDeleteButton = findViewById(R.id.delete_button);
        mGetButton = findViewById(R.id.get_button);

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
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(activity_view_player.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;

                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Player Id :" + res.getString(0) + "/n");
                    buffer.append("First Name :" + res.getString(1) + "/n");
                    buffer.append("Last Name :" + res.getString(2) + "/n/n");
                    buffer.append("Dob :" + res.getString(3) + "/n/n/n");
                    buffer.append("Height :" + res.getString(4) + "/n/n/n/n");
                    buffer.append("Weight :" + res.getString(5) + "/n/n/n/n/n");
                    buffer.append("Skill :" + res.getString(6) + "/n/n/n/n/n/n");
                    buffer.append("House No :" + res.getString(7) + "/n/n/n/n/n/n/n");
                    buffer.append("Street :" + res.getString(8) + "/n/n/n/n/n/n/n/n");
                    buffer.append("City :" + res.getString(9) + "/n/n/n/n/n/n/n/n/n");
                    buffer.append("Zip Code :" + res.getString(10) + "/n/n/n/n/n/n/n/n/n/n");
                    buffer.append("Academy Id :" + res.getString(11) + "/n/n/n/n/n/n/n/n/n/n/n/");
                    buffer.append("Coach Id :" + res.getString(12) + "/n/n/n/n/n/n/n/n/n/n/n/n");
                    buffer.append("Team Id :" + res.getString(13) + "/n/n/n/n/n/n/n/n/n/n/n/n/n");

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(activity_view_player.this);
                builder.setCancelable(true);
                builder.setTitle("Cricket Academy");
                builder.setMessage(buffer.toString());
                builder.show();
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
                    Toast.makeText(activity_view_player.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(activity_view_player.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();

            }
        });


        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });





    }
}