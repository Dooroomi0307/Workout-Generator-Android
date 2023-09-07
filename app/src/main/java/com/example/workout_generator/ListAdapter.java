package com.example.workout_generator;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workout_generator.profile_data_management.*;
import com.example.workout_generator.video_data_management.*;

import java.lang.reflect.*;
import java.net.URL;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private ArrayList<Video> ArrayListVideo;
    private DBVideoDataManager dbVideoDataManager;
    Context context;


    //Constructor
    public ListAdapter(ArrayList<Video> ArrayListVideo, Context context){
        this.ArrayListVideo = ArrayListVideo;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_list_cardview, parent, false);
        return new MyViewHolder(view);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView workout_title, workout_duration;
        ImageView workout_thumbnail;
        ConstraintLayout workoutLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            workout_title = itemView.findViewById(R.id.workout_title);
            workout_duration = itemView.findViewById(R.id.workout_duration);
            workout_thumbnail = itemView.findViewById(R.id.workout_thumbnail);
            workoutLayout = itemView.findViewById(R.id.workoutLayout);
        }
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Video video = ArrayListVideo.get(position);
        String id = video.getId();
        Integer value = 0;

        try {
            Field field = R.drawable.class.getDeclaredField(id);
            field.setAccessible(true);
            value = (Integer) field.get(R.drawable.class.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Double duration = video.getDuration();
        String duration_s = workoutDuration(duration);

        holder.workout_title.setText(video.getTitle());
        holder.workout_duration.setText(duration_s);
        holder.workout_thumbnail.setImageResource(value);


        //Intent for WorkoutScreen
        //pass workout video link
        holder.workoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                String[] durationParts =  String.valueOf(video.getDuration()).split("\\.");
                String mins = durationParts[0];
                String secs = durationParts[1];

                Intent intent = new Intent(context, WorkoutScreen.class);
                intent.putExtra("LINK", video.getLink());
                intent.putExtra("TITLE", video.getTitle());
                intent.putExtra("DURATION", "Video Duration: " + mins + "m " + secs + "s");
                intent.putExtra("DESCRIPTION", video.getDescription());
                context.startActivity(intent);
            }
        });
    }


    //change double duration value to String
    public String workoutDuration(Double duration){
            Double duration_m = duration;

            int mins = duration_m.intValue();
            double sec = ((duration_m % 60)-duration_m.intValue())*100;
            int secs = (int)sec;

            return (mins + "m " + secs + "s");
    }

    @Override
    public int getItemCount() {

        return ArrayListVideo.size();

    }


}
