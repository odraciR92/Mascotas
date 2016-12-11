package com.ricardoguzman.puppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class SegundoActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundo_activity);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mascotas = new ArrayList<Mascota>();

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas2);

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
    }

    public void initAdapatador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        rvMascotas.setAdapter(adaptador);
    }
}
