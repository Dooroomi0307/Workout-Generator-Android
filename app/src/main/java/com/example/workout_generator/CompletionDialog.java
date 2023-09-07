package com.example.workout_generator;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.content.Intent;

import androidx.fragment.app.DialogFragment;

public class CompletionDialog extends DialogFragment{

    private View parentView;
    private String pageTitle = null;

    // Tells where to navigate after completion
    public int listNo = -1;

    public int getListNo(){
        return this.listNo;
    }

    public CompletionDialog(String pageTitle, View parentView) {
        this.pageTitle = pageTitle;
        this.parentView = parentView;
    }

    public CompletionDialog() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        final View view = inflater.inflate(R.layout.activity_completion_dialog, container);
        getDialog().setTitle("Congratulations!");
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }

        //TODO - Yes button functionality - go to Recommendation Screen
        Button yesButton = view.findViewById(R.id.buttonYes);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
                listNo = 0;
            }
        });

        //TODO - No button functionality - go to Location Screen
        Button noButton = view.findViewById(R.id.buttonNo);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
                listNo = 1;
            }
        });

        //TODO - Replay button functionality - stay on current Workout Screen
        Button replayButton = view.findViewById(R.id.buttonReplay);
        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
                listNo = 2;
            }
        });

        return view;
    }

}
