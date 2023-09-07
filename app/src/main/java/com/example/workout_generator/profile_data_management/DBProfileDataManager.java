package com.example.workout_generator.profile_data_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

public class DBProfileDataManager {

    DBProfileInterface dbHelper;

    public DBProfileDataManager(Context context){
        dbHelper = new DBProfileInterface(context);
    }

    public void setUserProfile(String name, Integer age, String gender){

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBProfileInterface.ID_COL, 1000); //1000 is the default and only ID for a user profile - multiple profiles/records cannot exist
        values.put(DBProfileInterface.NAME_COL, name);
        values.put(DBProfileInterface.AGE_COL, age);
        values.put(DBProfileInterface.GENDER_COL, gender);

        //Push all the values to the DB
        db.insert(DBProfileInterface.TABLE_NAME, null, values);

        //Close the database
        db.close();

    }

    public UserProfile getUserProfile() {

        UserProfile up = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DBProfileInterface.TABLE_NAME, null);

        if(cursor.moveToFirst()){
            up = new UserProfile(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3));
        }

        cursor.close();

        return up;
    }

    public void removeUserProfile(Integer id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete(DBProfileInterface.TABLE_NAME, "id=?", new String[]{String.valueOf(id)});
        db.close();

    }

    public long getNumberOfRows(){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        long rows = DatabaseUtils.queryNumEntries(db, DBProfileInterface.TABLE_NAME);
        db.close();
        return rows;

    }

    public String getGender(){

        String gender = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DBProfileInterface.TABLE_NAME, null);

        if(cursor.moveToFirst()){
            gender = cursor.getString(3);
        }

        cursor.close();

        return gender;

    }




}
