package com.online.assistencia.assistcell;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class CadProdPrecoFornecedor extends AppCompatActivity {

    private RadioButton rdTelas, rdPeliculas, rdFones, rdCapinhas, rdCarregador, rdDiversos;

    private EditText Marca, Modelo,Descricao, ValorCompra, Cnpj, CodIdentificacao, Fornecedor;

    private Button botCadastrar;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_prod_preco_fornecedor);
        Marca = (EditText) findViewById(R.id.editMarca);
        Modelo = (EditText) findViewById(R.id.editModelo);
        Descricao = (EditText) findViewById(R.id.editCadDescricao);
        ValorCompra = (EditText) findViewById(R.id.editValorCompra);
        Cnpj = (EditText) findViewById(R.id.editCnpj);
        CodIdentificacao = (EditText) findViewById(R.id.editCodIdent);
        Fornecedor = (EditText) findViewById(R.id.editCadFornecedor);

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
                if (Marca.getText().length() == 0 || Modelo.getText().length() == 0 ||
                        Cnpj.getText().length() == 0 || Fornecedor.getText().length() == 0 ||
                        ValorCompra.getText().length() == 0 || CodIdentificacao.getText().length() == 0) {
                    Toast.makeText(getApplication(), "ERRO! Os campos 'Fornecedor', CNPJ, 'Marca', 'Código de Identificação', " +
                                    "'Modelo' e 'Valor da Compra' são obrigatórios!",
                            Toast.LENGTH_LONG).show();
                }
                if (rdTelas.isChecked() == false && rdPeliculas.isChecked() == false
                        && rdFones.isChecked() == false && rdCapinhas.isChecked() == false
                        && rdCarregador.isChecked() == false && rdDiversos.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "ERRO! Selecione uma categoria!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    NewPrecoForn newPrecoForn = new NewPrecoForn();
                    newPrecoForn.setId(UUID.randomUUID().toString());
                    newPrecoForn.setMarca(Marca.getText().toString());
                    newPrecoForn.setModelo(Modelo.getText().toString());
                    newPrecoForn.setDescricao(Descricao.getText().toString());
                    newPrecoForn.setValorCompra(ValorCompra.getText().toString());
                    newPrecoForn.setCnpj(Cnpj.getText().toString());
                    newPrecoForn.setCodIdentificacao(CodIdentificacao.getText().toString());
                    newPrecoForn.setFornecedor(Fornecedor.getText().toString());
                    if (rdTelas.isChecked()) {
                        newPrecoForn.setRb_telas(rdTelas.toString());
                    } else if (rdCapinhas.isChecked()) {
                        newPrecoForn.setRb_cases(rdCapinhas.toString());
                    } else if (rdCarregador.isChecked()) {
                        newPrecoForn.setRb_carregador(rdCarregador.toString());
                    } else if (rdPeliculas.isChecked()) {
                        newPrecoForn.setRb_peliculas(rdPeliculas.toString());
                    } else if (rdDiversos.isChecked()) {
                        newPrecoForn.setRb_diversos(rdDiversos.toString());
                    } else {
                        newPrecoForn.setRb_fone(rdFones.toString());
                    }
                    databaseReference.child("Preco-Produto-fornecedor").child(newPrecoForn.getId()).setValue(newPrecoForn); // cadastra no Firebase
                    AlertDialog show = new AlertDialog.Builder(CadProdPrecoFornecedor.this)
                            .setTitle("Sucesso")
                            .setMessage("Cadastrado com sucesso!")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    CadProdPrecoFornecedor.this.finish();
                                }
                            })
                            .show();
                    limparCampos();
                }
            }
        });
        inicializarFirebase();
    }
    private void limparCampos() {
        Marca.setText("");
        Modelo.setText("");
        Descricao.setText("");
        ValorCompra.setText("");
        Cnpj.setText("");
        CodIdentificacao.setText("");
        Fornecedor.setText("");
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(CadProdPrecoFornecedor.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference();
    }
}

