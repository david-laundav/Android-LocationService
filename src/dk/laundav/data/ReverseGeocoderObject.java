package dk.laundav.data;

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
