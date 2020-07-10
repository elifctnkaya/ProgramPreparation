package com.example.takvimdeneme;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {

    private Button buton2;
    private TextView textView1;
    private Button button;

    //Saatler
    private TextView de1;
    private TextView de2;
    private TextView de3;
    private TextView de4;
    private TextView de5;
    private TextView de6;
    private TextView de7;
    private TextView de8;
    private TextView de9;
    private TextView de10;
    private TextView de11;
    private TextView de12;
    private TextView de13;
    private TextView de14;
    private TextView de15;
    private TextView de16;
    private TextView de17;
    //

    private TextView editText;



    public void gecis(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment1,container,false);

        textView1 = view.findViewById(R.id.textview);
        button = view.findViewById(R.id.sayfaninTamami);
        //editText = view.findViewById(R.id.editText);
        buton2 = view.findViewById(R.id.buton2);
        String gun = textView1.getText().toString();

        //Saat Tanımlamaları
        de1 = view.findViewById(R.id.editText);
        de2 = view.findViewById(R.id.editText1);
        de3 = view.findViewById(R.id.editText2);
        de4 = view.findViewById(R.id.editText3);
        de5 = view.findViewById(R.id.editText4);
        de6 = view.findViewById(R.id.editText5);
        de7 = view.findViewById(R.id.editText6);
        de8 = view.findViewById(R.id.editText7);
        de9 = view.findViewById(R.id.editText8);
        de10 = view.findViewById(R.id.editText9);
        de11 = view.findViewById(R.id.editText10);
        de12 = view.findViewById(R.id.editText11);
        de13 = view.findViewById(R.id.editText12);
        de14 = view.findViewById(R.id.editText13);
        de15 = view.findViewById(R.id.editText14);
        de16 = view.findViewById(R.id.editText15);
        de17 = view.findViewById(R.id.editText16);

        //
        duzenle(de1);
        Database database = new Database(getContext());

        /*if(database.VeriAra(gun)){
            System.out.println("Sonuc2: Veri Cagirildi");
        }
        else{
            System.out.println("Sonuc3:::");
        }*/
        //database.VeriAra(gun);
        /*ArrayList<ProgramTable> gelenler = database.VeriAra(gun);
        for(ProgramTable d : gelenler){
            Log.e("DE",d.getDers());
        }*/
        ArrayList<ProgramTable> gelenler = database.TumVeriler();
        for(ProgramTable e : gelenler){
            String gunn = e.getGun();
            String saat = e.getSaat();
            String ders = e.getDers();
            String hoca = e.getHoca();

            //System.out.println("Gün: "+gunn+" Saat: "+saat+" Ders: "+ders+" Hoca: "+hoca);


            if(gunn.contentEquals("PAZARTESİ")){
                switch (saat){
                    case "08.00":
                        de1.setText(ders+"\n"+hoca);
                        de1.setBackgroundColor(Color.BLUE);
                        break;
                    case "09.00":
                        de2.setText(ders+"\n"+hoca);
                        de2.setBackgroundColor(Color.BLUE);
                        break;
                    case "10.00":
                        de3.setText(ders+"\n"+hoca);
                        de3.setBackgroundColor(Color.BLUE);
                        break;
                    case "11.00":
                        de4.setText(ders+"\n"+hoca);
                        de4.setBackgroundColor(Color.BLUE);
                        break;
                    case "12.00":
                        de5.setText(ders+"\n"+hoca);
                        de5.setBackgroundColor(Color.BLUE);
                        break;
                    case "13.00":
                        de6.setText(ders+"\n"+hoca);
                        de6.setBackgroundColor(Color.BLUE);
                        break;
                    case "14.00":
                        de7.setText(ders+"\n"+hoca);
                        de7.setBackgroundColor(Color.BLUE);
                        break;
                    case "15.00":
                        de8.setText(ders+"\n"+hoca);
                        de8.setBackgroundColor(Color.BLUE);
                        break;
                    case "16.00":
                        de9.setText(ders+"\n"+hoca);
                        de9.setBackgroundColor(Color.BLUE);
                        break;
                    case "17.00":
                        de10.setText(ders+"\n"+hoca);
                        de10.setBackgroundColor(Color.BLUE);
                        break;
                    case "18.00":
                        de11.setText(ders+"\n"+hoca);
                        de11.setBackgroundColor(Color.BLUE);
                        break;
                    case "19.00":
                        de12.setText(ders+"\n"+hoca);
                        de12.setBackgroundColor(Color.BLUE);
                        break;
                    case "20.00":
                        de13.setText(ders+"\n"+hoca);
                        de13.setBackgroundColor(Color.BLUE);
                        break;
                    case "21.00":
                        de14.setText(ders+"\n"+hoca);
                        de14.setBackgroundColor(Color.BLUE);
                        break;
                    case "22.00":
                        de15.setText(ders+"\n"+hoca);
                        de15.setBackgroundColor(Color.BLUE);
                        break;
                    case "23.00":
                        de16.setText(ders+"\n"+hoca);
                        de16.setBackgroundColor(Color.BLUE);
                        break;
                    case "00.00":
                        de17.setText(ders+"\n"+hoca);
                        de17.setBackgroundColor(Color.BLUE);
                        break;
                }
            }

        }
/*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sendData();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("EKLE YA DA SİL");
                alertDialog.setIcon(R.drawable.uyari);
                alertDialog.setPositiveButton("EKLE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ekleCalisti();
                    }
                });

                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti();
                    }
                });
                alertDialog.create().show();

            }
        });
*/
               /* try{
                    Database database = new Database(getContext());
                    List<String> vVeriler = database.VeriListele();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(vVeriler);
                    editText.setText(stringBuilder);
                    //System.out.println(stringBuilder);
                }
                catch (Exception e){
                    Toast.makeText(getContext(), "Hata", Toast.LENGTH_SHORT).show();
                }*/

        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    gecis(new Fragment2());
            }
        });

        return view;


    }

    public void sendData(){
        Intent intent = new Intent(getActivity(),EditActivity.class);
        intent.putExtra("GUN",textView1.getText().toString());

        startActivity(intent);
    }

    public void ekleCalisti(){
        Intent intent = new Intent(getActivity(),EditActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("GUN",textView1.getText().toString());
        bundle.putString("STATE","EKLE");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void silCalisti(){
        Intent intent = new Intent(getActivity(),EditActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("GUN",textView1.getText().toString());
        bundle.putString("STATE","SİL");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void duzenle(View view){
        Toast.makeText(getContext(),"Duzenle Butonu Çalıştı",Toast.LENGTH_SHORT).show();
    }
}
