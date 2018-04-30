package com.online.assistencia.assistcell;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SolicitacaoActivity extends AppCompatActivity {
    EditText editMarca;
    EditText editModelo;
    EditText editProduto;
    EditText editQuant;
    EditText editNome;
    EditText editEmail;
    EditText editTelefone;
    Button botEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao);

        editMarca = (EditText) findViewById(R.id.editMarca);
        editModelo = (EditText) findViewById(R.id.editModelo);
        editProduto = (EditText) findViewById(R.id.editProduto);
        editQuant = (EditText) findViewById(R.id.editQuant);
        editNome = (EditText) findViewById(R.id.editNome);
        editTelefone = (EditText) findViewById(R.id.editTelefone);
        editEmail = (EditText) findViewById(R.id.editEmail);
        botEnviar = (Button) findViewById(R.id.botEnviar);


        botEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editProduto.getText().length() == 0 || (editNome.getText().length() == 0) || (editTelefone.getText().length() == 0)
                        || editQuant.getText().length() == 0 || editMarca.getText().length() == 0 || editModelo.getText().length() == 0) {
                    Toast.makeText(getApplication(), "Os campos 'Marca', 'Modelo', 'Descrição do produto', 'Quantidade', 'Nome' e 'Seu Telefone' são obrigatórios!",
                            Toast.LENGTH_LONG).show();
                    //não coloquei email como campo obrigatório porquê
                    // o cliente que deseja um determinado produto pode não ter email, mas com certeza terá um telefone
                } else {
                    Toast.makeText(getApplication(),
                            "Produto solicitado com Sucesso!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}