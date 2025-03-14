package application.box;

public class Location{
		final public double EARTH_RADIUS = 3958.8;
		
		//value initializations
		private double latitude;
		private double longitude;
		private String address;
		private String city;
		private String state;
		private String zipCode;
		
		//constructor
		public Location(double lat, double lon, String address, String zipCode, String city, String state) {
			this.latitude = lat;
			this.longitude = lon;
			this.address = address;
			this.zipCode = zipCode;
			this.city = city;
			this.state = state;
		}
		
		//latitude get-set
		public double getLatitude() {
			return latitude;
		}
		public void setLatitude(double getLatitude) {
			this.latitude = getLatitude;
		}
		
		//longitude get-set
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double getLongitude) {
			this.longitude = getLongitude;
		}
		
		//address get-set
		public String getAddress() {
			return address;
		}
		public void setAddress(String getAddress) {
			this.address = getAddress;
		}
		
		//city get-set
		public String getCity() {
			return city;
		}
		public void setCity(String getCity) {
			this.city = getCity;
		}
		
		//state get-set
		public String getState() {
			return state;
		}
		public void setState(String getState) {
			this.state = getState;
		}
		//zipCode get set
		
		public String getZipCode() {
			return zipCode;
		}
		public void setZipCode(String getZipCode) {
			this.zipCode = getZipCode;
		}
		
		//distance method
		public double distance(Location loc) {
			//setting values for lats and lons
			double lat1 = Math.toRadians(this.latitude);
			double lon1 = Math.toRadians(this.longitude);
			double lat2 = Math.toRadians(loc.getLatitude());
			double lon2 = Math.toRadians(loc.getLongitude());
			
			// setting values for the difference of lats and lons
			double dLon = lon2 - lon1;
			double dLat = lat2 - lat1;
			
			//setting value for a
			double a = Math.pow(Math.sin(dLat/2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon/2), 2);
			
			//setting value for c
			double c = 2* Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
			
			//calculating distance
			double distance = EARTH_RADIUS * c;
			return distance;
		}
}