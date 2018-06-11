package com.online.assistencia.assistcell;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
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

public class Reservas extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ListView listV_reservas;

    private List<NewReserva> listReservas = new ArrayList<NewReserva>();
    private ArrayAdapter<NewReserva> arrayAdapterReservas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Reserva de Mercadoria");

        listV_reservas = (ListView) findViewById(R.id.listV_reserva);

        inicializarFirebase();
        eventoDatabase();

    }

    private void eventoDatabase(){
        databaseReference.child("Reservas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listReservas.clear();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    NewReserva newReserva = objSnapshot.getValue(NewReserva.class);
                    listReservas.add(newReserva);
                }
                arrayAdapterReservas = new ArrayAdapter<NewReserva>(Reservas.this,
                        android.R.layout.simple_list_item_1, listReservas);
                listV_reservas.setAdapter(arrayAdapterReservas);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(Reservas.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference();
    }

    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
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
