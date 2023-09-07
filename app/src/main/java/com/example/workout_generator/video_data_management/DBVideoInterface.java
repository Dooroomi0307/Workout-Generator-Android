package com.example.workout_generator.video_data_management;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBVideoInterface extends SQLiteOpenHelper {

    //Database info
    static final String DB_NAME = "videodb";
    static final int DB_VERSION = 1;

    //Table info
    static final String TABLE_NAME = "videodata";
    static final String ID_COL = "id";
    static final String LINK_COL = "link";
    static final String TITLE_COL = "title";
    static final String GENDER_COL = "gender";
    static final String LOCATION_COL = "location";
    static final String DURATION_COL = "duration";
    static final String DESCRIPTION_COL = "description";

    public DBVideoInterface(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " TEXT, "
                + LINK_COL + " TEXT,"
                + TITLE_COL + " TEXT,"
                + GENDER_COL + " TEXT,"
                + LOCATION_COL + " TEXT,"
                + DURATION_COL + " REAL,"
                + DESCRIPTION_COL + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
