package com.ricardoguzman.puppy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        mascotas = new ArrayList<Mascota>();

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        rvMascotas.setLayoutManager(llm);
        initListaContactos();
        initAdapatador();
    }

    public void initListaContactos(){
        mascotas.add(new Mascota("Lucky", ((int) (Math.random() *10 ) + 1) ,false,R.drawable.perro1));
        mascotas.add(new Mascota("Rocky", ((int) (Math.random() *10 ) + 1) ,false,R.drawable.perro2));
        mascotas.add(new Mascota("Chop", ((int) (Math.random() *10 ) + 1) ,false,R.drawable.perro3));
        mascotas.add(new Mascota("Rex", ((int) (Math.random() *10 ) + 1) ,false,R.drawable.perro4));
        mascotas.add(new Mascota("Lobo", ((int) (Math.random() *10 ) + 1) ,false,R.drawable.perro6));
        mascotas.add(new Mascota("Puppy", ((int) (Math.random() *10 ) + 1) ,false,R.drawable.perro5));
    }

    public void initAdapatador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        rvMascotas.setAdapter(adaptador);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.btnMasLikes) {
            startActivity(new Intent(getApplicationContext(), SegundoActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
