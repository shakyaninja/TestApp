package com.example.testapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapp.R;
import com.example.testapp.activities.FragmentsExample;
import com.example.testapp.adapters.StudentAdapters;
import com.example.testapp.modal.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    List<Student> studentList=new ArrayList<>();
    StudentAdapters studentAdapters;
    RecyclerView recyclerview;
    private EditText Nameenter;
    private EditText Crnenter;
    private Button Submit;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_first, container, false);
        return v;

    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Nameenter= view.findViewById(R.id.nameenter);
        Crnenter =view.findViewById(R.id.crnenter);
        Submit= view.findViewById(R.id.submit);
        recyclerview= view.findViewById(R.id.fragmentrecycle);
        //for static list
//        studentList.add(new Student("Luja","KCE074BCT022") );
//        studentList.add(new Student("Niranjan","KCE074BCT022") );
//        studentList.add(new Student("Bikesh","KCE074BCT022") );
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Nameenter.getText().toString().isEmpty()){
                    Toast.makeText(view.getContext(), "Enter your name first", Toast.LENGTH_SHORT).show();
                }
                else if(Crnenter.getText().toString().isEmpty()){
                    Toast.makeText(view.getContext(), "Enter your roll no.", Toast.LENGTH_SHORT).show();
                }
                else{
                    studentList.add(new Student(Nameenter.getText().toString(),Crnenter.getText().toString()));
                    studentAdapters = new StudentAdapters(studentList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
                    recyclerview.setLayoutManager(layoutManager);
                    recyclerview.setAdapter(studentAdapters);
                    studentAdapters.notifyDataSetChanged();
                    Nameenter.setText(null);
                    Crnenter.setText(null);
                }
            }
        });
    }
}
