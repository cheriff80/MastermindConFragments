package com.example.mastermindconfragments;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.example.mastermindconfragments.beans.FilaJuego;
import com.example.mastermindconfragments.beans.Juego;
import com.example.mastermindconfragments.beans.Ranking;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class ActivityJuego extends AppCompatActivity implements Fragment_Solucion.OnFragmentInteractionListener,Fragment_Opciones.OnFragmentInteractionListener  {

    private boolean botonSeleccion;
    private Button botonSeleccionado;
    private Fragment_Solucion fs;
    private Juego juego=null;
    private FilaJuego[] filas=null;
    private int[] solucion=null;
    private ArrayList<Ranking> ranking;
    private Calendar fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        ranking = (ArrayList<Ranking>) getIntent().getSerializableExtra("Ranking");
        if(ranking == null) {
            ranking = new ArrayList<>();
        }

        //Fragment_Solucion fragmentSolucion = (Fragment_Solucion) getSupportFragmentManager().findFragmentById(R.id.fragmentoJuego);
        //this.juego = fragmentSolucion.pasarJuegoConFragment();
        pasarJuego(juego,solucion);//paso el juego y todos sus elementos  desde el fragment

  }

    /**
     *Cambio el estado del botón de cada fila para que pueda recibir el tag del fragment de
     * solución
     * @param v
     */

    @Override
    public void clickBotonFila(View v) {

        botonSeleccionado = (Button) v;
        if((int) v.getTag() == 8){
            botonSeleccion=true;
        }else{
            botonSeleccion=false;
        }

    }


    @Override
    public void pasarJuego(Juego juego,int[] solucion) {

        this.juego = juego;
        this.solucion = solucion;
    }


    /**
     * Método principal del juego. Al pulsar el botón solución el método gestiona mediante
     * bucles el juego y devuelve la puntuación
     * @param juego
     * @param solucion
     */
    public void jugarJuego (Juego juego,int[] solucion) {
        int aciertos = 0;

        int puntuacion=0;
        Button  b = null;
        int nBoton;


        //bucle para comprobar las filas
        //meter si el tag está entre uno y seis para saber si la fila está acabada
        if(!juego.isJuegoAcabado()) {
           int  nFilasSinSolucion=10;
            for (int nFila = 0; nFila < juego.getFilaJuego().length; nFila++) {
                FilaJuego f = juego.getFilaJuego()[nFila];
                nFilasSinSolucion--;//sumo una fila a las filas que tienen solución en el juego
                //if(!f.isFilaAcabada() && !juego.isJuegoAcabado())//si la fila no está acabada y el juego no está acabado
                    for ( nBoton=0; nBoton < f.getBotonesOpciones().length; nBoton++) {
                        b = f.getBotonesOpciones()[nBoton];
                        if ((int) b.getTag() == 1 || (int) b.getTag() == 2 || (int) b.getTag() == 3 || (int) b.getTag() == 4 ||
                                (int) b.getTag() == 5 || (int) b.getTag() == 6) {
                            f.setFilaAcabada(true);//paso la fila a acabada

                            switch (solucion[nBoton]) {
                                case 1:
                                    if ((int) b.getTag() == solucion[nBoton]) {
                                        aciertos++;
                                        puntuacion+=10;

                                    }
                                    break;
                                case 2:
                                    if ((int) b.getTag() == solucion[nBoton]) {
                                        aciertos++;
                                        puntuacion+=10;
                                    }
                                    break;
                                case 3:
                                    if ((int) b.getTag() == solucion[nBoton]) {
                                        aciertos++;
                                        puntuacion+=10;
                                    }
                                    break;
                                case 4:
                                    if ((int) b.getTag() == solucion[nBoton]) {
                                        aciertos++;
                                        puntuacion+=10;}
                                    break;
                                case 5:
                                    if ((int) b.getTag() == solucion[nBoton]) {
                                        aciertos++;
                                        puntuacion+=10;}
                                    break;
                                case 6:
                                    if ((int) b.getTag() == solucion[nBoton]) {
                                        aciertos++;
                                        puntuacion+=10;}
                                    break;
                            }
                        }f.setNumeroAciertos(aciertos);
                    }



                    switch (aciertos) {

                        case 1:
                            f.getBotonesSolucion()[0].setImageResource(R.drawable.blanco);
                            break;
                        case 2:
                            f.getBotonesSolucion()[0].setImageResource(R.drawable.blanco);
                            f.getBotonesSolucion()[1].setImageResource(R.drawable.blanco);
                            break;
                        case 3:
                            f.getBotonesSolucion()[0].setImageResource(R.drawable.blanco);
                            f.getBotonesSolucion()[1].setImageResource(R.drawable.blanco);
                            f.getBotonesSolucion()[2].setImageResource(R.drawable.blanco);
                            break;
                        case 4:
                            f.getBotonesSolucion()[0].setImageResource(R.drawable.blanco);
                            f.getBotonesSolucion()[1].setImageResource(R.drawable.blanco);
                            f.getBotonesSolucion()[2].setImageResource(R.drawable.blanco);
                            f.getBotonesSolucion()[3].setImageResource(R.drawable.blanco);
                            break;
                        default:
                            break;
                    }
                    if (aciertos == 4) {//se acaba el juego

                        int sumaFilas= 50*(nFilasSinSolucion);
                        juego.setJuegoAcabado(true);
                        puntuacion+=sumaFilas;
                        mostrarSolucion();
                        juego.getTextoPuntuacion().setText(Integer.toString(puntuacion));

                        //para el recyclerView
                        fecha = GregorianCalendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm");
                        Ranking lineaRanking= new Ranking(puntuacion,sdf.format(fecha.getTime()),10-nFilasSinSolucion);
                        ranking.add(lineaRanking);

                    }


                if(nFila == 9 && f.isFilaAcabada()){
                    juego.setJuegoAcabado(true);
                    mostrarSolucion();
                    juego.getTextoPuntuacion().setText(Integer.toString(puntuacion));

                    //para el recyclerView
                    fecha = GregorianCalendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm");
                    Ranking lineaRanking= new Ranking(puntuacion,sdf.format(fecha.getTime()),10-nFilasSinSolucion);
                    ranking.add(lineaRanking);
                }

                aciertos=0;
            }
        }
    }



    /**
     * Recibe la imagen del botón pulsado en el fragment solución
     * Cambia el background del botón seleccionado en el fragment juego
     * Cambia el tag de ese botón según el color que va a tener
     * azul=1
     * naranja=2
     * rojo=3
     * verde=4
     * blanco=5
     * negro=6
     * @param v
     */
    @Override
    public void clickBotonOpciones(View v) {
     switch(v.getId()){

            case R.id.ibOpcion1://si el botón que está pulsado puede mostrar solución
                if(botonSeleccion){
                botonSeleccionado.setBackgroundResource(R.drawable.azul);
                botonSeleccionado.setTag(1);
                 }break;
            case R.id.ibOpcion2://si el botón que está pulsado puede mostrar solución
                if(botonSeleccion){
                    botonSeleccionado.setBackgroundResource(R.drawable.naranja);
                    botonSeleccionado.setTag(2);
                }break;
            case R.id.ibOpcion3://si el botón que está pulsado puede mostrar solución
                if(botonSeleccion){
                    botonSeleccionado.setBackgroundResource(R.drawable.rojo);
                    botonSeleccionado.setTag(3);
                }break;
            case R.id.ibOpcion4://si el botón que está pulsado puede mostrar solución
                if(botonSeleccion){
                    botonSeleccionado.setBackgroundResource(R.drawable.verde);
                    botonSeleccionado.setTag(4);
                }break;
            case R.id.ibOpcion5:
                if(botonSeleccion){
                    botonSeleccionado.setBackgroundResource(R.drawable.blanco);
                    botonSeleccionado.setTag(5);
                }break;
            case R.id.ibOpcion6:
                if(botonSeleccion){
                    botonSeleccionado.setBackgroundResource(R.drawable.negro);
                    botonSeleccionado.setTag(6);
                }break;
            case R.id.btConfirmar://empieza el juego
                 jugarJuego(juego,solucion);
        }
    }

    /**
     * Sobreescribimos el método para que me muestre el menú
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_juego,menu);
        return true;
    }

    /**
     * Muestra la solución en la parte superior de la pantalla
     */
    public void mostrarSolucion() {


        for (int nBotonSolucion = 0; nBotonSolucion < juego.getImagenesSolucion().length; nBotonSolucion++) {

            switch (solucion[nBotonSolucion]) {
                case 1:
                    juego.getImagenesSolucion()[nBotonSolucion].setImageResource(R.drawable.azul);
                    break;
                case 2:
                    juego.getImagenesSolucion()[nBotonSolucion].setImageResource(R.drawable.naranja);
                    break;
                case 3:
                    juego.getImagenesSolucion()[nBotonSolucion].setImageResource(R.drawable.rojo);
                    break;
                case 4:
                    juego.getImagenesSolucion()[nBotonSolucion].setImageResource(R.drawable.verde);
                    break;
                case 5:
                    juego.getImagenesSolucion()[nBotonSolucion].setImageResource(R.drawable.blanco);
                    break;
                case 6:
                    juego.getImagenesSolucion()[nBotonSolucion].setImageResource(R.drawable.negro);
                    break;

            }

        }
    }

    /**
     * Carga el menú en la activity
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }

    /**
     * Introduce funcionalidad a los botones del menú.
     * En caso de que pulsemos la flecha la app nos enviará a la pantalla de inicio
     * En caso de que pulsemos el disco iremos al ranking
     * @param item
     * @return
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                //declaro un intent que me inicie la pantalla principal
                Intent iHome = new Intent(ActivityJuego.this, MainActivity.class);
                iHome.putExtra("Ranking", (ArrayList<Ranking>) ranking);
                startActivity(iHome);
                return true;

            case R.id.ranking:
                //declaro un intent que inicie la pantalla de ranking
                Intent iRanking = new Intent(ActivityJuego.this, ActivityRanking.class);
                iRanking.putExtra("Ranking", (ArrayList<Ranking>) ranking);
                startActivity(iRanking);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }





}
