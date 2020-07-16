package com.example.takvimdeneme;

public class SinavTable {

    private int sinav_id;
    private String sinav_gun;
    private String sinav_saat;
    private String sinav_sinif;
    private String sinav_ders;
    private String sinav_hoca;

    public SinavTable(){

    }

    public SinavTable(int sinav_id, String sinav_gun, String sinav_saat, String sinav_sinif, String sinav_ders, String sinav_hoca){
        this.sinav_id = sinav_id;
        this.sinav_gun = sinav_gun;
        this.sinav_saat = sinav_saat;
        this.sinav_sinif = sinav_sinif;
        this.sinav_ders = sinav_ders;
        this.sinav_hoca = sinav_hoca;
    }
    public int getSinav_id(){
        return sinav_id;
    }
    public void setSinav_id(int sinav_id){
        this.sinav_id = sinav_id;
    }
    public String getSinav_gun(){
        return sinav_gun;
    }
    public void setSinav_gun(String sinav_gun){
        this.sinav_gun = sinav_gun;
    }
    public String getSinav_saat(){
        return sinav_saat;
    }
    public void setSinav_saat(String sinav_saat){
        this.sinav_saat = sinav_saat;
    }
    public String getSinav_sinif(){
        return sinav_sinif;
    }
    public void setSinav_sinif(String sinav_sinif){
        this.sinav_sinif = sinav_sinif;
    }
    public String getSinav_ders(){
        return sinav_ders;
    }
    public void setSinav_ders(String sinav_ders){
        this.sinav_ders = sinav_ders;
    }

    public String getSinav_hoca(){
        return sinav_hoca;
    }

    public void setSinav_hoca(String sinav_hoca){
        this.sinav_hoca = sinav_hoca;
    }

}
