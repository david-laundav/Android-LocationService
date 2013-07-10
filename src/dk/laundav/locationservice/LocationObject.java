package dk.laundav.locationservice;

public class LocationObject {
	private String address;
	private double latitude;
	private double longitude;

	public LocationObject() {
		
	}
	
	public LocationObject(String address, double latitude, double longitude) {
		setAddress(address);
		setLatitude(latitude);
		setLongitude(longitude);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
}
