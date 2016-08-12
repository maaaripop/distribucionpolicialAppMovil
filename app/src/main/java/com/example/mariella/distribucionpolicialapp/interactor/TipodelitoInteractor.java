package com.example.mariella.distribucionpolicialapp.interactor;

import android.content.Context;
import android.util.Log;

import com.example.mariella.distribucionpolicialapp.models.Tipodelito;
import com.example.mariella.distribucionpolicialapp.presenter.TipodelitoPresenter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mariella on 11/08/2016.
 */
public interface TipodelitoInteractor {
    /**
     * Created by Mariella on 10/08/2016.
     */
    public void listTipodelito(TipodelitoPresenter tipodelitopresenter, Context context);
}
