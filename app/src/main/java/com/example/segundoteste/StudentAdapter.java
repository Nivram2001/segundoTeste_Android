package com.example.segundoteste;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.student);
            textViewAverage = itemView.findViewById(R.id.note);

        }

        //colocar o remove no click longo
//        @Override
//        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
//            menu.add(0, itemView.getId(), 0, "Remove").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                @Override
//                public boolean onMenuItemClick(MenuItem menuItem) {
//                    studentList.remove(getLayoutPosition());
//                    notifyDataSetChanged();
//                    return false;
//                }
//            });
//        }
    }



}
