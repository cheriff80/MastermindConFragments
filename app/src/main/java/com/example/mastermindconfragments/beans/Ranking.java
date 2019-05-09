package com.example.mastermindconfragments.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class Ranking implements Serializable {

    private int puntuacion;
    private String fecha;
    private int nIntentos;

    /**
     * Constructor
     * @param puntuacion
     * @param fecha
     * @param nIntentos
     */
    public Ranking(int puntuacion, String fecha, int nIntentos) {
        this.puntuacion = puntuacion;
        this.fecha = fecha;
        this.nIntentos = nIntentos;
    }

    protected Ranking(Parcel in) {
        puntuacion = in.readInt();
        nIntentos = in.readInt();
    }


    /**
     * Getter y setter
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getnIntentos() {
        return nIntentos;
    }

    public void setnIntentos(int nIntentos) {
        this.nIntentos = nIntentos;
    }


}
