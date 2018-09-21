package com.example.picture.helloword;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;

public class AddActivity extends Activity {

    public static final int RESULT_OK = 10;
    DatePickerFragment datePickerFragment;
    Date finalDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        final Button buttonSave = findViewById(R.id.SaveStudent);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText lastNameEdit = (EditText) findViewById(R.id.lastname_text_input);
                String lastName = lastNameEdit.getText().toString();

                EditText firstNameEdit = (EditText) findViewById(R.id.firstname_text_input);
                String firstName = firstNameEdit.getText().toString();

                EditText emailEdit = (EditText) findViewById(R.id.email_text_input);
                String email = emailEdit.getText().toString();

                RadioGroup radioSexGroup = (RadioGroup) findViewById(R.id.radioSexGroup);
                int genderSelected = radioSexGroup.getCheckedRadioButtonId();
                RadioButton genderRadio = (RadioButton) findViewById(genderSelected);
                String gender = genderRadio.getText().toString();

                Spinner spinner = findViewById(R.id.group_spinner);
                String spinnerValue = spinner.getSelectedItem().toString();

                if(datePickerFragment != null && datePickerFragment.dateChosen != null){
                    finalDate = datePickerFragment.dateChosen;
                }else {
                    finalDate = new Date();
                }
                    Student newStudent = new Student(
                            lastName,
                            firstName,
                            gender,
                            email,
                            finalDate,
                            spinnerValue
                    );

                Intent intent = new Intent();
                intent.putExtra("newStudent", newStudent);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        final Button buttonDatePicker = findViewById(R.id.datePickerButton);
        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            @TargetApi(24)
            public void onClick(View v) {
                DialogFragment dialog = new DatePickerFragment();
            }
        });
    }
}
