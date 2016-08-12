package com.example.mariella.distribucionpolicialapp.services;

import com.example.mariella.distribucionpolicialapp.models.Tipodelito;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mariella on 11/08/2016.
 */
public interface ServiceEndPoints {
    @GET("localhost:8080/distribucionPolicialApp/tipodelitos/all")
    Call<ArrayList<Tipodelito>> callTipodelito();
}
