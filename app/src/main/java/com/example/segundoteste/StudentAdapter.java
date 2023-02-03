package com.example.segundoteste;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter  extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{

    private Context context;
    private ArrayList<Student> studentList;


    public StudentAdapter( Context context,ArrayList<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.textViewName.setText(student.getName());
        holder.textViewAverage.setText(String.valueOf(student.getAverage()));
    }

    @Override
    public int getItemCount() {
        if(studentList != null ){
            return studentList.size();
        }

        return 0;

    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewAverage;
        private DB db;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.student);
            textViewAverage = itemView.findViewById(R.id.note);


            //colocar o remove no click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(context, itemView);
                    popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.menu:
                                    db = new DB(context);
                                    Integer id = studentList.get(getLayoutPosition()).getId();
                                    long res = db.deleteStudent(id);
                                    notifyDataSetChanged();
                                    //para remover o item da lista se conseguir eliminar
                                    if (res > 0) {
                                        studentList.remove(getLayoutPosition());
                                    }
                                    return true;
                                default:
                                    return false;
                            }
                        };
                    });
                    popupMenu.show();
                }
            });

        }



    }



}
