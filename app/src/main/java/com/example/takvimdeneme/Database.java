package com.example.takvimdeneme;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    private static final String DatabaseName = "database";
    private static final int DatabaseVersion = 1;
    private static final String ProgramTable = "program";

    public static final String ROW_ID = "id";
    public static final String ROW_DERS = "ders";
    public static final String ROW_OGR = "ogr";


    public Database(@Nullable Context context) {
        super(context, DatabaseName, null, DatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ProgramTable + "(" + ROW_ID + "INTEGER PRIMARY KEY, " +  ROW_DERS + "TEXT NOT NULL, " + ROW_OGR + "TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ProgramTable);
        onCreate(db);
    }

    public void VeriEkle(String ders, String ogr){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ROW_DERS, ders.trim());
        cv.put(ROW_OGR, ogr.trim());
        db.insert(ProgramTable, null, cv);
        db.close();
    }
}
