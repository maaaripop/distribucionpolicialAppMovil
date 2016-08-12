package com.example.mariella.distribucionpolicialapp.presenter;

import android.content.Context;

import com.example.mariella.distribucionpolicialapp.interactor.TipodelitoInteractor;

/**
 * Created by Mariella on 11/08/2016.
 */
public class TipodelitoPresenter extends BasePresenter {
    TipodelitoInteractor interactor;

    public TipodelitoPresenter( TipodelitoInteractor interactor) {

        this.interactor = interactor;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public void getAllPayments(Context context){
        interactor.listTipodelito(this, context);
    }


}
