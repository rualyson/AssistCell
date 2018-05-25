package com.online.assistencia.assistcell;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroFuncionarios extends AppCompatActivity implements View.OnClickListener{
    private EditText emailFunc;
    private EditText nomeFunc;
    private EditText cpfFunc;
    private EditText enderecoFunc;
    private EditText telefoneFunc;
    private EditText senhaFunc;
    private Button cadastrar;

    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_funcionarios);

        firebaseAuth = FirebaseAuth.getInstance();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostra o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Faz funcionar o botão
        getSupportActionBar().setTitle("Cadastro de funcionários");//Titulo para ser exibido na Action Bar

        progressBar = new ProgressBar(this);

        nomeFunc = (EditText) findViewById(R.id.editText);
        cpfFunc = (EditText) findViewById(R.id.editText2);
        enderecoFunc = (EditText) findViewById(R.id.editText4);
        telefoneFunc = (EditText) findViewById(R.id.editText3);

        emailFunc = (EditText) findViewById(R.id.editText7);
        senhaFunc = (EditText) findViewById(R.id.editText5);
        cadastrar = (Button) findViewById(R.id.buttonCadastrar);

        cadastrar.setOnClickListener(this);
    }

    private void registrerUser(){
        String email = emailFunc.getText().toString().trim();
        String senha = senhaFunc.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Insira um E-mail válido!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(senha)){
            Toast.makeText(this,"Insira uma senha!",Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        firebaseAuth.createUserWithEmailAndPassword(email,senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            AlertDialog show = new AlertDialog.Builder(CadastroFuncionarios.this)
                                    .setTitle("Sucesso")
                                    .setMessage("Registrado com sucesso!")
                                    .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            CadastroFuncionarios.this.finish();
                                        }
                                    })
                                    .show();
                            }else{
                            Toast.makeText(CadastroFuncionarios.this, "Falha ao registrar",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão
                startActivity(new Intent(this, EscCadastro.class));
                finishAffinity();  //Matar activity
                break;
            default:break;
        }
        return true;
    }
    @Override
    public void onClick(View view) {
        if(view == cadastrar){
            if (nomeFunc.getText().length() == 0 || cpfFunc.getText().length() == 0 || enderecoFunc.getText().length() == 0 || (telefoneFunc.getText().length() == 0)) {
                Toast.makeText(getApplication(), "Os campos Nome, CPF, Endereço e Telefone são obrigatórios, por favor preencher corretamente!",
                        Toast.LENGTH_LONG).show();
            }
        }
        registrerUser();
    }
}