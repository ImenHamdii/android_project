package iset.beja.planetes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptateurBDPlanete <Databasehelper> extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "galaxie_db";

    public static final String TABLE_PLANET = "Planete";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "nom";
    public static final String COL_RAYON = "rayon";

    private SQLiteDatabase db;

    public static final String CREATE_PLANET_TABLE = "CREATE TABLE " + TABLE_PLANET + "(" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT NOT NULL, "
            + COL_RAYON + " INTEGER) ";

    public AdaptateurBDPlanete(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PLANET_TABLE);
        Log.d("db","onCreate: ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("Drop TABLE IF EXISTS "+ TABLE_PLANET);
        onCreate(db);
    }

    public SQLiteDatabase open(){
        db= this.getWritableDatabase();
        return db;
    }

    public void close (){
        db.close();
    }

    public SQLiteDatabase getBaseDonnees() {
        return db;
    }



    public void ajouterPlanete (Planete p){
        open();
        ContentValues values= new ContentValues();
        values.put(COL_NAME,p.getNom());
        values.put(COL_RAYON,p.getRayon());
        db.insert(TABLE_PLANET,null,values);
    }
    public void modifierPlanete(Planete p){
        open();
        ContentValues values = new ContentValues();
        values.put(COL_NAME,p.getNom());
        values.put(COL_RAYON,p.getRayon());
        db.update(TABLE_PLANET,values,COL_ID+"=?",new String[]{String.valueOf(p.getId())});
    }
    public void supprimerPlanet(int id){
        open();
        db.delete(TABLE_PLANET,COL_ID+"=?",new String[]{String.valueOf(id)});
    }
    public void supprimerPlanet(String nom){
        open();
        db.delete(TABLE_PLANET,COL_NAME+"=?",new String[]{String.valueOf(nom)});
    }

    public ArrayList<Planete> getAllPlanete(){
        db=this.getReadableDatabase();
        ArrayList<Planete>List=new ArrayList<Planete>();
        Cursor c =db.query(TABLE_PLANET,new String[]{COL_ID,COL_NAME,COL_RAYON},null,null,null,null,null);
        c.moveToFirst();
        do{
            Planete p=new Planete(c.getInt(0),c.getString(1),c.getInt(2));
            List.add(p);
        }while (c.moveToNext());
        return List;
    }
}
