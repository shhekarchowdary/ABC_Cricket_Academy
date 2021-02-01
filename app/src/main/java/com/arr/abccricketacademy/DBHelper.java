package com.arr.abccricketacademy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends MainActivity{
    public static class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, "CricketAcademy.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase DB) {
            DB.execSQL("create Table CricketAcademy(playerid primarykey,name TEXT, dob TEXT )");

        }

        @Override
        public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
                  DB.execSQL("drop Table if exists CricketAcademy");
        }
        public Boolean insertuserdata(String playerid, String firstname,String lastname,String dob,String height,String weight,String skill,String houseno,String street,String city,String zipcode,)
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("playerid", playerid);
            contentValues.put("firstname", firstname);
            contentValues.put("lastname", name);
            contentValues.put("dob", dob);
            contentValues.put("firstname", name);
            contentValues.put("firstname", name);
            contentValues.put("firstname", name);
            contentValues.put("firstname", name);
            contentValues.put("firstname", name);
            contentValues.put("firstname", name);
            contentValues.put("dob", dob);
            long result=DB.insert("CricketAcademy",null,contentValues);
            if(result==-1) {
                return false;
            }else{
                return true;
            }
        }

        public Boolean updateuserdata(String playerid, String name, String dob )
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("playerid", playerid);
            contentValues.put("name", name);
            contentValues.put("dob", dob);
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
        public Boolean deleteuserdata(String playerid, String name, String dob )
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
}