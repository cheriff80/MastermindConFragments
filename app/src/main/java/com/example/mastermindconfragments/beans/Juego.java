package com.example.mastermindconfragments.beans;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.mastermindconfragments.R;

public class Juego {

    private int puntuacion; //voy sumando la puntuación fila a fila
    private FilaJuego[] filaJuego; //conjunto de filas que componen el juego
    private int[] solucion; //conjunto de 4 números que suponen la solución del juego
    private boolean juegoAcabado;
    private int filasRestantes;//número de filas que faltan para llegar al final en caso de acertar antes
    private TextView textoPuntuacion;
    private ImageView[] imagenesSolucion;

    public Juego(FilaJuego[] filaJuego, ImageView[] imagenesSolucion, TextView textoPuntuacion) {
        puntuacion = 0;//en el momento de iniciar el juego la puntuación es 0
        this.filaJuego = filaJuego;
        this.imagenesSolucion=imagenesSolucion;
        this.textoPuntuacion=textoPuntuacion;
        solucion= combinacionSolucion();//genero la combinación al construir el juego
        juegoAcabado=false;
        filasRestantes=10;

    }

    public ImageView[] getImagenesSolucion() {
        return imagenesSolucion;
    }

    public void setImagenesSolucion(ImageView[] imagenesSolucion) {
        this.imagenesSolucion = imagenesSolucion;
    }

    public int getFilasRestantes() {
        return filasRestantes;
    }

    public void setFilasRestantes(int filasRestantes) {
        this.filasRestantes = filasRestantes;
    }

    public TextView getTextoPuntuacion() {
        return textoPuntuacion;
    }

    public void setTextoPuntuacion(TextView textoPuntuacion) {
        this.textoPuntuacion = textoPuntuacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public FilaJuego[] getFilaJuego() {
        return filaJuego;
    }

    public void setFilaJuego(FilaJuego[] filaJuego) {
        this.filaJuego = filaJuego;
    }

    public int[] getSolucion() {
        return solucion;
    }

    public void setSolucion(int[] solucion) {
        this.solucion = solucion;
    }

    public boolean isJuegoAcabado() {
        return juegoAcabado;
    }

    public void setJuegoAcabado(boolean juegoAcabado) {
        this.juegoAcabado = juegoAcabado;
    }

    /**
     * Método que me devuelve la combinación de números que serán la solución de mi juego
     */
    public int[] combinacionSolucion(){
        int[] combinacion = new int[4];
        //inicio el bucle para generar mis cuatro números
        for(int i=0;i<combinacion.length;i++){
            int numero = (int)(Math.random()*6)+1;//genero el número
            combinacion[i]=numero;//devuelvo el número
        }
        return combinacion;
    }





}
