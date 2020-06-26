package com.example.takvimdeneme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    private TextView editText;
    private EditText editText1;
    private EditText editText2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editText = findViewById(R.id.baslik);
        editText1 = findViewById(R.id.dersAdi);
        editText2 = findViewById(R.id.hocaismi);
        button = findViewById(R.id.ekle);
        db_ekle(button);

    }

    public void db_ekle(View view){
        Toast.makeText(getApplicationContext(),"Eklendi",Toast.LENGTH_SHORT).show();
    }

}
