package com.example.recyclerview_191169.Model;

public class Student{
    String Name, RollNo, Subject;

    public Student() {
    }

    public Student(String name, String rollNo, String subject) {
        Name = name;
        RollNo = rollNo;
        Subject = subject;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
