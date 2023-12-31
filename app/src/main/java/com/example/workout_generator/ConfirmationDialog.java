package com.example.workout_generator;

import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmationDialog extends DialogFragment {

    private View parentView;
    private String pageTitle = null;

    public interface SaveInfoListener {
        void exit();
    }

    public ConfirmationDialog(String pageTitle, View parentView){
        this.pageTitle = pageTitle;
        this.parentView = parentView;
    }

    public ConfirmationDialog() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_confirmation_dialog, container);
        getDialog().setTitle("Congratulations!");
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }

        Button okButton = view.findViewById(R.id.buttonOk);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pageTitle == null || pageTitle.equals("Edit Profile")){

                    getActivity().finish();
                    getDialog().dismiss();

                }
                else if(pageTitle.equals("Profile Setup")){

                    getActivity().finish();
                    startActivity(new Intent(parentView.getContext(), LocationScreen.class));
                    getDialog().dismiss();

                }

            }
        });

        return view;
    }

}