package com.example.gerardo.free.Fragments;


import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.gerardo.free.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by MasterHardisk on 8/06/16.
 */
public class FragmentLocalizacion extends Fragment implements OnMapReadyCallback{
    private SupportMapFragment mMap;
    private String marcador;
    private int numero = R.string.hereiam;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_localizacion, container, false);
        mMap = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mMap.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        marcador = getString(R.string.hereiam);

        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        map.setMyLocationEnabled(true);
        map.setTrafficEnabled(true);
        map.setIndoorEnabled(true);
        map.setBuildingsEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(40.71533, 0.57694), 17));
        map.addMarker(new MarkerOptions()
                .title("FREESTYLE")
                .snippet(marcador)
                .position(new LatLng(40.71533, 0.57694)));






    }
}
