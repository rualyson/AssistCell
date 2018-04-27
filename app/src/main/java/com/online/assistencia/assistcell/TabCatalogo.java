package com.online.assistencia.assistcell;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class TabCatalogo extends Fragment{
    ImageButton icon_tela;
    ImageButton icon_fones;
    ImageButton icon_capas;
    ImageButton icon_pelicula;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalogo, container, false);
        icon_tela = (ImageButton)view.findViewById(R.id.icon_tela);

        icon_tela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoTelas.class));
            }
        });
        icon_fones = (ImageButton)view.findViewById(R.id.icon_fones);
        icon_fones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoFones.class));
            }
        });

        icon_capas = (ImageButton)view.findViewById(R.id.icon_capas);
        icon_fones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoCases.class));
            }
        });

        icon_pelicula = (ImageButton)view.findViewById(R.id.icon_pelicula);
        icon_pelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoPeliculas.class));
            }
        });

        return view;
    }

}
