package com.example.testapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testapp.R;
import com.example.testapp.adapters.StudentAdapters;
import com.example.testapp.modal.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
List<Student> studentList=new ArrayList<>();
StudentAdapters studentAdapters;
RecyclerView recyclerView;
private EditText Nameenter;
private EditText Crnenter;
private Button Submit;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nameenter= findViewById(R.id.nameenter);
        Crnenter =findViewById(R.id.crnenter);
        Submit= findViewById(R.id.submit);
        recyclerView= findViewById(R.id.recycle);
        //for static list
//        studentList.add(new Student("Luja","KCE074BCT022") );
//        studentList.add(new Student("Niranjan","KCE074BCT022") );
//        studentList.add(new Student("Bikesh","KCE074BCT022") );
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Nameenter.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter your name first", Toast.LENGTH_SHORT).show();
                }
                else if(Crnenter.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter your roll no.", Toast.LENGTH_SHORT).show();
                }
                else{
                    studentList.add(new Student(Nameenter.getText().toString(),Crnenter.getText().toString()));
                    studentAdapters = new StudentAdapters(studentList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(studentAdapters);
                    studentAdapters.notifyDataSetChanged();
                    Nameenter.setText(null);
                    Crnenter.setText(null);
                }
            }
        });
    }
}
