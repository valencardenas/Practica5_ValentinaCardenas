package com.example.valentina.practica5_valentinacardenas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    private String[] opciones;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private int caso;
    private CharSequence tituloSec;
    private CharSequence tituloApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        opciones = new String[] {"Inicio","Hoteles","Bares","Sitios Turisticos","Información Demografica"};

        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        listView = (ListView) findViewById(R.id.menuIzq);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().
                getThemedContext(), android.R.layout.simple_list_item_1, opciones));

        final ActionBar ab = getSupportActionBar();
        if (ab !=null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
                switch(position){
                    case 0: fragment = new InicioFragment();
                        break;
                    case 1: fragment =  new HotelesFragment();
                        break;
                    case 2: fragment = new BaresFragment();
                        break;
                    case 3: fragment = new SitiosFragment();
                        break;
                    case 4: fragment = new InfoFragment();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
                listView.setItemChecked(position, true);
                tituloSec = opciones[position];
                ab.setTitle(tituloSec);
                drawerLayout.closeDrawer(listView);
            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.drawable.ic_menu_white_24dp,R.string.abierto,R.string.cerrado);

        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void mapa1(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("control",1);
        startActivity(i);
    }
    public void mapah1(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("control",2);
        startActivity(i);
    }
    public void mapah2(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("control",3);
        startActivity(i);
    }

    public void mapah3(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("control",4);
        startActivity(i);
    }
    public void mapab1(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("control",5);
        startActivity(i);
    }
    public void mapab2(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("control",6);
        startActivity(i);
    }
    public void mapab3(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("control",7);
        startActivity(i);
    }
    public void mapas1(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("control",8);
        startActivity(i);
    }
    public void mapas3(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("control",9);
        startActivity(i);
    }

    public void mapas4(View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("control",10);
        startActivity(i);
    }
}
