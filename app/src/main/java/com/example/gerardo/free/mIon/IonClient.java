package com.example.gerardo.free.mIon;

import android.content.Context;
import android.widget.ImageView;

import com.example.gerardo.free.mData.InfoPhoto;
import com.koushikdutta.ion.Ion;

/**
 * Created by MasterHardisk on 12/06/16.
 */
public class IonClient {


    public static void downloadImage (Context c, String url, ImageView photo){
        System.out.println(url);

                Ion.with(c)
                        .load(url)
                        .withBitmap()
                        .intoImageView(photo);
            }
}

