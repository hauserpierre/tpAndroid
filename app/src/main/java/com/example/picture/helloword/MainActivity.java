package com.example.picture.helloword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_ACTIVITY_RESULT = 11;
    //Pas la liste affichée, test pour la passation de données
    public ArrayList<Student> listStudents = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button buttonList = findViewById(R.id.button_list);

        listStudents.add(new Student("Boutamdja","Brice","Homme"));
        listStudents.add(new Student("Santerre","Charles","Homme"));

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListingActivity.class);
                intent.putParcelableArrayListExtra("listStudents",listStudents);
                startActivity(intent);
            }
        });
        final Button buttonAdd = findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, ADD_ACTIVITY_RESULT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 11 && resultCode == 10){
            Student newStudent = data.getParcelableExtra("newStudent");
            this.listStudents.add(newStudent);
            String message = "Student "+newStudent.getLastName()+" "+"has been added to list";
            Toast toast = Toast.makeText(this, message,Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
