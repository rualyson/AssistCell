package com.online.assistencia.assistcell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AddNewProduto extends AppCompatActivity {

    private EditText marca; // marca do produto
    private EditText modelo; // modelo do produto
    private EditText qtd; // quantidade do produto
    private EditText valor;
    private RadioButton tela;
    private RadioButton cases;
    private RadioButton fones;
    private RadioButton carregadores;
    private RadioButton diversos;
    private RadioButton peliculas;

    private Button btADD; // botão de confirmação

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_prod_novo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostra o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Faz funcionar o botão
        getSupportActionBar().setTitle("Cadastro de Produtos");//Titulo para ser exibido na Action Bar

        marca = (EditText) findViewById(R.id.editCadMarca);
        modelo = (EditText) findViewById(R.id.editCadModelo);
        qtd = (EditText) findViewById(R.id.editCadQuant);
        valor = (EditText) findViewById(R.id.editCadValor);
        tela = (RadioButton) findViewById(R.id.rbTelas);
        cases = (RadioButton) findViewById(R.id.rbCapinhas);
        fones = (RadioButton) findViewById(R.id.rbFones);
        carregadores = (RadioButton) findViewById(R.id.rbCarregadores);
        diversos = (RadioButton) findViewById(R.id.rbDiversos);
        peliculas = (RadioButton) findViewById(R.id.rbPeliculas);

        btADD = (Button) findViewById(R.id.botCadastrar);
        btADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (valor.getText().length() == 0 || modelo.getText().length() == 0 || marca.getText().length() == 0 ||
                            qtd.getText().length() == 0) {
                        Toast.makeText(getApplication(), "Todos os campos são obrigatórios!",
                                Toast.LENGTH_SHORT).show();
                    } else if (!tela.isChecked() && !cases.isChecked() && !fones.isChecked() && !carregadores.isChecked() &&
                            !diversos.isChecked() && !peliculas.isChecked()) {
                        Toast.makeText(getApplicationContext(), "Por favor, selecionar uma categoria!",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplication(), "Cadastrado com sucesso!",
                                Toast.LENGTH_SHORT).show();

                        limparCampos();
                    }
                } catch (Exception e){
                    Toast.makeText(getApplication(), "Todos os campos são obrigatórios!*",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão
                startActivity(new Intent(this, DashADM.class));
                finishAffinity();  //Matar activity
                break;
            default:break;
        }
        return true;
    }
    private void limparCampos() {
        valor.setText("");
        marca.setText("");
        modelo.setText("");
        qtd.setText("");
    }
}
