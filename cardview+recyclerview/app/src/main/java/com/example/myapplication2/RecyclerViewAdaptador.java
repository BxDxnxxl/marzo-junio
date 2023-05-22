package com.example.myapplication2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    @NonNull
    @Override
    public RecyclerViewAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personaje,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdaptador.ViewHolder holder, int position) {
        holder.nombre.setText(personajeLista.get(position).getNombre());
        holder.posicion.setText(personajeLista.get(position).getPosicion());
        holder.imgPersonaje.setImageResource(personajeLista.get(position).getImgPersonaje());
    }

    @Override
    public int getItemCount() {
        return personajeLista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre, posicion;
        ImageView imgPersonaje;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=(TextView) itemView.findViewById(R.id.tvNombre);
            posicion=(TextView) itemView.findViewById(R.id.tvPosicion);
            imgPersonaje=(ImageView) itemView.findViewById(R.id.imgPersonaje);
        }
    }
    public List<PersonajeModelo> personajeLista;
    public RecyclerViewAdaptador(List<PersonajeModelo> personajeLista){
        this.personajeLista=personajeLista;
    }
}
