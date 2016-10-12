package com.example.mariella.distribucionpolicialapp.services;

import com.example.mariella.distribucionpolicialapp.models.Tipodelito;
import com.example.mariella.distribucionpolicialapp.models.Usuario;
import com.example.mariella.distribucionpolicialapp.models.rest.UserLoginRest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Mariella on 11/08/2016.
 */
public interface ServiceEndPoints {
    @GET("tipodelitos/all")
    Call<ArrayList<Tipodelito>> callTipodelito();

    @POST("user/login")
    Call<Usuario> callUserLogin(@Body UserLoginRest userLoginRest);
}
