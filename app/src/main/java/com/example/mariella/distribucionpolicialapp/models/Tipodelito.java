package com.example.mariella.distribucionpolicialapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Mariella on 10/08/2016.
 */
public class Tipodelito {
    @SerializedName("idTipoDelito")
    @Expose private int idTipoDelito;
    @SerializedName("nombre")
    @Expose private String nombre;


    public int getIdTipoDelito() {
        return idTipoDelito;
    }

    public void setIdTipoDelito(int idTipoDelito) {
        this.idTipoDelito = idTipoDelito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
