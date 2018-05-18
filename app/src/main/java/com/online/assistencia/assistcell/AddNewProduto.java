package com.online.assistencia.assistcell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.UUID;

public class AddNewProduto extends AppCompatActivity {

    private EditText desc; // descrição do produto
    private EditText marca; // marca do produto
    private EditText modelo; // modelo do produto
    private EditText qtd; // quantidade do produto

    private Button btADD; // botão de confirmação

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

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


                    if (desc.getText().length() == 0 || marca.getText().length() == 0 || qtd.getText().length() == 0){
                        Toast.makeText(getApplication(), "Os campos 'descrição', 'marca', 'quantidade' são obrigatórios!",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        NewProduto newProduto = new NewProduto ();
                        newProduto.setId(UUID.randomUUID().toString());
                        newProduto.setDescricao(desc.getText().toString());
                        newProduto.setMarca(marca.getText().toString());
                        newProduto.setModelo(modelo.getText().toString());
                        newProduto.setQuantidade(Integer.parseInt(qtd.getText().toString()));
                        databaseReference.child("Produtos-Cadastrados").child(newProduto.getId()).setValue(newProduto);

                        Toast.makeText(getApplication(),
                                "Produto cadastrado!", Toast.LENGTH_LONG).show();

                        limparCampos();
                    }
                } catch (Exception e){
                    Toast.makeText(getApplication(),"Os campos 'descrição', 'marca', 'quantidade' são obrigatórios!", Toast.LENGTH_LONG).show();
                }
            }
        }); inicializarFirebase();
    }

    private void limparCampos() {
        desc.setText("");
        marca.setText("");
        modelo.setText("");
        qtd.setText("");
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(AddNewProduto.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference();
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