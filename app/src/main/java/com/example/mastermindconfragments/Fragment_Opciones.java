package com.example.mastermindconfragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Opciones.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Opciones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Opciones extends Fragment implements View.OnClickListener {


    private ImageButton[] ibSolucion= new ImageButton[6];
    private ImageButton ibSolucionAzul,ibSolucionRojo,ibSolucionNaranja,ibSolucionVerde,ibSolucionNegro,ibSolucionBlanco,ibConfirmar;
     private OnFragmentInteractionListener mListener;

    public Fragment_Opciones() {
        // Required empty public constructor
    }

    /**
     *
     *
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Opciones newInstance(Bundle arguments) {
        Fragment_Opciones f = new Fragment_Opciones();
        if(arguments != null){
            f.setArguments(arguments);
        }
        return f;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__opciones, container, false);


 }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ibSolucionAzul = getActivity().findViewById(R.id.ibOpcion1);
        ibSolucionAzul.setOnClickListener(this);
        ibSolucionNaranja = getActivity().findViewById(R.id.ibOpcion2);
        ibSolucionNaranja.setOnClickListener(this);
        ibSolucionRojo = getActivity().findViewById(R.id.ibOpcion3);
        ibSolucionRojo.setOnClickListener(this);
        ibSolucionVerde = getActivity().findViewById(R.id.ibOpcion4);
        ibSolucionVerde.setOnClickListener(this);
        ibSolucionBlanco = getActivity().findViewById(R.id.ibOpcion5);
        ibSolucionBlanco.setOnClickListener(this);
        ibSolucionNegro = getActivity().findViewById(R.id.ibOpcion6);
        ibSolucionNegro.setOnClickListener(this);
        ibConfirmar = getActivity().findViewById(R.id.btConfirmar);
        ibConfirmar.setOnClickListener(this);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
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
     * listener del botón opciones
     * @param v
     */
    @Override
    public void onClick(View v) {

        ImageButton ib = (ImageButton) v;
        mListener.clickBotonOpciones(v);

    }

    /**
     * Defino la interfaz para comunicar mi fragment con la actividad
     */
    public interface OnFragmentInteractionListener {
        void clickBotonOpciones(View v);


    }
}
