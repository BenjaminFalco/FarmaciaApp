package com.farmacia.app;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.farmacia.app.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//-36.606552301593375, -72.10330409210579
        // Add a marker in Sydney and move the camera
        LatLng Chillan= new LatLng(-36.606552301593375,-72.10330409210579);
        mMap.addMarker(new MarkerOptions().position(Chillan).title(" chillan"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chillan));

//-36.610362854116545, -72.10206441413456 (F.santos)
        LatLng FarmaciaSts= new LatLng(-36.610362854116545,-72.10206441413456);
        mMap.addMarker(new MarkerOptions().position(FarmaciaSts).title("Farmacia Santos, martes, 9:00–18:30 ,miércoles, 9:00–18:30,jueves, 9:00–18:30,viernes, 9:00–18:30,sábado (Navidad), Cerrado, Horario del día feriado,domingo, Cerrado,lunes, 9:00–18:30"));


//-36.60760692013815, -72.09245137779658 (F scb)
        LatLng FarmaciaSb= new LatLng(-36.60760692013815,-72.09245137779658);
        mMap.addMarker(new MarkerOptions().position(FarmaciaSb).title("Farmacia Salcobrand, martes, 9:00–20:30,miércoles, 9:00–20:30,jueves, 9:00–20:30,viernes, 9:00–20:30,sábado (Navidad), 9:00–19:30, Los horarios pueden variar,domingo, Cerrado,lunes, 9:00–20:30"));
//-36.60990334513379, -72.10142155599945
        LatLng FarmaciaDrSimi= new LatLng(-36.60990334513379,-72.10142155599945);
        mMap.addMarker(new MarkerOptions().position(FarmaciaDrSimi).title("FarmaciaDrSimi,LUNES A VIERNES DE 09:00 A 18:00\""));

//-36.60966132343415, -72.10072442691968
        LatLng FarmaciaAhumada= new LatLng(-36.60966132343415,-72.10072442691968);
        mMap.addMarker(new MarkerOptions().position(FarmaciaAhumada).title("Farmacia Ahumada, LUNES A VIERNES DE 09:00 A 18:00\""));
        //-36.609046028105446, -72.101773339236
        LatLng FarmaciaCrusVerde= new LatLng(-36.609046028105446,-72.101773339236);
        mMap.addMarker(new MarkerOptions().position(FarmaciaCrusVerde).title("FarmaciaCrusVerde, LUNES A VIERNES DE 09:00 A 18:00"));

    }

}