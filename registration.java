package com.example.dell.attendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registration extends AppCompatActivity {
    Button Admin;
    Button faculty;
    Button student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Admin=findViewById(R.id.btn1);
        faculty=findViewById(R.id.btn2);
        student=findViewById(R.id.btn3);

        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent admin=new Intent(registration.this,admin.class);
                startActivity(admin);
            }
        });

        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent faculty=new Intent(registration.this,faculty.class);
                startActivity(faculty);
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent student=new Intent(registration.this,student.class);
                startActivity(student);
            }
        });
    }
}

