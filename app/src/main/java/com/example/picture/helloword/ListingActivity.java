package com.example.picture.helloword;

import android.app.ListActivity;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListingActivity extends Activity{

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = (ListView) findViewById(R.id.studentList);
        ArrayList<Student> studentList = new ArrayList<Student>();

        Student.listStudent.add(new Student("Boutamdja","Brice"));
        Student.listStudent.add(new Student("Santerre","Charles"));
        StudentAdapter stAdapter = new StudentAdapter(this, Student.listStudent);
        list.setAdapter(stAdapter);
        Log.i("Money","Genre ez ça s'est bien passé");
    }
}
