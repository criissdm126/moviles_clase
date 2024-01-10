package com.example.gridviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView view;
    private List<Ejemplo> ejemploList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (GridView) findViewById(R.id.GridViewEjemplo);

        ejemploList = new ArrayList<>();
        ejemploList.add(new Ejemplo("Título Ejemplo 1","Subtitulo Ejemplo 1","",1));
        ejemploList.add(new Ejemplo("Título Ejemplo 2","Subtitulo Ejemplo 2","",2));
        ejemploList.add(new Ejemplo("Título Ejemplo 3","Subtitulo Ejemplo 3","",3));
        ejemploList.add(new Ejemplo("Título Ejemplo 4","Subtitulo Ejemplo 4","",4));
        ejemploList.add(new Ejemplo("Título Ejemplo 5","Subtitulo Ejemplo 5","",5));

        MiAdapatadorEjemplo adapatador = new MiAdapatadorEjemplo(this, R.layout.ejemplo_grid_item, ejemploList);

        view.setAdapter(adapatador);
        view.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
}