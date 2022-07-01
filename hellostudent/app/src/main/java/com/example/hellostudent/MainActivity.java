package com.example.hellostudent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hellostudent.database.DatabaseHelper;
import com.example.hellostudent.database.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ListView listView;
private StudentAdapter adapter;
private DatabaseHelper db;
private ArrayList<Student>liststudent;
FloatingActionButton b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_view);
        db=new DatabaseHelper(this);
        int nb=db.getStudentCount();
        if (nb>0) {
            liststudent=db.getAllStudent();
            StudentAdapter adapter=new StudentAdapter(this,liststudent);
            adapter.notifyDataSetChanged();
            listView.setAdapter(adapter);
            db.close();

        }
        else {
            Toast.makeText(MainActivity.this,"there is no student in this table",Toast.LENGTH_LONG).show();
        }


        b=findViewById(R.id.btn_add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
                View viewadd=inflater.inflate(R.layout.add_student,null);

                EditText n=viewadd.findViewById(R.id.edit_name);
                EditText p=viewadd.findViewById(R.id.edit_phone);

                AlertDialog.Builder a=new AlertDialog.Builder(MainActivity.this);
                a.setTitle("Add new student");
                a.setView(viewadd);
                a.create();
                a.setPositiveButton("Add student", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String name=n.getText().toString();
                        String phone=p.getText().toString();
                        if (TextUtils.isEmpty(name)){
                            Toast.makeText(MainActivity.this,"check input values",Toast.LENGTH_LONG).show();

                        }else{
                            Student s=new Student(name,phone);
                            db.addStudent(s);
                            finish();
                            startActivity(getIntent());
                        }
                    }
                });

                a.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Task cancelled",Toast.LENGTH_LONG).show();
                    }
                });
                a.show();
            }
        });
    }
}