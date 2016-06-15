package com.example.gerardo.free.FireDataBase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.gerardo.free.R;
import com.example.gerardo.free.mData.InfoEventos;
import com.example.gerardo.free.mRecyclerView.EventosAdapter;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by MasterHardisk on 14/06/16.
 */
public class FireBaseEventos {
    Context c;
    String DB_URL;
    RecyclerView recyclerView;
    Firebase firebase;
    ArrayList<InfoEventos> eventos = new ArrayList<>();
    EventosAdapter eventosAdapter;

    public FireBaseEventos(Context c, String DB_URL, RecyclerView recyclerView) {
        this.c = c;
        this.DB_URL = DB_URL;
        this.recyclerView = recyclerView;

        firebase.setAndroidContext(c);
        firebase = new Firebase(DB_URL);
    }

    public void refreshData() {
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());

            }
        });
    }

    public void getUpdates(DataSnapshot dataSnapshot){
        eventos.clear();
        for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

           InfoEventos evento = new InfoEventos();
            evento.setTitulo(dataSnapshot1.getValue(InfoEventos.class).getTitulo());
            evento.setFecha(dataSnapshot1.getValue(InfoEventos.class).getFecha());
            evento.setUrlphoto(dataSnapshot1.getValue(InfoEventos.class).getUrlphoto());
            eventos.add(evento);
        }
        if(eventos.size()>0){
            eventosAdapter = new EventosAdapter(c, eventos);
            recyclerView.setAdapter(eventosAdapter);
        }else{
            System.out.println(R.string.no_events);
        }

    }
}
