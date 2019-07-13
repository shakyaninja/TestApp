package com.example.testapp.modal;

public class Student {
    protected  String name;
    protected  String crn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public Student(String name, String crn) {
        this.name = name;
        this.crn = crn;
    }
}
