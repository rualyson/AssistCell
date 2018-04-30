package com.online.assistencia.assistcell;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GrupoDiversos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo_diversos);
        ExpandableListView elvCompra = (ExpandableListView) findViewById(R.id.elvCompra);

        // cria os grupos
        List<String> lstGrupos = new ArrayList<>();
        lstGrupos.add("Chips");
        lstGrupos.add("Adaptador");


        // cria os itens de cada grupo
        List<Produto> lstChips = new ArrayList<>();
        lstChips.add(new Produto("Oi", 10.0));
        lstChips.add(new Produto("Tim", 10.0));
        lstChips.add(new Produto("Claro", 10.0));
        lstChips.add(new Produto("Vivo", 10.0));

        List<Produto> lstAdaptador = new ArrayList<>();
        lstAdaptador.add(new Produto("Cartão de memória", 10.0));
        lstAdaptador.add(new Produto("chip", 10.0));



        // cria o "relacionamento" dos grupos com seus itens
        HashMap<String, List<Produto>> lstItensGrupo = new HashMap<>();
        lstItensGrupo.put(lstGrupos.get(0), lstChips);
        lstItensGrupo.put(lstGrupos.get(1), lstAdaptador);

        // cria um adaptador (BaseExpandableListAdapter) com os dados acima
        Adaptador adaptador = new Adaptador(this, lstGrupos, lstItensGrupo);
        // define o apadtador do ExpandableListView
        elvCompra.setAdapter(adaptador);
    }

}
