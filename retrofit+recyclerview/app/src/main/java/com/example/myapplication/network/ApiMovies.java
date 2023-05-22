package com.example.myapplication.network;

import com.example.myapplication.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
///describir las operaciones que usaremos de la api
public interface ApiMovies {
    @GET("retrofit+recyclerview/list.php")
    Call<List<Movie>> getMovies();
}
