package com.example.segundoteste;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "student_db";
    private static final String TABLE_NAME = "students";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_NOTE1 = "note1";
    private static final String COLUMN_NOTE2 = "note2";
    private static final String COLUMN_NOTE = "note";

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_NOTE1 + " REAL," + ""
                + COLUMN_NOTE2 + " REAL," + ""
                + COLUMN_NOTE + " REAL" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_NOTE1, student.getNote1());
        values.put(COLUMN_NOTE2, student.getNote2());
        values.put(COLUMN_NOTE, student.getAverage());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public ArrayList<Student> getApprovedStudents() {
        ArrayList<Student> students = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE note >= 12.0", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                float note1 = cursor.getFloat(2);
                float note2 = cursor.getFloat(3);
                float average = cursor.getFloat(4);
                students.add(new Student(id, name, note1, note2, average));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return students;
    }

    public ArrayList<Student> getExamStudents() {
        ArrayList<Student> students = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE note  < 12.0", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                float note1 = cursor.getFloat(2);
                float note2 = cursor.getFloat(3);
                float average = cursor.getFloat(4);
                students.add(new Student(id, name, note1, note2, average));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return students;
    }

    public void deleteStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(student.getId())});
        db.close();
    }
}