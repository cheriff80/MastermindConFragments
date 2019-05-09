package com.example.mastermindconfragments;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.mastermindconfragments.beans.AdaptadorRanking;
import com.example.mastermindconfragments.beans.Ranking;
import java.util.ArrayList;


public class ActivityRanking extends AppCompatActivity  {

    private ArrayList<Ranking> ranking = new ArrayList<>();
    //atributos del recyclerView
    private RecyclerView recyclerView;
    private AdaptadorRanking adaptadorRanking;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actitivy_ranking);

        ranking = (ArrayList<Ranking>) getIntent().getSerializableExtra("Ranking");
        recyclerView=findViewById(R.id.recyclerView );
        adaptadorRanking=new AdaptadorRanking(ranking);




        recyclerView.setAdapter(adaptadorRanking);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }


}
