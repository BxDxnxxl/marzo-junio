package com.example.myapplication.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
///llamar a la api
public class ApiClient {
    private static Retrofit retrofit;

    public static Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.104.63/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
