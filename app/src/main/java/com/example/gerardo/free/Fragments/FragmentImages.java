package com.example.gerardo.free.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerardo.free.AddPhoto;
import com.example.gerardo.free.FireDataBase.FireBasePhotos;
import com.example.gerardo.free.R;
/**
 * Created by MasterHardisk on 10/06/16.
 */
public class FragmentImages extends Fragment {
    final static String DB_URL="https://pubfreestyle.firebaseio.com/Fotos";
    FireBasePhotos fireBasePhotos;
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_images, container, false);
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerviewPhotos);
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        mLayoutManager.setReverseLayout(false);
        recyclerView.setItemAnimator(null);
        fireBasePhotos = new FireBasePhotos(getContext().getApplicationContext(), DB_URL, recyclerView);
        fireBasePhotos.refreshData();

        FloatingActionButton newPage = (FloatingActionButton) view.findViewById(R.id.btnadd);
        newPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext().getApplicationContext(), AddPhoto.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
