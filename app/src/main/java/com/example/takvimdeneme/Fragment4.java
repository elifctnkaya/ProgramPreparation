package com.example.takvimdeneme;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment4 extends Fragment{

    private TextView textView1;
    private Button button;
    private Button buton1;
    private Button buton2;

    public void gecis(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment4,container,false);

        textView1 = view.findViewById(R.id.textview);
        button = view.findViewById(R.id.sayfaninTamami);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

       buton1 = view.findViewById(R.id.buton1);
       buton2 = view.findViewById(R.id.buton2);

       buton1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               gecis(new Fragment3());
           }
       });

       buton2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               gecis(new Fragment5());
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
