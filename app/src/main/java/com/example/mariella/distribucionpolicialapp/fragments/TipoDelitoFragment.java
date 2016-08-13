package com.example.mariella.distribucionpolicialapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mariella.distribucionpolicialapp.Adapters.TipoDelitoAdapter;
import com.example.mariella.distribucionpolicialapp.Constants;
import com.example.mariella.distribucionpolicialapp.R;
import com.example.mariella.distribucionpolicialapp.models.Tipodelito;
import com.example.mariella.distribucionpolicialapp.presenter.TipodelitoPresenter;

import java.util.ArrayList;

/**
 * Created by USER on 12/08/2016.
 */
public class TipoDelitoFragment  extends Fragment {
    TipodelitoPresenter presenter=TipodelitoPresenter.getInstance(this);
    TipoDelitoAdapter tipoDelitoAdapter;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tipo_delito,container,false);
        prepareView(rootView, getArguments(), savedInstanceState);
        return rootView;
    }

    public void prepareView(View rootView, Bundle args, Bundle savedInstanceState){
        ListView tipodelitoList=(ListView)rootView.findViewById(R.id.fragment_tipo_delito_list);
        Button loginBtn = (Button) rootView.findViewById(R.id.fragment_tipo_delito_btnListar);
        Button clearBtn = (Button) rootView.findViewById(R.id.fragment_tipo_delito_btnBorrar);
        tipoDelitoAdapter=new TipoDelitoAdapter(this.getContext(),this,R.layout.tipodelito_list_item, new ArrayList<Tipodelito>());
        tipodelitoList.setAdapter(tipoDelitoAdapter);


        loginBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                presenter.getAllTipoDelitos(getContext());
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tipoDelitoAdapter.clear();
            }
        });

    }

    public void displayTipoDelitos(ArrayList<Tipodelito> list){
        if(list!=null){
            tipoDelitoAdapter.clear();
            tipoDelitoAdapter.addAll(list);
            tipoDelitoAdapter.notifyDataSetChanged();
        }
    }

    public void displayError(Constants.Message type){
        String errorMessage="";
        if(type==Constants.Message.ERROR_NOT_FOUND_TIPO_DELITOS){
            errorMessage="No se pudieron encontrar Tipos de Delito.";
        }
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
    }

}
