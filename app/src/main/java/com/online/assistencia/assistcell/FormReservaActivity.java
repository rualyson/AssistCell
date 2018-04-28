package com.online.assistencia.assistcell;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class FormReservaActivity extends AppCompatActivity {

    //Criação dos Objetos
    EditText editNome;
    EditText editTelefone;
    EditText editEmail;
    EditText editData;
    Button btnReservar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        //Vinculando os objetos aos ids
        editNome = (EditText) findViewById(R.id.editNome);
        editTelefone = (EditText) findViewById(R.id.editTelefone);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editData = (EditText) findViewById(R.id.editData);
        btnReservar = (Button) findViewById(R.id.btnReservar);
    }

    /*btnAcessar.setOnClickListener(new View.OnClickListener()) {
        @Override public void onClick(View v) {

            if(editNome.getText().length() == 0 || (editTelefone.getText().length() == 0) || (editEmail.getText().length() == 0) || (editData.getText().length() == 0)){
                Toast.makeText(getApplication(),
                "Os campos Nome, Telefone, Email e Data são obrigatórios!"
                Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplication(),
                    "Reservado com Sucesso!", Toast.LENGTH_LONG).show();

            }
        } */
     }

