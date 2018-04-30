package com.online.assistencia.assistcell;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TabCatalogo extends Fragment{

    ImageButton icon_tela, icon_fones,  icon_pelicula, icon_capas, icon_carregador, icon_diversos;
    TextView txtTela, txtPelicula, txtCase, txtFone, txtCarregador, txtDiversos;
    LinearLayout tela, pelicula, fone, cases, carregadores, diversos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalogo, container, false);

        // bloco de telas
        tela = (LinearLayout)view.findViewById(R.id.linear_tela);
        tela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoTelas.class));
            }
        });
        icon_tela = (ImageButton)view.findViewById(R.id.icon_tela);
        icon_tela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoTelas.class));
            }
        });
        txtTela = (TextView)view.findViewById(R.id.txtTela);
        txtTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoTelas.class));
            }
        });

        // bloco de fones
        fone = (LinearLayout)view.findViewById(R.id.linear_fones);
        fone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoFones.class));
            }
        });
        icon_fones = (ImageButton)view.findViewById(R.id.icon_fones);
        icon_fones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoFones.class));
            }
        });
        txtFone = (TextView)view.findViewById(R.id.txtFone);
        txtFone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoPeliculas.class));
            }
        });

        // bloco de cases
        cases = (LinearLayout)view.findViewById(R.id.linear_cases);
        cases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoCases.class));
            }
        });
        icon_capas = (ImageButton)view.findViewById(R.id.icon_capas);
        icon_fones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoCases.class));
            }
        });
        txtCase = (TextView)view.findViewById(R.id.txtCapa);
        txtCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoCases.class));
            }
        });

        // bloco de películas
        pelicula = (LinearLayout)view.findViewById(R.id.linear_pelicula);
        pelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoPeliculas.class));
            }
        });
        icon_pelicula = (ImageButton)view.findViewById(R.id.icon_pelicula);
        icon_pelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoPeliculas.class));
            }
        });
        txtPelicula = (TextView)view.findViewById(R.id.txtPelicula);
        txtPelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoPeliculas.class));
            }
        });

        // bloco de carregadores
        carregadores = (LinearLayout)view.findViewById(R.id.linear_carregadores);
        carregadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoCarregadores.class));
            }
        });
        icon_carregador = (ImageButton)view.findViewById(R.id.icon_carregador);
        icon_carregador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoCarregadores.class));
            }
        });
        txtCarregador = (TextView)view.findViewById(R.id.txtCarregador);
        txtCarregador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoCarregadores.class));
            }
        });

        // bloco de diversos
        diversos = (LinearLayout)view.findViewById(R.id.linear_diversos);
        diversos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoDiversos.class));
            }
        });
        icon_diversos = (ImageButton)view.findViewById(R.id.icon_diversos);
        icon_diversos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (getActivity(), GrupoDiversos.class));
            }
        });
        txtDiversos = (TextView)view.findViewById(R.id.txtDiversos);
        txtDiversos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GrupoDiversos.class));
            }
        });

        return view;
    }

}
