package com.example.hellostudent;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.hellostudent.database.DatabaseHelper;
import com.example.hellostudent.database.Student;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {
    Activity context;
    ArrayList<Student>Liste;
    DatabaseHelper db;

    public StudentAdapter(Activity context, ArrayList<Student> liste) {
        super(context,R.layout.student_item,liste);
        this.context = context;
        this.Liste=liste;
        db=new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.student_item,null,true);
        TextView id=v.findViewById(R.id.txtid);
        TextView name=v.findViewById(R.id.txtn);
        TextView phone=v.findViewById(R.id.txtp);
        ImageView edit=v.findViewById(R.id.img1);
        ImageView delete=v.findViewById(R.id.img2);
        id.setText(String.valueOf(Liste.get(position).getId()));
        name.setText(Liste.get(position).getName());
        phone.setText(Liste.get(position).getPhone());
        Student s=Liste.get(position);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editStudent(s);
            }
        });
        
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteStudent(s);
            }
        });

        return v;
    }

    private void deleteStudent(Student s) {
        db.removeStudent(s.getId());
        context.finish();
        context.startActivity(context.getIntent());
        Toast.makeText(context,"Student deleted",Toast.LENGTH_LONG).show();
    }

    private void editStudent(Student s) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View viewadd=inflater.inflate(R.layout.add_student,null);

        EditText n=viewadd.findViewById(R.id.edit_name);
        EditText p=viewadd.findViewById(R.id.edit_phone);

        if(s!=null){
            n.setText(s.getName());
            p.setText(s.getPhone());
        }

        AlertDialog.Builder a=new AlertDialog.Builder(context);
        a.setTitle("edit student");
        a.setView(viewadd);
        a.create();
        a.setPositiveButton("edit student", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name=n.getText().toString();
                String phone=p.getText().toString();
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(context,"check input values",Toast.LENGTH_LONG).show();

                }else{
                    Student s2=new Student(s.getId(),name,phone);
                    db.updateStudent(s2);
                    context.finish();
                    context.startActivity(context.getIntent());
                }
            }
        });

        a.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context,"Task cancelled",Toast.LENGTH_LONG).show();
            }
        });
        a.show();
    }
}
