package com.example.gerardo.free.mRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gerardo.free.FireDataBase.FireBasePhotos;
import com.example.gerardo.free.R;
import com.koushikdutta.ion.Ion;

import java.util.Collections;
import java.util.List;

/**
 * Created by gerardo on 11/06/16.
 */
public class PhotosAdapter extends RecyclerView.Adapter <PhotosAdapter.MyViewHolder>{
    private LayoutInflater inflater;
    Context context;
    List<String> photos = Collections.emptyList();
    FireBasePhotos fireBasePhotos;

    public PhotosAdapter(Context c, List<String> photos){
        this.context = c;
        this.photos = photos;
        inflater=LayoutInflater.from(c);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

         View view = inflater.inflate(R.layout.photo_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(context!=null) {
            Ion.with(holder.photo)
                   .placeholder(R.drawable.ic_placeholder)
                    .error(R.drawable.ic_error)
                   .load(photos.get(position));
       }
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView photo;

        public MyViewHolder(View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.photoView);
        }
    }
}
