package com.online.assistencia.assistcell;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class TabPrecosFornecedor extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<String> precosPorFornecedor = new ArrayList<>();
    ListView listV_precosFornecedor;
    private Firebase objetoRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_precos_fornecedor);

        listV_precosFornecedor = (ListView) findViewById ( R.id.listV_PrecosFornecedor );

        Firebase novaRef = objetoRef.child("Preco-Produto-fornecedor");
        final ArrayAdapter<String> adaptador;
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) listV_precosFornecedor);
        listV_precosFornecedor.setAdapter(adaptador);

        novaRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(com.firebase.client.DataSnapshot dataSnapshot, String s) {
                String message = dataSnapshot.getValue(String.class);
                precosPorFornecedor.add(message);
                adaptador.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(com.firebase.client.DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(com.firebase.client.DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(com.firebase.client.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}





