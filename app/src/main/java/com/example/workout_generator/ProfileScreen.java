package com.example.workout_generator;


import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.workout_generator.profile_data_management.DBProfileDataManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileScreen extends AppCompatActivity {

    //Input fields
    EditText nameField;
    EditText ageField;
    RadioGroup genderGroup;
    RadioButton selectedButton;

    //Empty fields error labels
    TextView nameEmpty;
    TextView ageEmpty;
    TextView genderEmpty;

    //Confirmation Button
    Button confirmButton;

    //Header TextView
    TextView header;

    //Information from profile form
    String name;
    Integer age;
    String gender;

    //DB Helper initialization
    DBProfileDataManager dbInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        //Disable app name in Action Bar title
        actionbar.setDisplayShowTitleEnabled(false);

    }

    //Enable back button to go back to previous screen
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuitem){
        if (menuitem.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(menuitem);
    }

    //Next and Save Button Functionality - overridden by children with custom functionality
    public void saveProfileInfo(View view){

    }

    //Launch confirmation dialog - overridden by children with custom functionality
    public void launchConfirmationDialog(View view, String status, String pageTitle){
        FragmentManager fm = getSupportFragmentManager();
        ConfirmationDialog dialog = new ConfirmationDialog(pageTitle, view);
        dialog.show(fm, "Profile " + status + " Successfully");
    }

    /**
     * Create a toast by passing in your message.
     * @param msg Toast Message
     */
    public void makeToast(String msg){
        Spannable centeredText = new SpannableString(msg);
        centeredText.setSpan(
                new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                0, msg.length() - 1,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
        );
        Toast.makeText(this, centeredText, Toast.LENGTH_LONG).show();
    }

    //Clear button functionality
    public void clearAllFields(View view){

        nameField = findViewById(R.id.nameField);
        ageField = findViewById(R.id.ageField);
        genderGroup = findViewById(R.id.chooseGenderGroup);

        nameEmpty = findViewById(R.id.nameEmptyAlert);
        ageEmpty = findViewById(R.id.ageEmptyAlert);
        genderEmpty = findViewById(R.id.genderEmptyAlert);

        nameField.setText("");
        ageField.setText("");
        genderGroup.clearCheck();

        nameEmpty.setText("");
        ageEmpty.setText("");
        genderEmpty.setText("");

        cleanData();
    }

    /**
     * Note: SQLite databases are typically stored under /data/data/{package_name}/databases/dbname
     */
    void sendDataToDatabase(){
        dbInterface = new DBProfileDataManager(ProfileScreen.this);
        dbInterface.setUserProfile(this.name, this.age, this.gender);
        dbInterface = null;
    }

    boolean validateAndInitialize() {

        //Validation flags
        boolean namePassed = false;
        boolean agePassed = false;
        boolean genderPassed = false;

        nameField = findViewById(R.id.nameField);
        ageField = findViewById(R.id.ageField);
        genderGroup = findViewById(R.id.chooseGenderGroup);

        name = nameField.getText().toString();
        String nameWithoutSpaces = name.replace(" ", "");
        String nameWithoutNumbers = nameField.getText().toString();

        {   //Remove all number and special characters from the name - to see if any letters are remaining
            //and spaces

            String regexNumeric = "[0-9]";
            String regexSpecial = "[^A-Za-z0-9]";
            Pattern pattern = Pattern.compile(regexNumeric);
            Matcher matcher = pattern.matcher(nameWithoutNumbers);
            nameWithoutNumbers = matcher.replaceAll("");

            pattern = Pattern.compile(regexSpecial);
            matcher = pattern.matcher(nameWithoutNumbers);
            nameWithoutNumbers = matcher.replaceAll("");

            nameWithoutNumbers = nameWithoutNumbers.replace(" ", "");

        }

        //Validate name field
        nameEmpty = findViewById(R.id.nameEmptyAlert);
        if(name.isEmpty() || nameWithoutSpaces.isEmpty()){
            nameEmpty.setText("Please enter your name in the field above.");
        }
        else if(nameWithoutNumbers.isEmpty()){
            nameEmpty.setText("Please enter some letters for your name in the field above.");
        }
        else{
            nameEmpty.setText("");
            namePassed = true;
        }

        //Validate age field
        String ageString = ageField.getText().toString();
        ageEmpty = findViewById(R.id.ageEmptyAlert);
        if(ageString.isEmpty()){
            ageEmpty.setText("Please enter your age in the field above.");
        }
        else {
            ageEmpty.setText("");
            age = Integer.parseInt(ageString);
            agePassed = true;
        }

        //Validate if any gender button is selected
        genderEmpty = findViewById(R.id.genderEmptyAlert);
        int radioID = genderGroup.getCheckedRadioButtonId();
        if(radioID < 0){
            genderEmpty.setText("Please select your age.");
        }
        else{
            genderEmpty.setText("");
            selectedButton = findViewById(radioID);
            String genderSelected = selectedButton.getText().toString();
            if(genderSelected.equals("Male")){
                gender = "m";
            }
            else if(genderSelected.equals("Female")){
                gender = "f";
            }

            genderPassed = true;
        }

        //Check if all conditions are present and have passed validation
        return namePassed && agePassed && genderPassed;

    }

    void setButtonText(String text, int buttonID){
        confirmButton = findViewById(buttonID);
        confirmButton.setText(text);
    }

    void setHeaderText(String text, int headerID){
        header = findViewById(headerID);
        header.setText(text);
    }

    void setSoftKeyboardToDisappearWhenUnfocused(){

        //Set soft-keyboard to disappear when EditTexts are unfocused
        nameField = findViewById(R.id.nameField);
        ageField = findViewById(R.id.ageField);
        View.OnFocusChangeListener ofcl = new MyFocusChangeListener();
        nameField.setOnFocusChangeListener(ofcl);
        ageField.setOnFocusChangeListener(ofcl);
    }

    //Manage soft keyboard
    class MyFocusChangeListener implements View.OnFocusChangeListener {

        public void onFocusChange(View v, boolean hasFocus){

            if(v.getId() == R.id.nameField && !hasFocus) {

                InputMethodManager imm =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            }

            if(v.getId() == R.id.ageField && !hasFocus) {

                InputMethodManager imm =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            }

        }
    }

    //Clean class variables
    private void cleanData(){
        name = null;
        age = null;
        gender = null;
    }


}
