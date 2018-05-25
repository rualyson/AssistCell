package com.online.assistencia.assistcell;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class CadProdNovo extends AppCompatActivity {

    private RadioButton rdTelas;  //na classe da tela a gente começa declarando as variáveis
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
        setContentView(R.layout.activity_cad_prod_novo); //aqui chama a tela que referencia a classe



                                                                /* aqui a gente pega as variáveis e
                                                                referencia com os nomes que a gente atribuiu a elas
                                                                na tela*/
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

                                                                /* esse primeiro if serve pra saber se os campos de textos foram
                                                                * preenchidos*/
        botCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((editMarca.getText().length() == 0) || (editModelo.getText().length() == 0)
                        || editQuant.getText().length() == 0) {
                    Toast.makeText(getApplication(), "ERRO! Os campos 'Marca', 'Modelo' e 'Quantidade' são obrigatórios!",
                            Toast.LENGTH_LONG).show();
                }
                                                                /* esse segundo if serve pra saber se a gente escolheu alguma
                                                                 * categoria */
                if (rdTelas.isChecked() == false && rdPeliculas.isChecked() == false
                        && rdFones.isChecked() == false && rdCapinhas.isChecked() == false
                        && rdCarregador.isChecked() == false && rdDiversos.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "ERRO! Selecione uma categoria!",
                            Toast.LENGTH_SHORT).show();
                }
                                                                /* se passar nos dois if's ele imprime a msg dizendo que o cadastro
                                                                 * foi realizado com sucesso */
                else {
                    Toast.makeText(getApplication(),
                            "Produto cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}