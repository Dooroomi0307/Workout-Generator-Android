package com.example.workout_generator;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.FragmentManager;

import com.example.workout_generator.profile_data_management.DBProfileDataManager;
import com.example.workout_generator.profile_data_management.UserProfile;

public class EditProfile extends ProfileScreen {

    UserProfile up;
    RadioButton mButton;
    RadioButton fButton;
    boolean hasChanges = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        setButtonText("Save", findViewById(R.id.confirmButton).getId());
        setHeaderText("Edit Profile", findViewById(R.id.profileLabel).getId());

        readDataFromDatabase();

        setProfileInfoFields();

        setSoftKeyboardToDisappearWhenUnfocused();

        //Disable app name in Action Bar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }

    @Override
    public void onBackPressed(){

        Button buttonCancel = (Button) findViewById(R.id.cancelButton);

        //Launch Cancel Dialog if there are changes
        if(hasChanges)
            launchCancelDialog(buttonCancel,"Save Changes?");
        else
            this.finish();
    }

    @Override
    public void saveProfileInfo(View view) {

        if(super.validateAndInitialize()){
            dbInterface = new DBProfileDataManager(EditProfile.this);
            dbInterface.removeUserProfile(up.getId());
            dbInterface = null;

            super.sendDataToDatabase();

            //Launch Confirmation Dialog
            launchConfirmationDialog(view, "updated", "Edit Profile");

        }

    }

    public void cancelChanges(View view){

        //Launch Cancel Dialog if there are changes
        if(hasChanges)
            launchCancelDialog(view,"Save Changes?");
        else
            this.finish();
    }

    //Launch cancel dialog - overridden by children with custom functionality
    public void launchCancelDialog(View view, String pageTitle){
        FragmentManager fm = getSupportFragmentManager();
        CancelDialog dialog = new CancelDialog(pageTitle, view);
        dialog.show(fm, "Exit Without Saving?");
        fm.executePendingTransactions();

        dialog.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                saveSystem(dialog.getListNo());
            }
        });
    }

    public void saveSystem(int navigationNo) {
        if(navigationNo >= 0) {
            switch (navigationNo) {
                case 0:
                    saveProfileInfo((Button) findViewById(R.id.confirmButton));
                    break;
                case 1:
                    this.finish();
                    break;
            }
        }
    }

    /**
     * Note: SQLite databases are typically stored under /data/data/{package_name}/databases/dbname
     */
    private void readDataFromDatabase(){
        dbInterface = new DBProfileDataManager(EditProfile.this);
        up = dbInterface.getUserProfile();
        dbInterface = null;
    }

    private void setProfileInfoFields() {

        //Initialize the fields
        nameField = findViewById(R.id.nameField);
        ageField = findViewById(R.id.ageField);
        genderGroup = findViewById(R.id.chooseGenderGroup);
        mButton = findViewById(R.id.maleRadio);
        fButton = findViewById(R.id.femaleRadio);

        nameField.setText(up.getName());
        ageField.setText(String.valueOf(up.getAge()));

        if(up.getGender().equals("m")){
            mButton.setChecked(true);
            fButton.setChecked(false);
        }
        else if(up.getGender().equals("f")){
            fButton.setChecked(true);
            mButton.setChecked(false);
        }

        nameField.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            public void afterTextChanged(Editable editable) {
                hasChanges = true;
            }});

        ageField.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                public void afterTextChanged(Editable editable) {
                    hasChanges = true;
                }});

        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                hasChanges = true;
            }
        });

    }

}