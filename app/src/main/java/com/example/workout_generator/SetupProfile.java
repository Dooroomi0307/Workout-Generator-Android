package com.example.workout_generator;


import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class SetupProfile extends ProfileScreen implements ConfirmationDialog.SaveInfoListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_profile);

        setButtonText("Next", findViewById(R.id.confirmButton).getId());
        setHeaderText("Profile Setup", findViewById(R.id.profileLabel).getId());

        setSoftKeyboardToDisappearWhenUnfocused();
    }

    @Override
    public void saveProfileInfo(View view){

        //If validation succeeded with no empty fields...
        if(super.validateAndInitialize()){

            //Save to DB
            sendDataToDatabase();

            //Launch Confirmation Dialog
            launchConfirmationDialog(view, "saved", "Profile Setup");
        }

    }

    @Override
    public void exit(){
        startActivity(new Intent(SetupProfile.this, LocationScreen.class));
    }

}