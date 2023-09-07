package com.example.workout_generator;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;

public class CancelDialog extends DialogFragment{

    // Tells where to navigate after completion
    public int listNo = -1;

    public int getListNo(){
        return this.listNo;
    }

    public CancelDialog(String pageTitle, View parentView) {
        // Empty constructor required for DialogFragment
    }

    public CancelDialog(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        final View view = inflater.inflate(R.layout.activity_cancel_dialog, container);
        getDialog().setTitle("Exit Without Saving?");
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }

        //TODO - Yes button functionality - go to Recommendation Screen
        Button yesButton = view.findViewById(R.id.buttonYes);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listNo = 0;
                getDialog().dismiss();
            }
        });

        //TODO - No button functionality - go to Location Screen
        Button noButton = view.findViewById(R.id.buttonNo);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listNo = 1;
                getDialog().dismiss();
            }
        });

        //TODO - Cancel button functionality - remains on Edit Profile
        Button cancelButton = view.findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }
}