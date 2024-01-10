package com.example.gridviewpersonalizado;

public class Ejemplo {

    private String titulo;
    private String subtitulo;
    private String urlFoto;
    private int numero;

    public Ejemplo(String titulo, String subtitulo, String urlFoto, int numero) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.urlFoto = urlFoto;
        this.numero = numero;
    }

    public Ejemplo(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}