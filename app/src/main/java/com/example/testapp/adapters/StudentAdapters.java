package com.example.testapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapp.R;
import com.example.testapp.activities.MainActivity;
import com.example.testapp.modal.Student;

import java.util.List;

public class StudentAdapters  extends RecyclerView.Adapter<StudentAdapters.StudentViewHolder> {
List<Student> studentList ;
    public StudentAdapters(List<Student> studentList) {
        this.studentList = studentList;
    }
    @Override
    public StudentAdapters.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_items,viewGroup,false);
       return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapters.StudentViewHolder studentViewHolder, int i) {
        studentViewHolder.name.setText(studentList.get(i).getName());
        studentViewHolder.crn.setText(studentList.get(i).getCrn());
        studentViewHolder.bind(studentList.get(i));
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{
        protected TextView name;
        protected TextView crn;
        public StudentViewHolder(@NonNull final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            crn = itemView.findViewById(R.id.crn);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "You clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
        public void bind(final Student student){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),student.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
