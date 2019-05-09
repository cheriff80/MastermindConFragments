package com.example.mastermindconfragments.beans;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mastermindconfragments.R;

import java.util.List;

public class AdaptadorRanking extends RecyclerView.Adapter<AdaptadorRanking.RankingViewHolder>{


    //necesitamos un atributo que sea nuestra lista
    List<Ranking> listaRanking;

    //constructor

    public AdaptadorRanking(List<Ranking> listaRanking) {
        this.listaRanking = listaRanking;
    }

    @NonNull
    @Override
    public RankingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from (parent.getContext()).inflate(R.layout. item_recyclerview , parent, false);

        RankingViewHolder usuariosViewHolder=new RankingViewHolder(itemView);
        return usuariosViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RankingViewHolder rankingViewHolder, int i) {

        Ranking itemRanking= listaRanking.get(i);
        rankingViewHolder.bindElementoRanking(itemRanking);
    }

    @Override
    public int getItemCount() {
        return listaRanking.size();
    }


    public  static  class RankingViewHolder extends RecyclerView.ViewHolder {

        private TextView tvPuntuacion,tvIntentos,tvFechaHora;

        public RankingViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPuntuacion = (TextView) itemView.findViewById(R.id.tvPuntuacion);
            tvIntentos = (TextView) itemView.findViewById(R.id.tvIntentos);
            tvFechaHora = (TextView) itemView.findViewById(R.id.tvFechaHora);
        }

        public void bindElementoRanking(Ranking ranking){

            tvPuntuacion.setText(Integer.toString(ranking.getPuntuacion()));
            tvIntentos.setText(Integer.toString(ranking.getnIntentos()));
            tvFechaHora.setText(ranking.getFecha());
        }
    }
}
