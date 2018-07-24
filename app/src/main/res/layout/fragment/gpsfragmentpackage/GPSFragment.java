package com.hi.gpsmaps.fragment.gpsfragmentpackage;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.hi.gpsmaps.R;

import java.util.ArrayList;
import java.util.Iterator;

import static android.content.ContentValues.TAG;


public class GPSFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,GpsStatus.Listener {
        Context mContext;
       // TextView txtOutputLat, txtOutputLon;

        LocationManager locationManager;
        private GoogleApiClient mGoogleApiClient;
        private LocationRequest mLocationRequest;
        String lat, lon;
        private GpsStatusView gpsStatusView;
        private GpsSnrView gpsSnrView;
        private LinearLayout gpsLatLayout;
        private TextView gpsLat;
        private LinearLayout gpsLonLayout;
        private TextView gpsLon;
        private LinearLayout gpsCoordLayout;
        private TextView gpsCoord;
        private TextView orDeclination;
        private TextView gpsSpeed;
        private TextView gpsSpeedUnit;
        private TextView gpsAlt;
        private TextView gpsAltUnit;
        private TextView gpsTime;
        private TextView gpsBearing;
        private TextView gpsAccuracy;
        private TextView gpsAccuracyUnit;
        private TextView gpsOrientation;
        private TextView gpsSats;
        private TextView gpsTtff;
        Location mLastLocation;
        ArrayList<Long> srn = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        TextView mSatname, mPrn, mUsedfix, mSnr, mAzimuth, mElevation;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.gpsfragment, container, false);
                gpsSnrView = (GpsSnrView) view.findViewById(R.id.gpsSnrView);
                gpsStatusView = new GpsStatusView(getContext());
                gpsSats = view.findViewById(R.id.gpsSats);
                gpsBearing = view.findViewById(R.id.gpsBearing);
                gpsSpeed = view.findViewById(R.id.gpsSpeed);
                gpsLatLayout = view.findViewById(R.id.gpsLatLayout);
                gpsLonLayout =view.findViewById(R.id.gpsLonLayout);
                gpsLon = view.findViewById(R.id.gpsLon);
                gpsLat = view.findViewById(R.id.gpsLat);
                gpsAlt = view .findViewById(R.id.gpsAlt);
                mContext = getActivity();
                mContext = getContext();
                buildGoogleApiClient();
                locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                locationManager.addGpsStatusListener(this);
                return view;
        }

        @Override
        public void onStart() {
                super.onStart();
                mGoogleApiClient.connect();
        }

        @Override
        public void onDestroy() {
                super.onDestroy();
                mGoogleApiClient.connect();
        }

        @Override
        public void onGpsStatusChanged(int event) {

                GpsStatus gpsStatus = locationManager.getGpsStatus(null);
                if(gpsStatus != null) {

                        Iterable<GpsSatellite>satellites = gpsStatus.getSatellites();
                        int sattInView = 0;
                        int sattInUse = 0;
                        Iterator<GpsSatellite> sat = satellites.iterator();
                        if(satellites != null){
                                for(GpsSatellite dataOFSat : satellites){
                                        sattInView++;
                                        if(dataOFSat.usedInFix()){
                                                sattInUse++;
                                        }
                                }
                        }
                        gpsSats.setText(String.valueOf(sattInUse) + "/" + String.valueOf(sattInView));
                        gpsSnrView.showSats(satellites);
                        gpsStatusView.showSats(satellites);
                        String lSatellites = null;
                        int i = 0;
                        while (sat.hasNext()) {
                                GpsSatellite satellite = sat.next();
                                lSatellites = "Satellite" + (i++) + ": "
                                        + satellite.getPrn() + ","
                                        + satellite.usedInFix() + ","
                                        + satellite.getSnr() + ","
                                        + satellite.getAzimuth() + ","
                                        + satellite.getElevation()+ "\n\n";
                               /* srn.add((long) satellite.getSnr());
                                names.add("Satellite"+(i++));
                                mSatname.setText("Satellite" + (i++));
                                mPrn.setText(String.valueOf(satellite.getPrn()));
                                mUsedfix.setText(String.valueOf(satellite.usedInFix()));
                                mSnr.setText(String.valueOf(satellite.getSnr()));
                                mAzimuth.setText(String.valueOf(satellite.getAzimuth()));
                                mElevation.setText(String.valueOf(satellite.getElevation()));*/
                                Log.d("SATELLITE",lSatellites);
                        }
                }
        }



    @Override
        public void onConnected(@Nullable Bundle bundle) {
                mLocationRequest = LocationRequest.create();
                mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                mLocationRequest.setInterval(100); // Update location every second

                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, new com.google.android.gms.location.LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        lat = String.valueOf(location.getLatitude());
                        lon = String.valueOf(location.getLongitude());
                            updateUI();
                            if(location.hasAltitude()){
                                    Float getAltitude = (float) 0.0 ;
                                    getAltitude = (float)(location.getAltitude());
                                    Log.d(TAG, "onLocationChanged: Altitude " +getAltitude);
                                    gpsAlt.setText(String.format("0.0",getAltitude));
                            }
                            if(location.hasSpeed()){
                                    Float getSpeed = (float) 0.0;
                                    getSpeed = location.getSpeed();
                                    gpsSpeed.setText(String.format("0.0",getSpeed));
                                    Log.d(TAG, "onLocationChanged: Speed "+gpsSpeed);
                            }
                    }
                });


                mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
                if (mLastLocation != null) {
                        lat = String.valueOf(mLastLocation.getLatitude());
                        lon = String.valueOf(mLastLocation.getLongitude());
                        gpsLat.setText(lat);
                        gpsLon.setText(lon);
                }
                updateUI();

        }

        @Override
        public void onConnectionSuspended(int i) {

        }

        @Override
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                buildGoogleApiClient();
        }

        synchronized void buildGoogleApiClient() {
                mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                        .addConnectionCallbacks(this)
                        .addOnConnectionFailedListener(this)
                        .addApi(LocationServices.API)
                        .build();
        }

        void updateUI() {
                Log.d("TAG", "updateUI: " +lat +lon );
              
        }
}
