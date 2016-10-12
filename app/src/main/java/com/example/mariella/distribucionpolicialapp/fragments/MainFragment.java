package com.example.mariella.distribucionpolicialapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mariella.distribucionpolicialapp.R;

/**
 * Created by Mariella on 09/08/2016.
 */
public class MainFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main,container,false);
        return rootView;

    }
}
