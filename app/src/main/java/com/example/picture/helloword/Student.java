package com.example.picture.helloword;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Student implements Parcelable{

    static ArrayList<Student> listStudent = new ArrayList<Student>();
    public static final Parcelable.Creator<Student> CREATOR =
            new Parcelable.Creator<Student>(){
                @Override
                public Student createFromParcel(Parcel source){
                    return new Student(source);
                }
                @Override
                public Student[] newArray(int size){
                    return new Student[size];
                }
            };

    private String lastName;
    private String firstName;
    private String sexe;
    private String email;
    private Date birthday;
    private String group;
    private Boolean redoublant;

    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Student(String lastName, String firstName, String sexe, String email, Date birthday, String group){
        this.lastName = lastName;
        this.firstName = firstName;
        this.sexe = sexe;
        this.email = email;
        this.birthday = birthday;
        this.group = group;
    }

    public Student(Parcel in){
        this.lastName = in.readString();
        this.firstName = in.readString();
        this.sexe = in.readString();
        this.email = in.readString();
        this.group = in.readString();
        this.birthday = (Date) in.readSerializable();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(this.lastName);
        dest.writeString(this.firstName);
        dest.writeString(this.sexe);
        dest.writeString(this.email);
        dest.writeString(this.group);
        dest.writeSerializable(this.birthday);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Boolean getRedoublant() {
        return redoublant;
    }

    public void setRedoublant(Boolean redoublant) {
        this.redoublant = redoublant;
    }
}
