package com.example.picture.helloword;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
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

    DatePickerFragment datePickerFragment;
    Date finalDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        final Button buttonList = findViewById(R.id.button_list);
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                            findViewById(R.id.lastname_text_input).toString(),
                            findViewById(R.id.firstname_text_input).toString(),
                            gender,
                            findViewById(R.id.email_text_input).toString(),
                            finalDate,
                            spinnerValue
                    );
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
        Toast toast = Toast.makeText(this,"The student has been created",Toast.LENGTH_SHORT);
        toast.show();
    }
}
