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
       db.execSQL("CREATE TABLE ProgramTable (id INTEGER PRIMARY KEY AUTOINCREMENT , gun TEXT, saat TEXT, ders TEXT, hoca TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ProgramTable");
        onCreate(db);
    }

    public boolean VeriEkle(String gun, String saat, String ders, String hoca) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("gun", gun);
        cv.put("saat", saat);
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
                    , c.getString(c.getColumnIndex("ders"))
                    , c.getString(c.getColumnIndex("hoca")));
            VerilerArrayList.add(programTable);
        }
        return VerilerArrayList;
    }

    public void VeriSil(String ders, String hoca){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("ProgramTable", "ders=? and hoca=?", new String[]{ders, hoca});
        db.close();
    }
    public boolean VeriGuncelle(String gun, String saat, String ders, String hoca){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("gun",gun);
        cv.put("saat",saat);
        cv.put("ders", ders);
        cv.put("hoca", hoca);
        long xx = db.update("ProgramTable",cv, "gun=? and saat=? and ders=? and hoca=?", new String[]{gun,saat,ders,hoca});
        db.close();
        if(xx == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public ArrayList<ProgramTable> VeriAra(String kelime){
        ArrayList<ProgramTable> VeriArrayList = new ArrayList<>();
        //String aa = null;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM ProgramTable WHERE gun like '%"+kelime+"%'", null);
        while (c.moveToNext()){
            ProgramTable programTable = new ProgramTable(c.getInt(c.getColumnIndex("id"))
                    , c.getString(c.getColumnIndex("gun"))
                    , c.getString(c.getColumnIndex("saat"))
                    , c.getString(c.getColumnIndex("ders"))
                    , c.getString(c.getColumnIndex("hoca")));
            //VeriArrayList.add(c.getString(c.getColumnIndex("ders")));
            //VeriArrayList.add(c.getString(c.getColumnIndex("hoca")));
            /*aa = (c.getString(c.getColumnIndex("ders")) + c.getString(c.getColumnIndex("hoca")));
            //VeriArrayList.add(aa);*/
            VeriArrayList.add(programTable);
        }
        return VeriArrayList ;
        //return aa;
        //System.out.println(VeriArrayList);
        //return VeriArrayList;
       /* boolean de = VeriArrayList.add(aa);
        if (de == true){
            return true;
        }
        else{
            return false;
        }*/
    }
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


