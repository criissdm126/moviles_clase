package com.example.fragmentdinamico;

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
    Fragment fragmentInicio, fragmentRojo, fragmentVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentInicio = new FragmentInicio();
        fragmentRojo = new FragmentRojo();
        fragmentVerde = new FragmentVerde();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragmentos, fragmentInicio).commit();
    }

    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        if (view.getId() == R.id.btnRojo) {
            transaction.replace(R.id.contenedorFragmentos, fragmentRojo).commit();
        } else if (view.getId() == R.id.btnVerde) {
            transaction.replace(R.id.contenedorFragmentos, fragmentVerde).commit();
        }
    }

    @Override
    public void onBackPressed() {
        // Obtener el fragmento actual
        super.onBackPressed();
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.contenedorFragmentos);

        // Verificar si estamos en el fragmento de inicio
        if (currentFragment instanceof FragmentInicio) {
            // Si estamos en el fragmento de inicio, realizar las acciones deseadas
            // Por ejemplo, puedes mostrar un mensaje o realizar alguna acción específica.
            // En este caso, simplemente finalizamos la actividad.
            finish();
        } else {
            // Si no estamos en el fragmento de inicio, volver al fragmento de inicio.
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragmentos, fragmentInicio).commit();
        }
    }
}
