package com.niitapp;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

@SuppressLint("NewApi")
public class Map_fragment extends Activity implements
		ActionBar.OnNavigationListener {

	public GoogleMap mMap;
	public Button b; 
	public Double latti,longi;
	public String s;
	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("MapOpen", "Success");
		setContentView(R.layout.map_layout);
		Log.d("MapShown", "Success");
		
		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        
        // Set up the action bar to show a dropdown list.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		// Set up the dropdown list navigation in the action bar.
		actionBar.setListNavigationCallbacks(
		// Specify a SpinnerAdapter to populate the dropdown list.
				new ArrayAdapter<String>(actionBar.getThemedContext(),
						android.R.layout.simple_list_item_1,
						android.R.id.text1, new String[] {
								getString(R.string.title_section1),
								getString(R.string.title_section2),
								getString(R.string.title_section3)}), this);
		
		final LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        
		// Define a listener that responds to location updates
        LocationListener locationListner = new LocationListener() {
         
         @Override
         public void onStatusChanged(String provider, int status, Bundle extras) {
          // TODO Auto-generated method stub
        	 Toast.makeText(getApplicationContext(), "Problem with GPS!!", Toast.LENGTH_SHORT).show();
         }
         
         @Override
         public void onProviderEnabled(String provider) {
          // TODO Auto-generated method stub
          
        	Toast.makeText(getApplicationContext(), "GPS Enabled!!", Toast.LENGTH_SHORT).show();
         }
         
         @Override
         public void onProviderDisabled(String provider) {
          // TODO Auto-generated method stub
        	 Toast.makeText(getApplicationContext(), "GPS Disabled!!", Toast.LENGTH_SHORT).show();
         }
         
         @Override
         public void onLocationChanged(Location location) {
          // TODO Auto-generated method stub
          latti = location.getLatitude();
          longi = location.getLongitude();
          
          mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL );
          mMap.setMyLocationEnabled(true);
          mMap.setTrafficEnabled(true);
          mMap.setBuildingsEnabled(true);

          /*CameraPosition pos= CameraPosition.builder().target(new LatLng(latti, longi)).zoom(12).build();
          mMap.animateCamera(CameraUpdateFactory.newCameraPosition(pos));
          locationManager.removeUpdates(this);*/
          
         }
        };
        // Register the listener with the Location Manager to receive location updates
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListner);
}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		LatLngBounds.Builder bld = new LatLngBounds.Builder();
		LatLngBounds.Builder bld1 = new LatLngBounds.Builder();
		LatLngBounds.Builder bld2 = new LatLngBounds.Builder();
		
		switch(position)
		{
		case 0: 
			mMap.clear();
    		mMap.addMarker(new MarkerOptions()
    		    .position(new LatLng(13.129904, 80.213827))
    		    .snippet("Kolathur\nRating:4.2")
    		    .title("NIIT"));
    		bld.include(new LatLng(13.129904, 80.213827));
    		
    		mMap.addMarker(new MarkerOptions()
    		    .position(new LatLng(13.109765, 80.244245))
    		    .snippet("Perambur\nRating:4.0")
    		    .title("NIIT"));
    		bld.include(new LatLng(13.109765, 80.244245));
    		
    		mMap.addMarker(new MarkerOptions()
    		    .position(new LatLng(13.084652, 80.211886))
    		    .snippet("Anna Nagar\nRating:4.2")
    		    .title("NIIT"));
    		bld.include(new LatLng(13.084652, 80.211886));
    		
    		mMap.addMarker(new MarkerOptions()
    		    .position(new LatLng(13.074508, 80.221070))
    		    .snippet("Kilpauk\nRating:4.3")
    		    .title("NIIT"));
    		bld.include(new LatLng(13.074508, 80.221070));
    		
    		mMap.addMarker(new MarkerOptions()
    		    .position(new LatLng(13.089855, 80.286585))
    		    .snippet("Parrys\nRating:4.3")
    		    .title("NIIT"));
    		bld.include(new LatLng(13.089855, 80.286585));
    		
    		mMap.addMarker(new MarkerOptions()
    		    .position(new LatLng(13.037477, 80.161106))
    		    .snippet("Porur\nRating:4.4")
    		    .title("NIIT"));
    		bld.include(new LatLng(13.037477, 80.161106));
    		
    		mMap.addMarker(new MarkerOptions()
    		    .position(new LatLng(13.082083, 80.168978))
    		    .snippet("Mogappair\nRating:4.2")
    		    .title("NIIT"));
    		bld.include(new LatLng(13.082083, 80.168978));
    		
    		mMap.addMarker(new MarkerOptions()
    		    .position(new LatLng(13.110742, 80.152144))
    		    .snippet("Ambattur\nRating:4.0")
    		    .title("NIIT"));
    		bld.include(new LatLng(13.110742, 80.152144));
    		
    		mMap.addMarker(new MarkerOptions()
    		    .position(new LatLng(13.033330, 80.230646))
    		    .snippet("T.Nagar\nRating:4.5")
    		    .title("NIIT"));
    		bld.include(new LatLng(13.033330, 80.230646));
    		
    		mMap.addMarker(new MarkerOptions()
    		    .position(new LatLng(13.042768, 80.266651))
    		    .snippet("Cathedral Road\nRating:4.1")
    		    .title("NIIT"));
    		bld.include(new LatLng(13.042768, 80.266651));
    		
    		LatLngBounds bounds = bld.build();
    	    mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 40), 3300, null);
    	
    	    break;
		
		case 1:
			mMap.clear();
			
			mMap.addMarker(new MarkerOptions()
				.position(new LatLng(9.918627, 78.093980))
				.title("NIIT B P ROAD")
				.snippet("ByPass ROAD\nRating:4.5"));
			bld1.include(new LatLng(9.918627, 78.093980));
			
			mMap.addMarker(new MarkerOptions()
				.position(new LatLng(9.925200, 78.119764))
				.title("NIIT Laxvel Systems")
				.snippet("NH-49\nRating:4.0"));
			bld1.include(new LatLng(9.925200, 78.119764));
			
			mMap.addMarker(new MarkerOptions()
				.position(new LatLng(9.920562, 78.148737))
				.title("NIIT")
				.snippet("Lake View Road\nRating:4.3"));
			bld1.include(new LatLng(9.920562, 78.148737));
			
			LatLngBounds bounds1 = bld1.build();          
			mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds1, 60), 3300, null);
    		
			break;
    	    
		case 2:
			mMap.clear();
			
			mMap.addMarker(new MarkerOptions()
				.position(new LatLng(11.024385, 77.011478))
				.title("NIIT Peelamedu Centre")
				.snippet("Rating:4.0"));
			bld2.include(new LatLng(11.024385, 77.011478));
			
			mMap.addMarker(new MarkerOptions()
				.position(new LatLng(11.019739, 76.963691))
				.title("NIIT One World")
				.snippet("100 feet road \n Rating:4.3"));
			bld2.include(new LatLng(11.019739, 76.963691));
			
			mMap.addMarker(new MarkerOptions()
				.position(new LatLng(11.001271, 76.972747))
				.title("NIIT Coimbature Centre")
				.snippet("Gopalapuram\nRating:4.6"));
			bld2.include(new LatLng(11.001271, 76.972747));
			
			mMap.addMarker(new MarkerOptions()
				.position(new LatLng(11.005125, 76.951421))
				.title("NIIT RS Puram Centre")
				.snippet("DB Road\nRating:4.5"));
			bld2.include(new LatLng(11.005125, 76.951421));
			
			LatLngBounds bounds2 = bld2.build();
			mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds2, 60), 3300, null);
    		
			break;
		}
		return true;
	}
}