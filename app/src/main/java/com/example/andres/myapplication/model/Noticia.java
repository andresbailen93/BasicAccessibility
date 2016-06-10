package com.example.andres.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by andres on 10/06/2016.
 */
public class Noticia implements Parcelable{
    private String titulo;
    private String cabecera;
    private String tematica;
    private String cuerpo;

    public Noticia(String tematica, String titulo, String cabecera, String cuerpo) {
        this.titulo = titulo;
        this.cabecera = cabecera;
        this.tematica = tematica;
        this.cuerpo = cuerpo;
    }

    protected Noticia(Parcel in) {
        titulo = in.readString();
        cabecera = in.readString();
        tematica = in.readString();
        cuerpo = in.readString();
    }

    public static final Creator<Noticia> CREATOR = new Creator<Noticia>() {
        @Override
        public Noticia createFromParcel(Parcel in) {
            return new Noticia(in);
        }

        @Override
        public Noticia[] newArray(int size) {
            return new Noticia[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCabecera() {
        return cabecera;
    }

    public void setCabecera(String cabecera) {
        this.cabecera = cabecera;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(cabecera);
        dest.writeString(tematica);
        dest.writeString(cuerpo);
    }
}
