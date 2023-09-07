package com.example.workout_generator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.workout_generator.profile_data_management.*;
import com.example.workout_generator.video_data_management.*;

import java.util.ArrayList;

public class ListMain extends AppCompatActivity {

    //private ArrayList<Video> ArrayListVideo;
    private ListAdapter listAdapter;
    private DBVideoDataManager dbVideoDataManager;

    //add recycler view object
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);

        //Initializing all variables
        //ArrayListVideo = new ArrayList<>();
        dbVideoDataManager = new DBVideoDataManager(ListMain.this);

        //list from DBVideoDataManager
        //ArrayListVideo = dbVideoDataManager.getFullVideoList();

        //Get passed information
        ArrayList<Video> ArrayListVideo = (ArrayList<Video>) getIntent().getSerializableExtra("VideoList");
        String label = getIntent().getStringExtra("Location");
        String duration = getIntent().getStringExtra("Duration");

        //Pass array list to ListAdapter
        listAdapter = new ListAdapter(ArrayListVideo, ListMain.this);

        //Set the content view
        setContentView(R.layout.activity_list_main);

        //Initialize the textviews from the layout
        TextView location_label = findViewById(R.id.location_label);
        TextView duration_time = findViewById(R.id.duration_time);

        //Set the current location label
        location_label.setText(label);

        //Set the estimated duration time for this set of workouts
        duration_time.setText("Estimated Workout Time: " + duration);

        //go back to previous screen (welcome screen)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Disable app name in Action Bar title
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        recyclerView = findViewById(R.id.recyclerView);

        //setting layout manager for recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListMain.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //pass data to listAdapter
        recyclerView.setAdapter(listAdapter);
    }

    //action bar back button
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }


}
