package com.example.mariella.distribucionpolicialapp.interactor;

import android.content.Context;

import com.example.mariella.distribucionpolicialapp.models.Usuario;
import com.example.mariella.distribucionpolicialapp.models.rest.UserLoginRest;
import com.example.mariella.distribucionpolicialapp.presenter.LoginPresenter;
import com.example.mariella.distribucionpolicialapp.services.ServiceEndPoints;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by USER on 11/10/2016.
 */
public class LoginInteractorImpl implements LoginInteractor {
    ServiceEndPoints service;

    public LoginInteractorImpl(ServiceEndPoints service) {
        this.service = service;
    }

    @Override
    public void login(UserLoginRest userLoginRest, final LoginPresenter loginPresenter, Context context) {

        Call<Usuario> request = service.callUserLogin(userLoginRest);
        request.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Usuario usuario = (Usuario) response.body();
                if (response.isSuccessful()) {
                    loginPresenter.onLoginSuccess(usuario);
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                loginPresenter.onLoginFailure();
            }
        });
    }
}
