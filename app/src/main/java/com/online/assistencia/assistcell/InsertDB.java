package com.online.assistencia.assistcell;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertDB extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        Button botao = (Button)findViewById(R.id.btnReservar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CTRLDB crud = new CTRLDB(getBaseContext());
                EditText nome = (EditText)findViewById(R.id.editNome);
                EditText telefone = (EditText)findViewById((R.id.editTelefone));
                EditText email = (EditText)findViewById((R.id.editEmail));
                EditText data = (EditText)findViewById(R.id.editData);
                String nomeString = nome.getText().toString();
                String telefoneString = telefone.getText().toString();
                String emailString = telefone.getText().toString();
                String dataString = data.getText().toString();
                String resultado;

                resultado = crud.insereDado(nomeString,telefoneString,emailString,dataString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}