package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.adapter.MovieAdapter;
import com.example.myapplication.model.Movie;
import com.example.myapplication.network.ApiClient;
import com.example.myapplication.network.ApiMovies;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movies;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv_movies);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        //movieAdapter = new MovieAdapter(movies,getApplicationContext());
        //recyclerView.setAdapter(movieAdapter);
        showMovies();
    }

    public void showMovies(){
        Call<List<Movie>> call = ApiClient.getClient().create(ApiMovies.class).getMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()){
                    movies = response.body();
                    movieAdapter = new MovieAdapter(movies,getApplicationContext());
                    recyclerView.setAdapter(movieAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error al cargar la app", Toast.LENGTH_SHORT).show();
            }
        });
    }
}