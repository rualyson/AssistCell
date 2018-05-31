package com.online.assistencia.assistcell;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;

public class EscFornecedor extends AppCompatActivity implements View.OnClickListener{
    public CardView listPreco;
    public CardView listForne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esc_fornecedor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostra o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Faz funcionar o botão
        getSupportActionBar().setTitle("Fornecedores");//Titulo para ser exibido na Action Bar

        listForne = (CardView) findViewById(R.id.ListForn);
        listForne.setOnClickListener(this);
        listPreco = (CardView) findViewById(R.id.ListPreco);
        listPreco.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog show = new AlertDialog.Builder(EscFornecedor.this)
                        .setTitle("O que deseja cadastrar?")
                        .setMessage("Escolha uma opção!")
                        .setPositiveButton("Fornecedor",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                //substituir o CadProdEmFalta pela classe que irá direcionar
                                Intent intent = new Intent(EscFornecedor.this, CadProdEmFalta.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Preço p/ fornecedor",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                //substituir o CadProdEmFalta pela classe que irá direcionar
                                Intent intent = new Intent(EscFornecedor.this, CadProdPrecoFornecedor.class);
                                startActivity(intent);
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.ListForn:
                //substituir o SolicitLogin pela classe que irá direcionar
                //i = new Intent(this, SolicitLogin.class);
                //startActivity(i);
                break;
            case R.id.ListPreco:
                //substituir o CadastroFuncionario pela classe que irá direcionar
                //i = new Intent(this, CadastroFuncionarios.class);
                //startActivity(i);
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
