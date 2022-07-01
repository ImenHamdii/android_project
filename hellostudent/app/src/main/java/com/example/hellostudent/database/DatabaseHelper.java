package com.example.hellostudent.database;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "student_db";
    public static final String TABLE_STUDENT = "student";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_phone = "phone";

    public String CREATE_STUDENT_TABLE ="create table "+TABLE_STUDENT+"("
            +COL_ID+" integer primary key autoincrement, "
            +COL_NAME+" text, "
            +COL_phone+" text)";

    SQLiteDatabase db;

    public DatabaseHelper(Activity context) {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT_TABLE);
        Log.d("DB","DB created ! ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS "+ TABLE_STUDENT);
        onCreate(db);
    }

    public SQLiteDatabase open(){
        db= this.getWritableDatabase();
        return db;
    }

    public void addStudent(Student s){
        open();
        ContentValues values= new ContentValues();
        values.put(COL_NAME,s.getName());
        values.put(COL_phone,s.getPhone());
        db.insert(TABLE_STUDENT,null,values);
    }

    public void updateStudent(Student s){
        open();
        ContentValues values = new ContentValues();
        values.put(COL_NAME,s.getName());
        values.put(COL_phone,s.getPhone());
        db.update(TABLE_STUDENT,values,COL_ID+"=?",new String[]{String.valueOf(s.getId())});
    }

    public void removeStudent(int id){
        open();
        db.delete(TABLE_STUDENT,COL_ID+"=?",new String[]{String.valueOf(id)});
    }

    public ArrayList<Student> getAllStudent(){
        db=this.getReadableDatabase();
        ArrayList<Student>List=new ArrayList<Student>();
        Cursor c =db.query(TABLE_STUDENT,null,null,null,null,null,null);
        c.moveToFirst();
        do{
            Student s=new Student(c.getInt(0),c.getString(1),c.getString(2));
            List.add(s);
        }while (c.moveToNext());
        return List;
    }
public int getStudentCount(){
        db=this.getReadableDatabase();
        int cpt=0;
        Cursor c=db.query(TABLE_STUDENT,null,null,null,null,null,null,null);
        cpt=c.getCount();
        return cpt;
}
}
