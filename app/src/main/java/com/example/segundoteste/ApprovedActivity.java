package com.example.segundoteste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ApprovedActivity extends AppCompatActivity {

    private RecyclerView recyclerView_Approved;
    private StudentAdapter studentAdapter;
    private ArrayList<Student> studentList;
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approved);

        //Chamar o rescycleView
        recyclerView_Approved = findViewById(R.id.recycleView_Approved);

        //chamar a DB e relacionala com a studentList
        db = new DB(this);
        studentList = db.getApprovedStudents();

        //
        studentAdapter = new StudentAdapter(this, studentList);
        recyclerView_Approved.setAdapter(studentAdapter);
        recyclerView_Approved.setLayoutManager(new LinearLayoutManager(this));

    }
}