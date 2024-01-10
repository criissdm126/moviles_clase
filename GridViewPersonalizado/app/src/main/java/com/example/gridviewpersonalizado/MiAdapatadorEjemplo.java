package com.example.gridviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MiAdapatadorEjemplo extends ArrayAdapter<Ejemplo> {

    Context ctx;
    int layoutTemplate;
    List<Ejemplo> ejemploList;

    public MiAdapatadorEjemplo(@NonNull Context context, int resource, @NonNull List<Ejemplo> objects) {
        super(context, resource, objects);

        this.ctx = context;
        this.layoutTemplate = resource;
        this.ejemploList = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){

        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);

        Ejemplo elementoActual = ejemploList.get(position);

        TextView textViewTitulo = (TextView) v.findViewById(R.id.tituloEjemplo);
        TextView textViewSubtitulo = (TextView) v.findViewById(R.id.subtituloEjemplo);
        TextView textViewNumero = (TextView) v.findViewById(R.id.numeroEjemplo);
        ImageView imageViewFoto = (ImageView) v.findViewById(R.id.imagenEjemplo);

        textViewTitulo.setText(elementoActual.getTitulo());
        textViewSubtitulo.setText(elementoActual.getSubtitulo());
        textViewNumero.setText(elementoActual.getNumero()+"");


        return v;
    }
}