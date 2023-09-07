package com.example.workout_generator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

/*
This screen displays workout video
 */
public class WorkoutScreen extends AppCompatActivity {

    YouTubePlayerView workoutVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_screen);

        //Set Life cycle observer for workout video
        workoutVideo = findViewById(R.id.workoutVideo);
        getLifecycle().addObserver(workoutVideo);

        //Set the video link
        workoutVideo.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);

                String link = getIntent().getStringExtra("LINK");
                youTubePlayer.cueVideo(link, 0f);

            }
        });

        //Get elements
        TextView workoutTitle = findViewById(R.id.workoutTitle);
        TextView workoutTime = findViewById(R.id.workoutTime);
        TextView workoutDescription = findViewById(R.id.workoutDescription);

        //Set the content of the elements
        workoutTitle.setText(getIntent().getStringExtra("TITLE"));
        workoutTime.setText(getIntent().getStringExtra("DURATION"));
        workoutDescription.setText(getIntent().getStringExtra("DESCRIPTION"));

        //go back to previous screen (Workout List screen)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Disable app name in Action Bar title
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Button buttonConfirm = findViewById(R.id.confirmButton2);
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Launch Completion Dialog
                launchCompletionDialog(v, "Congratulations!");
            }
        });


    }


    //Launch completion dialog - overridden by children with custom functionality
    public void launchCompletionDialog(View view, String pageTitle) {
        FragmentManager fm = getSupportFragmentManager();
        CompletionDialog dialog = new CompletionDialog(pageTitle, view);
        dialog.show(fm, "Congratulations!");
        fm.executePendingTransactions();

        dialog.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                navigationSystem(dialog.getListNo());
            }
        });
    }

    //action bar back button
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void navigationSystem(int navigationNo) {
        if(navigationNo >= 0) {
            switch (navigationNo) {
                case 0:
                    //startActivity(new Intent(WorkoutScreen.this, ListMain.class));
                    this.finish();
                    break;
                case 1:
                    startActivity(new Intent(WorkoutScreen.this, LocationScreen.class));
                    this.finish();
                    break;
                case 2:
                    //startActivity(new Intent(WorkoutScreen.this, WorkoutScreen.class));
                    //this.finish();
                    break;
            }
        }
    }
}
