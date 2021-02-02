package com.arr.abccricketacademy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_update_delete_player extends AppCompatActivity {
    EditText mPlayerid1, mFirstname1,mLastname1,mDob1,mHeight1,mWeight1,mSkill1,mHouseno1,mStreet1,mCity1,mZipcode1,mAcademyId1,mCoachId1,mTeamId1,mSearchId;
    Button mUpdateButton,mDeleteButton,mGetButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_player);

        mUpdateButton = findViewById(R.id.update_button);
        mDeleteButton = findViewById(R.id.delete_button);
        mGetButton = findViewById(R.id.get_button);

        mSearchId = findViewById(R.id.search);
        mPlayerid1 = findViewById(R.id.player_idv);
        mFirstname1 = findViewById(R.id.f_namev);
        mLastname1 = findViewById(R.id.l_namev);
        mDob1 = findViewById(R.id.dobv);
        mHeight1 = findViewById(R.id.heightv);
        mWeight1 = findViewById(R.id.weightv);
        mSkill1 = findViewById(R.id.skillv);
        mHouseno1 = findViewById(R.id.h_nov);
        mStreet1= findViewById(R.id.streetv);
        mCity1 = findViewById(R.id.cityv);
        mZipcode1 = findViewById(R.id.zip_codev);
        mAcademyId1 = findViewById(R.id.academy_idv);
        mCoachId1 = findViewById((R.id.coach_idv));
        mTeamId1 = findViewById(R.id.team_idv);

        DB = new DBHelper(this);


        mGetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ///Toast.makeText(activity_update_delete_player.this, "Searching Database", Toast.LENGTH_SHORT).show();

                String search_id = mSearchId.getText().toString();
                Cursor res = DB.getdata(search_id);

                while (res.moveToNext()) {
                    mPlayerid1.setText(res.getString(0));
                    mFirstname1.setText(res.getString(1));
                    mLastname1.setText(res.getString(2));
                    mDob1.setText(res.getString(3));
                    mHeight1.setText(res.getString(4));
                    mWeight1.setText(res.getString(5));
                    mSkill1.setText(res.getString(6));
                    mHouseno1.setText(res.getString(7));
                    mStreet1.setText(res.getString(8));
                    mCity1.setText(res.getString(9));
                    mZipcode1.setText(res.getString(10));
                    mAcademyId1.setText(res.getString(11));
                    mCoachId1.setText(res.getString(12));
                    mTeamId1.setText(res.getString(13));
                }

                if (res.getCount() == 0) {

                    Toast.makeText(activity_update_delete_player.this, "No Player Exists with this ID", Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder builder = new AlertDialog.Builder(activity_update_delete_player.this);
                    builder.setCancelable(true);
                    builder.setTitle("No Player Found");
                    builder.setMessage("No Player Exists with this ID");
                    builder.show();

                    mPlayerid1.setText(null);
                    mFirstname1.setText(null);
                    mLastname1.setText(null);
                    mDob1.setText(null);
                    mHeight1.setText(null);
                    mWeight1.setText(null);
                    mSkill1.setText(null);
                    mHouseno1.setText(null);
                    mStreet1.setText(null);
                    mCity1.setText(null);
                    mZipcode1.setText(null);
                    mAcademyId1.setText(null);
                    mCoachId1.setText(null);
                    mTeamId1.setText(null);

                }
            }
        });

        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idTXT = mPlayerid1.getText().toString();
                String firstnameTXT = mFirstname1.getText().toString();
                String lastnameTXT = mLastname1.getText().toString();
                String dobTXT = mDob1.getText().toString();
                String heightTXT = mHeight1.getText().toString();
                String weightTXT = mWeight1.getText().toString();
                String skillTXT = mSkill1.getText().toString();
                String housenoTXT = mHouseno1.getText().toString();
                String streetTXT = mStreet1.getText().toString();
                String cityTXT = mCity1.getText().toString();
                String zipcodeTXT = mZipcode1.getText().toString();
                String academyIdTXT = mAcademyId1.getText().toString();
                String coachIdTXT = mCoachId1.getText().toString();
                String teamIdTXT = mTeamId1.getText().toString();
                Boolean checkupdatedata = DB.updateplayerdata(idTXT,firstnameTXT,lastnameTXT, dobTXT,heightTXT,weightTXT,skillTXT,housenoTXT,streetTXT,cityTXT,zipcodeTXT,academyIdTXT,coachIdTXT,teamIdTXT);

                if(checkupdatedata)
                    Toast.makeText(activity_update_delete_player.this, "Player Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(activity_update_delete_player.this, "Please Create Player with this Id first", Toast.LENGTH_SHORT).show();

            }
        });


        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idTXT = mPlayerid1.getText().toString();

                Boolean checkdeletedata = DB.deleteplayerdata(idTXT);
                if(checkdeletedata)
                    Toast.makeText(activity_update_delete_player.this, "Player Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(activity_update_delete_player.this, "No Player Exists with this ID", Toast.LENGTH_SHORT).show();


            }
        });





    }
}