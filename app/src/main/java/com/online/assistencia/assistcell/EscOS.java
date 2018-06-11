package com.online.assistencia.assistcell;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;

public class EscOS extends AppCompatActivity implements View.OnClickListener {
    public CardView listService;
    public CardView listOrcamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esc_os);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostra o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Faz funcionar o botão
        getSupportActionBar().setTitle("Serviços");//Titulo para ser exibido na Action Bar

        listOrcamento = (CardView) findViewById(R.id.listOrcamento);
        listOrcamento.setOnClickListener(this);
        listService = (CardView) findViewById(R.id.ListService);
        listService.setOnClickListener(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EscOS.this, CadServices.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.listOrcamento:
                i = new Intent(this, TabOrcamento.class);
                startActivity(i);
                break;
            case R.id.ListService:
                i = new Intent(this, TabServicos.class);
                startActivity(i);
                break;
        }

    }
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão
                startActivity(new Intent(this, DashADM.class));
                finishAffinity();  //Matar activity
                break;
            default:break;
        }
        return true;
    }
}
