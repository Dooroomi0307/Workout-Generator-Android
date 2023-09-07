package com.example.workout_generator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import com.example.workout_generator.profile_data_management.*;
import com.example.workout_generator.video_data_management.*;

import java.util.ArrayList;

public class LocationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_screen);

        DBProfileDataManager dbProfileDataManager = new DBProfileDataManager(LocationScreen.this);
        DBVideoDataManager dbVideoDataManager = new DBVideoDataManager(LocationScreen.this);

        //go back to previous screen (welcome screen)
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Disable app name in Action Bar title
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Location buttons***********************************************************

        //Gym button
        ImageButton gym_btn = findViewById(R.id.gym_btn);
        gym_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prepare Recommendation Screen Intent
                Intent intent = new Intent(view.getContext(), ListMain.class);

                //Pass Page Title
                intent.putExtra("Location", "Gym");

                //Pass List of Videos based on gender and location
                String gender = dbProfileDataManager.getGender();
                ArrayList<Video> ArrayListVideo = dbVideoDataManager.getVideoListBasedOnGenderAndLocation(gender, "gym");
                intent.putExtra("VideoList", ArrayListVideo);

                //Pass Estimated duration for all the workouts
                String duration = dbVideoDataManager.calculateEstimatedDuration(ArrayListVideo);
                intent.putExtra("Duration", duration);

                //Pass title of workout


                //Start the recommendation screen
                view.getContext().startActivity(intent);}
        });

        //Home button
        ImageButton home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prepare Recommendation Screen Intent
                Intent intent = new Intent(view.getContext(), ListMain.class);

                //Pass Page Title
                intent.putExtra("Location", "Home");

                //Pass List of Videos based on gender and location
                String gender = dbProfileDataManager.getGender();
                ArrayList<Video> ArrayListVideo = dbVideoDataManager.getVideoListBasedOnGenderAndLocation(gender, "home");
                intent.putExtra("VideoList", ArrayListVideo);

                //Pass Estimated duration for all the workouts
                String duration = dbVideoDataManager.calculateEstimatedDuration(ArrayListVideo);
                intent.putExtra("Duration", duration);

                //Start the recommendation screen
                view.getContext().startActivity(intent);}

        });

        //Office button
        ImageButton office_btn = findViewById(R.id.office_btn);
        office_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prepare Recommendation Screen Intent
                Intent intent = new Intent(view.getContext(), ListMain.class);

                //Pass Page Title
                intent.putExtra("Location", "Office");

                //Pass List of Videos based on gender and location
                String gender = dbProfileDataManager.getGender();
                ArrayList<Video> ArrayListVideo = dbVideoDataManager.getVideoListBasedOnGenderAndLocation(gender, "office");
                intent.putExtra("VideoList", ArrayListVideo);

                //Pass Estimated duration for all the workouts
                String duration = dbVideoDataManager.calculateEstimatedDuration(ArrayListVideo);
                intent.putExtra("Duration", duration);

                //Start the recommendation screen
                view.getContext().startActivity(intent);}
        });


        //Outdoor button
        ImageButton outdoor_btn = findViewById(R.id.outdoor_btn);
        outdoor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prepare Recommendation Screen Intent
                Intent intent = new Intent(view.getContext(), ListMain.class);

                //Pass Page Title
                intent.putExtra("Location", "Outdoor");

                //Pass List of Videos based on gender and location
                String gender = dbProfileDataManager.getGender();
                ArrayList<Video> ArrayListVideo = dbVideoDataManager.getVideoListBasedOnGenderAndLocation(gender, "outdoor");
                intent.putExtra("VideoList", ArrayListVideo);

                //Pass Estimated duration for all the workouts
                String duration = dbVideoDataManager.calculateEstimatedDuration(ArrayListVideo);
                intent.putExtra("Duration", duration);

                //Start the recommendation screen
                view.getContext().startActivity(intent);}
        });
    }

    //connecting activity and actionbar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //action bar back button
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    //Open edit profile screen
    public void goToEditProfile(MenuItem item){
        startActivity(new Intent(LocationScreen.this, EditProfile.class));
    }

    //Open app info screen
    public void goToAboutPage(MenuItem item){

        FragmentManager fm = getSupportFragmentManager();
        AboutDialog dialog = new AboutDialog();
        dialog.show(fm, "About");

    }


}