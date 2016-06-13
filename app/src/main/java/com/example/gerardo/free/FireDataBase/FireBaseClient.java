package com.example.gerardo.free.FireDataBase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.gerardo.free.mData.InfoPhoto;
import com.example.gerardo.free.mRecyclerView.PhotosAdapter;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MasterHardisk on 12/06/16.
 */
public class FireBaseClient {
    Context c;
    String DB_URL;
    RecyclerView recyclerView;
    Firebase fire;
    ArrayList<InfoPhoto> photos;
    PhotosAdapter photosAdapter;

    public FireBaseClient(Context c, String DB_URL, RecyclerView recyclerView) {
        this.c = c;
        this.DB_URL = DB_URL;
        this.recyclerView = recyclerView;
        photos = new ArrayList<>();
        Firebase.setAndroidContext(c);
        fire = new Firebase(DB_URL);


    }



    public void refreshData(){
        fire.addValueEventListener(new ValueEventListener() {
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
    private void getUpdates(DataSnapshot dataSnapshot){

        photos.clear();
        for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
            InfoPhoto photo = dataSnapshot1.getValue(InfoPhoto.class);
            photos.add(photo);
        }
        if(photos.size()>0){
           System.out.println(photos);
            photosAdapter = new PhotosAdapter(c, photos);
            recyclerView.setAdapter(photosAdapter);
        }else{
            System.out.println("No hay fotos");
        }
    }
}
