package com.online.assistencia.assistcell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class EscCadastro extends AppCompatActivity implements View.OnClickListener{

    private CardView solicitCadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esc_cadastro);

        solicitCadastro = (CardView) findViewById(R.id.RequestCad);
        solicitCadastro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.RequestCad:
                i = new Intent(this, SolicitLogin.class);
                startActivity(i);
                break;
        }
    }
}
