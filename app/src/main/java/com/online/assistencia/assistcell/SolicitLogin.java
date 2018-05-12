package com.online.assistencia.assistcell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SolicitLogin extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ListView listV_dados;

    private List <RequestCadFunc> listFuncionario = new ArrayList <RequestCadFunc>();
    private ArrayAdapter <RequestCadFunc> arrayAdapterFuncionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicit_login);

        listV_dados = (ListView) findViewById(R.id.listV_dados);

        inicializarFirebase();
        eventoDatabase();

    }

    private void eventoDatabase() {
        databaseReference.child("Requisicoes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listFuncionario.clear();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    RequestCadFunc requestCadFunc = objSnapshot.getValue(RequestCadFunc.class);
                    listFuncionario.add(requestCadFunc);
                }
                arrayAdapterFuncionario = new ArrayAdapter<RequestCadFunc>(SolicitLogin.this,
                        android.R.layout.simple_list_item_1, listFuncionario);
                listV_dados.setAdapter(arrayAdapterFuncionario);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(SolicitLogin.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference =  firebaseDatabase.getReference();
    }
}
