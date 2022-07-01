package iset.beja.planetes;

import android.database.sqlite.SQLiteDatabase;

public class MaBaseOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "galaxie.db";

    public static final String TABLE_PLANET = "planete";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "nom";
    public static final String COL_RAYON = "rayon";

    private SQLiteDatabase db;

    public static final String CREATE_PLANET_TABLE = "CREATE TABLE " + TABLE_PLANET + "(" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT NOT NULL, "
            + COL_RAYON + " INTEGER) ";
}
