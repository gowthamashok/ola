package com.example.ola;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class BookRideFrag extends Fragment implements OnMapReadyCallback {

    Fragment fragment;
    private GoogleMap mMap;
    Location location;
    FusedLocationProviderClient fusedLocationProviderClient;
    public static final int Request_code = 101;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.book_ride_frag, container, false);
        Toolbar toolbar = v.findViewById(R.id.toolbar);
        getActivity().setTitle("Book your Ride");

      

        SupportMapFragment supportMapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);

        return v;

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        float zoomlevel = 16.0f;
        LatLng sydney = new LatLng(13.0827, 80.2707);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney,zoomlevel));

//        mMap.setMyLocationEnabled(true);
//        mMap.setOnMyLocationButtonClickListener((GoogleMap.OnMyLocationButtonClickListener) this);
//        mMap.setOnMyLocationClickListener((GoogleMap.OnMyLocationClickListener) this);

    }


}