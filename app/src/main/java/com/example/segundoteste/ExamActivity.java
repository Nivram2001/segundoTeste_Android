package com.example.segundoteste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ExamActivity extends AppCompatActivity {

    private RecyclerView recyclerView_Exam;
    private StudentAdapter studentAdapter;
    private ArrayList<Student> studentList;
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        //
        recyclerView_Exam = findViewById(R.id.recycleView_Exam);

        //chamar a DB e relacionala com a studentList
        db = new DB(this);
        studentList = db.getExamStudents();

        //
        studentAdapter = new StudentAdapter(this, studentList);
        recyclerView_Exam.setAdapter(studentAdapter);
        recyclerView_Exam.setLayoutManager(new LinearLayoutManager(this));

    }
}