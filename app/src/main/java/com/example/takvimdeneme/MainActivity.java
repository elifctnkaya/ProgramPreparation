package com.example.takvimdeneme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button2;
    private TextView textView1;

    public void gecis(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gecis(new Fragment1());

        button2 = findViewById(R.id.buton2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gecis(new Fragment2());

            }
        });

        //textView1 = findViewById(R.id.editText);
        duzenle(textView1);
    }

    public void duzenle(View view){
        Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),EditActivity.class);
        startActivity(intent);
    }

}
