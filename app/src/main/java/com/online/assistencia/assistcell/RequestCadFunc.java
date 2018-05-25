package com.online.assistencia.assistcell;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class RequestCadFunc extends AppCompatActivity {

    EditText editName;
    EditText editCPF;
    EditText editEmailFunc;
    EditText editEndereco;
    EditText editContact;
    Button btCadastrar;
    Button btCancelar;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao_cadastro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostra o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Faz funcionar o botão
        getSupportActionBar().setTitle("Requisição de Cadastro");//Titulo para ser exibido na Action Bar

        editName = (EditText) findViewById(R.id.editName);
        editCPF = (EditText) findViewById(R.id.editCPF);
        editEmailFunc = (EditText) findViewById(R.id.editEmailFunc);
        editEndereco = (EditText) findViewById(R.id.editEndereco);
        editContact = (EditText) findViewById(R.id.editContact);
        btCadastrar = (Button) findViewById(R.id.bt_cadastrar);
        btCancelar = (Button) findViewById(R.id.bt_cancelar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editName.getText().length() == 0 ||editCPF.getText().length() == 0 ||editEmailFunc.getText().length() == 0 || (editEndereco.getText().length() == 0) || (editContact.getText().length() == 0)) {
                    Toast.makeText(getApplication(), "Os campos Nome, CPF, Email, Endereço e Telefone são obrigatórios, por favor preencher corretamente!",
                            Toast.LENGTH_LONG).show();
                } else {
                    NewFuncionario newFuncionario = new NewFuncionario();
                    newFuncionario.setId(UUID.randomUUID().toString());
                    newFuncionario.setNome(editName.getText().toString());
                    newFuncionario.setCpf(editCPF.getText().toString());
                    newFuncionario.setEndereco(editEndereco.getText().toString());
                    newFuncionario.setEmail(editEmailFunc.getText().toString());
                    newFuncionario.setTelefone(editContact.getText().toString());
                    databaseReference.child("Requisicoes").child(newFuncionario.getId()).setValue(newFuncionario);
                    AlertDialog show = new AlertDialog.Builder(RequestCadFunc.this)
                            .setTitle("Sucesso")
                            .setMessage("Requisição feita com Sucesso!")
                            .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    RequestCadFunc.this.finish();
                                }
                            })
                            .show();
                    limparcampos();
                }
            }
        });
        inicializarFirebase();
    }
    public void limparcampos(){
        editName.setText("");
        editCPF.setText("");
        editEmailFunc.setText("");
        editEndereco.setText("");
        editContact.setText("");
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(RequestCadFunc.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference();
    }
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão
                startActivity(new Intent(this, LoginActivity.class));
                finishAffinity();  //Matar activity
                break;
            default:break;
        }
        return true;
    }

}
