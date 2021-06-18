package com.example.puneguide;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.puneguide.database.Databaseaccess;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;

public class mallsdata  extends AppCompatActivity implements GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener, OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback
{

    private MapView mapView;
    Bundle mapViewBundle = null;
    private GoogleMap mMap;
    private UiSettings mUiSettings;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    Location loc;
    FusedLocationProviderClient fusedLocationProviderClient;
    Context context = this;
    private static final int Request_code=101;
    private static final String MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey";
    String mapname;
    double lat,lon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mallsdata);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Databaseaccess access = Databaseaccess.getInstance(getApplicationContext());
        access.open();
        SQLiteDatabase db = access.open();
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");

        //Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
        String a = "select id,name,photo,info,address,contactno,latitude,longitude from malls where name = " + "'" + name + "'";
        Cursor cursor = db.rawQuery(a, new String[]{});
        if (cursor.getCount() == 0) {

        } else {
            while (cursor.moveToNext()) {


                //collegelist name
                TextView name1 = new TextView(this);
                name1 = (TextView) findViewById(R.id.mallsname);
                name1.setText(cursor.getString(1));
                mapname=cursor.getString(1);


                //collegelist image
                ImageView image = (ImageView) findViewById(R.id.mallsimage);
                InputStream ims = null;
                try {
                    ims = getAssets().open("images/malls/"+cursor.getString(2));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                Drawable d = Drawable.createFromStream(ims, null);
                image.setImageDrawable(d);


                //collegeaddress
                name1 = (TextView) findViewById(R.id.mallsaddress);
                name1.setText(Html.fromHtml(cursor.getString(3)));
                // name1.setText(s);


                name1 = (TextView) findViewById(R.id.mallsinfo);
                name1.setText(Html.fromHtml(cursor.getString(4)));

                name1 = (TextView)  findViewById(R.id.mallscontact);
                name1.setText(Html.fromHtml(cursor.getString(5)));

                //  map
                lat = cursor.getDouble(6);
                lon = cursor.getDouble(7);
                mapView = (MapView) findViewById(R.id.mallsmap);
                mapView.onCreate(savedInstanceState);
                mapView.getMapAsync(this);
                MapsInitializer.initialize(this);


            }

        }

    }
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }


    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        mUiSettings = mMap.getUiSettings();

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng loc = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(loc).title(mapname));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 20));
        // Zoom in, animating the camera.
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);
        // mUiSettings.setZoomControlsEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);


        mUiSettings.setMapToolbarEnabled(true);
    }

}
