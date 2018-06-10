package com.online.assistencia.assistcell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
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

public class Notificacao extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ListView listV_Notific;

    private List<NewNotificacao> listNotific = new ArrayList<NewNotificacao>();
    private ArrayAdapter<NewNotificacao> arrayAdapterNotificacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Notificações");

        listV_Notific = (ListView) findViewById(R.id.listV_newNotific);

        inicializarFirebase();
        eventoDatabase();

    }


    private void eventoDatabase(){

        databaseReference.child("Notificacoes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listNotific.clear();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    NewNotificacao newNotificacao = objSnapshot.getValue(NewNotificacao.class);
                    listNotific.add(newNotificacao);
                }
                arrayAdapterNotificacao = new ArrayAdapter<NewNotificacao>(Notificacao.this,
                        android.R.layout.simple_list_item_1, listNotific);
                listV_Notific.setAdapter(arrayAdapterNotificacao);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(Notificacao.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
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
