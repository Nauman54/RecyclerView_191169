package com.example.recyclerview_191169;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerview_191169.Adapter.RecyclerViewAdapter;
import com.example.recyclerview_191169.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Student> studentList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    public void removeItem(int position){
        studentList.remove(position);
        recyclerViewAdapter.notifyItemRemoved(position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        studentList.add(new Student("Nauman Ahmed","191169","English"));
        studentList.add(new Student("Afaq Ahmed","191085","Mathematics"));
        studentList.add(new Student("Umar Ateeq","191091","Biology"));
        studentList.add(new Student("Ubaid Zahoor","191154","Physics"));
        studentList.add(new Student("Aliyan Siddiqui","191196","Computer"));

        recyclerViewAdapter = new RecyclerViewAdapter(studentList,MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerViewAdapter);

        Student S;

        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
                recyclerViewAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"item "+(position+1)+" deleted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}