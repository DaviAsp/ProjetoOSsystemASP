package com.example.projetoossystemasp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.projetoossystemasp.models.OrdemServico;
import com.example.projetoossystemasp.models.Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
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

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private Fragment homeFragment,contatoFragment;

    private EditText edtNrOS;

    private Spinner spMarca;

    private  Spinner spModelo;

    private  EditText edDefeito;
    private  EditText edNrSerie;

    private  EditText edSolucao;
    private String mParam1;
    private String mParam2;

    private Button btnGravar;



    private  OrdemServico os = null;

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
         btnGravar = view.findViewById(R.id.btnGravar);



        List<String> marcas = new ArrayList();
        marcas.addAll(Arrays.asList("Positivo","Multilaser","Lenovo"));

        ArrayAdapter<String> adapter2 = new
                ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,marcas);
        spMarca.setAdapter(adapter2);


        List<String> modelos = new ArrayList();
        modelos.addAll(Arrays.asList("N1110","D570","T2040"));

        ArrayAdapter<String> adapter3 = new
                ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,modelos);
        spModelo.setAdapter(adapter3);

        FileInputStream fin  = null;
        ObjectInputStream in;
        try
        {
            fin = getContext().openFileInput("ordemservicos.dad");
            in = new ObjectInputStream(fin);
            Singleton.listOSs = (List<OrdemServico>) in.readObject();
            in.close();
        }
        catch(Exception e){ Singleton.listOSs = new ArrayList<>();
            e.printStackTrace();}

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(os!=null)
                {
                    gravarDados();
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void gravarDados(){

        Singleton.listOSs.add(os);

        FileOutputStream fout  = null;
        ObjectOutputStream out;
        try
        {
            fout = getContext().openFileOutput("ordemservicos.dad", Context.MODE_PRIVATE);
            out = new ObjectOutputStream(fout);
            out.writeObject(Singleton.listOSs);
            out.close();
        }
        catch(Exception e){   e.printStackTrace();}
    }


    protected void onStopView() {
        super.onStop();

        FileOutputStream fout  = null;
        ObjectOutputStream out;
        try
        {
            fout = getContext().openFileOutput("ordemservicos.dad", Context.MODE_PRIVATE);
            out = new ObjectOutputStream(fout);
            out.writeObject(Singleton.listOSs);
            out.close();
        }
        catch(Exception e){   e.printStackTrace();}

    }

    @SuppressLint("RestrictedApi")
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.itLimpaCampos)
        {
            edtNrOS.setText("");
            edDefeito.setText("");
            edNrSerie.setText("");
            edSolucao.setText("");
        }
        else {
            if(item.getItemId() == R.id.itHistorico){

                Intent intent;

                intent = new Intent(getActivity(),ListarHistorico.class);
                startActivity(intent);
            }
            else{
                getActivity().finish();
            }

        }
        return super.onOptionsItemSelected(item);
    }
}