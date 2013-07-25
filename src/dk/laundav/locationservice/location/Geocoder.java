package dk.laundav.locationservice.location;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONException;

import dk.laundav.locationservice.parsing.JSONReader;

public class Geocoder {
	
	private static String url;
	private static HashMap<String, String> hashMap;
	private static Set<Entry<String, String>> set;
	private static Iterator<?> iterator;
	
	@SuppressWarnings("rawtypes")
	private static Map.Entry mapEntry;
	
	public static String addLocationToUrl(LocationObject location) {
		
	    url = 	"http://maps.googleapis.com/maps/api/geocode/json?latlng=" + 
	    		location.getLatitude() + 
	    		"," + 
	    		location.getLongitude() + 
	    		"&sensor=true";
	    
	    return url;

	}
	
	@SuppressWarnings("rawtypes")
	public static void setLocationContent(LocationObject location) {
		
		url = addLocationToUrl(location);

		try {
			
			hashMap = JSONReader.getAddressComponents(url);
			set = hashMap.entrySet();
			iterator = set.iterator();
			
			while (iterator.hasNext()) {
				mapEntry = (Map.Entry)iterator.next();
				System.out.println(mapEntry.getKey() + ": " + mapEntry.getValue());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
}
