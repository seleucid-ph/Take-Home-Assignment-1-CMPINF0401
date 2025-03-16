package application.box;
/**
 * Class CommunityFoodOrg
 * author: June Noblitt
 * createdL 03/12/2025
 */
public class CommunityFoodOrg{
	private String id;
	private String name;
	private Location location;
	private String firstDayOpen;
	private String lastDayOpen;
	private TimeFrame timeOpen;
	private int weeklyVolunteersNeeded;
	private int weeklyVolunteerSignups;
	private boolean offersTransportation;
	
	//constructor
	public CommunityFoodOrg(String id, String name, Location location, String firstDayOpen, String lastDayOpen, TimeFrame timeOpen, int weeklyVolunteersNeeded, int weeklyVolunteerSignups, boolean offersTransportation){
		this.id = id;
		this.name = name;
		this.location = location;
		this.firstDayOpen = firstDayOpen;
		this.lastDayOpen = lastDayOpen;
		this.timeOpen = timeOpen;
		this.weeklyVolunteersNeeded = weeklyVolunteersNeeded;
		this.weeklyVolunteerSignups = weeklyVolunteerSignups;
		this.offersTransportation = offersTransportation;
		
	}
	
	public boolean offersTransportation() {
        return offersTransportation;
    }
	
//!!! in getters and setters remember to add if statements for constraints where needed
	//id get-set
	public String getId() {
		return id;
	}
	public void setId(String getId) {
		this.id = getId;
	}public String getName() { //name get-set
		return name;
	}public void setName(String getName) {
		this.name = getName;
	}
	
	public Location getLocation() { //location get-set
		return location;
	}public void setLocation(Location getLocation) {
		this.location = getLocation;
	}
	
	public String getFirstDayOpen() { //firstDayOpen get-set
		return firstDayOpen;
	}public void setFirstDayOpen(String getFirstDayOpen) {
		this.firstDayOpen = getFirstDayOpen;
	}
	
	public String getLastDayOpen() {//lastDayOpen get-set
		return lastDayOpen;
	}public void setLastDayOpen(String getLastDayOpen) {
		this.lastDayOpen = getLastDayOpen;
	}
	
	public TimeFrame getTimeOpen() { //timeOpen get-setters
		return timeOpen;
	}public void setTimeOpen(TimeFrame getTimeOpen) {
		this.timeOpen = getTimeOpen;
	}
	
	public int getWeeklyVolunteersNeeded() { //weeklyVolunteersNeeded get-set
		return weeklyVolunteersNeeded;
	}public void setWeeklyVolunteersNeeded(int getWeeklyVolunteersNeeded) {
		this.weeklyVolunteersNeeded = getWeeklyVolunteersNeeded;
		
	}public int getWeeklyVolunteerSignups() { //weeklyVolunteerSingups get set
		return weeklyVolunteerSignups;
	}public void setWeeklyVolunteerSignups(int getWeeklyVolunteerSignups) {
		this.weeklyVolunteerSignups = getWeeklyVolunteerSignups;
		if (this.weeklyVolunteerSignups > this.weeklyVolunteersNeeded) {
			this.weeklyVolunteerSignups = this.weeklyVolunteersNeeded;
		if (this.weeklyVolunteerSignups < 0) {
			this.weeklyVolunteerSignups = 0;
		}
		}
	}
	
	public boolean getOffersTransportation() { //offersTransportation get set
		return offersTransportation;
	}public void setOffersTransportation(boolean getOffersTransportation) {
		this.offersTransportation = getOffersTransportation;
	}
	
	//method which produces the number of volunteer slots still available in a week, so we do not refer the user to food banks or pantries which are not accepting more volunteers
	public int weeklyVolunteerSpotsLeft() {
		return this.weeklyVolunteersNeeded - this.weeklyVolunteerSignups;
	}
	
	//method which adds a new volunteer signup for CommunityFoodOrg
	public boolean signUpVolunteer() {
	if(this.weeklyVolunteersNeeded > this.weeklyVolunteerSignups) {
		this.weeklyVolunteerSignups += 1;
		return true;
	}else {
		return false;
	}}
	
	//method which removes a volunteer signup for CommunityFoodOrg
	public boolean cancelVolunteerSignup() {
		if(this.weeklyVolunteerSignups > 0) {
			this.weeklyVolunteerSignups -= 1;
			return true;
		}else {
			System.out.println("No volunteer has signed up yet");
			return false;
		}
	}
}