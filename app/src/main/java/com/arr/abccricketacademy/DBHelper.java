package com.arr.abccricketacademy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "CricketAcademy1.db", null, 1);
    }
        //creating Database with name CricketAcademy1.db
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table CricketAcademytable(playerid TEXT primary key,firstname TEXT,lastname TEXT, dob TEXT ,height TEXT, weight TEXT,skill TEXT,houseno TEXT,street TEXT,city TEXT,zipcode TEXT,academyid TEXT,coachid TEXT,teamid TEXT)");
        //Creating Table with name CricketAcademytable
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
              DB.execSQL("drop Table if exists CricketAcademytable");
              //Drops the Table if the Table already Exists in Database
    }



    public Boolean insertplayerdata(String playerid, String firstname,String lastname,String dob,String height,String weight,String skill,String houseno,String street,String city,String zipcode,String academyid,String coachid,String teamid)
    {
        //Function to insert data to database
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("playerid", playerid);
        contentValues.put("firstname", firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("dob", dob);
        contentValues.put("height", height);
        contentValues.put("weight", weight);
        contentValues.put("skill", skill);
        contentValues.put("houseno", houseno);
        contentValues.put("street", street);
        contentValues.put("city", city);
        contentValues.put("zipcode", zipcode);
        contentValues.put("academyid", academyid);
        contentValues.put("coachid", coachid);
        contentValues.put("teamid", teamid);

        long result=DB.insert("CricketAcademytable",null,contentValues);
        //runs insert query
        if(result==-1) {
            return false;
        }else{
            return true;
        }
    }




    public Boolean updateplayerdata(String playerid, String firstname,String lastname,String dob,String height,String weight,String skill,String houseno,String street,String city,String zipcode,String academyid,String coachid,String teamid )
    {
        //Function to update data to database
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname", firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("dob", dob);
        contentValues.put("height", height);
        contentValues.put("weight", weight);
        contentValues.put("skill", skill);
        contentValues.put("houseno", houseno);
        contentValues.put("street", street);
        contentValues.put("city", city);
        contentValues.put("zipcode", zipcode);
        contentValues.put("academyid", academyid);
        contentValues.put("coachid", coachid);
        contentValues.put("teamid", teamid);
        Cursor cursor = DB.rawQuery("Select * from CricketAcademytable where playerid = ?",new String[]{playerid});
        if(cursor.getCount()>0) {
            long result = DB.update("CricketAcademytable", contentValues, "playerid=?", new String[]{playerid});
        //runs update query to cricket academy table where playerid is given by user
        if (result == -1) {
                return false;
        } else {
                return true;
        }
        }else{
            return false;
        }
    }



    public Boolean deleteplayerdata(String playerid)
    {
        //Function to delete data from database
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from CricketAcademytable where playerid=?", new String[]{playerid});
        if(cursor.getCount()>0) {
            long result = DB.delete("CricketAcademytable", "playerid=?", new String[]{playerid});
            //runs delete query to cricket academy table where playerid is given by user
            if (result == -1) {
                return false;
            } else {
                return true;
            }
            }else {
            return false;
        }
    }



    public Cursor getdata(String search_id)
    {
        //Function to select data from database
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from CricketAcademytable where playerid = ?", new String[]{search_id});
        //runs select query to select data from cricket academy table where playerid is given by user
        return cursor;
    }



    public Cursor viewall()
    {
        //Function to all select data from database
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from CricketAcademytable", null);
        //runs select query to select all data from cricket academy table
        return cursor;
    }


}

