package com.example.segundoteste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText etStudentID, etStudentName, etNote1, etNote2;
    private Button bttAdd, bttCancel;
    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //buscar os id's dos campos e botoes
        etStudentID = findViewById(R.id.student_id);
        etStudentName = findViewById(R.id.student_name);
        etNote1 = findViewById(R.id.student_test1);
        etNote2 = findViewById(R.id.student_test2);
        bttAdd = findViewById(R.id.btt_add);
        bttCancel = findViewById(R.id.btt_cancel);

        db = new DB(this);

        //escutar os click's para saber se as notes forem adicionadas e fazer os calculos automaticamente se forem inseridos
        bttAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(etStudentID.getText().toString());
                String name = etStudentName.getText().toString();
                float note1 = Float.parseFloat(etNote1.getText().toString());
                float note2 = Float.parseFloat(etNote2.getText().toString());
                int average = Math.round((note1 + note2) / 2);

//                if (id.isEmpty() || name.isEmpty() || note1.isEmpty() || note2.isEmpty()) {
//                    Toast.makeText(RegisterActivity.this, "The fields are empty. Please complete the fields!!", Toast.LENGTH_SHORT).show();
//                }
//                else if (!name.matches("^[A-Za-z]+$")){
//                    Toast.makeText(RegisterActivity.this, "Name can only contain letters (upper or lower case)", Toast.LENGTH_SHORT).show();
//                } else if (note1 && note2 >= 21 || note1 && note2 <= -1) {
//                    Toast.makeText(RegisterActivity.this, "The values have to be in the range of 0 and 20", Toast.LENGTH_SHORT).show();
//                } else {
//                    //Inserir os dados do student na db
//                    Student student = new Student(id,name, note1, note2, average);
//                    db.addStudent(student);
//                    Toast.makeText(RegisterActivity.this, "Entered data" + average, Toast.LENGTH_LONG).show();
//                    finish();
//                }

                //Inserir os dados do student na db
                Student student = new Student(id,name, note1, note2, average);
                db.addStudent(student);
                Toast.makeText(RegisterActivity.this, "Entered data", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        bttCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}