package com.online.assistencia.assistcell;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class CadProdEmFalta extends AppCompatActivity {

    private RadioButton rdTelas,rdPeliculas,rdFones,rdCapinhas,rdCarregador,rdDiversos;
    private EditText editMarca,editModelo,editQuant,editDescricao;
    private Button botCadastrar;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_prod_em_falta);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Cadastro de Prod. em Falta");

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
                        || editQuant.getText().length() == 0 || editDescricao.getText().length() == 0){
                    Toast.makeText(getApplication(), "Preencha corretamente todos os campos.",
                            Toast.LENGTH_LONG).show();
                }else{
                    if (rdTelas.isChecked() == false && rdPeliculas.isChecked() == false
                            && rdFones.isChecked() == false && rdCapinhas.isChecked() == false
                            && rdCarregador.isChecked() == false && rdDiversos.isChecked() == false) {
                        Toast.makeText(getApplicationContext(), "Selecione uma categoria!",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        NewProdutoF newProdutoF = new NewProdutoF();
                        newProdutoF.setId(UUID.randomUUID().toString());
                        newProdutoF.setMarcaProdF(editMarca.getText().toString());
                        newProdutoF.setModeloProdF(editModelo.getText().toString());
                        newProdutoF.setQuantProdF(editQuant.getText().toString());
                        newProdutoF.setDesProdF(editDescricao.getText().toString());
                        if (rdTelas.isChecked()) {
                            newProdutoF.setRb_telas(rdTelas.toString());
                        } else if (rdPeliculas.isChecked()) {
                            newProdutoF.setRb_peliculas(rdPeliculas.toString());
                        } else if (rdFones.isChecked()) {
                            newProdutoF.setRb_carregador(rdFones.toString());
                        } else if (rdCapinhas.isChecked()) {
                            newProdutoF.setRb_cases(rdCapinhas.toString());
                        } else if (rdCarregador.isChecked()) {
                            newProdutoF.setRb_carregador(rdCarregador.toString());
                        }else if (rdDiversos.isChecked()) {
                            newProdutoF.setRb_diversos(rdDiversos.toString());
                        }
                        databaseReference.child("ProdutosF").child(newProdutoF.getId()).setValue(newProdutoF);
                        AlertDialog show = new AlertDialog.Builder(CadProdEmFalta.this)
                                .setTitle("Sucesso")
                                .setMessage("Produto cadastrado com Sucesso!")
                                .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        CadProdEmFalta.this.finish();
                                    }
                                })
                                .show();
                        limparCampos();

                    }
                }
            }
        });
        inicializarFirebase();
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(CadProdEmFalta .this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, TabProdEmFalta.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }


    private void limparCampos() {
        editMarca.setText("");
        editModelo.setText("");
        editQuant.setText("");
        editDescricao.setText("");
    }
}
