package com.example.lutfi.menuprogram;



public class StudentsModel {

    public int id;
    public String name;
    public String phone_number;

    public StudentsModel(int id, String name, String phone_number) {
        // TODO Auto-generated constructor stub
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
    }

    public StudentsModel(){}

    public int getId() {
        return id;
    }

    public String getName(){
        return this.name;
    }

    public String getPhone_number(){
        return this.phone_number;
    }
}