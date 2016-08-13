package com.example.mariella.distribucionpolicialapp.presenter;

import android.content.Context;

import com.example.mariella.distribucionpolicialapp.Constants;
import com.example.mariella.distribucionpolicialapp.MainActivity;
import com.example.mariella.distribucionpolicialapp.fragments.TipoDelitoFragment;
import com.example.mariella.distribucionpolicialapp.interactor.TipodelitoInteractor;
import com.example.mariella.distribucionpolicialapp.interactor.TipodelitoInteractorImpl;
import com.example.mariella.distribucionpolicialapp.models.Tipodelito;
import com.example.mariella.distribucionpolicialapp.services.ApiServiceAdapter;
import com.example.mariella.distribucionpolicialapp.services.ServiceEndPoints;

import java.util.ArrayList;

/**
 * Created by Mariella on 11/08/2016.
 */
public class TipodelitoPresenter{
    private static TipodelitoInteractor interactor=null;
    private static TipodelitoPresenter instance=null;
    private static TipoDelitoFragment fragment=null;
    protected TipodelitoPresenter(){

    }

    public static TipodelitoPresenter getInstance(TipoDelitoFragment tipoDelitoFragment) {
        if(instance == null) {
            instance = new TipodelitoPresenter();
            interactor= new TipodelitoInteractorImpl(MainActivity.service);
            fragment=tipoDelitoFragment;
        }
        return instance;
    }

    public void getAllTipoDelitos(Context context){
        interactor.listTipodelito(this, context);
    }

    public void OnTipoDelitosFound(ArrayList<Tipodelito> list){
        fragment.displayTipoDelitos(list);
    }

    public void OnTipoDelitosNotFound(){
        fragment.displayError(Constants.Message.ERROR_NOT_FOUND_TIPO_DELITOS);
    }

}
