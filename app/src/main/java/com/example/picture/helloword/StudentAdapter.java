package com.example.picture.helloword;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(Context context, ArrayList<Student> list){
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Student student = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_student, parent, false);
        }
        TextView lastName = (TextView) convertView.findViewById(R.id.lastName);
        TextView firstName = (TextView) convertView.findViewById(R.id.firstName);
        lastName.setText(student.getLastName());
        firstName.setText(student.getFirstName());
        return convertView;
    }
}
