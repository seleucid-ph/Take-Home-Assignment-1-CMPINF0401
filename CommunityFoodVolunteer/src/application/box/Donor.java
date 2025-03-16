package application.box;
/**
 * Class Donor
 * author: seleucidPh
 * created 03/14/2025
 */
public class Donor{
	private String id;
	private String name;
	private Location location;
	private int donation;
	
	//constructor
	public Donor(String id, String name, Location location, int donation) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.donation = donation;
	}
	//id get-set
	public String getId() {
		return id;
	}public void setId(String getId) {
		this.id = getId;
	}
	
	//name get-set
	public String getName() {
		return name;
	}public void setName(String getName) {
		this.name = getName;
	}
	
	//location get set
	public Location getLocation() {
		return location;
	}public void setLocation(Location getLocation) {
		this.location = getLocation;
	}
	
	//donation get set
	public int getDonation() {
		return donation;
	}public void setDonation(int getDonation) {
		this.donation = getDonation;
	}
	
	//method
	//donation pick up method for when a volunteer picks up some amount of food
	public boolean donationPickUp(Volunteer volunteer, int donation) {
		//error conditions
		if (donation<=0) {
			System.out.println("You can't donate zero or less than zero food!");
			return false;
		}
		if (donation > this.donation) {
			System.out.println("Pickup failed: requested amount exceeds available donation");
			return false;
		}
		//pass condition
		this.donation -= donation;
		System.out.println("Successful pickup! "+donation+" pounds colected by volunteer!");
		System.out.println("Remaining donation amount: "+this.donation+" pounds.");
		return true;
	}
}