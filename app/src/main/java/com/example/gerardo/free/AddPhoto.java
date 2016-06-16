package com.example.gerardo.free;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.kosalgeek.android.photoutil.CameraPhoto;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.koushikdutta.ion.Ion;

import java.io.File;
import java.io.IOException;

/**
 * Created by MasterHardisk on 15/06/16.
 */
public class AddPhoto extends AppCompatActivity {
    private FloatingActionButton fabCamera;
    private FloatingActionButton fabGallery;
    private FloatingActionButton fabSave;
    private ImageView addPhoto;
    private ProgressBar progressBar;
    private CameraPhoto cameraPhoto;
    private GalleryPhoto galleryPhoto;
    final int CAMERA_REQUEST = 13323;
    final int GALLERY_REQUEST = 13324;
    private final String TAG = this.getClass().getName();
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReferenceFromUrl("gs://project-6423673664632179304.appspot.com/");
    String urlphoto = "";
    Toolbar mtoolbar;
    private final int ADD_REQUEST = 57841;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addphoto);
        mtoolbar = (Toolbar) findViewById(R.id.addphoto_bar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.addphoto);

        fabCamera = (FloatingActionButton) findViewById(R.id.fabCamera);
        fabGallery = (FloatingActionButton) findViewById(R.id.fabGallery);
        fabSave = (FloatingActionButton) findViewById(R.id.fabSave);
        addPhoto = (ImageView) findViewById(R.id.addphotoView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        cameraPhoto =  new CameraPhoto(getApplicationContext());
        galleryPhoto = new GalleryPhoto(getApplicationContext());

        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivityForResult(cameraPhoto.takePhotoIntent(), CAMERA_REQUEST);
                } catch (IOException e) {
                    e.printStackTrace();
                    Snackbar.make(view, R.string.ERROR, Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        fabGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(galleryPhoto.openGalleryIntent(), GALLERY_REQUEST);
            }
        });

        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(urlphoto==""){
                    Snackbar.make(view,R.string.MAKE_A_PHOTO, Snackbar.LENGTH_SHORT).show();
                }else{
                    UploadImage(urlphoto);
                }

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST) {

                String photoPath = cameraPhoto.getPhotoPath();
                urlphoto = photoPath;
                Ion.with(this).load(photoPath)
                        .withBitmap()
                        .intoImageView(addPhoto);
            }
            if (requestCode == GALLERY_REQUEST) {
                Uri uri = data.getData();
                galleryPhoto.setPhotoUri(uri);
                String galleryPath = galleryPhoto.getPath();
                urlphoto = galleryPath;
                Ion.with(this).load(galleryPath)
                        .withBitmap()
                        .intoImageView(addPhoto);


            }
        }
    }



    public void UploadImage(final String data){
        final UploadTask uploadTask;
        if(data!="") {
            Uri file = Uri.fromFile(new File(data));
            StorageReference riversRef = storageRef.child("images/" + file.getLastPathSegment());
            uploadTask = riversRef.putFile(file);
            Snackbar.make(findViewById(R.id.addphotoView), R.string.WAIT, Snackbar.LENGTH_LONG).show();

// Register observers to listen for when the download is done or if it fails
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Snackbar.make(findViewById(R.id.addphotoView), R.string.ERROR, Snackbar.LENGTH_LONG).show();
                    // Handle unsuccessful uploads
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                    progressBar.setVisibility(View.GONE);

                    Snackbar.make(findViewById(R.id.addphotoView), R.string.SUCCESS, Snackbar.LENGTH_SHORT).show();
                    writeNewFoto(taskSnapshot.getDownloadUrl().toString());

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.animate();

                }
            });
        }
    }

        private void writeNewFoto(String urlphoto) {

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Fotos").push().child("urlphoto");
            myRef.setValue(urlphoto);
        }
}


