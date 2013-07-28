package dk.laundav.locationservice.service;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import dk.laundav.data.AbstractLocationObject;
import dk.laundav.data.LocationObject;
import dk.laundav.data.ReverseGeocoderObject;
import dk.laundav.locationservice.service.GPSTracker;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

/* 
 * Copyright 2013 David Laundav
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class LocationService {
	
	private static GPSTracker gps;
	
	public static LocationObject getLocationFromGeocoder(Context context) {
		
		gps = new GPSTracker(context);

		// check if GPS enabled     
		if(gps.canGetLocation()) {

			double latitude = gps.getLatitude();
			double longitude = gps.getLongitude();

			Geocoder geocoder = new Geocoder(context, Locale.getDefault());
			
			LocationObject location = new LocationObject(latitude, longitude);
			
			try {
				
				// addresses er altid lig 0 (ingen elementer)
				List<Address> addresses = geocoder.getFromLocation( 
						location.getLatitude(), 
						location.getLongitude(), 
						1);
				
				if ( addresses != null && addresses.size() > 0 ) {
				
					System.out.println("The geocoder works!");
					
					location.setLocation(
							addresses.get(0).getAddressLine(0), // address
							addresses.get(0).getAddressLine(1), // city
							addresses.get(0).getAddressLine(2)  // country
							);
				
				}
				
				return location;

			} catch (IOException e) {
				e.printStackTrace();
				return location;
			}

		} else {
			// can't get location
			// GPS or Network is not enabled
			// Ask user to enable GPS/network in settings
			gps.showSettingsAlert();
			return null;
		}
	}
	
	public static ReverseGeocoderObject getLocationFromReverseGeocoding(Context context) {
		
		gps = new GPSTracker(context);

		// check if GPS enabled     
		if(gps.canGetLocation()) {
			
			double latitude = gps.getLatitude();
			double longitude = gps.getLongitude();
			
			ReverseGeocoderObject location = new ReverseGeocoderObject(latitude, longitude);
			
			ReverseGeocoder.setLocationContent(location);
			
			return location;
			
		}
		
		else {
			// can't get location
			// GPS or Network is not enabled
			// Ask user to enable GPS/network in settings
			gps.showSettingsAlert();
			return null;
		}
	}
}
