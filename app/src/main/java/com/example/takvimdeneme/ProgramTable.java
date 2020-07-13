package com.example.takvimdeneme;



public class ProgramTable {

    private int id;
    private String gun;
    private String saat;
    private String sinif;
    private String ders;
    private String hoca;
    public ProgramTable(){

    }
    public ProgramTable(int id, String gun, String saat, String sinif, String ders, String hoca){
        this.id = id;
        this.gun = gun;
        this.saat = saat;
        this.sinif = sinif;
        this.ders = ders;
        this.hoca = hoca;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getGun(){
        return gun;
    }
    public void setGun(String gun){
        this.gun = gun;
    }
    public String getSaat(){
        return saat;
    }
    public void setSaat(String saat){
        this.saat = saat;
    }
    public String getSinif(){
        return sinif;
    }
    public void setSinif(String sinif){
        this.sinif = sinif;
    }
    public String getDers(){
        return ders;
    }
    public void setDers(String ders){
        this.ders = ders;
    }

    public String getHoca(){
        return hoca;
    }

    public void setHoca(String hoca){
        this.hoca = hoca;
    }
}
