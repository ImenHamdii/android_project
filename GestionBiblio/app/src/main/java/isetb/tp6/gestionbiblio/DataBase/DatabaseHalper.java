package isetb.tp6.gestionbiblio.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import isetb.tp6.gestionbiblio.Livre;
import isetb.tp6.gestionbiblio.NewUser;

public class DatabaseHalper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "bibliotheque.db";
    public static final String TABLE_LIVRE = "livre";
    public static final String TABLE_USER="user";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_AUTEUR= "auteur";

    public static final String COL_username= "username";
    public static final String COL_userpwd= "password";

    public String CREATE_livre_TABLE ="create table "+TABLE_LIVRE+"("
            +COL_ID+" integer primary key autoincrement, "
            +COL_NAME+" text, "
            +COL_AUTEUR+" text)";

    public String CREATE_user_TABLE ="create table "+TABLE_USER+"("
            +COL_username+" text primary key, "
            +COL_userpwd+" text)";

    SQLiteDatabase db;

    public DatabaseHalper( Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION );
    }

    public SQLiteDatabase open(){
        db= this.getWritableDatabase();
        return db;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_livre_TABLE);
        db.execSQL(CREATE_user_TABLE);
        Log.d("DB","DB created ! ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS "+ TABLE_LIVRE);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USER);
        onCreate(db);
    }

    public boolean addUser(String username,String password){
        open();
        ContentValues values= new ContentValues();
        values.put("username",username);
        values.put("password",password);
        long res=db.insert(TABLE_USER,null,values);

        if(res==-1) return false;
        else return true;
    }
    public boolean checkuserName(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from user where username =?",new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else return false;

    }

    public boolean checkpassword(String username ,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from user where username =? and password=?",new String[]{username,password});
        if(cursor.getCount()>0)
            return true;
        else return false;
    }


    public void addlivre(Livre l){
        open();
        ContentValues values= new ContentValues();
        values.put(COL_NAME,l.getName());
        values.put(COL_AUTEUR,l.getAuteur());
        db.insert(TABLE_LIVRE,null,values);
    }

    public void updateLivre(Livre l){
        open();
        ContentValues values = new ContentValues();
        values.put(COL_NAME,l.getName());
        values.put(COL_AUTEUR,l.getAuteur());
        db.update(TABLE_LIVRE,values,COL_ID+"=?",new String[]{String.valueOf(l.getId())});
    }

    public void removeLivre(int id){
        open();
        db.delete(TABLE_LIVRE,COL_ID+"=?",new String[]{String.valueOf(id)});
    }

    public ArrayList<Livre> getAllLivre(){
        db=this.getReadableDatabase();
        ArrayList<Livre>List=new ArrayList<Livre>();
        Cursor c =db.query(TABLE_LIVRE,new String[]{COL_ID,COL_NAME,COL_AUTEUR},null,null,null,null,null,null);
        c.moveToFirst();
        do{
            Livre l=new Livre(c.getInt(0),c.getString(1),c.getString(2));
            List.add(l);
        }while (c.moveToNext());
        return List;
    }
    public int getLivreCount(){
        db=this.getReadableDatabase();
        int cpt=0;
        Cursor c=db.query(TABLE_LIVRE,null,null,null,null,null,null,null);
        cpt=c.getCount();
        return cpt;
    }

}
