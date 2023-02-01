package com.example.segundoteste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bttRegister, bttApproved, bttExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //botoes que serao utilizados
        bttRegister = findViewById(R.id.btt_register);
        bttApproved = findViewById(R.id.btt_approved);
        bttExam = findViewById(R.id.btt_exam);

        //escutar os click's e para onde esses clicks nos levaram
        bttRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });

        bttApproved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent approved = new Intent(MainActivity.this, ApprovedActivity.class);
                startActivity(approved);
            }
        });

        bttExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam = new Intent(MainActivity.this, ExamActivity.class);
                startActivity(exam);
            }
        });
    }
}