package com.example.takvimdeneme;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

public class Fragment1 extends Fragment {

    private Button buton2;
    private TextView textView1;
    private Button button;
    private TextView textView8;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;
    private TextView textView13;
    private TextView textView14;
    private TextView textView15;
    private TextView textView16;
    private TextView textView17;
    private TextView textView18;
    private TextView textView19;
    private TextView textView20;
    private TextView textView21;
    private TextView textView22;
    private TextView textView23;
    private TextView textView00;
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
        editText = view.findViewById(R.id.editText);


                try{
                    Database database = new Database(getContext());
                    List<String> vVeriler = database.VeriListele();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(vVeriler);
                    editText.setText(stringBuilder);
                }
                catch (Exception e){
                    Toast.makeText(getContext(), "Hata", Toast.LENGTH_SHORT).show();
                }


        buton2 = view.findViewById(R.id.buton2);
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




}
