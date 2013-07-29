package dk.laundav.activities;

import dk.laundav.data.AbstractLocationObject;
import dk.laundav.data.LocationObject;
import dk.laundav.data.ReverseGeocoderObject;
import dk.laundav.locationservice.R;
import dk.laundav.locationservice.service.LocationService;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

public class ExampleActivity extends Activity {
	
	private Button getLocationButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_example_activity);
		
		getLocation();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.example, menu);
		return true;
	}
	
	public void getLocation() {
		
		getLocationButton = (Button) findViewById(R.id.getLocationButton);
		
		getLocationButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				ReverseGeocoderObject location = LocationService.getLocationFromReverseGeocoding(ExampleActivity.this);

				//TODO: Lav fallback metode til LocationService
				//TODO: Se på JSONTokener, GSON eller Jackson for at parse JSON
						//JSONTOkener: http://developer.android.com/reference/org/json/JSONTokener.html
						//GSON: https://code.google.com/p/google-gson/
						//Jackson: http://jackson.codehaus.org/
				//TODO: Lav example service færdig (hvordan skal indholdet se ud?)
				//TODO: Lav Javadocs
				//TODO: Lav README.md om når alt er færdiggjort
				//TODO: Lav blogindlæg (ligesom til Calendar Service)
				
				System.out.println(
									"Location is: " + 
									location.getLatitude() + ", " + 
									location.getLongitude() + ", " + 
									location.getAddress() + ", " +
									location.getAdministrative_area_level_1() + ", " + 
									location.getAdministrative_area_level_2() + ", " + 
									location.getRoute() + ", " + 
									location.getPostal_code() + ", " +
									location.getLocality() + ", " +
									location.getStreet_number() + ", " + 
									location.getSublocality() + ", " + 
									location.getCountry());
				
//		
//				TextView latitudeText = (TextView) findViewById(R.id.latitude_value);
//				latitudeText.setText("" + location.getLatitude());
//				
//				TextView longitudeText = (TextView) findViewById(R.id.longitude_value);
//				longitudeText.setText("" + location.getLongitude());
//				
//				TextView addressText = (TextView) findViewById(R.id.address_value);
//				addressText.setText("" + location.getAddress());
//				
//				TextView cityText = (TextView) findViewById(R.id.city_value);
//				cityText.setText("" + location.getLocality());
//				
//				TextView countryText = (TextView) findViewById(R.id.country_value);
//				countryText.setText("" + location.getCountry());
				
			}
		});
	}
}
