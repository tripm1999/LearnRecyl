package com.phamminhtri.learnrecyl;

import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rvStudent;
    ArrayList<StudentModel> studentModelList;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvStudent = (RecyclerView) findViewById(R.id.rv_student);

        studentModelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StudentModel studentModel = new StudentModel();
            studentModel.id = i + 1;
            studentModel.name = "tri" + i;
            studentModel.old = "old" + i;
            studentModelList.add(studentModel);
        }
        Log.d("LayoutManager","name" +studentModelList.size());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvStudent.setLayoutManager(layoutManager);
        adapter = new AdapterStudent(studentModelList);
        rvStudent.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
