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

    private EditText editMarca, editModelo,editDescricao, editValorCompra, editCnpj, editCodIdentificacao,
            editFornecedor;

    private Button botCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_prod_preco_fornecedor);
        editMarca = (EditText) findViewById(R.id.editMarca);
        editModelo = (EditText) findViewById(R.id.editModelo);
        editDescricao = (EditText) findViewById(R.id.editDescricao);
        editValorCompra = (EditText) findViewById(R.id.editValorCompra);
        editCnpj = (EditText) findViewById(R.id.editCnpj);
        editCodIdentificacao = (EditText) findViewById(R.id.editCodIdent);
        editFornecedor =(EditText) findViewById(R.id.editCadFornecedor);

        rdTelas = (RadioButton) findViewById(R.id.rbTelas);
        rdPeliculas = (RadioButton) findViewById(R.id.rbPeliculas);
        rdFones = (RadioButton) findViewById(R.id.rbFones);
        rdCapinhas = (RadioButton) findViewById(R.id.rbFones);
        rdCarregador = (RadioButton) findViewById(R.id.rbCarregadores);
        rdDiversos = (RadioButton) findViewById(R.id.rbDiversos);

        botCadastrar = (Button) findViewById(R.id.botCadastrar);


        botCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //NÃO COLOQUEI DESCRIÇÃO PQ ACREDITO SER UM ITEM OPCIONAL
                if (editMarca.getText().length() == 0 || editModelo.getText().length() == 0 ||
                       editCnpj.getText().length() == 0 || editFornecedor.getText().length() == 0 ||
                        editValorCompra.getText().length() == 0 || editCodIdentificacao.getText().length() == 0) {
                    Toast.makeText(getApplication(), "ERRO! Os campos 'Fornecedor', CNPJ, 'Marca', 'Código de Identificação', " +
                                    "'Modelo' e 'Valor da Compra' são obrigatórios!",
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
                            "Preço cadastrado com Sucesso!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
