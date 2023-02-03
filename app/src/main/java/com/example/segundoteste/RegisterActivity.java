package com.example.segundoteste;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
                String idTxt = String.valueOf(etStudentID);
                String nameTxt = String.valueOf(etStudentName);
                String note1Txt = String.valueOf(etNote1);
                String note2Txt = String.valueOf(etNote2);

                if (idTxt.isEmpty() || nameTxt.isEmpty() || note1Txt.isEmpty() || note2Txt.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "The fields are empty. Please complete the fields!!", Toast.LENGTH_SHORT).show();
                }
                else if (!nameTxt.matches("^[A-Za-z]+$")){
                    Toast.makeText(RegisterActivity.this, "Name can only contain letters (upper or lower case)", Toast.LENGTH_SHORT).show();
                }

                int id = Integer.parseInt(etStudentID.getText().toString());
                String name = etStudentName.getText().toString();
                float note1 = Float.parseFloat(etNote1.getText().toString());
                float note2 = Float.parseFloat(etNote2.getText().toString());
                int average = Math.round((note1 + note2) / 2);


                //Inserir os dados do student na db
                Student student = new Student(id,name, note1, note2, average);
                db.addStudent(student);
                Toast.makeText(RegisterActivity.this, "Entered data" + average, Toast.LENGTH_LONG).show();
                finish();
            }
        });

        bttCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Do you really want to complete this task?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // O que acontecerá quando o usuário clicar no botão yes
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // O que acontecerá quando o usuário clicar no botão Cancel
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
}