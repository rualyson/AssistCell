package com.online.assistencia.assistcell;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class TabServicos extends AppCompatActivity  implements View.OnClickListener{

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ListView listV_OS;

    private List<NewOS> listServico = new ArrayList<NewOS>();
    private ArrayAdapter<NewOS> arrayAdapterOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_services);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Ordem de serviços (OS)");

        listV_OS = (ListView) findViewById(R.id.listV_newOS);

        inicializarFirebase();
        eventoDatabase();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TabServicos.this, CadServices.class);
                startActivity(intent);
            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(TabServicos.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference();
    }

    private void eventoDatabase(){
        databaseReference.child("OS").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listServico.clear();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    NewOS newOS = objSnapshot.getValue(NewOS.class);
                    listServico.add(newOS);
                }
                arrayAdapterOS = new ArrayAdapter<NewOS>(TabServicos.this,
                        android.R.layout.simple_list_item_1, listServico);
                listV_OS.setAdapter(arrayAdapterOS);
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
                startActivity(new Intent(this, DashADM.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }
}
