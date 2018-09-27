package com.example.picture.helloword;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StudentDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Student studentSelected = (Student) intent.getParcelableExtra("studentSelected");

        TextView lastName = (TextView) findViewById(R.id.NameInfo);
        TextView firstName = (TextView) findViewById(R.id.PrenomInfo);
        TextView email = (TextView) findViewById(R.id.EmailInfo);
        TextView sexe = (TextView) findViewById(R.id.GenderInfo);
        TextView group = (TextView) findViewById(R.id.GroupeInfo);
        TextView birthday = (TextView) findViewById(R.id.DateNaissanceInfo);
        TextView redoublant = (TextView) findViewById(R.id.RedoublantInfo);

        if(studentSelected!= null){
            if(studentSelected.getLastName()!= null){
                lastName.setText(studentSelected.getLastName());
            }
            if(studentSelected.getFirstName()!= null){
                firstName.setText(studentSelected.getFirstName());
            }
            if(studentSelected.getEmail()!= null){
                email.setText(studentSelected.getEmail());
            }
            if(studentSelected.getSexe()!= null){
                sexe.setText(studentSelected.getSexe());
            }
            if(studentSelected.getBirthday()!= null){
                birthday.setText(studentSelected.getBirthday().toString());
            }
            if(studentSelected.getGroup()!= null){
                group.setText(studentSelected.getGroup());
            }
            if(studentSelected.getRedoublant()!= null && studentSelected.getRedoublant()){
                redoublant.setText("OUI");
            }else{
                redoublant.setText("NON");
            }
        }

    }
}
