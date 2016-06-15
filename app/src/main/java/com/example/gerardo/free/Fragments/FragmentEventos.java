package com.example.gerardo.free.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerardo.free.FireDataBase.FireBaseEventos;
import com.example.gerardo.free.mRecyclerView.EventosAdapter;
import com.example.gerardo.free.mData.InfoEventos;
import com.example.gerardo.free.R;
import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MasterHardisk on 8/06/16.
 */

public class FragmentEventos extends Fragment {
    final static String DB_URL="https://pubfreestyle.firebaseio.com/eventos";
    FireBaseEventos fireBaseEventos;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.fragment_eventos, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.recyclerviewEventos);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        fireBaseEventos = new FireBaseEventos(getContext().getApplicationContext(), DB_URL, recyclerView);
        fireBaseEventos.refreshData();
        return layout;
    }



}
