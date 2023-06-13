package com.example.myapplication.network;

import com.example.myapplication.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
//se encargará de preparar los metodos de las acciones de la app
public interface APIService {

    @GET("volley_array.json")
    Call<List<MovieModel>> getMovieList();



}
