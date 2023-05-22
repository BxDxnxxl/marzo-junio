package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerViewPersonaje;
private RecyclerViewAdaptador adaptadorPersonaje;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewPersonaje = (RecyclerView) findViewById(R.id.recyclerInazuma);
        recyclerViewPersonaje.setLayoutManager(new LinearLayoutManager(this));
        adaptadorPersonaje = new RecyclerViewAdaptador(obtenerPersonaje());
        recyclerViewPersonaje.setAdapter(adaptadorPersonaje);
    }
    public List<PersonajeModelo> obtenerPersonaje() {
        List<PersonajeModelo> personaje = new ArrayList<>();
        personaje.add(new PersonajeModelo("AxelB Blaze", "delantero", R.drawable.axel));

        return personaje;
    }
}