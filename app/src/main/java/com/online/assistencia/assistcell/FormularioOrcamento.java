package com.online.assistencia.assistcell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormularioOrcamento extends AppCompatActivity implements View.OnClickListener {

    private EditText nomeCli;
    private EditText Marca;
    private EditText Modelo;
    private EditText EstadoF;
    private EditText Relato;
    private EditText Contato;
    private EditText Email;
    private EditText Forma;
    private Button enviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orcamento);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Formulario de Orcamento");

        nomeCli = (EditText) findViewById(R.id.editNome);
        Marca = (EditText) findViewById(R.id.editMarca);
        Modelo = (EditText) findViewById(R.id.editModelo);
        EstadoF = (EditText) findViewById(R.id.editEstadoFisico);
        Relato = (EditText) findViewById(R.id.editProblema);
        Contato = (EditText) findViewById(R.id.editPhone);
        Email = (EditText) findViewById(R.id.editEmailCli);
        Forma = (EditText) findViewById(R.id.editEnviorcamento);
        enviar = (Button) findViewById(R.id.btnEnviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nomeCli.getText().length() == 0 || (Marca.getText().length() == 0) || (Modelo.getText().length() == 0)
                        || EstadoF.getText().length() == 0 || Relato.getText().length() == 0 || Contato.getText().length() == 0 || Email.getText().length() == 0 || Forma.getText().length() == 0) {
                    Toast.makeText(getApplication(), "Todos os campos devem ser preenchidos!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão
                startActivity(new Intent(this, Inicio.class));
                finishAffinity();  //Matar activity
                break;
            default:break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {

    }
}
