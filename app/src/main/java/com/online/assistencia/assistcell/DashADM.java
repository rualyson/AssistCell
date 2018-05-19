package com.online.assistencia.assistcell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class DashADM extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;
    private CardView adm_User;
    private CardView services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_dash_adm);

        adm_User = (CardView) findViewById(R.id.admUser);
        adm_User.setOnClickListener(this);
        services = (CardView) findViewById(R.id.ordemService);
        services.setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.btn_logout) {
            mAuth.signOut();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.admUser:
                i = new Intent(this, EscCadastro.class);
                startActivity(i);
                break;
        }
        switch (v.getId()) {
            case R.id.ordemService:
                i = new Intent(this, TabServicos.class);
                startActivity(i);
                break;
        }
    }
}
