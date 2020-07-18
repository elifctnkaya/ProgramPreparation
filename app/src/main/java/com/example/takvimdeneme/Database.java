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
       db.execSQL("CREATE TABLE ProgramTable (id INTEGER PRIMARY KEY AUTOINCREMENT , gun TEXT, saat TEXT, sinif TEXT, ders TEXT, hoca TEXT);");
       db.execSQL("CREATE TABLE SinavTable (sinav_id INTEGER PRIMARY KEY AUTOINCREMENT , sinav_gun TEXT, sinav_saat TEXT, sinav_sinif TEXT, sinav_ders TEXT, sinav_hoca TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ProgramTable");
        db.execSQL("DROP TABLE IF EXISTS SinavTable");
        onCreate(db);
    }


    ///////////////DERS PROGRAMI İÇİN DATABASE
    public boolean VeriEkle(String gun, String saat, String sinif,String ders, String hoca) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("gun", gun);
        cv.put("saat", saat);
        cv.put("sinif", sinif);
        cv.put("ders", ders);
        cv.put("hoca", hoca);
        long dd = db.insert("ProgramTable", null, cv);
        db.close();
        if (dd == -1) {
            return false;
        } else {
            return true;
        }
    }
    public ArrayList<ProgramTable>TumVeriler(){
        ArrayList<ProgramTable> VerilerArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM ProgramTable" , null);
        while (c.moveToNext()){
            ProgramTable programTable = new ProgramTable(c.getInt(c.getColumnIndex("id"))
                    , c.getString(c.getColumnIndex("gun"))
                    , c.getString(c.getColumnIndex("saat"))
                    , c.getString(c.getColumnIndex("sinif"))
                    , c.getString(c.getColumnIndex("ders"))
                    , c.getString(c.getColumnIndex("hoca")));
            VerilerArrayList.add(programTable);
        }
        return VerilerArrayList;
    }
    public boolean VeriSil(String gun, String saat){
        SQLiteDatabase db = this.getWritableDatabase();
        long delete = db.delete("ProgramTable", "gun=? and saat=?", new String[]{gun,saat});
        db.close();
        if(delete == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean VeriGuncelle(String gun, String saat, String sinif, String ders, String hoca){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("gun",gun);
        cv.put("saat",saat);
        cv.put("sinif",sinif);
        cv.put("ders", ders);
        cv.put("hoca", hoca);
        long xx = db.update("ProgramTable",cv, "gun=? and saat=? ", new String[]{gun,saat});
        db.close();
        if(xx == -1){
            return false;
        }
        else{
            return true;
        }
    }
    ////////////////////////////////////////////////

    /////////SINAV PROGRAMI İÇİN DATABASE
    public boolean SinavEkle(String sinav_gun, String sinav_saat, String sinav_sinif,String sinav_ders, String sinav_hoca) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("sinav_gun", sinav_gun);
        cv.put("sinav_saat", sinav_saat);
        cv.put("sinav_sinif", sinav_sinif);
        cv.put("sinav_ders", sinav_ders);
        cv.put("sinav_hoca", sinav_hoca);
        long dd = db.insert("SinavTable", null, cv);
        db.close();
        if (dd == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<SinavTable>SinavVerileri(){
        ArrayList<SinavTable> SinavArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM SinavTable" , null);
        while (c.moveToNext()){
            SinavTable sinavTable = new SinavTable(c.getInt(c.getColumnIndex("sinav_id"))
                    , c.getString(c.getColumnIndex("sinav_gun"))
                    , c.getString(c.getColumnIndex("sinav_saat"))
                    , c.getString(c.getColumnIndex("sinav_sinif"))
                    , c.getString(c.getColumnIndex("sinav_ders"))
                    , c.getString(c.getColumnIndex("sinav_hoca")));
            SinavArrayList.add(sinavTable);
        }
        return SinavArrayList;
    }

    public boolean SinavSil(String sinav_gun, String sinav_saat){
        SQLiteDatabase db = this.getWritableDatabase();
        long delete = db.delete("SinavTable", "sinav_gun=? and sinav_saat=?", new String[]{sinav_gun,sinav_saat});
        db.close();
        if(delete == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean SinavGuncelle(String sinav_gun, String sinav_saat, String sinav_sinif, String sinav_ders, String sinav_hoca){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("sinav_gun",sinav_gun);
        cv.put("sinav_saat",sinav_saat);
        cv.put("sinav_sinif",sinav_sinif);
        cv.put("sinav_ders", sinav_ders);
        cv.put("sinav_hoca", sinav_hoca);
        long yy = db.update("SinavTable",cv, "sinav_gun=? and sinav_saat=?", new String[]{sinav_gun,sinav_saat});
        db.close();
        if(yy == -1){
            return false;
        }
        else{
            return true;
        }
    }

}


