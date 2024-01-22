package com.example.permisosapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    // Definir códigos de solicitud de permisos
    private static final int STORAGE_PERMISSION_REQUEST_CODE = 1;
    private static final int INTERNET_PERMISSION_REQUEST_CODE = 2;
    private static final int CONTACTS_PERMISSION_REQUEST_CODE = 3;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Comprobar y solicitar permiso de almacenamiento
        checkAndRequestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_REQUEST_CODE);

        // Comprobar y solicitar permiso de internet
        checkAndRequestPermission(Manifest.permission.INTERNET, INTERNET_PERMISSION_REQUEST_CODE);

        // Comprobar y solicitar permiso de contactos
        checkAndRequestPermission(Manifest.permission.READ_CONTACTS, CONTACTS_PERMISSION_REQUEST_CODE);

        // Comprobar y solicitar permiso de ubicación
        checkAndRequestPermission(Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_PERMISSION_REQUEST_CODE);
    }

    // Método para comprobar y solicitar permisos
    private void checkAndRequestPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            // Si el permiso no está concedido, solicitarlo al usuario
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
        } else {
            // Permiso ya concedido
            Toast.makeText(this, "Permiso " + permission + " ya concedido", Toast.LENGTH_SHORT).show();
        }
    }

    // Método llamado después de que el usuario responda a la solicitud de permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permiso concedido por el usuario
            Toast.makeText(this, "Permiso concedido", Toast.LENGTH_SHORT).show();
        } else {
            // Permiso denegado por el usuario
            Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para verificar la conexión a Internet
    private boolean isInternetConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
