package com.example.myapplication;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
    List<responsemodel> data;

    public myadapter(List<responsemodel> data){
        this.data=data;
    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return  new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
            holder.t1.setText(data.get(position).getName());
            holder.t2.setText(data.get(position).getDesig());
            Glide.with(holder.t1.getContext()).load("http://192.168.104.63/api/img"+data.get(position).getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView t1, t2;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);

        }
    }
}
