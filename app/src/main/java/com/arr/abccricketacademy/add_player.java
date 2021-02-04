package com.arr.abccricketacademy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class add_player extends AppCompatActivity {
    TextView mAcademyId;
    EditText mPlayerid, mFirstname,mLastname,mDob,mHeight,mWeight,mSkill,mHouseno,mStreet,mCity,mZipcode,mCoachId,mTeamId;
    Button mAdd_Button;
    private int mDate,mMonth,mYear;
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

        mDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar cal = Calendar.getInstance();
                mDate = cal.get(Calendar.DATE);
                mMonth = cal.get(Calendar.MONTH);
                mYear = cal.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(add_player.this, android.R.style.Theme_DeviceDefault, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                    mDob.setText(date+"-"+month+"-"+year);

                    }
                },mYear,mMonth,mDate);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis()-1000);
                datePickerDialog.show();
            }
        });


        DB = new DBHelper(this); //calling DBHelper constructor

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


                if(mPlayerid() & mFirstName()  & mDob() & mHeight() & mSkill() & mWeight() & mStreet() & mHouseno() & mStreet() & mCity() & mZipcode() & mCoachId() & mTeamId())
                {
                    Boolean checkinsertdata = DB.insertplayerdata(idTXT, firstnameTXT, lastnameTXT, dobTXT, heightTXT, weightTXT, skillTXT, housenoTXT, streetTXT, cityTXT, zipcodeTXT, academyIdTXT, coachIdTXT, teamIdTXT);
                    //Calling insertplayerdata function to insert data to Database using DBHelper
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
                    } else {
                        ///Toast.makeText(add_player.this, "Player already Exists\nPlease use Update Player", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(add_player.this);
                        builder.setCancelable(true);
                        builder.setTitle("Error Adding Player");
                        builder.setMessage("Player already Exists\nPlease use Update Player");
                        builder.show();
                    }

                }

            }
        });

    }


    private boolean mPlayerid(){
        String feild = mPlayerid.getText().toString().trim();
        if(feild.isEmpty()){
            mPlayerid.setError("This field cannot be blank");
            mPlayerid.requestFocus();
            return false;
        }
        else if(feild.length()>3){
            mPlayerid.setError("Player Id consists only 3 Digits");
            mPlayerid.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mFirstName(){
        String feild = mFirstname.getText().toString().trim();
        if(feild.isEmpty()){
            mFirstname.setError("This field cannot be blank");
            mFirstname.requestFocus();
            return false;
        }
        else
            return  true;
    }

   /* private boolean mLastname(){
        String feild = mLastname.getText().toString().trim();
        if(feild.isEmpty()){
            mLastname.setError("This field cannot be blank");
            mLastname.requestFocus();
            return false;
        }
        else
            return  true;
    }*/

    private boolean mDob(){
        String feild = mDob.getText().toString().trim();
        if(feild.isEmpty()){
            mDob.setError("This field cannot be blank");
            mDob.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mHeight(){
        String feild = mHeight.getText().toString().trim();
        if(feild.isEmpty()){
            mHeight.setError("This field cannot be blank");
            mHeight.requestFocus();
            return false;
        }
        else if(feild.length()>2){
            mHeight.setError("Invalid Height");
            mHeight.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mWeight(){
        String feild = mWeight.getText().toString().trim();
        if(feild.isEmpty()){
            mWeight.setError("This field cannot be blank");
            mWeight.requestFocus();
            return false;
        }
        else if(feild.length()>3){
            mWeight.setError("Invalid Weight");
            mWeight.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mSkill(){
        String feild = mSkill.getText().toString().trim();
        if(feild.isEmpty()){
            mSkill.setError("This field cannot be blank");
            mSkill.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mHouseno(){
        String feild = mHouseno.getText().toString().trim();
        if(feild.isEmpty()){
            mHouseno.setError("This field cannot be blank");
            mHouseno.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mStreet(){
        String feild = mStreet.getText().toString().trim();
        if(feild.isEmpty()){
            mStreet.setError("This field cannot be blank");
            mStreet.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mCity(){
        String feild = mCity.getText().toString().trim();
        if(feild.isEmpty()){
            mCity.setError("This field cannot be blank");
            mCity.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mZipcode(){
        String feild = mZipcode.getText().toString().trim();
        if(feild.isEmpty()){
            mZipcode.setError("This field cannot be blank");
            mZipcode.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mCoachId(){
        String feild = mCoachId.getText().toString().trim();
        if(feild.isEmpty()){
            mCoachId.setError("This field cannot be blank");
            mCoachId.requestFocus();
            return false;
        }
        else if(feild.length()>3){
            mCoachId.setError("Coach Id consists only 3 Digits");
            mCoachId.requestFocus();
            return false;
        }
        else
            return  true;
    }

    private boolean mTeamId(){
        String feild = mTeamId.getText().toString().trim();
        if(feild.isEmpty()){
            mTeamId.setError("This field cannot be blank");
            mTeamId.requestFocus();
            return false;
        }
        else if(feild.length()>3){
            mTeamId.setError("Team Id consists only 3 Digits");
            mTeamId.requestFocus();
            return false;
        }
        else
            return  true;
    }

}

