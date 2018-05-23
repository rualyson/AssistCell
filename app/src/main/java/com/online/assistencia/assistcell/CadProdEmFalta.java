package com.online.assistencia.assistcell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CadProdEmFalta extends AppCompatActivity {

    private RadioButton rdTelas;
    private RadioButton rdPeliculas;
    private RadioButton rdFones;
    private RadioButton rdCapinhas;
    private RadioButton rdCarregador;
    private RadioButton rdDiversos;

    private EditText editMarca;
    private EditText editModelo;
    private EditText editQuant;
    private EditText editDescricao;
    private Button botCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_prod_em_falta);

        editMarca = (EditText) findViewById(R.id.editMarca);
        editModelo = (EditText) findViewById(R.id.editModelo);
        editQuant = (EditText) findViewById(R.id.editQuant);
        editDescricao = (EditText) findViewById(R.id.editDescricao);

        rdTelas = (RadioButton) findViewById(R.id.radioButtonTelas);
        rdPeliculas = (RadioButton) findViewById(R.id.radioButtonPeliculas);
        rdFones = (RadioButton) findViewById(R.id.radioButtonFones);
        rdCapinhas = (RadioButton) findViewById(R.id.radioButtonCapinhas);
        rdCarregador = (RadioButton) findViewById(R.id.radioButtonCarregadores);
        rdDiversos = (RadioButton) findViewById(R.id.radioButtonDiversos);

        botCadastrar = (Button) findViewById(R.id.botCadastrar);


        botCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((editMarca.getText().length() == 0) || (editModelo.getText().length() == 0)
                        || editQuant.getText().length() == 0) {
                    Toast.makeText(getApplication(), "ERRO! Os campos 'Marca', 'Modelo' e 'Quantidade' são obrigatórios!",
                            Toast.LENGTH_LONG).show();
                } if (rdTelas.isChecked() == false && rdPeliculas.isChecked() == false
                        && rdFones.isChecked() == false && rdCapinhas.isChecked() == false
                        && rdCarregador.isChecked() == false && rdDiversos.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "ERRO! Selecione uma categoria!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplication(),
                            "Produto cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
