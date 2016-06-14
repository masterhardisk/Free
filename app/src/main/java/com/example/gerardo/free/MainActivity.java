package com.example.gerardo.free;

import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.gerardo.free.Fragments.FragmentAyuda;
import com.example.gerardo.free.Fragments.FragmentEventos;
import com.example.gerardo.free.Fragments.FragmentImages;
import com.example.gerardo.free.Fragments.FragmentLocalizacion;

/**
 * Created by MasterHardisk on 8/06/16.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentImages fragmentImages;
    private FragmentAyuda fragmentAyuda;
    private FragmentLocalizacion fragmentLocalizacion;
    private FragmentEventos fragmentEventos;
    private FragmentTransaction transaction;
    private FragmentManager mManager;
    private Toolbar mtoolbar;
    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mManager=getSupportFragmentManager();
        mtoolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mtoolbar);
        FragmentEventos fragmentEventos = new FragmentEventos();
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.main_content, fragmentEventos, "Eventos");
        transaction.commit();
        mDrawer = (NavigationView) findViewById(R.id.main_drawer);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mtoolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if(item.getItemId()== R.id.navigation_item1){
             fragmentEventos = new FragmentEventos();
            transaction = mManager.beginTransaction();
            transaction.replace(R.id.main_content, fragmentEventos, "Eventos");
            transaction.commit();
            mDrawerLayout.closeDrawer(mDrawer);
            mtoolbar.setTitle(item.getTitle() + " FreeStyle");
        }
        if(item.getItemId()== R.id.navigation_item2){
            fragmentLocalizacion = new FragmentLocalizacion();
            transaction = mManager.beginTransaction();
            transaction.replace(R.id.main_content, fragmentLocalizacion, "Localizacion");
            transaction.commit();
            mDrawerLayout.closeDrawer(mDrawer);
            mtoolbar.setTitle(item.getTitle());
        }
        if(item.getItemId()==R.id.navigation_item3){
            fragmentImages = new FragmentImages();
            transaction = mManager.beginTransaction();
            transaction.replace(R.id.main_content, fragmentImages, "Imagenes");
            transaction.commit();
            mDrawerLayout.closeDrawer(mDrawer);
            mtoolbar.setTitle(item.getTitle());
        }
        if(item.getItemId()==R.id.navigation_item4){
            fragmentAyuda = new FragmentAyuda();
            transaction = mManager.beginTransaction();
            transaction.replace(R.id.main_content, fragmentAyuda,"Ayuda");
            transaction.commit();
            mDrawerLayout.closeDrawer(mDrawer);
            mtoolbar.setTitle(item.getTitle());
        }

        return false;
    }


}
