package com.beastcourse.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.beastcourse.R;
import com.beastcourse.entities.RushEvent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andrey on 11.12.2016.
 */

public class MapsActivity extends BaseActivity {

    @BindView(R.id.activity_maps_rush_date)
    TextView rushDate;
    @BindView(R.id.activity_maps_rush_description)
    TextView rushDescription;
    @BindView(R.id.activity_maps_rush_name)
    TextView rushName;
    @BindView(R.id.activity_maps_rush_time)
    TextView rushTime;
    @BindView(R.id.activity_maps_rush_location)
    TextView rushLocation;

    private GoogleApiClient mGoogleApiClient;
    private GoogleMap mMap;
    private RushEvent rushEvent;

    public static final String RUSH_EVENT_INFO = "RUSH_EVENT_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);

        rushEvent = getIntent().getParcelableExtra(RUSH_EVENT_INFO);

        rushName.setText(rushEvent.getEventName());
        rushDate.setText(rushEvent.getEventDate());
        rushDescription.setText(rushEvent.getEventDescription());
        rushTime.setText(rushEvent.getEventTime());
        rushLocation.setText(rushEvent.getEventLocation());

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(@Nullable Bundle bundle) {
                        updateUI();
                    }

                    @Override
                    public void onConnectionSuspended(int i) {

                    }
                }).build();

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.activity_maps_map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
            }
        });
    }

    private void updateUI() {
        LatLng rushEventPoint = new LatLng(rushEvent.getEventLatitude(), rushEvent.getEventLongtitude());
        MarkerOptions rushEventMarker = new MarkerOptions().position(rushEventPoint)
                .title("Rush event location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

        mMap.clear();
        mMap.addMarker(rushEventMarker);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rushEventPoint, 15));
    }

    public static Intent newIntent(Context context,RushEvent rushEvent){
        Intent intent = new Intent(context,MapsActivity.class);
        intent.putExtra(RUSH_EVENT_INFO,rushEvent);
        return intent;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mGoogleApiClient.disconnect();
    }
}
