package dk.laundav.locationservice;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

public class LocationService {
	
	private static GPSTracker gps;
	
	public static LocationObject getLocation(Context context) {

		gps = new GPSTracker(context);

		// check if GPS enabled     
		if(gps.canGetLocation()) {

			double latitude = gps.getLatitude();
			double longitude = gps.getLongitude();
			// Log.d(TAG, "Found latitude="+latitude+" longitude="+longitude);

			Geocoder geocoder;
			List<Address> addresses;
			geocoder = new Geocoder(context, Locale.getDefault());
			
			LocationObject location = new LocationObject();
			location.setLatitude(latitude);
			location.setLongitude(longitude);
			
			try {
				//Log.d(TAG, "reached A");
				addresses = geocoder.getFromLocation(latitude, longitude, 1);
				//Log.d(TAG, "reached B");
				String address = addresses.get(0).getAddressLine(0);
				String city = addresses.get(0).getAddressLine(1);
				String country = addresses.get(0).getAddressLine(2);
				
				location.setAddress(address + " " + city +  " " + country);
				return location;//address + " " + city +  " " + country;
				
			} catch (IOException e) {
				e.printStackTrace();
				//Log.d(TAG, "Failed to get location information");
				//Log.e(TAG, e.getMessage());
				location.setAddress(latitude+","+longitude);
				return location;
			}

		} else {
			// can't get location
			// GPS or Network is not enabled
			// Ask user to enable GPS/network in settings
			gps.showSettingsAlert();
			//Log.d(TAG, "Failed utterly... impossible to get location");
			return null;//"Could not find location";
		}
	}

}