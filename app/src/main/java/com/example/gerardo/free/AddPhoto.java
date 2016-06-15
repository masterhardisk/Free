package com.example.gerardo.free;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by gerardo on 15/06/16.
 */
public class AddPhoto extends AppCompatActivity {
        Toolbar mtoolbar;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.addphoto);
        mtoolbar = (Toolbar) findViewById(R.id.addphoto_bar);
        setSupportActionBar(mtoolbar);

    }
}
