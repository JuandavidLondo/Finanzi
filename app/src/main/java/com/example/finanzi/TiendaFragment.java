package com.example.finanzi;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TiendaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TiendaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TiendaFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TiendaFragment newInstance(String param1, String param2) {
        TiendaFragment fragment = new TiendaFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private InicioActivity inicioActivity;
    public void onAttach(Context context) {
        super.onAttach(context);
        inicioActivity = (InicioActivity) context;
    }

    Button compra1,compra2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_tienda, container, false);
        compra1 = root.findViewById(R.id.Comprar1);
        compra2 = root.findViewById(R.id.Comprar2);
        compra1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comprar1();
            }
        });
        compra2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comprar3();
            }
        });

        return root;
    }

    private void Comprar3() {inicioActivity.Comprar3();
    }

    private void Comprar1() {
        inicioActivity.Comprar1();
    }
}