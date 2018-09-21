package com.example.picture.helloword;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Date;

public class AddActivity extends Activity {

    public static final int RESULT_OK = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        final Button buttonDatePicker = findViewById(R.id.datePickerButton);
        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            @TargetApi(24)
            public void onClick(View v) {
                DatePickerDialog d = new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        buttonDatePicker.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },0,0,0);
                d.show();
            }
        });
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

                Date birthday = new Date();

                if(buttonDatePicker.getText() != null){
                    String birthdayText = buttonDatePicker.getText().toString();
                    String[] split = birthdayText.split("/");
                    birthday = new Date(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]));
                }
                    Student newStudent = new Student(
                            lastName,
                            firstName,
                            gender,
                            email,
                            birthday,
                            spinnerValue
                    );

                Intent intent = new Intent();
                intent.putExtra("newStudent", newStudent);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
