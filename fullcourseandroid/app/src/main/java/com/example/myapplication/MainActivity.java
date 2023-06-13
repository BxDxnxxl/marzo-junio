package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.adapter.MovieListAdapter;
import com.example.myapplication.model.MovieModel;
import com.example.myapplication.viewmodel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieListAdapter.ItemClickListener {

    private List<MovieModel> movieModelList;
    private MovieListAdapter adapter;
    private MovieListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView =  findViewById(R.id.recyclerView);
        final TextView noresult = findViewById(R.id.noResultTv);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter =  new MovieListAdapter(this, movieModelList, this);
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        viewModel.getMoviesListObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(movieModels != null){
                    movieModelList = movieModels;
                    adapter.setMovieList(movieModels);
                    noresult.setVisibility(View.GONE);
                }else{
                    noresult.setVisibility(View.VISIBLE);

                }
            }
        });
        viewModel.makeApiCall();
    }

    @Override
    public void onMovieClick(MovieModel movie) {
        Toast.makeText(this, "clicked mobie name is :" +movie.getTitle(), Toast.LENGTH_SHORT).show();
    }
}