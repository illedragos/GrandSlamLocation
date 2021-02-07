package com.example.grandslamlocation;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private String TAG = "Dragos";

    private LatLng RolandGarros;
    private LatLng AustralianOpen;
    private LatLng Wimbledon;
    private LatLng USOpen;

    private MarkerOptions RolandGarrosOptions;
    private MarkerOptions AustralianOpenOptions;
    private MarkerOptions WimbledonOptions;
    private MarkerOptions USOpenOptions;

    private List<Marker> markerList;
    private List<MarkerOptions> markerOptionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        markerList = new ArrayList<>();
        markerOptionsList = new ArrayList<>();

        AustralianOpen = new LatLng(-37.821580,144.978643);
        RolandGarros = new LatLng(48.847174,2.249260);
        Wimbledon = new LatLng(51.433749,-0.214033);
        USOpen = new LatLng(40.750002,-73.847072);

        AustralianOpenOptions = new MarkerOptions().position(AustralianOpen).
                title("Rod Laver Arena - Australian Open")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        markerOptionsList.add(AustralianOpenOptions);

        RolandGarrosOptions =new MarkerOptions().position(RolandGarros)
                .title("Philippe-Chatrier - Roland Garros")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        markerOptionsList.add(RolandGarrosOptions);

        WimbledonOptions = new MarkerOptions().position(Wimbledon)
                .title("Centre Court - Wimbledon")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        markerOptionsList.add(WimbledonOptions);

        USOpenOptions = new  MarkerOptions().position(USOpen)
                .title("Arthur Ashe Stadium - USOpen")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        markerOptionsList.add(USOpenOptions);

        for(MarkerOptions options : markerOptionsList){
           markerList.add(mMap.addMarker(options));
        }

        //markerList.get(0).showInfoWindow(); show Info at Rod Laver Arena

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(RolandGarros,1));
        mMap.setOnMarkerClickListener(this);

        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker.getId().equals("m0")){
            Toast.makeText(this,"Rod Laver Arena Clicked",Toast.LENGTH_SHORT).show();
        }
        else if(marker.getId().equals("m1")){
            Toast.makeText(this,"Philippe-Chatrier Clicked",Toast.LENGTH_SHORT).show();
        }
        else if(marker.getId().equals("m2")){
            Toast.makeText(this, "Centre Court Clicked", Toast.LENGTH_SHORT).show();
        }
        else if(marker.getId().equals("m3")){
            Toast.makeText(this, "Arthur Ashe Stadium", Toast.LENGTH_SHORT).show();
        }

        return false;
        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
    }
}