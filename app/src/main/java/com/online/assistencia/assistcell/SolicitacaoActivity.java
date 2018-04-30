package com.online.assistencia.assistcell;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SolicitacaoActivity extends AppCompatActivity {
    EditText editProduto;
    EditText editNome;
    EditText editEmail;
    EditText editTelefone;
    Button botEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao);

        editProduto = (EditText) findViewById(R.id.editNome);
        editNome = (EditText) findViewById(R.id.editNome);
        editTelefone = (EditText) findViewById(R.id.editTelefone);
        editEmail = (EditText) findViewById(R.id.editEmail);
        botEnviar = (Button) findViewById(R.id.botEnviar);

        /*
        botEnviar.setOnClickListener (new View.OnClickListener()){
            public void onClick(View view) {
                if (editProduto.getText().toString().trim().equals("") || editNome.getText().toString().trim().equals("") || editTelefone.getText().toString().trim().equals("")) {
                    editProduto.setError("Campo vazio");
                    editNome.setError("Campo vazio");
                    editTelefone.setError("Campo vazio");
                }
            }
        }*/
    }
}