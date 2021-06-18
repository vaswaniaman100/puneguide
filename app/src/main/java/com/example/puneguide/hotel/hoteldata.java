package com.example.puneguide.hotel;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.puneguide.R;
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

public class hoteldata extends AppCompatActivity implements GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener, OnMapReadyCallback,
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
        setContentView(R.layout.hoteldata);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Databaseaccess access = Databaseaccess.getInstance(getApplicationContext());
        access.open();
        SQLiteDatabase db = access.open();
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");

        //Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
        String a = "select name,photo,address,contactno1,contactno2,pnoneno,latitude,longitude,id,rent from hotels where name = " + "'" + name + "'";
        Cursor cursor = db.rawQuery(a, new String[]{});
        if (cursor.getCount() == 0) {

        } else {
        while (cursor.moveToNext()) {


        //hostelname
        TextView name1 = new TextView(this);
        name1 = (TextView) findViewById(R.id.hotelname);
        name1.setText(cursor.getString(0));
        mapname=cursor.getString(0);


        //hostelimage
        ImageView image = (ImageView) findViewById(R.id.hotelimage);
        InputStream ims = null;
        try {
        ims = getAssets().open("images/hotels/"+cursor.getString(1));
        }
        catch (IOException e) {
        e.printStackTrace();
        }
        Drawable d = Drawable.createFromStream(ims, null);
        image.setImageDrawable(d);


        //hosteladdress
        name1 = (TextView) findViewById(R.id.hoteladdress);
        name1.setText(cursor.getString(2));


        //hostelfacilities
        int id = cursor.getInt(8);
        String b = "select aminities from hotelaminities where id = "+id;
        //Toast.makeText(this,String.valueOf(cursor.getInt(8)),Toast.LENGTH_SHORT).show();
        Cursor cursor1 = db.rawQuery(b, new String[]{});
        if (cursor1.getCount() == 0) {

        } else {
        while (cursor1.moveToNext()) {
        TextView name2;
        name2 = new TextView(this);
        name2.setText(cursor1.getString(0));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        params.width=params.MATCH_PARENT;
        params.height = params.MATCH_PARENT;
        name2.setTextSize(18);
        LinearLayout layout = (LinearLayout) findViewById(R.id.hotelaminitieslayout);
        layout.addView(name2, params);
        name2.setGravity(Gravity.CENTER);

        }
        }

        // contact1
        name1 = (TextView) findViewById(R.id.hotelcontact1);
        name1.setText(cursor.getString(3));

        // contact2
        name1 = (TextView) findViewById(R.id.hotelcontact2);
        name1.setText(cursor.getString(4));

        // phoneno
        name1 = (TextView) findViewById(R.id.hotelphoneno);
        name1.setText(cursor.getString(5));

        //rent
        name1 = (TextView) findViewById(R.id.hotelprice);
        name1.setText(cursor.getString(9));

        //  map
        lat = cursor.getDouble(6);
        lon = cursor.getDouble(7);
        mapView = (MapView) findViewById(R.id.hotelmap);
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
