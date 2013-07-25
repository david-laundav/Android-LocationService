package dk.laundav.locationservice.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class JSONReader {

	private static int cp;
	private static String jsonText, type;
	private static JSONObject json, jsonResult, jsonAddressComponent;
	private static JSONArray resultsArray, addressComponentsArray, typesArray;
	private static StringBuilder sb;
	private static BufferedReader br;
	private static InputStream is;
	
	private static String readAll(Reader rd) throws IOException {
		
		sb = new StringBuilder();
		
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		
		return sb.toString();
	}

	public static JSONObject readJSONFromUrl(String url) throws IOException, JSONException {

		is = new URL(url).openStream();

		try {
			br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			jsonText = readAll(br);
			json = new JSONObject(jsonText);
			return json;
		} 

		finally {
			is.close();
		}
	}
	
	public static HashMap<String, String> getAddressComponents(String url) throws IOException, JSONException {
			
		json = readJSONFromUrl(url);
		HashMap<String, String> hm = new HashMap<String, String>();
		
		resultsArray = json.getJSONArray("results");
		jsonResult = resultsArray.getJSONObject(0);

		// use this method to iterate through the list of components
		addressComponentsArray = jsonResult.getJSONArray("address_components");
		
		for (int i = 0; i < addressComponentsArray.length(); i++) {
			jsonAddressComponent = addressComponentsArray.getJSONObject(i);
			String hm_value = jsonAddressComponent.getString("long_name");
			
			typesArray = jsonAddressComponent.getJSONArray("types");
			type = typesArray.getString(0);
			
			hm.put(type, hm_value);
				
		}
		
		return hm;
		
	}
	
	public static String getFormattedAddress(String url) throws IOException, JSONException {
		
		json = readJSONFromUrl(url);
		
		resultsArray = json.getJSONArray("results");
		jsonResult = resultsArray.getJSONObject(0);
		
		// use this method for finding the first formatted address string
		String formatted_address = jsonAddressComponent.getString("formatted_address");
		
		return formatted_address;
		
	}
}