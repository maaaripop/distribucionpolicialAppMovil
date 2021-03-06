package com.example.mariella.distribucionpolicialapp.interactor;

import android.content.Context;
import android.util.Log;

import com.example.mariella.distribucionpolicialapp.models.Tipodelito;
import com.example.mariella.distribucionpolicialapp.presenter.TipodelitoPresenter;
import com.example.mariella.distribucionpolicialapp.services.ServiceEndPoints;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mariella on 11/08/2016.
 */
public class TipodelitoInteractorImpl implements TipodelitoInteractor {

    ServiceEndPoints service;

    public TipodelitoInteractorImpl(ServiceEndPoints service) {
        this.service = service;
    }
    @Override
    public void listTipodelito(final TipodelitoPresenter tipodelitoPresenter, Context context ) {
       Call<ArrayList<Tipodelito>> request = service.callTipodelito();
        request.enqueue(new Callback<ArrayList<Tipodelito>>() {
            @Override
            public void onResponse(Call<ArrayList<Tipodelito>> call, Response<ArrayList<Tipodelito>> response) {
                ArrayList<Tipodelito> list=(ArrayList<Tipodelito>) response.body();
                if (response.isSuccessful()) {
                    tipodelitoPresenter.OnTipoDelitosFound(list);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Tipodelito>> call, Throwable t) {
                tipodelitoPresenter.OnTipoDelitosNotFound();
            }
        });
    }
}
