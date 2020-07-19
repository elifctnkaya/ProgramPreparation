package com.example.takvimdeneme;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class SinavFragment7 extends Fragment {

    private Button buton1;
    private TextView textView1;

    //Saatler
    private TextView de1;
    private TextView de2;
    private TextView de3;
    private TextView de4;
    private TextView de5;
    private TextView de6;
    private TextView de7;
    private TextView de8;
    private TextView de9;
    private TextView de10;
    private TextView de11;
    private TextView de12;
    private TextView de13;
    private TextView de14;
    private TextView de15;
    private TextView de16;
    private TextView de17;
    //
    private TextView editText;

    public void gecis(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.sinav_frame, fragment);
        fragmentTransaction.commit();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.sinavfragment7, container, false);

        textView1 = view.findViewById(R.id.textview);
        buton1 = view.findViewById(R.id.buton1);
        String gun = textView1.getText().toString();

        //Saat Tanımlamaları
        de1 = view.findViewById(R.id.editText);
        de2 = view.findViewById(R.id.editText1);
        de3 = view.findViewById(R.id.editText2);
        de4 = view.findViewById(R.id.editText3);
        de5 = view.findViewById(R.id.editText4);
        de6 = view.findViewById(R.id.editText5);
        de7 = view.findViewById(R.id.editText6);
        de8 = view.findViewById(R.id.editText7);
        de9 = view.findViewById(R.id.editText8);
        de10 = view.findViewById(R.id.editText9);
        de11 = view.findViewById(R.id.editText10);
        de12 = view.findViewById(R.id.editText11);
        de13 = view.findViewById(R.id.editText12);
        de14 = view.findViewById(R.id.editText13);
        de15 = view.findViewById(R.id.editText14);
        de16 = view.findViewById(R.id.editText15);
        de17 = view.findViewById(R.id.editText16);
        //
        Database database = new Database(getContext());

        ArrayList<SinavTable> gelenler = database.SinavVerileri();
        for (SinavTable e : gelenler) {
            String gunn = e.getSinav_gun();
            String saat = e.getSinav_saat();
            String sinif = e.getSinav_sinif();
            String ders = e.getSinav_ders();
            String hoca = e.getSinav_hoca();

            if (gunn.contentEquals("PAZAR")) {
                switch (saat) {
                    case "08.00":
                        de1.setText(sinif + " " + ders + "\n" + hoca);
                        de1.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "09.00":
                        de2.setText(sinif + " " + ders + "\n" + hoca);
                        de2.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "10.00":
                        de3.setText(sinif + " " + ders + "\n" + hoca);
                        de3.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "11.00":
                        de4.setText(sinif + " " + ders + "\n" + hoca);
                        de4.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "12.00":
                        de5.setText(sinif + " " + ders + "\n" + hoca);
                        de5.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "13.00":
                        de6.setText(sinif + " " + ders + "\n" + hoca);
                        de6.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "14.00":
                        de7.setText(sinif + " " + ders + "\n" + hoca);
                        de7.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "15.00":
                        de8.setText(sinif + " " + ders + "\n" + hoca);
                        de8.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "16.00":
                        de9.setText(sinif + " " + ders + "\n" + hoca);
                        de9.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "17.00":
                        de10.setText(sinif + " " + ders + "\n" + hoca);
                        de10.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "18.00":
                        de11.setText(sinif + " " + ders + "\n" + hoca);
                        de11.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "19.00":
                        de12.setText(sinif + " " + ders + "\n" + hoca);
                        de12.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "20.00":
                        de13.setText(sinif + " " + ders + "\n" + hoca);
                        de13.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "21.00":
                        de14.setText(sinif + " " + ders + "\n" + hoca);
                        de14.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "22.00":
                        de15.setText(sinif + " " + ders + "\n" + hoca);
                        de15.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "23.00":
                        de16.setText(sinif + " " + ders + "\n" + hoca);
                        de16.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                    case "00.00":
                        de17.setText(sinif + " " + ders + "\n" + hoca);
                        de17.setBackgroundColor(Color.rgb(204,229,255));
                        break;
                }
            }
        }

        de1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("08.00");
            }
        });
        de1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("08.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });

        de2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("09.00");
            }
        });
        de2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("09.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("10.00");
            }
        });
        de3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("10.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("11.00");
            }
        });
        de4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("11.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("12.00");
            }
        });
        de5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("12.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("13.00");
            }
        });
        de6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("13.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("14.00");
            }
        });
        de7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("14.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("15.00");
            }
        });
        de8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("15.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("16.00");
            }
        });
        de9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("16.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("17.00");
            }
        });
        de10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("17.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("18.00");
            }
        });
        de11.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("18.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("19.00");
            }
        });
        de12.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("19.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("20.00");
            }
        });
        de13.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("20.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("21.00");
            }
        });
        de14.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("21.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("22.00");
            }
        });
        de15.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("22.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("23.00");
            }
        });
        de16.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("23.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });
        de17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekleCalisti("00.00");
            }
        });
        de17.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ ?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setNegativeButton("SİL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silCalisti("00.00");
                    }
                });
                alertDialog.create().show();
                return false;
            }
        });


        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gecis(new SinavFragment6());
            }
        });
        return view;
    }

    public void ekleCalisti(String saat) {
        Intent intent = new Intent(getActivity(), SinavEditActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("GUN", textView1.getText().toString());
        bundle.putString("SAAT", saat);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void silCalisti(String saat) {

        Database sildb = new Database(getContext());
        boolean dd = sildb.SinavSil(textView1.getText().toString(), saat);
        if (dd == true) {
            Toast.makeText(getContext(), "Silme İşlemi Başarılı", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getActivity(), SinavMainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getContext(), "Silme İşlemi Başarısız", Toast.LENGTH_LONG).show();
        }
    }
}
