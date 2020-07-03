package com.example.takvimdeneme;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class Veritabani extends SQLiteOpenHelper {

    private static final String Veritabani_Name = "Takvim";
    private static final int Veritabani_Version = 1;
    private static final String Takvim_Table = "TakvimTable";

    private static final String ROW_ID = "id";
    private static final String ROW_GUN = "gun";
    private static final String ROW_SAAT = "saat";
    private static final String ROW_DERS = "ders";
    private static final String ROW_HOCA = "hoca";

    public Veritabani(@Nullable Context context) {
        super(context, Takvim_Table, null, Veritabani_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +Takvim_Table+ "(" +ROW_ID+ "INTEGER PRIMARY KEY,"+ ROW_GUN+ "TEXT NOT NULL," +ROW_SAAT+ "TEXT NOT NULL," +ROW_DERS+ "TEXT NOT NULL," +ROW_HOCA+ "TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Takvim_Table);
        onCreate(db);
    }

    public boolean VeriEkle(String gun, String saat, String ders, String hoca){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ROW_GUN, gun.trim());
        cv.put(ROW_SAAT, saat);
        cv.put(ROW_DERS, ders.trim());
        cv.put(ROW_HOCA, hoca.trim());
        long dd = db.insert(Takvim_Table,null,cv);
        db.close();
        if(dd == -1){
            return false;
        }
        else{
            return true;
        }
    }
}
