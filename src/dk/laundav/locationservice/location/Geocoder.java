package dk.laundav.locationservice.location;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONException;

import dk.laundav.locationservice.parsing.JSONReader;

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
