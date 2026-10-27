package com.example.projetoossystemasp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.projetoossystemasp.models.OrdemServico;
import com.example.projetoossystemasp.models.Singleton;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChamadosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChamadosFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    private EditText edtNrOS;

    private Spinner spMarca;

    private  Spinner spModelo;

    private  EditText edDefeito;
    private  EditText edNrSerie;

    private  EditText edSolucao;
    private String mParam1;
    private String mParam2;

    public ChamadosFragment() {
        // Required empty public constructor
    }


    public static ChamadosFragment newInstance(String param1, String param2) {
        ChamadosFragment fragment = new ChamadosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chamados, container, false);
         edtNrOS = view.findViewById(R.id.edNrOS);
         spMarca = view.findViewById(R.id.spMarca);
         spModelo = view.findViewById(R.id.spModelo);
         edDefeito = view.findViewById(R.id.edDefeito);
         edSolucao = view.findViewById(R.id.edSolucao);

        FileInputStream fin  = null;
        ObjectInputStream in;
        try
        {
//            fin = openFileInput("medidas.dad");
//            in = new ObjectInputStream(fin);
            Singleton.listMedidas = (List<OrdemServico>) in.readObject();
            in.close();
        }
        catch(Exception e){ Singleton.listMedidas = new ArrayList<>();
            e.printStackTrace();}


        // Inflate the layout for this fragment
        return view;
    }
}