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

public class LocationObject extends AbstractLocationObject {
	
	private String city;
	
	public LocationObject() {
		super();
	}
	
	public LocationObject(double latitude, double longitude) {
		super(latitude, longitude);
	}
	
	public LocationObject(double latitude, double longitude, String address, String country) {
		super(latitude, longitude, address, country);
	}
	
	public LocationObject(double latitude, double longitude, String address, String country, String city)
	{
		super(latitude, longitude, address, country);
		setCity(city);
	}
	
	public void setLocation(String address, String country, String city) {
		setAddress(address);
		setCountry(country);
		setCity(city);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
