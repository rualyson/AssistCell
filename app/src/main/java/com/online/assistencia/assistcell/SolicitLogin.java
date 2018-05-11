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

    ListView listV_dados;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    List<RequestCadFunc> listFuncionario = new ArrayList<RequestCadFunc>();
    ArrayAdapter<RequestCadFunc> arrayAdapterFuncionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicit_login);

        listV_dados = (ListView) findViewById(R.id.listV_dados);

        inicializarFirebase();
        eventoDatabase();
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(SolicitLogin.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference =  firebaseDatabase.getReference();
    }

    private void eventoDatabase() {
        databaseReference.child("RequestCadFunc").addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listFuncionario.clear();
                for(DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    RequestCadFunc r = objSnapshot.getValue(RequestCadFunc.class);
                    listFuncionario.add(r);
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
}
