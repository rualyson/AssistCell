package com.online.assistencia.assistcell;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

public class TabProdEmFalta extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ListView listV_prodF;

    private List<NewProdutoF> listProdF = new ArrayList<NewProdutoF>();
    private ArrayAdapter<NewProdutoF> arrayAdapterProdutoF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_prod_em_falta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Produtos em Falta");

        listV_prodF = (ListView) findViewById(R.id.listV_ProdF);

        inicializarFirebase();
        eventoDatabase();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TabProdEmFalta.this, CadProdEmFalta.class);
                startActivity(intent);
            }
        });
    }

    private void eventoDatabase(){
        databaseReference.child("ProdutosF").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listProdF.clear();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    NewProdutoF newProdutoF = objSnapshot.getValue(NewProdutoF.class);
                    listProdF.add(newProdutoF);
                }
                arrayAdapterProdutoF = new ArrayAdapter<NewProdutoF>(TabProdEmFalta.this,
                        android.R.layout.simple_list_item_1, listProdF);
                listV_prodF.setAdapter(arrayAdapterProdutoF);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(TabProdEmFalta.this);
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
