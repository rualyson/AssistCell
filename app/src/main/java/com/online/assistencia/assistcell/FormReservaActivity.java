package com.online.assistencia.assistcell;

import android.content.ContentValues;
import android.content.Context;
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
                    newReserva.setId(UUID.randomUUID().toString());
                    newReserva.setMarca(editMarca.getText().toString());
                    newReserva.setModelo(editModelo.getText().toString());
                    newReserva.setData(editData.getText().toString());
                    newReserva.setTelefone(editTelefone.getText().toString());
                    newReserva.setNome(editNome.getText().toString());
                    newReserva.setEmail(editEmail.getText().toString());
                    databaseReference.child("Reservas").child(newReserva.getId()).setValue(newReserva);


                    Toast.makeText(getApplication(),
                            "Reservado com Sucesso!", Toast.LENGTH_LONG).show();
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