package com.online.assistencia.assistcell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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

public class TabFornecedores extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ListView listV_Fornecedores;

    private List<NewFornecedor> listFornecedor = new ArrayList<NewFornecedor>();
    private ArrayAdapter<NewFornecedor> arrayAdapterFornecedor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_fornecedores);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Fornecedores");

        listV_Fornecedores = (ListView) findViewById(R.id.ListV_Fornecedores);

        inicializarFirebase();
        eventoDatabase();
    }

    private void eventoDatabase(){
        databaseReference.child("Fornecedores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listFornecedor.clear();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    NewFornecedor newFornecedor = objSnapshot.getValue(NewFornecedor.class);
                    listFornecedor.add(newFornecedor);
                }
                arrayAdapterFornecedor = new ArrayAdapter<NewFornecedor>(TabFornecedores.this,
                        android.R.layout.simple_list_item_1, listFornecedor);
                listV_Fornecedores.setAdapter(arrayAdapterFornecedor);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(TabFornecedores.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference();
    }

    public void onClick(View v) {
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, EscFornecedor.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }
}
