package com.example.gerardo.free.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerardo.free.FireDataBase.FireBaseClient;
import com.example.gerardo.free.R;
/**
 * Created by MasterHardisk on 10/06/16.
 */
public class FragmentImages extends Fragment {
    final static String DB_URL="https://barfreestyle.firebaseio.com/Fotos";
    FireBaseClient fireBaseClient;
    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_images, container, false);
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerviewPhotos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fireBaseClient = new FireBaseClient(getActivity().getApplicationContext(), DB_URL, recyclerView);
        fireBaseClient.refreshData();
        return view;
    }


}
