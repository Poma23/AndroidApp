package com.example.androidexam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Accomodation_map extends Fragment implements OnMapReadyCallback  {
    private GoogleMap mapAPI;
    private SupportMapFragment mapFragment;

    public Accomodation_map() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_accomodation_map, container, false);

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapCounter);
        mapFragment.getMapAsync((OnMapReadyCallback) this);


        return view;
    }

    // get location from google map

    public void onMapReady(GoogleMap googleMap) {
        mapAPI = googleMap;
        LatLng Denmark= new LatLng(55.980934, 10.012116);
        mapAPI.addMarker(new MarkerOptions().position(Denmark).title("Denmark"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(Denmark));

    }
}
