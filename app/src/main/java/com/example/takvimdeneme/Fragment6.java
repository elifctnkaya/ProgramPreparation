package com.example.takvimdeneme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment6 extends Fragment {

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

       View view = inflater.inflate(R.layout.fragment6,container,false);

       buton1 = view.findViewById(R.id.buton1);
       buton2 = view.findViewById(R.id.buton2);

       buton1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               gecis(new Fragment5());
           }
       });

       buton2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               gecis(new Fragment7());
           }
       });

        return view;
    }
}
