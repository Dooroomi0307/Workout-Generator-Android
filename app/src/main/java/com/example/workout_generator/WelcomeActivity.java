package com.example.workout_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.workout_generator.profile_data_management.DBProfileDataManager;
import com.example.workout_generator.video_data_management.DBVideoDataManager;
import com.example.workout_generator.video_data_management.Video;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {

    //DB Helper initialization
    DBProfileDataManager dbInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //Disable app name in Action Bar title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    //Functionality for GET STARTED button
    public void getStarted(View view) {

        dbInterface = new DBProfileDataManager(WelcomeActivity.this);
        boolean profileAlreadySetup = (dbInterface.getNumberOfRows() > 0);
        dbInterface = null;

        if(profileAlreadySetup){
            //Go to location screen
            startActivity(new Intent(WelcomeActivity.this, LocationScreen.class));
        }
        else{
            //Initialize video database
            DBVideoDataManager dbvdm = new DBVideoDataManager(WelcomeActivity.this);
            dbvdm.setVideos();

            //Setup Profile
            startActivity(new Intent(WelcomeActivity.this, SetupProfile.class));
        }
    }
}