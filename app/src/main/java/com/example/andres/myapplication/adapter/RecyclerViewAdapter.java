package com.example.andres.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andres.myapplication.R;
import com.example.andres.myapplication.model.Noticia;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by andres on 10/06/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Noticia> noticiaArrayList;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tematica;
        public TextView titulo;
        public TextView cabecera;
        public TextView cuerpo;
        public ViewHolder(View v){
            super(v);
            tematica = (TextView) v.findViewById(R.id.tematica);
            titulo = (TextView) v.findViewById(R.id.titulo);
            cabecera = (TextView) v.findViewById(R.id.cabecera);
            cuerpo = (TextView) v.findViewById(R.id.cuerpo);
        }
    }

    public RecyclerViewAdapter(Context context, ArrayList<Noticia> noticiaArrayList){
        this.context = context;
        this.noticiaArrayList = noticiaArrayList;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tematica.setText(noticiaArrayList.get(position).getTematica());
        holder.titulo.setText(noticiaArrayList.get(position).getTitulo());
        holder.cabecera.setText(noticiaArrayList.get(position).getCabecera());
        holder.cuerpo.setText(noticiaArrayList.get(position).getCuerpo());
    }

    @Override
    public int getItemCount() {
        return noticiaArrayList.size();
    }
}
