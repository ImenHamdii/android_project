package iset.beja.correctionplanet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MaBaseOpenHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "mabase";

    public static final String TABLE_PLANET = "planete";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "nom";
    public static final String COL_RAYON = "rayon";

    private SQLiteDatabase db;

    public static final String CREATE_PLANET_TABLE = "CREATE TABLE " + TABLE_PLANET + "(" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT NOT NULL, "
            + COL_RAYON + " INTEGER) ";

    public MaBaseOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PLANET_TABLE);
        Log.d("db", "onCreate: ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("Drop TABLE IF EXISTS " + TABLE_PLANET);
        onCreate(db);
    }

    public SQLiteDatabase open() {
        db = this.getWritableDatabase();
        return db;
    }

    public void close() {
        db.close();
    }

    public Planet getplanete(String nom) {

    }
}