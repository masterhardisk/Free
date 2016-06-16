package com.example.gerardo.free;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;

public class ImagesDetails extends AppCompatActivity {
    Toolbar mtoolbar;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.images_details);
        mtoolbar = (Toolbar) findViewById(R.id.photodetail_bar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = (ImageView) findViewById(R.id.iv_imagedetail);

        Ion.with(this).load(getIntent().getStringExtra("urlPhoto"))
        .withBitmap()
        .intoImageView(imageView);

    }
}
