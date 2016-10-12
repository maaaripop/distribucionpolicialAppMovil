package com.example.mariella.distribucionpolicialapp.presenter;


import android.content.Context;

import com.example.mariella.distribucionpolicialapp.MainActivity;
import com.example.mariella.distribucionpolicialapp.fragments.LoginFragment;
import com.example.mariella.distribucionpolicialapp.interactor.LoginInteractor;
import com.example.mariella.distribucionpolicialapp.interactor.LoginInteractorImpl;
import com.example.mariella.distribucionpolicialapp.models.Usuario;
import com.example.mariella.distribucionpolicialapp.models.rest.UserLoginRest;

/**
 * Created by USER on 11/10/2016.
 */
public class LoginPresenter {
    private static LoginInteractor interactor = null;
    private static LoginPresenter instance = null;
    private static LoginFragment fragment = null;

    protected LoginPresenter() {

    }

    public static LoginPresenter getInstance(LoginFragment loginFragment) {
        if (instance == null) {
            instance = new LoginPresenter();
            interactor = new LoginInteractorImpl(MainActivity.service);
            fragment = loginFragment;
        }
        return instance;
    }

    public void login(UserLoginRest userLoginRest, Context context) {
        interactor.login(userLoginRest, this, context);
    }

    public void onLoginSuccess(Usuario usuario) {
        fragment.showAppMainFragment(usuario);
    }

    public void onLoginFailure() {
        fragment.showLoginFailureMessage();
    }
}
