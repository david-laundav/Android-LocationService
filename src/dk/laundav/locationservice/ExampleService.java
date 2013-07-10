package dk.laundav.locationservice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ExampleService extends Activity {
	
	private static Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_example_service);
		
		addListenerOnAddCurrentPositionToWP(getAppContext());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.example, menu);
		return true;
	}
	
	public void addListenerOnAddCurrentPositionToWP(final Context context) {

		TextView addCurrentPositionToWP = (TextView) findViewById(R.id.text);

		addCurrentPositionToWP.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				LocationObject location = LocationService.getLocation(context);
				if(location != null){
					Toast.makeText(
							context.getApplicationContext(), 
							"Added the following location: \n" + location.getAddress(),
							Toast.LENGTH_LONG).show();
				}
			}

		});

	}
	
	public static Context getAppContext() {
		return ExampleService.context;
	}

}
