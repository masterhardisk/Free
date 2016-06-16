package com.example.gerardo.free.mRecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gerardo.free.FireDataBase.FireBasePhotos;
import com.example.gerardo.free.ImagesDetails;
import com.example.gerardo.free.R;
import com.example.gerardo.free.mData.InfoPhoto;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gerardo on 11/06/16.
 */
public class PhotosAdapter extends RecyclerView.Adapter <PhotosAdapter.MyViewHolder>{
    private LayoutInflater inflater;
    Context c;
    ArrayList<InfoPhoto> photos;

    public PhotosAdapter(Context c, ArrayList<InfoPhoto> photos){
        this.c = c;
        this.photos = photos;
        inflater=LayoutInflater.from(c);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

         View view = inflater.inflate(R.layout.photo_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view, c, photos);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(c!=null) {
            Ion.with(holder.photo)
                   .placeholder(R.drawable.ic_placeholder)
                    .error(R.drawable.ic_error)
                   .load(photos.get(position).getUrlphoto());
       }
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView photo;
        ArrayList<InfoPhoto> infoPhotos = new ArrayList<InfoPhoto>();
        Context c;

        public MyViewHolder(View itemView, Context c, ArrayList<InfoPhoto> infoPhotos) {
            super(itemView);
            this.c = c;
            this.infoPhotos = infoPhotos;
            itemView.setOnClickListener(this);
            photo = (ImageView) itemView.findViewById(R.id.photoView);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            InfoPhoto infoPhoto = this.infoPhotos.get(position);
            Intent intent= new  Intent(this.c, ImagesDetails.class);
            intent.putExtra("urlPhoto", infoPhoto.getUrlphoto());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.c.startActivity(intent);

        }
    }
}
