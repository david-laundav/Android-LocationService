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

public class AbstractLocationObject {
	
	private double latitude;
	private double longitude;	
	private String address;
	private String country;
	
	public AbstractLocationObject() {
		
	}
	
	public AbstractLocationObject(double latitude, double longitude) { 
		setLatitude(latitude);
		setLongitude(longitude);
	}
	
	public AbstractLocationObject(double latitude, double longitude, String address, String country) {
		setLatitude(latitude);
		setLongitude(longitude);
		setAddress(address);
		setCountry(country);
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
