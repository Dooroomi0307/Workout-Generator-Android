package com.example.workout_generator.profile_data_management;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBProfileInterface extends SQLiteOpenHelper {

    //Database info
    static final String DB_NAME = "profiledb";
    static final int DB_VERSION = 1;

    //Table info
    static final String TABLE_NAME = "userdata";
    static final String ID_COL = "id";
    static final String NAME_COL = "name";
    static final String AGE_COL = "age";
    static final String GENDER_COL = "gender";

    public DBProfileInterface(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, "
                + NAME_COL + " TEXT,"
                + AGE_COL + " INTEGER,"
                + GENDER_COL + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
