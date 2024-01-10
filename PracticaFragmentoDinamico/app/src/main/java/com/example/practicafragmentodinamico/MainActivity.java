package com.example.practicafragmentodinamico;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction transaction;
    Fragment fragmentManzana, fragmentPera, fragmentPlatano;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManzana = new FragmentManzanas();
        fragmentPera = new FragmentPeras();
        fragmentPlatano = new FragmentPlatanos();
    }
    public void onClick(View view){
        transaction = getSupportFragmentManager().beginTransaction();
        if (view.getId() == R.id.btnManzanas) {
            transaction.replace(R.id.contenedorFragmentos,fragmentManzana);
            transaction.addToBackStack(null);
        }
        else if (view.getId() == R.id.btnPeras) {
            transaction.replace(R.id.contenedorFragmentos,fragmentPera);
            transaction.addToBackStack(null);
        }
        else if (view.getId() == R.id.btnPlatanos) {
            transaction.replace(R.id.contenedorFragmentos,fragmentPlatano);
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}