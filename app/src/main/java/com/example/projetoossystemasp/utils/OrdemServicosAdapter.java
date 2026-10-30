package com.example.projetoossystemasp.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projetoossystemasp.R;
import com.example.projetoossystemasp.models.OrdemServico;

import java.util.List;

public class OrdemServicosAdapter extends ArrayAdapter<OrdemServico>  {

    private int resource;
    public OrdemServicosAdapter(@NonNull Context context, int resource, @NonNull List<OrdemServico> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        //   LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(this.resource,parent,false);
        TextView tvMarca = convertView.findViewById(R.id.tvMarca);
        TextView tvModelo = convertView.findViewById(R.id.tvModelo);
        TextView tvNrSerie = convertView.findViewById(R.id.tvNrSerie);
        TextView tvData = convertView.findViewById(R.id.tvData);
        TextView tvDataConclusao = convertView.findViewById(R.id.tvDataConclusao);


        OrdemServico OS = getItem(position);

        tvMarca.setText(OS.getMarca());
        tvModelo.setText(OS.getModelo());
        tvNrSerie.setText(OS.getNrserie());
        tvData.setText(OS.getDatacriacao());
        tvDataConclusao.setText(OS.getDataconclusao());

        if(position == (getCount()-1)/2 )
            convertView.setBackgroundColor(0xffffff00);
        return convertView;
    }
}
