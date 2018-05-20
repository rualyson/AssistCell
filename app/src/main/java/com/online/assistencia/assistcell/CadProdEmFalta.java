package com.online.assistencia.assistcell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadProdEmFalta extends AppCompatActivity {

    EditText editCategoria;
    EditText editMarca;
    EditText editModelo;
    EditText editQuant;
    Button botCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_prod_em_falta);

        editCategoria = (EditText) findViewById(R.id.editCategoria);
        editMarca = (EditText) findViewById(R.id.editMarca);
        editModelo = (EditText) findViewById(R.id.editModelo);
        editQuant = (EditText) findViewById(R.id.editQuant);
        botCadastrar = (Button) findViewById(R.id.botCadastrar);


        botCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editCategoria.getText().length() == 0 || (editMarca.getText().length() == 0) || (editModelo.getText().length() == 0)
                        || editQuant.getText().length() == 0) {
                    Toast.makeText(getApplication(), "Os campos 'Categoria', 'Marca', 'Modelo' e 'Quantidade' são obrigatórios!",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplication(),
                            "Produto cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
