package com.online.assistencia.assistcell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

public class TabOrcamento extends AppCompatActivity implements View.OnClickListener{
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ListView listV_orcamento;

    private List<NewOrcamento> listOrcamento = new ArrayList<NewOrcamento>();
    private ArrayAdapter<NewOrcamento> arrayAdapterOrcamento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_orcamento);

        listV_orcamento = (ListView) findViewById(R.id.listV_Orcamento);
        listV_orcamento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                startActivity(emailIntent);
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Orçamento de clientes");

        inicializarFirebase();
        eventoDatabase();
    }
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(TabOrcamento.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference();
    }

    private void eventoDatabase(){
        databaseReference.child("Orcamentos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listOrcamento.clear();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    NewOrcamento newOrcamento = objSnapshot.getValue(NewOrcamento.class);
                    listOrcamento.add(newOrcamento);
                }
                arrayAdapterOrcamento = new ArrayAdapter<NewOrcamento>(TabOrcamento.this,
                        android.R.layout.simple_list_item_1, listOrcamento);
                listV_orcamento.setAdapter(arrayAdapterOrcamento);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, EscOS.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }
}
