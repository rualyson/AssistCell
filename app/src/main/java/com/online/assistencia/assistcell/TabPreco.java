package com.online.assistencia.assistcell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
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

public class TabPreco extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ListView listV_Preco;

    private List<NewPrecoForn> listPreco = new ArrayList<NewPrecoForn>();
    private ArrayAdapter<NewPrecoForn> arrayAdapterPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_preco);
        listV_Preco = (ListView) findViewById(R.id.listV_preco);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Preços de Compra");

        inicializarFirebase();
        eventoDatabase();

    }
    private void eventoDatabase(){
        databaseReference.child("Preco-Produto-fornecedor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listPreco.clear();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    NewPrecoForn newPrecoForn = objSnapshot.getValue(NewPrecoForn.class);
                    listPreco.add(newPrecoForn);
                }
                arrayAdapterPreco = new ArrayAdapter<NewPrecoForn>(TabPreco.this,
                        android.R.layout.simple_list_item_1, listPreco);
                listV_Preco.setAdapter(arrayAdapterPreco);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(TabPreco.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference();
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
