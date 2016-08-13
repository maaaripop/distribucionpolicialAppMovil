package com.example.mariella.distribucionpolicialapp.services;

import android.util.Log;

import com.example.mariella.distribucionpolicialapp.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mariella on 11/08/2016.
 */
public class ApiServiceAdapter {
    private static Retrofit API_ADAPTER;

    public static Retrofit getInstance(){
        if(API_ADAPTER==null){
            /*Interceptor interceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest = chain.request().newBuilder().build();
                    return chain.proceed(newRequest);
                }
            };

// Add the interceptor to OkHttpClient
            OkHttpClient client = new OkHttpClient();
            client.interceptors().add(interceptor);*/

            API_ADAPTER =new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return API_ADAPTER;
    }
}
