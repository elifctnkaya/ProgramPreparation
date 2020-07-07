package com.example.takvimdeneme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class Database extends SQLiteOpenHelper {

    private static final String Database_Name = "Programs";
    private static final int Database_Version = 1;
    private static final String Programs_Table = "ProgramsTable";

    private static final String ROW_ID = "id";
    private static final String ROW_GUN = "gunn";
    private static final String ROW_SAAT = "saat";
    private static final String ROW_DERS = "ders";
    private static final String ROW_HOCA = "hoca";

    public Database(@Nullable Context context) {
        super(context, Programs_Table, null, Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +Programs_Table
                + "(" + ROW_ID + "INTEGER PRIMARY KEY,"
                + ROW_GUN + "TEXT NOT NULL,"
                + ROW_SAAT + "TEXT NOT NULL,"
                + ROW_DERS + "TEXT NOT NULL,"
                + ROW_HOCA + "TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Programs_Table);
        onCreate(db);
    }

    public boolean VeriEkle(String gunn, String saat, String ders, String hoca) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ROW_GUN, gunn.trim());
        cv.put(ROW_SAAT, saat.trim());
        cv.put(ROW_DERS, ders.trim());
        cv.put(ROW_HOCA, hoca.trim());
        long dd = db.insertOrThrow(Programs_Table, null, cv);
        db.close();
        if (dd == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<String> VeriListele(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] sutunlar = {ROW_ID, ROW_GUN, ROW_SAAT, ROW_DERS, ROW_HOCA};
        Cursor cursor = db.query(Programs_Table, sutunlar, null,null,null,null,null);
        while (cursor.moveToNext()){
            veriler.add(cursor.getString(3));
            veriler.add(cursor.getString(4));
        }
        return veriler;
    }
}


