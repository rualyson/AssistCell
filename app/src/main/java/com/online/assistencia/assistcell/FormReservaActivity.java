package com.online.assistencia.assistcell;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormReservaActivity extends AppCompatActivity {
    //Criação dos Objetos
    EditText editNome;
    EditText editMarca;
    EditText editModelo;
    EditText editTelefone;
    EditText editEmail;
    EditText editData;
    Button btnReservar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        //Vinculando os objetos aos ids
        editMarca = (EditText) findViewById(R.id.editMarca);
        editMarca = (EditText) findViewById(R.id.editModelo);
        editNome = (EditText) findViewById(R.id.editNome);

        editTelefone = (EditText) findViewById(R.id.editTelefone);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editData = (EditText) findViewById(R.id.editData);
        btnReservar = (Button) findViewById(R.id.btnReservar);

        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editMarca.getText().length() == 0 ||editModelo.getText().length() == 0 ||editNome.getText().length() == 0 || (editTelefone.getText().length() == 0) || (editEmail.getText().length() == 0) || (editData.getText().length() == 0)) {
                    Toast.makeText(getApplication(), "Os campos Marca do produto, Modelo, Seu Nome, Telefone, Email e Data da reserva são obrigatórios!",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplication(),
                            "Reservado com Sucesso!", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}