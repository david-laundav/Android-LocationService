package dk.laundav.data;

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

public class ReverseGeocoderObject extends AbstractLocationObject {
	
	private String administrative_area_level_2;
	private String administrative_area_level_1;
	private String route;
	private String postal_code;
	private String locality;
	private String street_number;
	private String sublocality;
	
	public ReverseGeocoderObject() {
		super();
	}
	
	public ReverseGeocoderObject(double latitude, double longitude) {
		super(latitude, longitude);
	}

	public ReverseGeocoderObject(double latitude, double longitude, String address, String country) {
		super(latitude, longitude, country, country);
	}
	
	public ReverseGeocoderObject(double latitude, double longitude, String address, String country,
								String administrative_area_level_2, String administrative_area_level_1,
								String route, String postal_code, String locality, String street_number,
								String sublocality) {
		
		super(latitude, longitude, sublocality, sublocality);
		setAdministrative_area_level_2(administrative_area_level_2);
		setAdministrative_area_level_1(administrative_area_level_1);
		setRoute(route);
		setPostal_code(postal_code);
		setLocality(sublocality);
		setStreet_number(street_number);
		setSublocality(sublocality);
	}
	
	public void setAddressComponent(String key, String value) {
		
		// sets the content of the location object
		if (key.equals("administrative_area_level_2")) {
			setAdministrative_area_level_2(value);
		} else if (key.equals("administrative_area_level_1")) {
			setAdministrative_area_level_1(value);
		} else if (key.equals("route")) {
			setRoute(value);
		} else if (key.equals("postal_code")) {
			setPostal_code(value);
		} else if (key.equals("locality")) {
			setLocality(value);
		} else if (key.equals("street_number")) {
			setStreet_number(value);
		} else if (key.equals("sublocality")) {
			setSublocality(value);
		} else if (key.equals("country")) {
			setCountry(value);
		}
		
	}

	public String getAdministrative_area_level_2() {
		return administrative_area_level_2;
	}

	public void setAdministrative_area_level_2(
			String administrative_area_level_2) {
		this.administrative_area_level_2 = administrative_area_level_2;
	}

	public String getAdministrative_area_level_1() {
		return administrative_area_level_1;
	}

	public void setAdministrative_area_level_1(
			String administrative_area_level_1) {
		this.administrative_area_level_1 = administrative_area_level_1;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getStreet_number() {
		return street_number;
	}

	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	public String getSublocality() {
		return sublocality;
	}

	public void setSublocality(String sublocality) {
		this.sublocality = sublocality;
	}

}
