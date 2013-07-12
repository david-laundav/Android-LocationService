package dk.laundav.locationservice;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ExampleService extends Activity {
	
	private Button getLocationButton;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_example_service);
		
		getLocation();
		
		listView = (ListView) findViewById(R.id.listView);
		
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
