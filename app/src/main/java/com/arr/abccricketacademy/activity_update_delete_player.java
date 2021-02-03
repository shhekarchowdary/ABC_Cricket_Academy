package com.arr.abccricketacademy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class activity_update_delete_player extends AppCompatActivity {
    TextView mAcademyId1;
    EditText mPlayerid1, mFirstname1,mLastname1,mDob1,mHeight1,mWeight1,mSkill1,mHouseno1,mStreet1,mCity1,mZipcode1,mCoachId1,mTeamId1,mSearchId;
    Button mUpdateButton,mDeleteButton,mGetButton;
    private int mDate,mMonth,mYear;
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

        mDob1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar cal = Calendar.getInstance();
                mDate = cal.get(Calendar.DATE);
                mMonth = cal.get(Calendar.MONTH);
                mYear = cal.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(activity_update_delete_player.this, android.R.style.Theme_DeviceDefault, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                        mDob1.setText(date+"-"+month+"-"+year);

                    }
                },mYear,mMonth,mDate);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis()-1000);
                datePickerDialog.show();
            }
        });

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

                if(mPlayerid() & mFirstName() & mDob() & mHeight() & mSkill() & mWeight() & mStreet() & mHouseno() & mStreet() & mCity() & mZipcode() & mCoachId() & mTeamId()) {

                    if (checkupdatedata) {

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

                        AlertDialog.Builder builder = new AlertDialog.Builder(activity_update_delete_player.this);
                        builder.setCancelable(true);
                        builder.setTitle("Player updated Successfully");
                        builder.setMessage(buffer.toString());
                        builder.show();
                        ///Toast.makeText(activity_update_delete_player.this, "Player Updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(activity_update_delete_player.this, "Please Create Player with this Id first", Toast.LENGTH_SHORT).show();

                        AlertDialog.Builder builder = new AlertDialog.Builder(activity_update_delete_player.this);
                        builder.setCancelable(true);
                        builder.setTitle("Error Player update");
                        builder.setMessage("Please Create Player with this Id first");
                        builder.show();
                    }
                }
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

    private boolean mPlayerid(){
        String feild = mPlayerid1.getText().toString().trim();
        if(feild.isEmpty()){
            mPlayerid1.setError("This field cannot be blank");
            mPlayerid1.requestFocus();
            return false;
        }
        else if(feild.length()>3){
            mPlayerid1.setError("Player Id consists only 3 Digits");
            mPlayerid1.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mFirstName(){
        String feild = mFirstname1.getText().toString().trim();
        if(feild.isEmpty()){
            mFirstname1.setError("This field cannot be blank");
            mFirstname1.requestFocus();
            return false;
        }
        else
            return  true;
    }

    /*private boolean mLastname(){
        String feild = mLastname1.getText().toString().trim();
        if(feild.isEmpty()){
            mLastname1.setError("This field cannot be blank");
            mLastname1.requestFocus();
            return false;
        }
        else
            return  true;
    }*/

    private boolean mDob(){
        String feild = mDob1.getText().toString().trim();
        if(feild.isEmpty()){
            mDob1.setError("This field cannot be blank");
            mDob1.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mHeight(){
        String feild = mHeight1.getText().toString().trim();
        if(feild.isEmpty()){
            mHeight1.setError("This field cannot be blank");
            mHeight1.requestFocus();
            return false;
        }
        else if(feild.length()>2){
            mHeight1.setError("Invalid Height");
            mHeight1.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mWeight(){
        String feild = mWeight1.getText().toString().trim();
        if(feild.isEmpty()){
            mWeight1.setError("This field cannot be blank");
            mWeight1.requestFocus();
            return false;
        }
        else if(feild.length()>3){
            mWeight1.setError("Invalid Weight");
            mWeight1.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mSkill(){
        String feild = mSkill1.getText().toString().trim();
        if(feild.isEmpty()){
            mSkill1.setError("This field cannot be blank");
            mSkill1.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mHouseno(){
        String feild = mHouseno1.getText().toString().trim();
        if(feild.isEmpty()){
            mHouseno1.setError("This field cannot be blank");
            mHouseno1.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mStreet(){
        String feild = mStreet1.getText().toString().trim();
        if(feild.isEmpty()){
            mStreet1.setError("This field cannot be blank");
            mStreet1.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mCity(){
        String feild = mCity1.getText().toString().trim();
        if(feild.isEmpty()){
            mCity1.setError("This field cannot be blank");
            mCity1.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mZipcode(){
        String feild = mZipcode1.getText().toString().trim();
        if(feild.isEmpty()){
            mZipcode1.setError("This field cannot be blank");
            mZipcode1.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mCoachId(){
        String feild = mCoachId1.getText().toString().trim();
        if(feild.isEmpty()){
            mCoachId1.setError("This field cannot be blank");
            mCoachId1.requestFocus();
            return false;
        }
        else if(feild.length()>3){
            mCoachId1.setError("Coach Id consists only 3 Digits");
            mCoachId1.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mTeamId(){
        String feild = mTeamId1.getText().toString().trim();
        if(feild.isEmpty()){
            mTeamId1.setError("This field cannot be blank");
            mTeamId1.requestFocus();
            return false;
        }
        else if(feild.length()>3){
            mTeamId1.setError("Team Id consists only 3 Digits");
            mTeamId1.requestFocus();
            return false;
        }
        else
            return  true;
    }
}