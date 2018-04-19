package com.online.assistencia.assistcell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SubGruposTela extends AppCompatActivity implements View.OnClickListener {

    private TextView mrc_lg, mrc_lenovo, mrc_motorola, mrc_samsung;

    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_grupos_tela);

        mrc_lg = (TextView) findViewById (R.id.id_lg);
        mrc_lenovo = (TextView) findViewById (R.id.id_lenovo);
        mrc_motorola = (TextView) findViewById (R.id.id_motorola);
        mrc_samsung = (TextView) findViewById (R.id.id_samsung);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.id_lg: i = new Intent(this, Inicio.class);startActivity(i);break;
            case R.id.id_lenovo: i = new Intent(this, Inicio.class);startActivity(i);break;
            case R.id.id_motorola: i = new Intent(this, Inicio.class);startActivity(i);break;
            case R.id.id_samsung: i = new Intent(this, Inicio.class);startActivity(i);break;
        }
    }
}
