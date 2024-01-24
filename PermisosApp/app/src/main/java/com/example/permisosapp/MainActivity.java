package com.example.permisosapp;

import android.Manifest;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    int CODIGO_RESPUESTA = 200;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verificarPermisosSMS();
        verificarPermisosContactos();
        verificarPermisosFotos();
        verificarPermisosGPS();
        verificarPermisosInternet();
    }
    private void verificarPermisosSMS() {
        int permisoSMS = ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS);
        if (permisoSMS == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permiso SMS concedido",
                    Toast.LENGTH_SHORT).show();
        } else {
            requestPermissions(new
                    String[]{Manifest.permission.SEND_SMS}, CODIGO_RESPUESTA);
        }
    }
    private void verificarPermisosFotos(){
        int permisoFotos = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permisoFotos == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permiso acceso a fotos concedido",
                    Toast.LENGTH_SHORT).show();
        } else {
            requestPermissions(new
                            String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    CODIGO_RESPUESTA);
        }
    }
    private void verificarPermisosInternet(){
        int permisoInternet =
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.INTERNET);
        if (permisoInternet == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permiso conexión a internet concedido", Toast.LENGTH_SHORT).show();
        } else {
            requestPermissions(new String[]{Manifest.permission.INTERNET}, CODIGO_RESPUESTA);
        }
    }

    private void verificarPermisosContactos(){
        int permisoContactos =
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.READ_CONTACTS);
        if (permisoContactos == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permiso a contactos concedido",
                    Toast.LENGTH_SHORT).show();
        } else {
            requestPermissions(new
                    String[]{Manifest.permission.READ_CONTACTS}, CODIGO_RESPUESTA);
        }
    }
    private void verificarPermisosGPS(){
        int permisoGPS = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        if (permisoGPS == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permiso al GPS concedido",
                    Toast.LENGTH_SHORT).show();
        } else {
            requestPermissions(new
                            String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    CODIGO_RESPUESTA);
        }
    }
}
