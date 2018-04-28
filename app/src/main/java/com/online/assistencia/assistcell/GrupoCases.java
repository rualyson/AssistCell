package com.online.assistencia.assistcell;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GrupoCases extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo_cases);

        ExpandableListView elvCompra = (ExpandableListView) findViewById(R.id.elvCompra);

        // cria os grupos
        List<String> lstGrupos = new ArrayList<>();
        lstGrupos.add("Motorola");
        lstGrupos.add("Samsung");
        lstGrupos.add("Xiaomi");

        // cria os itens de cada grupo
        List<Produto> lstMotorola = new ArrayList<>();
        lstMotorola.add(new Produto("Moto G1", 10.0));
        lstMotorola.add(new Produto("Moto G2", 10.0));
        lstMotorola.add(new Produto("Moto G3", 10.0));

        List<Produto> lstSamsung = new ArrayList<>();
        lstSamsung.add(new Produto("Grand Prime", 10.0));
        lstSamsung.add(new Produto("J5", 10.0));

        List<Produto> lstXiaomi = new ArrayList<>();
        lstXiaomi.add(new Produto("Mi A1", 10.0));
        lstXiaomi.add(new Produto("Mi6", 10.0));
        lstXiaomi.add(new Produto("Mi5", 10.0));
        lstXiaomi.add(new Produto("Redmi note 4X", 10.0));


        // cria o "relacionamento" dos grupos com seus itens
        HashMap<String, List<Produto>> lstItensGrupo = new HashMap<>();
        lstItensGrupo.put(lstGrupos.get(0), lstMotorola);
        lstItensGrupo.put(lstGrupos.get(1), lstSamsung);
        lstItensGrupo.put(lstGrupos.get(2), lstXiaomi);

        // cria um adaptador (BaseExpandableListAdapter) com os dados acima
        Adaptador adaptador = new Adaptador(this, lstGrupos, lstItensGrupo);
        // define o apadtador do ExpandableListView
        elvCompra.setAdapter(adaptador);
    }

}
