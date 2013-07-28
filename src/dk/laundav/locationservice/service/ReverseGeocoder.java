package dk.laundav.locationservice.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dk.laundav.data.AbstractLocationObject;
import dk.laundav.data.LocationObject;
import dk.laundav.data.ReverseGeocoderObject;

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

/*
 * References:
 * 		
 * 		JSONReader:
 * 		http://stackoverflow.com/a/4308662/2399772
 * 
 * 		Parsing JSON:
 * 		http://stackoverflow.com/a/11875002/2399772
 */

public class ReverseGeocoder {
	
	private static String readAll(Reader rd) throws IOException {
		
		int cp;
		StringBuilder sb = new StringBuilder();

		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		
		return sb.toString();
	}
	
	public static String addLocationToUrl(ReverseGeocoderObject location) {
		
		String latitude = String.format(Locale.US, "%.10f", location.getLatitude());
		String longitude = String.format(Locale.US, "%.10f", location.getLongitude());
		
	   String url = "http://maps.googleapis.com/maps/api/geocode/json?latlng=" + 
		    		longitude + 
		    		"," + 
		    		latitude + 
		    		"&sensor=true";
	   
	   System.out.println(url);
	    
	    return url;

	}

	public static JSONObject readJSONFromUrl(String url) throws IOException, JSONException {

		InputStream is = new URL(url).openStream();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(br);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} 

		finally {
			is.close();
		}
	}
	
	public static void getAddressComponents(String url, ReverseGeocoderObject location) throws IOException, JSONException { 
		
		JSONObject json = readJSONFromUrl(url);
		
		JSONArray resultsArray = json.getJSONArray("results");
		JSONObject jsonResult = resultsArray.getJSONObject(0);
		
		String formatted_address = jsonResult.getString("formatted_address");
		location.setAddress(formatted_address);

		// use this method to iterate through the list of components
		JSONArray addressComponentsArray = jsonResult.getJSONArray("address_components");
		
		for (int i = 0; i < addressComponentsArray.length(); i++) {
			JSONObject jsonAddressComponent = addressComponentsArray.getJSONObject(i);
			String value = jsonAddressComponent.getString("long_name");
			
			JSONArray typesArray = jsonAddressComponent.getJSONArray("types");
			String key = typesArray.getString(0);
			
			setAddressComponents(key, value, location);
			
		}
		
	}
	
	public static void setAddressComponents(String key, String value, ReverseGeocoderObject location) {
		
		// sets the content of the location object
		if (key.equals("administrative_area_level_2")) {
			location.setAdministrative_area_level_2(value);
		} else if (key.equals("administrative_area_level_1")) {
			location.setAdministrative_area_level_1(value);
		} else if (key.equals("route")) {
			location.setRoute(value);
		} else if (key.equals("postal_code")) {
			location.setPostal_code(value);
		} else if (key.equals("locality")) {
			location.setLocality(value);
		} else if (key.equals("street_number")) {
			location.setStreet_number(value);
		} else if (key.equals("sublocality")) {
			location.setSublocality(value);
		} else if (key.equals("country")) {
			location.setCountry(value);
		}
		
	}
	
	public static void setLocationContent(ReverseGeocoderObject location) {
		
		String url = addLocationToUrl(location);

		try {
			
			getAddressComponents(url, location);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

}