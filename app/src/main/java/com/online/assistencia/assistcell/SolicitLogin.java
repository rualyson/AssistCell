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

    private List <NewFuncionario> listFuncionario = new ArrayList <NewFuncionario>();
    private ArrayAdapter <NewFuncionario> arrayAdapterFuncionario;

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
                    NewFuncionario newFuncionario = objSnapshot.getValue(NewFuncionario.class);
                    listFuncionario.add(newFuncionario);
                }
                arrayAdapterFuncionario = new ArrayAdapter<NewFuncionario>(SolicitLogin.this,
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
