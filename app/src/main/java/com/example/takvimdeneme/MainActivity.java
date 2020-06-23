package com.example.takvimdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.editText);
        duzenle(textView1);
    }

    public void duzenle(View view){
        Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),EditActivity.class);
        startActivity(intent);
    }

}
