package com.example.mastermindconfragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mastermindconfragments.beans.FilaJuego;
import com.example.mastermindconfragments.beans.Juego;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Solucion.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Solucion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Solucion extends Fragment implements View.OnClickListener {

    //instancio los elementos del fragment
    private ImageView[] imagenesSolucion= new ImageView[4];//array botones para solución
    private ImageView iSolucionUno,iSolucionDos,iSolucionTres,iSolucionCuatro;//botonesSolucion
    private ImageView[] iResultadoFila;
    private ImageView iResultadoSI,iResultadoSD,iResultadoII,iResultadoID;
    private TextView textoPuntuacion;
    private Button[] botonesFila;
    private Button botonUnoFila,botonDosFila,botonTresFila,botonCuatroFila;
    private FilaJuego[] filas;
    private Juego juego;
    private int[] solucion = new int[4];
    //instancio mi llamada al método
    private OnFragmentInteractionListener mListener;

    public Fragment_Solucion() {
        // Required empty public constructor
    }

    /**
     *
     * @param arguments
     * @return
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Solucion newInstance(Bundle arguments) {
        Fragment_Solucion f = new Fragment_Solucion();
        if(arguments != null){
            f.setArguments(arguments);


        }
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  }




    /**
     * Inicio todos los elementos del fragment asociandolos a su vista.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__solucion, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        textoPuntuacion = (TextView) getActivity().findViewById(R.id.tvPuntuacion);
        iSolucionUno = (ImageView) getActivity().findViewById(R.id.ivSolucion1);
        iSolucionDos = (ImageView) getActivity().findViewById(R.id.ivSolucion2);
        iSolucionTres = (ImageView) getActivity().findViewById(R.id.ivSolucion3);
        iSolucionCuatro = (ImageView) getActivity().findViewById(R.id.ivSolucion4);

        //pongo número a las filas
        numerosFilas();
        //cargo las filas
        cargarJuego();
        //genero la combinación de la solución
        solucion = juego.combinacionSolucion();
        //paso el juego
        pasarJuego();





    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Método para poner los números al inicio de cada fila del juego
     */
    public  void numerosFilas(){


        for(int i=0;i<10;i++){

            String strIncludeId = "fila" + i;//el id de las filas tiene en común fila
            int includeId = getResources().getIdentifier(strIncludeId, "id",
                    getActivity().getPackageName());
            View includeLayout = getActivity().findViewById(includeId);
            if (includeLayout != null) {//si encuentra la vista
                TextView textoNumeroFila = (TextView)
                        includeLayout.findViewById(R.id.textoNumeros);
                textoNumeroFila.setText(Integer.toString(i+1));
            }
        }

            }

    /**
     * Carga todas las filas de mi juego
     */
    public  void cargarJuego(){

        filas = new FilaJuego[10];//defino las filas del juego
        for (int j=0;j<10;j++){
            FilaJuego filaJuego = crearFila(j);
            filas[j] = filaJuego;
        }
        juego = new Juego(filas,crearArrayImagenes(),textoPuntuacion);

    }

    /**
     * Crea el array de imágenes de la soluciónn superior
     */
    public ImageView[] crearArrayImagenes(){

        imagenesSolucion[0]= iSolucionUno;
        imagenesSolucion[1]= iSolucionDos;
        imagenesSolucion[2]= iSolucionTres;
        imagenesSolucion[3]= iSolucionCuatro;

        return imagenesSolucion;

    }

    /**
     * Crear filas por número de fila
     */
    public FilaJuego crearFila(int numeroFila) {

        FilaJuego filaNueva=null;

        //creo los dos arrays
        botonesFila = new Button[4];
        iResultadoFila = new ImageView[4];

        String strIncludeId = "fila" + numeroFila;//el id de las filas tiene en común fila
        int includeId = getResources().getIdentifier(strIncludeId, "id",
                getActivity().getPackageName());
        View includeLayout = getActivity().findViewById(includeId);
        if (includeLayout != null) {//si encuentra la vista


            //botones de cada fila

            //boton Uno
            botonUnoFila = (Button) includeLayout.findViewById(R.id.btnUnoFila);
            botonUnoFila.setTag(7);//añado tag al boton
            botonUnoFila.setOnClickListener(this);//asigno el onClick al boton
            botonesFila[0]=botonUnoFila;
            //boton Dos
            botonDosFila = (Button) includeLayout.findViewById(R.id.btnDosFila);
            botonDosFila.setTag(7);
            botonDosFila.setOnClickListener(this);
            botonesFila[1]=botonDosFila;
            //boton Tres
            botonTresFila = (Button) includeLayout.findViewById(R.id.btnTresFila);
            botonTresFila.setTag(7);
            botonTresFila.setOnClickListener(this);
            botonesFila[2]=botonTresFila;
            //boton Cuatro
            botonCuatroFila = (Button) includeLayout.findViewById(R.id.btnCuatroFila);
            botonCuatroFila.setTag(7);
            botonCuatroFila.setOnClickListener(this);
            botonesFila[3]=botonCuatroFila;

            //imagenes resultado
            iResultadoSI = (ImageView) includeLayout.findViewById(R.id.ivAciertosSI);
            iResultadoFila[0]=iResultadoSI;
            iResultadoSD = (ImageView) includeLayout.findViewById(R.id.ivAciertosSD);
            iResultadoFila[1]=iResultadoSD;
            iResultadoII = (ImageView) includeLayout.findViewById(R.id.ivAciertosII);
            iResultadoFila[2]=iResultadoII;
            iResultadoID = (ImageView) includeLayout.findViewById(R.id.ivAciertosID);
            iResultadoFila[3]=iResultadoID;

            //inicio la nueva fila
            filaNueva = new FilaJuego(botonesFila, iResultadoFila, numeroFila);
            filaNueva.setNumeroFila(numeroFila);
        }
        return filaNueva;

    }

    /**
     * Sobreescribo el método onClick de mis botones
     * Si el tag es 7 significa que el botón está en estado inicial
     * Si el tag es 8 el botón puede cambiar de aspecto
    **/
    @Override
    public void onClick(View v) {

        Button b = (Button) v;//casteo la vista a botón
        if((int)v.getTag() == 7 ){
            b.setBackgroundResource(R.drawable.madera3);
            v.setTag(8);
        }else
        if((int)v.getTag()==8){
            b.setBackgroundResource(R.drawable.boton_juego);
            v.setTag(7);
        }
        mListener.clickBotonFila(b);
    }

    public Juego pasarJuegoConFragment(){
        return juego;
    }

    /**
     * Pasa el juego a la activity
     */
    public void pasarJuego() {

        mListener.pasarJuego(juego,solucion);

    }


        /**
         * This interface must be implemented by activities that contain this
         * fragment to allow an interaction in this fragment to be communicated
         * to the activity and potentially other fragments contained in that
         * activity.
         * <p>
         * See the Android Training lesson <a href=
         * "http://developer.android.com/training/basics/fragments/communicating.html"
         * >Communicating with Other Fragments</a> for more information.
         */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void clickBotonFila(View v);
        void pasarJuego(Juego juego,int[] solucion);

    }
}
