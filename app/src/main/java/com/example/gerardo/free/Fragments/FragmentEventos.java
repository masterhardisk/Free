package com.example.gerardo.free.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerardo.free.mRecyclerView.EventosAdapter;
import com.example.gerardo.free.mData.InfoEventos;
import com.example.gerardo.free.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MasterHardisk on 8/06/16.
 */

public class FragmentEventos extends Fragment {
    private RecyclerView recyclerView;
    private EventosAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.fragment_eventos, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.recyclerviewEventos);
        adapter= new EventosAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

    public static List<InfoEventos> getData(){
        List<InfoEventos> data = new ArrayList<>();
        int[] icons={
                R.drawable.festafreestyle,
                R.drawable.llolipop_colors,
                R.drawable.session_freestyle,
                R.drawable.festa_kutreparty,
                R.drawable.festafreestyle,
                R.drawable.session_freestyle
        };
        String[] titles={
                "Festa FreeStyle",
                "Llolipop Color",
                "Sessió Free",
                "la GRAN Kutreparty",
                "Festa FreeStyle",
                "Sessió Free"
        };
        String[] dates= {
                "11 de juny",
                "18 de juny",
                "24 de juny",
                "25 de juny",
                "08 de July",
                "09 de july"
        };

        for(int i=0;i<titles.length && i<dates.length && i<icons.length;i++){
            InfoEventos current = new InfoEventos();
            current.setIconId(icons[i]);
            current.setTitle(titles[i]);
            current.setDate(dates[i]);
            data.add(current);
        }
        return data;
    }

}
