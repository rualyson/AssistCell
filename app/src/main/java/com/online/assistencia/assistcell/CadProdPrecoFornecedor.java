package com.online.assistencia.assistcell;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CadProdPrecoFornecedor extends AppCompatActivity {

    private RadioButton rdTelas, rdPeliculas, rdFones, rdCapinhas, rdCarregador, rdDiversos;

    private EditText editMarca, editModelo, editQuant, editDescricao, editvalorDeCompra, editCnpj, editCodIdentificacao,
            editFornecedor;

    private Button botCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_prod_preco_fornecedor);
        editMarca = (EditText) findViewById(R.id.editMarca);
        editModelo = (EditText) findViewById(R.id.editModelo);
        editQuant = (EditText) findViewById(R.id.editQuant);
        editDescricao = (EditText) findViewById(R.id.editDescricao);
        editvalorDeCompra = (EditText) findViewById(R.id.editValorCompra);
        editCnpj = (EditText) findViewById(R.id.editCadCnpj);
        editCodIdentificacao = (EditText) findViewById(R.id.editCodIdent);
        editFornecedor =(EditText) findViewById(R.id.editCadFornecedor);

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
                //NÃO COLOQUEI DESCRIÇÃO PQ ACREDITO SER UM ITEM OPCIONAL
                if (editMarca.getText().length() == 0 || editModelo.getText().length() == 0
                        || editQuant.getText().length() == 0 || editFornecedor.getText().length() == 0
                        || editvalorDeCompra.getText().length() == 0 || editCodIdentificacao.getText().length() == 0
                        || editCnpj.getText().length() == 0) {
                    Toast.makeText(getApplication(), "ERRO! Os campos 'Fornecedor', 'CNPJ' 'Código de Identificacao'" +
                                    " 'Marca', 'Modelo', 'Quantidade'" +
                                    "'Valor de Compra' são obrigatórios!",
                            Toast.LENGTH_LONG).show();
                }
                if (rdTelas.isChecked() == false && rdPeliculas.isChecked() == false
                        && rdFones.isChecked() == false && rdCapinhas.isChecked() == false
                        && rdCarregador.isChecked() == false && rdDiversos.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "ERRO! Selecione uma categoria!",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplication(),
                            "Produto cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
