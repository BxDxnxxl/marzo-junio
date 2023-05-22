package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface apiset {
    @GET("json_user_fetch")
    Call<List<responsemodel>> getdata();
}
