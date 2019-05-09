package com.example.mastermindconfragments.beans;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FilaJuego {

    private Button[] botonesOpciones;
    private ImageView[] botonesSolucion;
    private int numeroFila;
    private int numeroAciertos;
    private boolean filaSolucion;
    private int botonesSinSolucion;
    private boolean filaAcabada;


    public FilaJuego(Button[] botonesOpciones, ImageView[] botonesSolucion,int numeroFila) {
        this.botonesOpciones = botonesOpciones;
        this.botonesSolucion = botonesSolucion;
        this.numeroFila = numeroFila;
        filaSolucion = false;
        botonesSinSolucion=4;
        filaAcabada=false;
        numeroAciertos=0;
    }

    public int getNumeroFila() {
        return numeroFila;
    }

    public void setNumeroFila(int numeroFila) {
        this.numeroFila = numeroFila;
    }

    public void setBotonesSolucion(ImageView[] botonesSolucion) {
        this.botonesSolucion = botonesSolucion;
    }

    public int getBotonesSinSolucion() {
        return botonesSinSolucion;
    }

    public void setBotonesSinSolucion(int botonesSinSolucion) {
        this.botonesSinSolucion = botonesSinSolucion;
    }

    public boolean isFilaAcabada() {
        return filaAcabada;
    }

    public void setFilaAcabada(boolean filaAcabada) {
        this.filaAcabada = filaAcabada;
    }

    public Button[] getBotonesOpciones() {
        return botonesOpciones;
    }

    public void setBotonesOpciones(Button[] botonesOpciones) {
        this.botonesOpciones = botonesOpciones;
    }

    public ImageView[] getBotonesSolucion() {
        return botonesSolucion;
    }

    public void setBotonesSolucion(ImageButton[] botonesSolucion) {
        this.botonesSolucion = botonesSolucion;
    }

    public boolean isFilaSolucion() {
        return filaSolucion;
    }

    public void setFilaSolucion(boolean filaSolucion) {
        this.filaSolucion = filaSolucion;
    }

    public int getNumeroAciertos() {
        return numeroAciertos;
    }

    public void setNumeroAciertos(int numeroAciertos) {
        this.numeroAciertos = numeroAciertos;
    }

}
