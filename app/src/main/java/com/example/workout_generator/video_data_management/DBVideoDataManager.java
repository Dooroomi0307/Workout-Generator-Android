package com.example.workout_generator.video_data_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.workout_generator.profile_data_management.UserProfile;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBVideoDataManager {

    DBVideoInterface dbHelper;
    VideoDataSource vds;

    public DBVideoDataManager(Context context){
        dbHelper = new DBVideoInterface(context);
    }

    public void setVideos(){

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        vds = new VideoDataSource();
        vds.initializeVideoArray();
        ArrayList<Video> videos = vds.getVideoList();

        for(int i = 0; i < videos.size(); i++){

            ContentValues values = new ContentValues();
            values.put(DBVideoInterface.ID_COL, videos.get(i).getId());
            values.put(DBVideoInterface.LINK_COL, videos.get(i).getLink());
            values.put(DBVideoInterface.TITLE_COL, videos.get(i).getTitle());
            values.put(DBVideoInterface.GENDER_COL, videos.get(i).getGender());
            values.put(DBVideoInterface.LOCATION_COL, videos.get(i).getLocation());
            values.put(DBVideoInterface.DURATION_COL, videos.get(i).getDuration());
            values.put(DBVideoInterface.DESCRIPTION_COL, videos.get(i).getDescription());

            db.insert(DBVideoInterface.TABLE_NAME, null, values);
        }

        //Close the database
        db.close();

    }

    public ArrayList<Video> getFullVideoList(){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DBVideoInterface.TABLE_NAME, null);

        ArrayList<Video> videoList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {

                videoList.add(new Video(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getDouble(5),
                        cursor.getString(6)
                ));
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursor.close();
        return videoList;

    }

    public ArrayList<Video> getVideoListBasedOnGenderAndLocation(String gender, String location){

        ArrayList<Video> fullList = getFullVideoList();
        ArrayList<Video> videoList = new ArrayList<>();

        for(int i = 0; i < fullList.size(); i++){

            if(fullList.get(i).getGender().contains(gender) && fullList.get(i).getLocation().equals(location)){
                videoList.add(fullList.get(i));
            }

        }

        return videoList;
    }

    public String calculateEstimatedDuration(ArrayList<Video> videoList){

        Integer hours = 0;
        Double minutes = 0.00;
        Double seconds = 0.00;

        String timing;
        String[] parts;

        for(int i = 0; i < videoList.size(); i++){

            timing = String.valueOf(videoList.get(i).getDuration());
            parts = timing.split("\\.");

            minutes += Double.parseDouble(parts[0]);
            seconds += Double.parseDouble(parts[1]);

        }

        int mins = (int) (minutes + (seconds/60));
        int secs = (int) (seconds%60);

        if(mins > 60) {
            hours = mins/60;
            mins = mins%60;

            return (hours + "h " + mins + "m " + secs + "s");

        }
        else {
            return (mins + "m " + secs + "s");
        }

    }

    public long getNumberOfRows(){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        long rows = DatabaseUtils.queryNumEntries(db, DBVideoInterface.TABLE_NAME);
        db.close();
        return rows;

    }


}
