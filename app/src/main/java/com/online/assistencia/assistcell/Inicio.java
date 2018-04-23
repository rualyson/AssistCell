package com.online.assistencia.assistcell;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Inicio extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    ImageView tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //viewPager

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout1);
        tabLayout.setupWithViewPager(viewPager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tela = (ImageView) findViewById(R.id.icon_tela);

        tela.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_orcamento) {
            // Handle the camera action
        } else if (id == R.id.nav_inicio) {
            Intent intent = new Intent(this, DashADM.class);
            startActivity(intent);
        }else if (id == R.id.nav_login) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.icon_tela) {
            Intent intent = new Intent (this, SubGruposTela.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class MyAdapter extends FragmentPagerAdapter {
        private final ArrayList<Fragment> fragments;
        private final ArrayList<String> titles;

        public MyAdapter(FragmentManager fm){
            super(fm);

            fragments = new ArrayList<Fragment>(2);
            fragments.add(new TabCatalogo());
            fragments.add(new TabInformacoes());

            titles = new ArrayList<String>(fragments.size());
            titles.add(getString(R.string.informacoes));
            titles.add(getString(R.string.catalogo));

        }

        @Override
        public Fragment getItem(int position) {

            return fragments.get(position);
        }

        @Override
        public int getCount() {

            return fragments.size();
        }
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "CATÁLOGO";
                case 1:
                    return "INFORMAÇÕES";
            }
            return null;
        }

    }
    public void onClick(View v){
        Intent i;
        switch (v.getId()){
            case R.id.icon_tela: i = new Intent(this, Inicio.class);startActivity(i);break;
            case R.id.icon_pelicula: i = new Intent(this, Inicio.class);startActivity(i);break;
            case R.id.icon_fones: i = new Intent(this, Inicio.class);startActivity(i);break;
            case R.id.icon_capas: i = new Intent(this, Inicio.class);startActivity(i);break;
    }

}
}
