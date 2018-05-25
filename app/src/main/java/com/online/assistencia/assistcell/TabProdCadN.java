package com.online.assistencia.assistcell;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
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

public class TabProdCadN extends AppCompatActivity{

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ListView listV_prodCadF;

    private List<NewProduto> listProdCadN = new ArrayList<NewProduto>();
    private ArrayAdapter<NewProduto> arrayAdapterProdutoCadN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_cad_prod_novo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Lista de Produtos Cadastrados");

        listV_prodCadF = (ListView) findViewById(R.id.listV_CadProdNovo);

        inicializarFirebase();
        eventoDatabase();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TabProdCadN.this, AddNewProduto.class);
                startActivity(intent);
            }
        });
    }

    private void eventoDatabase(){
        databaseReference.child("Produtos-Cadastrados").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listProdCadN.clear();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    NewProduto newProduto = objSnapshot.getValue(NewProduto.class);
                    listProdCadN.add(newProduto);
                }
                arrayAdapterProdutoCadN = new ArrayAdapter<NewProduto>(TabProdCadN.this,
                        android.R.layout.simple_list_item_1, listProdCadN);
                listV_prodCadF.setAdapter(arrayAdapterProdutoCadN);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(TabProdCadN.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference();
    }

    public void onClick(View v) {
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, DashADM.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

}
