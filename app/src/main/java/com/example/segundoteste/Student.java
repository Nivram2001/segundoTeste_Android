package com.example.segundoteste;

public class Student {

    private int id;
    private String name;
    private float note1;
    private float note2;
    private float average;

    public Student(int id, String name, float note1, float note2, float average) {
        this.id = id;
        this.name = name;
        this.note1 = note1;
        this.note2 = note2;
        this.average = average;
    }

    public Student(){
        id = 0;
        name = "";
        note1 = 0;
        note2 = 0;
        average = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getNote1() {
        return note1;
    }

    public void setNote1(float note1) {
        this.note1 = note1;
    }

    public float getNote2() {
        return note2;
    }

    public void setNote2(float note2) {
        this.note2 = note2;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }
}
