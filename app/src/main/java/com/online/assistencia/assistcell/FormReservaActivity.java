package com.online.assistencia.assistcell;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class FormReservaActivity extends AppCompatActivity {
    //Criação dos Objetos
    EditText editNome;
    EditText editMarca;
    EditText editModelo;
    EditText editTelefone;
    EditText editEmail;
    EditText editData;
    Button btnReservar;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        //Vinculando os objetos aos ids
        editMarca = (EditText) findViewById(R.id.editMarca);
        editModelo = (EditText) findViewById(R.id.editModelo);
        editNome = (EditText) findViewById(R.id.editNome);
        editTelefone = (EditText) findViewById(R.id.editTelefone);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editData = (EditText) findViewById(R.id.editData);
        btnReservar = (Button) findViewById(R.id.btnReservar);

        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editMarca.getText().length() == 0 ||editModelo.getText().length() == 0 ||editNome.getText().length() == 0 || (editTelefone.getText().length() == 0) || (editEmail.getText().length() == 0) || (editData.getText().length() == 0)) {
                    Toast.makeText(getApplication(), "Os campos Marca do produto, Modelo, Seu Nome, Telefone, Email e Data da reserva são obrigatórios!",
                            Toast.LENGTH_LONG).show();
                } else {
                    NewReserva newReserva = new NewReserva();
                    NewNotificacao newNotificacao = new NewNotificacao();
                    newReserva.setTitulo("Reserva de Mercadoria");
                    newNotificacao.setTitulo("Reserva de Mercadoria");
                    newReserva.setId(UUID.randomUUID().toString());
                    newNotificacao.setId_reserva(UUID.randomUUID().toString());
                    newReserva.setMarca(editMarca.getText().toString());
                    newNotificacao.setMarca_reservada(editMarca.getText().toString());
                    newReserva.setModelo(editModelo.getText().toString());
                    newNotificacao.setModelo_reservado(editModelo.getText().toString());
                    newReserva.setData(editData.getText().toString());
                    newNotificacao.setData_reserva(editData.getText().toString());
                    newReserva.setTelefone(editTelefone.getText().toString());
                    newReserva.setNome(editNome.getText().toString());
                    newNotificacao.setNome_cliente(editNome.getText().toString());
                    newReserva.setEmail(editEmail.getText().toString());
                    databaseReference.child("Reservas").child(newReserva.getId()).setValue(newReserva);
                    databaseReference.child("Notificacoes").child(newNotificacao.getId_reserva()).setValue(newNotificacao);

                    AlertDialog show = new AlertDialog.Builder(FormReservaActivity.this)
                            .setTitle("Reservado com sucesso!\nSeu código de Reserva é:")
                            .setMessage(newReserva.getId())
                            .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    FormReservaActivity.this.finish();
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
        editModelo.setText("");
        editMarca.setText("");
        editData.setText("");
        editTelefone.setText("");
        editNome.setText("");
        editEmail.setText("");
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(FormReservaActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference();
    }

}