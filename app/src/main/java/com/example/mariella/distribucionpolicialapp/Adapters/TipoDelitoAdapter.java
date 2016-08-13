package com.example.mariella.distribucionpolicialapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mariella.distribucionpolicialapp.R;
import com.example.mariella.distribucionpolicialapp.fragments.TipoDelitoFragment;
import com.example.mariella.distribucionpolicialapp.models.Tipodelito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 12/08/2016.
 */
public class TipoDelitoAdapter extends ArrayAdapter<Tipodelito> {
    private TipoDelitoFragment fragment;
    private int itemLayout;
    List<Tipodelito> list=null;
    public TipoDelitoAdapter(Context context, TipoDelitoFragment fragment, int itemLayout, List<Tipodelito> objects) {
        super(context, 0, objects);
        this.fragment=fragment;
        this.itemLayout=itemLayout;
        this.list=objects;
    }
    @Override
    public final View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(itemLayout, null);
        }
        prepareItemView(convertView, getItem(position), position);
        return convertView;
    }

    public void prepareItemView(final View convertView, final Tipodelito item, int position) {
        TextView code=(TextView)convertView.findViewById(R.id.tipodelito_item_code);
        TextView name=(TextView)convertView.findViewById(R.id.tipodelito_item_name);

        code.setText(String.valueOf(item.getIdTipoDelito()));
        name.setText(String.valueOf(item.getNombre()));
    }

}
