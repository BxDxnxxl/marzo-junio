package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.Movie;

import java.util.List;
///inflar el recycler view
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    private List<Movie> movies;
    private Context context;

    public MovieAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    //especificar el xml que se infalrá
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie,parent,false);

        return new ViewHolder(view);
    }

    @Override
    //colocar los componentes que necesitamos
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(movies.get(position).getPortada()).into(holder.iv_portada);
        holder.tv_titulo.setText(movies.get(position).getTitulo());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    //decir los componentes que usaremos para mostrar datos del json, en este caso solo estas 2
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_portada;
        private TextView tv_titulo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_portada=itemView.findViewById(R.id.iv_portada);
            tv_titulo=itemView.findViewById(R.id.tv_titulo);
        }
    }
}
