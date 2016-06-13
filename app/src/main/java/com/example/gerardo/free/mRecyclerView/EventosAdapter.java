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

import java.util.Collections;
import java.util.List;

/**
 * Created by gerardo on 11/06/16.
 */
public class EventosAdapter extends RecyclerView.Adapter <EventosAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    List<InfoEventos> data = Collections.emptyList();

    public EventosAdapter(Context context, List<InfoEventos> data){
        inflater= LayoutInflater.from(context);
        this.data = data;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.eventos_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InfoEventos current = data.get(position);
        holder.title.setText(current.getTitle());
        holder.date.setText(current.getDate());
        holder.icon.setImageResource(current.getIconId());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView date;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textViewEventos);
            date = (TextView) itemView.findViewById(R.id.textViewFecha);
            icon = (ImageView) itemView.findViewById(R.id.imageViewEventos);
        }
    }
}
