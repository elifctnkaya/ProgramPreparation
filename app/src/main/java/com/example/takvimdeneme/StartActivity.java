package com.example.takvimdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    //positionindeterminete
    private Button dersprogram;
    private Button sinavprogram;
    private ProgressDialog yukleme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        yukleme = new ProgressDialog(this);
        dersprogram = findViewById(R.id.dersprogram);
        sinavprogram = findViewById(R.id.sinavprogram);

        dersprogram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yukleme.setTitle("Program Açılıyor");
                yukleme.setMessage("Lütfen Bekleyin");
                yukleme.setCanceledOnTouchOutside(false);
                yukleme.show();

                Intent intent = new Intent(StartActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        sinavprogram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yukleme.setTitle("Program Açılıyor");
                yukleme.setMessage("Lütfen Bekleyin");
                yukleme.setCanceledOnTouchOutside(false);
                yukleme.show();

                Intent intent = new Intent(StartActivity.this,SinavMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

    }

}