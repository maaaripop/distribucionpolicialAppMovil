package com.example.mariella.distribucionpolicialapp.interactor;

import android.content.Context;

import com.example.mariella.distribucionpolicialapp.models.rest.UserLoginRest;
import com.example.mariella.distribucionpolicialapp.presenter.LoginPresenter;

/**
 * Created by USER on 11/10/2016.
 */
public interface LoginInteractor {
    public void login(UserLoginRest userLoginRest, final LoginPresenter loginPresenter, Context context);
}
