package com.arr.abccricketacademy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private String name;

    public DBHelper(Context context) {
        super(context, "CricketAcademy.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table CricketAcademy(playerid primarykey,firstname TEXT,lastname TEXT, dob TEXT ,height TEXT, weight TEXT,skill TEXT,houseno TEXT,street TEXT,city TEXT,zipcode TEXT,academyid TEXT,coachid TEXT,teamid TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
              DB.execSQL("drop Table if exists CricketAcademy");
    }
    public Boolean insertuserdata(String playerid, String firstname,String lastname,String dob,String height,String weight,String skill,String houseno,String street,String city,String zipcode,String academyid,String coachid,String teamid)
    {
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

        long result=DB.insert("CricketAcademy",null,contentValues);
        if(result==-1) {
            return false;
        }else{
            return true;
        }
    }

    public Boolean updateuserdata(String playerid, String firstname,String lastname,String dob,String height,String weight,String skill,String houseno,String street,String city,String zipcode,String academyid,String coachid,String teamid )
    {
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
        Cursor cursor = DB.rawQuery("Select*from CricketAcademy where id=?", new String[]  {name});
        if(cursor.getCount()>0) {
            long result = DB.update("CricketAcademy", contentValues, "id=?", new String[]{name});
        if (result == -1) {
                return false;
        } else {
                return true;
        }
        }else{
            return false;
        }
    }
    public Boolean deleteuserdata(String playerid, String firstname,String lastname,String dob,String height,String weight,String skill,String houseno,String street,String city,String zipcode,String academyid,String coachid,String teamid)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select*from CricketAcademy where id=?", new String[]  {name});
        if(cursor.getCount()>0) {
            long result = DB.delete("CricketAcademy", "id=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
            }else {
            return false;
        }
    }
    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select*from CricketAcademy",null);
        return cursor;
    }

}

