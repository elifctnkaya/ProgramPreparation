package com.example.takvimdeneme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context) {
        super(context, "Programs", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("CREATE TABLE ProgramsTable (program_id INTEGER PRIMARY KEY AUTOINCREMENT , gun TEXT, saat TEXT, ders TEXT, hoca TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ProgramsTable");
        onCreate(db);
    }

    public boolean VeriEkle(String gunn, String saat, String ders, String hoca) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("gun", gunn);
        cv.put("saat", saat);
        cv.put("ders", ders);
        cv.put("hoca", hoca);
        long dd = db.insert("ProgramsTable", null, cv);
        db.close();
        if (dd == -1) {
            return false;
        } else {
            return true;
        }
    }

  /*  public boolean VeriAra(String kelime){
        ArrayList<String> VeriArrayList = new ArrayList<>();
        String aa = null;
        SQLiteDatabase dbx =this.getWritableDatabase();
        Cursor c = dbx.rawQuery("SELECT * FROM ProgramsTable WHERE gun like '%" + kelime+ "%'", null);
        while (c.moveToNext()){
            aa = (c.getString(c.getColumnIndex("ders")) + c.getString(c.getColumnIndex("hoca")));
            VeriArrayList.add(aa);
        }
        boolean de = VeriArrayList.add(aa);
        if (de == true){
            return true;
        }
        else{
            return false;
        }
    }*/
/*
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
    }*/
}


