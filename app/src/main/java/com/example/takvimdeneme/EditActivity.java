package com.example.takvimdeneme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.net.SocketTimeoutException;
import java.util.ArrayList;


public class EditActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private TextView textView;
    private EditText editText1;
    private EditText editText2;
    private Button buttonekle;
    private TextView textView2;
    private Database database;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        textView = findViewById(R.id.gun);
        textView2 = findViewById(R.id.saat);
        editText1 = findViewById(R.id.dersAdi);
        editText2 = findViewById(R.id.hocaismi);
        buttonekle = findViewById(R.id.ekle);
        //final String gun = this.getIntent().getExtras().getString("GUN");
        Bundle bundle = getIntent().getExtras();
        final String gun = bundle.getString("GUN");
        String clock = bundle.getString("SAAT");

        textView.setText(gun);
        textView2.setText(clock);
        final String gunn = textView.getText().toString();
            //saatleri tablo seklinde gösteren kod
            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(EditActivity.this, textView2);
                    popup.setOnMenuItemClickListener(EditActivity.this);
                    popup.inflate(R.menu.popup_menu);
                    popup.show();
                }
            });

            buttonekle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        database = new Database(getApplicationContext());
                        final String x1 = textView.getText().toString();
                        final String x2 = textView2.getText().toString();
                        final String x3 = editText1.getText().toString();
                        final String x4 = editText2.getText().toString();
                        ////////////////////////////////////////////////
                        final int[] kontrol = {0};
                        ArrayList<ProgramTable> gelenler = database.TumVeriler();
                        for (ProgramTable e : gelenler) {
                            String gunn = e.getGun();
                            String saat = e.getSaat();
                            String ders = e.getDers();
                            String hoca = e.getHoca();

                            System.out.println("Gün: " + gunn + " Saat: " + saat + " Ders: " + ders + " Hoca: " + hoca);
                            if (gunn.contentEquals(textView.getText().toString()) && saat.contentEquals(textView2.getText().toString())) {
                                kontrol[0] = 1;
                            }
                        }
                        if (kontrol[0] == 1) {
                            AlertDialog.Builder alert = new AlertDialog.Builder(EditActivity.this);
                            alert.setTitle("Eklemek istediğiniz alan dolu");
                            alert.setMessage("Eklemek istediğinize emin misiniz ?");
                            alert.setIcon(R.drawable.unlem);
                            alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.out.println("VERİLER ::: " + x1 + x2 + x3 + x4);
                                    boolean ed = database.VeriEkle(x1, x2, x3, x4);

                                    if(ed == true){
                                        System.out.println("Ekrana Bas");
                                        Toast.makeText(getApplicationContext(),"Veri Yüklendi", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(EditActivity.this,MainActivity.class);
                                        startActivity(intent);
                                        /*switch (x1) {
                                            case "PAZARTESİ":
                                                gecis(new Fragment1());
                                                break;
                                            case "SALI":
                                                gecis(new Fragment2());
                                                break;
                                            case "ÇARŞAMBA":
                                                gecis(new Fragment3());
                                                break;
                                            case "PERŞEMBE":
                                                gecis(new Fragment4());
                                                break;
                                            case "CUMA":
                                                gecis(new Fragment5());
                                                break;
                                            case "CUMARTESİ":
                                                gecis(new Fragment6());
                                                break;
                                            case "PAZAR":
                                                gecis(new Fragment7());
                                                break;

                                        }*/
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),"Veri Güncellenmedi", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "Veri Eklenmedi", Toast.LENGTH_SHORT).show();
                                }
                            });
                            alert.create().show();
                        }
                        else{
                            boolean dd = database.VeriEkle(textView.getText().toString(),textView2.getText().toString(),editText1.getText().toString(),editText2.getText().toString());
                            //boolean dd = database.VeriEkle();
                            if(dd == true) {
                                Toast.makeText(getApplicationContext(), "Veri Yüklendi", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(EditActivity.this,MainActivity.class);
                                startActivity(intent);
                                /*switch (textView.getText().toString()) {
                                    case "PAZARTESİ":
                                        System.out.println("PAZARTESİYE GEÇ");
                                        gecis(new Fragment1());
                                        break;
                                    case "SALI":
                                        System.out.println("SALIYA GEÇ");
                                        gecis(new Fragment2());
                                        break;
                                    case "ÇARŞAMBA":
                                        System.out.println("ÇARŞAMBAYA GEÇ");
                                        gecis(new Fragment3());
                                        break;
                                    case "PERŞEMBE":
                                        System.out.println("PERŞEMBEYE GEÇ");
                                        gecis(new Fragment4());
                                        break;
                                    case "CUMA":
                                        System.out.println("CUMAYA GEÇ");
                                        gecis(new Fragment5());
                                        break;
                                    case "CUMARTESİ":
                                        System.out.println("CUMARTESİYE GEÇ");
                                        gecis(new Fragment6());
                                        break;
                                    case "PAZAR":
                                        System.out.println("PAZARA GEÇ");
                                        gecis(new Fragment7());
                                        break;


                                    //VeriAra(zaman);
                                }*/
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Veri Yüklenemedi", Toast.LENGTH_SHORT).show();
                            }
                        }

                        ////////////////////////////////////////////////

                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"HATA", Toast.LENGTH_SHORT).show();
                    }
                    textView2.setText("");
                    editText1.setText("");
                    editText2.setText("");

                }
            });


        ////


    }

   public void gecis(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
   }

    //saat secimi icin kod
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                textView2.setText("08.00");
                return true;
            case R.id.item2:
                textView2.setText("09.00");
                return true;
            case R.id.item3:
                textView2.setText("10.00");
                return true;
            case R.id.item4:
                textView2.setText("11.00");
                return true;
            case R.id.item5:
                textView2.setText("12.00");
                return true;
            case R.id.item6:
                textView2.setText("13.00");
                return true;
            case R.id.item7:
                textView2.setText("14.00");
                return true;
            case R.id.item8:
                textView2.setText("15.00");
                return true;
            case R.id.item9:
                textView2.setText("16.00");
                return true;
            case R.id.item10:
                textView2.setText("17.00");
                return true;
            case R.id.item11:
                textView2.setText("18.00");
                return true;
            case R.id.item12:
                textView2.setText("19.00");
                return true;
            case R.id.item13:
                textView2.setText("20.00");
                return true;
            case R.id.item14:
                textView2.setText("21.00");
                return true;
            case R.id.item15:
                textView2.setText("22.00");
                return true;
            case R.id.item16:
                textView2.setText("23.00");
                return true;
            case R.id.item17:
                textView2.setText("00.00");
                return true;
            default:
                return false;
        }
    }
}
