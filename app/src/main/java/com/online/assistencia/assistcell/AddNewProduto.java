package com.online.assistencia.assistcell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewProduto extends AppCompatActivity {

    private EditText desc; // descrição do produto
    private EditText marca; // marca do produto
    private EditText modelo; // modelo do produto
    private EditText qtd; // quantidade do produto

    private Button btADD; // botão de confirmação

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto_novo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostra o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Faz funcionar o botão
        getSupportActionBar().setTitle("Cadastro de Produtos");//Titulo para ser exibido na Action Bar

        desc = (EditText) findViewById(R.id.editDescricao);
        marca = (EditText) findViewById(R.id.editMarca);
        modelo = (EditText) findViewById(R.id.editCadastraModelo);
        qtd = (EditText) findViewById(R.id.editCadastraQuantidade);
        btADD = (Button) findViewById(R.id.btnSalvar);

        btADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{


                    if (desc.getText().length() == 0 && marca.getText().length() == 0 && qtd.getText().length() == 0){
                        Toast.makeText(getApplication(), "Os campos 'descrição', 'marca', 'quantidade' são obrigatórios!",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e){
                    Toast.makeText(getApplication(),"Os campos 'descrição', 'marca', 'quantidade' são obrigatórios!", Toast.LENGTH_LONG).show();
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
}
