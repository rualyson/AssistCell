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

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class FormularioOrcamento extends AppCompatActivity implements View.OnClickListener {

    private EditText nomeCli, Marca, Modelo, EstadoF, Relato, Contato, Email;
    private RadioButton rbn_receberViaSms;
    private RadioButton rbn_receberViaEmail;
    private RadioButton rbn_buscarNaAssist;
    private Button enviar;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orcamento);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Formulario de Orcamento");

        nomeCli = (EditText) findViewById(R.id.editNome);
        Marca = (EditText) findViewById(R.id.editMarca);
        Modelo = (EditText) findViewById(R.id.editModelo);
        EstadoF = (EditText) findViewById(R.id.editEstadoFisico);
        Relato = (EditText) findViewById(R.id.editProblema);
        Contato = (EditText) findViewById(R.id.editPhone);
        Email = (EditText) findViewById(R.id.editEmailCli);
        rbn_receberViaSms = (RadioButton) findViewById(R.id.rbn_sms);
        rbn_receberViaEmail = (RadioButton) findViewById(R.id.rbn_email);
        rbn_buscarNaAssist = (RadioButton) findViewById(R.id.rbn_buscarAssist);

        enviar = (Button) findViewById(R.id.btnEnviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nomeCli.getText().length() == 0 || (Marca.getText().length() == 0) || (Modelo.getText().length() == 0)
                        || EstadoF.getText().length() == 0 || Relato.getText().length() == 0 || Contato.getText().length() == 0 || Email.getText().length() == 0 ){
                    Toast.makeText(getApplication(), "Todos os campos devem ser preenchidos!",
                            Toast.LENGTH_LONG).show();
                }if (rbn_receberViaSms.isChecked() == false && rbn_receberViaEmail.isChecked() == false && rbn_buscarNaAssist.isChecked() == false){
                    Toast.makeText(getApplicationContext(), "Escolha como deseja receber o feedback do Orçamento",
                            Toast.LENGTH_SHORT).show();
                } else {
                    NewOrcamento newOrcamento = new NewOrcamento();
                    newOrcamento.setId(UUID.randomUUID().toString());
                    newOrcamento.setNomeCli(nomeCli.getText().toString());
                    newOrcamento.setMarca(Marca.getText().toString());
                    newOrcamento.setModelo(Modelo.getText().toString());
                    newOrcamento.setEstadoF(EstadoF.getText().toString());
                    newOrcamento.setRelato(Relato.getText().toString());
                    newOrcamento.setContato(Contato.getText().toString());
                    newOrcamento.setEmail(Email.getText().toString());
                    if (rbn_receberViaSms.isChecked()){
                        newOrcamento.setRb_sms(rbn_receberViaSms.toString());
                    } else if (rbn_receberViaEmail.isChecked()){
                        newOrcamento.setRb_email(rbn_receberViaEmail.toString());
                    } else {
                        newOrcamento.setRb_buscarAssist(rbn_buscarNaAssist.toString());
                    }
                    databaseReference.child("Orcamentos").child(newOrcamento.getId()).setValue(newOrcamento);
                    Toast.makeText(getApplication(), "Seus dados foram enviados!",
                            Toast.LENGTH_LONG).show();
                    limparCampos();
                }
            }
        });
        inicializarFirebase();
    }

    private void limparCampos() {
        nomeCli.setText("");
        Marca.setText("");
        Modelo.setText("");
        EstadoF.setText("");
        Relato.setText("");
        Contato.setText("");
        Email.setText("");
    }
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(FormularioOrcamento.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do botão de voltar
                startActivity(new Intent(this, Inicio.class));
                finishAffinity();  //Matar activity
                break;
            default:break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {


    }
}