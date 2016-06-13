package com.example.andres.myapplication.activity;

import android.app.IntentService;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.andres.myapplication.fragment.ListFragment;
import com.example.andres.myapplication.fragment.LoadFragment;
import com.example.andres.myapplication.model.Noticia;
import com.example.andres.myapplication.R;
import com.example.andres.myapplication.service.AccessibilityService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Noticia noticia1 = new Noticia("Deporte","Messi es un paquete","Messi se ha dopado segun fuentes cercanas", "Dicen los hijos de maradona que messi se ha dopado, aclarar que tenían la nariz con un poco de polvo blanco.");
        Noticia noticia2 = new Noticia("Deporte","Cristiano balon de oro", "cabecera", "cuerpo Irina");
        Noticia noticia3 = new Noticia("Política","Coletas se va a Venezuela y decide no volver","Cabecera es iglesias","Ojala se fuera de verdad aclaran unos españoles :)");

        LoadFragment loadFragment = new LoadFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_main, loadFragment).commit();
        Toast.makeText(getApplicationContext(), "¡Cargando!", Toast.LENGTH_LONG).show();


        ArrayList<Noticia> noticiaArrayList = new ArrayList<>();
        noticiaArrayList.add(noticia1);
        noticiaArrayList.add(noticia2);
        noticiaArrayList.add(noticia3);


        ListFragment listFragment = new ListFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("noticiasArrayList", noticiaArrayList);
        listFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, listFragment).commit();



    }


}
