package com.example.takvimdeneme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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

import java.util.ArrayList;


public class EditActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private TextView textView;
    private EditText editText1;
    private EditText editText2;
    private Button button;
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
        button = findViewById(R.id.ekle);
        String gun = this.getIntent().getExtras().getString("GUN");
        textView.setText(gun);

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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    database = new Database(getApplicationContext());
                    boolean dd = database.VeriEkle(textView.getText().toString(),textView2.getText().toString(),editText1.getText().toString(),editText2.getText().toString());
                    //boolean dd = database.VeriEkle();
                    if(dd == true){
                        Toast.makeText(getApplicationContext(),"Veri Yüklendi", Toast.LENGTH_SHORT).show();
                        //VeriAra(zaman);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Veri Yüklenemedi", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"HATA", Toast.LENGTH_SHORT).show();
                }
                textView2.setText("");
                editText1.setText("");
                editText2.setText("");

                /*String xx =textView.getText().toString();
                switch (VeriAra(xx)){
                    case "PAZARTESİ":
                        gecis(new Fragment1());
                    case "SALI":
                        gecis(new Fragment2());
                    case "ÇARŞAMBA":
                        gecis(new Fragment3());
                    default:
                        Toast.makeText(getApplicationContext(),"tekrar deneyin", Toast.LENGTH_SHORT).show();

                }*/
                //gecis(new Fragment1());
            }
        });

    }

    public void gecis(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }

    /*public String VeriAra(String kelime){
       // ArrayList<String> VeriArrayList = new ArrayList<>();
        String aa = null;
        SQLiteDatabase dbx =database.getWritableDatabase();
        Cursor c = dbx.rawQuery("SELECT * FROM ProgramsTable WHERE gun like '%" + kelime+ "%'", null);
        while (c.moveToNext()){
            aa = (c.getString(c.getColumnIndex("ders")) + c.getString(c.getColumnIndex("hoca")));
           // VeriArrayList.add(aa);
        }
        return aa;
    }*/
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
