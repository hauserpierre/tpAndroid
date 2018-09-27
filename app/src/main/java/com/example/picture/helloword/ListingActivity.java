package com.example.picture.helloword;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        list = (ListView) findViewById(R.id.studentList);
        ArrayList<Student> studentList = bundle.getParcelableArrayList("listStudents");

        StudentAdapter stAdapter = new StudentAdapter(this, studentList);
        list.setAdapter(stAdapter);
        Log.i("Money","Genre ez ça s'est bien passé");
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student studentSelected = (Student) list.getItemAtPosition(position);
                Intent intent = new Intent(ListingActivity.this, StudentDetailActivity.class);
                intent.putExtra("studentSelected", studentSelected);
                startActivity(intent);
            }
        });
    }
}
