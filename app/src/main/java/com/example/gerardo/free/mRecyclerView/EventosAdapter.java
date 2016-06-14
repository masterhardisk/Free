package com.example.gerardo.free.mRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gerardo.free.R;
import com.example.gerardo.free.mData.InfoEventos;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by MasterHardisk on 11/06/16.
 */
public class EventosAdapter extends RecyclerView.Adapter <EventosAdapter.MyViewHolder>{

    Context c;
    ArrayList<InfoEventos> eventos;

    public EventosAdapter(Context context, ArrayList<InfoEventos> eventos){
        this.c = context;
        this.eventos = eventos;


    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventos_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            System.out.println(position);
            holder.titulo.setText(eventos.get(position).getTitulo());
            holder.fecha.setText(eventos.get(position).getFecha());
            Ion.with(holder.foto)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error)
                    .load(eventos.get(position).getUrlphoto());


    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        TextView fecha;
        ImageView foto;
        public MyViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.textViewEventos);
            fecha = (TextView) itemView.findViewById(R.id.textViewFecha);
            foto = (ImageView) itemView.findViewById(R.id.imageViewEventos);
        }
    }

}
