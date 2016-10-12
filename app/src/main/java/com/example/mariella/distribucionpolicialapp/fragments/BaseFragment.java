package com.example.mariella.distribucionpolicialapp.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by USER on 12/10/2016.
 */
public abstract class BaseFragment extends Fragment {

    protected FragmentActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (FragmentActivity) context;
    }
}