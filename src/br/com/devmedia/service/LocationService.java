package br.com.devmedia.service;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

public class LocationService {
	private LocationManager locationManager;
	private Context context;
	private LocationListener listener;

	public LocationService(Context context, LocationListener locationListener) {
		this.context = context;
		this.locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		this.listener = locationListener;
	}

	public Location getLastKnownLocationGPS() {
		return this.locationManager
				.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	}

	public Location getLastKnownLocationNetwork() {
		return this.locationManager
				.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	}

	public void startGpsLocationCapture() {
		stop();
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
				0, listener);
	}

	public void startNetworkLocationCapture() {
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, 0, 0, listener);
	}

	public void startPassiveLocationCapture() {
		locationManager.requestLocationUpdates(
				LocationManager.PASSIVE_PROVIDER, 0, 0, listener);
	}

}