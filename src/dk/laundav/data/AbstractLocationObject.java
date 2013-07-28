package dk.laundav.data;

public abstract class AbstractLocationObject {
	
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
