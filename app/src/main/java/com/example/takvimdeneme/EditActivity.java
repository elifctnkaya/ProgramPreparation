package com.example.takvimdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class EditActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private static final String LOG = "Veritabani";
    private TextView textView;
    private EditText editText1;
    private EditText editText2;
    private Button button;
    private TextView textView2;
    private Veritabani database;

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
        //final String gunn = textView.getText().toString();
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

        //database islemleri
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    database = new Veritabani(getApplicationContext());
                    boolean de = database.VeriEkle(textView.getText().toString(), textView2.getText().toString(), editText1.getText().toString(), editText2.getText().toString());
                    if (de == true) {
                        Toast.makeText(getApplicationContext(), "VERİ YÜKLENDİ", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "VERİ YÜKLENEMEDİ", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "HATA", Toast.LENGTH_SHORT).show();
                }
                textView2.setText("");
                editText1.setText("");
                editText2.setText("");
            }

        });
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
