package com.example.mariella.distribucionpolicialapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mariella.distribucionpolicialapp.MainActivity;
import com.example.mariella.distribucionpolicialapp.R;
import com.example.mariella.distribucionpolicialapp.models.Usuario;
import com.example.mariella.distribucionpolicialapp.models.rest.UserLoginRest;
import com.example.mariella.distribucionpolicialapp.presenter.LoginPresenter;

/**
 * Created by USER on 11/10/2016.
 */
public class LoginFragment extends BaseFragment {
    LoginPresenter presenter = LoginPresenter.getInstance(this);

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        prepareView(rootView, getArguments(), savedInstanceState);
        return rootView;
    }

    public void prepareView(View rootView, Bundle args, Bundle savedInstanceState) {
        EditText userId = (EditText) rootView.findViewById(R.id.txtUsr);
        EditText password = (EditText) rootView.findViewById(R.id.txtPwd);
        Button btnLogin = (Button) rootView.findViewById(R.id.btnLogin);
        final UserLoginRest userLoginRest = new UserLoginRest();

        userLoginRest.setUserId(userId.getText().toString());
        userLoginRest.setPassword(password.getText().toString());

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.login(userLoginRest, getContext());
            }
        });

    }

    public void showAppMainFragment(Usuario usuario) {
        Toast.makeText(mActivity, "Bienvenido: " + usuario.getNombre(), Toast.LENGTH_SHORT).show();
        ((MainActivity) mActivity).accessAppMainFragment();
    }

    public void showLoginFailureMessage() {
        Toast.makeText(mActivity, "Error al intentar autenticar.", Toast.LENGTH_SHORT).show();
    }

}
