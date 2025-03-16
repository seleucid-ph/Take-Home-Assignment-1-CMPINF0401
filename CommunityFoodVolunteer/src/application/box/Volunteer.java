package application.box;
/**
 * Class Volunteer
 * author: seleucidPh
 * created 03/14/2025
 */

public class Volunteer{
	private String id;
	private String fullName;
	private int age;
	private Location location;
	private String dayAvailable;
	private TimeFrame timeAvailable;
	private double distanceAvailable;
	private boolean needsTransportation;
	private CommunityFoodOrg orgVolunteering;
	
	//constructor
	public Volunteer(String id, String fullName, int age, Location location, String dayAvailable, TimeFrame timeAvailable, double distanceAvailable, boolean needsTransportation, CommunityFoodOrg orgVolunteering){
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.location = location;
		this.dayAvailable = dayAvailable;
		this.timeAvailable = timeAvailable;
		this.distanceAvailable = distanceAvailable;
		this.needsTransportation = needsTransportation;
		this.orgVolunteering = orgVolunteering;
	}
	
	//id get-set
	public String getId() {
		return id;
	}public void setId(String getId) {
		this.id = getId;
	}
	
	//fullName get-set
	public String getFullName() {
		return fullName;
	}public void setFullName(String getFullName) {
		this.fullName = getFullName;
	}
	
	//age get-get
	public int getAge() {
		if (age > 100 || age < 18) {
			age = 18;
		}
		return age;
		
	}public void setAge(int getAge) {
		this.age = getAge;
	}
	
	//location get-set
	public Location getLocation() {
		return location;
	}public void setLocation(Location getLocation) {
		this.location = getLocation;
	}
	
	//dayAvailable get-set
	public String getDayAvailable() {
		if(dayAvailable != "Monday" || dayAvailable != "Tuesday" || dayAvailable != "Wednesday" || dayAvailable != "Thursday" || dayAvailable != "Friday" || dayAvailable != "Saturday" || dayAvailable != "Sunday") {
			dayAvailable = "Monday";
		}
		return dayAvailable;
	}public void setDayAvailable(String getDayAvailable) {
		this.dayAvailable = getDayAvailable;
	}
	
	//timeAvailable get-set
	public TimeFrame getTimeAvailable() {
		return timeAvailable;
	}public void setTimeAvailable(TimeFrame getTimeAvailable) {
		this.timeAvailable = getTimeAvailable;
	}
	
	//distanceAvailable get-set
	public double getDistanceAvailable() {
		return distanceAvailable;
	}public void setDistanceAvailable(double getDistanceAvailable) {
		this.distanceAvailable = getDistanceAvailable;
	}
	
	//needsTransportation get-set
	public boolean getNeedsTransportation() {
		return needsTransportation;
	}public void setNeedsTransportation(boolean getNeedsTransportation) {
		this.needsTransportation = getNeedsTransportation;
	}
	
	//orgVolunteering get-set
	public CommunityFoodOrg getOrgVolunteering() {
		return orgVolunteering;
	}public void setOrgVolunteering(CommunityFoodOrg getOrgVolunteering) {
		this.orgVolunteering = getOrgVolunteering;
	}
	
	//methods
	//sign up method which adds a volunteer
	public boolean signUp(CommunityFoodOrg org){
		if (org == null) {
			System.out.println("Invalid organizaiton");
			return false;
		}
		
		//attempt signup
		boolean signUpSuccess = org.signUpVolunteer();
		
		if(signUpSuccess) {
			this.orgVolunteering = org;
			System.out.println("You've signed up!");
			return true;
		}else {
			System.out.println("Signup failed! Is the organization accepting new volunteers?");
			return false;
		}
	}
	
	//cancel sign up method
	public void cancelSignup(){
		if (orgVolunteering != null) {
			orgVolunteering.cancelVolunteerSignup();
			System.out.println("Canceled sign-up!");
			orgVolunteering = null;
		}else {
			System.out.println("No current volunteer sign-up to withdraw from.");
		}
	}
	 
	//opportunity checking / matching method
	public boolean orgMatch(CommunityFoodOrg org) {
		if(needsTransportation && !org.offersTransportation()) { //checks if transporation needs match
			return false;
		}
		if(!this.timeAvailable.timeFrameMatch(org.getTimeOpen())) { //checks if day/time availability match
			return false;
		}
		if(this.distanceAvailable < location.distance(org.getLocation())) {
			return false; //check reachable distance
		}
		return true;
	}
	
    }