package dk.laundav.locationservice;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
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

public class ExampleService extends Activity {
	
	private Button getLocationButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_example_service);
		
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
				LocationObject location = LocationService.getLocation(ExampleService.this);
				if(location != null){
					Toast.makeText(
							ExampleService.this, 
							"Your current location is \n" + location.getAddress(),
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}
