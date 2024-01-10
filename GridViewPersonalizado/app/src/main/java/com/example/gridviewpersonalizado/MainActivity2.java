package com.example.gridviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
public class MainActivity2 extends AppCompatActivity {

    private ListView lista;
    private List<Ejemplo> ejemploList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lista = (ListView) findViewById(R.id.Listviewejemplo);
        ejemploList = new ArrayList<>();
        ejemploList.add(new Ejemplo("Título Ejemplo 1","Subtitulo Ejemplo 1","",1));
        ejemploList.add(new Ejemplo("Título Ejemplo 2","Subtitulo Ejemplo 2","",2));
        ejemploList.add(new Ejemplo("Título Ejemplo 3","Subtitulo Ejemplo 3","",3));
        ejemploList.add(new Ejemplo("Título Ejemplo 4","Subtitulo Ejemplo 4","",4));
        ejemploList.add(new Ejemplo("Título Ejemplo 5","Subtitulo Ejemplo 5","",5));

        MiAdapatadorEjemplo adapatador = new MiAdapatadorEjemplo(this, R.layout.ejemplo_grid_item, ejemploList);

        lista.setAdapter(adapatador);
    }
}