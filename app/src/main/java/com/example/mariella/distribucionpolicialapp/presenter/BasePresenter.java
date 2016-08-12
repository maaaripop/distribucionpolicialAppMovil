package com.example.mariella.distribucionpolicialapp.presenter;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by Mariella on 11/08/2016.
 */
public abstract BasePresenter {
    public abstract void onStart();
    public abstract void onStop();

    public void onNoInternet(Context context){
        /*AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(onNoInternetString()).setNeutralButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();*/
    }
    public void onNoInternetString(){
        //return R.string.no_internet;
    }
}
