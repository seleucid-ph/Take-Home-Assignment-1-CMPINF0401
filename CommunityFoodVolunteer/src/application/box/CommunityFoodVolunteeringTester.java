package application.box;
/**
 * Class CommunityFoodVolunteeringTester
 * author: seleucidPh
 * created 03/14/2025
 */
public class CommunityFoodVolunteeringTester{
	public static void main(String[] args) {
	//location for org1+org2, latitude comes first then longitude then the strings
	Location location1 = new Location(40.433640,-79.961326,"370 Lawn St","Pittsburgh","Pennsylvania","15213"); //pantry 1
	Location location2 = new Location(40.462818,-79.921699, "6140 Station St","Pittsburgh","Pennsylvania","15206"); //pantry 2
	Location location3 = new Location(40.469427,-79.961661, "4053 Butler St","Pittsburgh","Pennsylvania","15201"); //Goldblum
	Location location4 = new Location(40.428266,-79.965285, "415 S 27th St","Pittsburgh","Pennsylvania","15203"); //Stern
	Location location5 = new Location(40.426989,-79.967410, "2628 E Carson St","Pittsburgh","Pennsylvania","15203"); //Aldi
	Location location6 = new Location(40.441920,-79.958749,"3610 5th Ave","Pittsburgh","Pennsylvania","15213"); //Raisin' Canes
	
	//time frame for org1+org2 ,starting hour and minute first
	TimeFrame timeFrame1 = new TimeFrame(3,0,18,0);
	TimeFrame timeFrame2 = new TimeFrame(9,0,17,0);
	TimeFrame timeFrame3 = new TimeFrame(8,30,12,30);
	TimeFrame timeFrame4 = new TimeFrame(-1,-1,-1,-1); //these should be reset to default values by setters in TimeFrame.java, I hope
	
	//first CommunityFoodOrg object
	CommunityFoodOrg org1 = new CommunityFoodOrg(
		"ORG001", //id
		"CHS Food Pantry", 	//name
		location1, 			//location
		"Wednesday", 		//firstDayOpen
		"Thursday", 		//lastDayOpen
		timeFrame1, 		//timeOpen
		100, 				//weeklyVolunteersNeeded
		20, 				//weeklyVolunteerSignups
		true 				//offersTransportation
		);
	
	//second CommunityFoodOrg object
	CommunityFoodOrg org2 = new CommunityFoodOrg(
		"ORG002", //id
		"412 Food Rescue", 	//name
		location2, 			//location
		"Monday", 		//firstDayOpen
		"Friday", 		//lastDayOpen
		timeFrame2, 		//timeOpen
		200, 				//weeklyVolunteersNeeded
		150, 				//weeklyVolunteerSignups
		false 				//offersTransportation
		);
	
	//first volunteer object
	Volunteer volunteer1 = new Volunteer(
		"VLN001", 				//id
		"Jeff Goldblum",		//name (sorry Jeff Goldblum I know you're not an object really :( )
		72,						//age
		location3,				//location
		"Tuesday",				//day available
		timeFrame3,				//time available
		300,					//distance available
		true,					//needs transportation
		org2					//volunteering org
		);
	
	//second volunteer object
	Volunteer volunteer2 = new Volunteer(
		"VLN002", 				//id
		"Beth Ostrosky Stern",	//name (sorry Beth Ostrosky Stern I know you're not an object really :( )
		52,						//age
		location4,				//location
		"Wednesday",			//day available
		timeFrame4,				//time available
		900,					//distance available
		false,					//needs transportation
		org1					//volunteering org
		);	
	
	//first donor object
	Donor donor1 = new Donor(
		"DNR001",		//id
		"Aldi",			//name
		location5,		//location
		2000			//donation amount
		);
	
	Donor donor2 = new Donor(
		"DNR002",					//id
		"Raisin' Canes",			//name
		location6,					//location
		500							//donation amount
		);
	
	
	System.out.println("(a)");
	//checking Jeff Goldblum's availability
	if(volunteer1.orgMatch(org1) == true) {
		System.out.println(volunteer1.getFullName()+" can volunteer with "+org1.getName()+"!");
	}else if(volunteer1.orgMatch(org1) == false){
		System.out.println(volunteer1.getFullName()+" cannot volunteer with "+org1.getName()+"!");
	}if(volunteer1.orgMatch(org2) == true) {
		System.out.println(volunteer1.getFullName()+" can volunteer with "+org2.getName()+"!");
	}else if(volunteer1.orgMatch(org2) == false){
		System.out.println(volunteer1.getFullName()+" cannot volunteer with "+org2.getName()+"!");
	}
	
	//checkig Beth Ostrosky Stern's availability
	if(volunteer2.orgMatch(org1) == true) {
		System.out.println(volunteer2.getFullName()+" can volunteer with "+org1.getName()+"!");
	}else if(volunteer2.orgMatch(org1) == false){
		System.out.println(volunteer2.getFullName()+" cannot volunteer with "+org1.getName()+"!");
	}if(volunteer2.orgMatch(org2) == true) {
		System.out.println(volunteer2.getFullName()+" can volunteer with "+org2.getName()+"!");
	}else if(volunteer2.orgMatch(org2) == false){
		System.out.println(volunteer2.getFullName()+" cannot volunteer with "+org2.getName()+"!");
	}
	
	
	System.out.println("(b)");
	//checking Jeff Goldblum's donor availability
	if(donor1.donationPickUp(volunteer1,20) == true) {
		System.out.println(volunteer1.getFullName()+" can pick up the donation from "+donor1.getName()+".");
	}else if(donor1.donationPickUp(volunteer1,20) == false){
		System.out.println(volunteer1.getFullName()+" cannot pick up the donation from "+donor1.getName()+".");
	}
	if(donor2.donationPickUp(volunteer1,20) == true) {
		System.out.println(volunteer1.getFullName()+" can pick up the donation from "+donor2.getName()+".");
	}else if(donor2.donationPickUp(volunteer1,20) == false){
		System.out.println(volunteer1.getFullName()+" cannot pick up the donation from "+donor2.getName()+".");
	}
	
	//checkig Beth Ostrosky Stern's donor availability
	if(donor1.donationPickUp(volunteer1,20) == true) {
		System.out.println(volunteer1.getFullName()+" can pick up the donation from "+donor1.getName()+".");
	}else if(donor1.donationPickUp(volunteer1,20) == false){
		System.out.println(volunteer1.getFullName()+" cannot pick up the donation from "+donor1.getName()+".");
	}
	if(donor2.donationPickUp(volunteer2,20) == true) {
		System.out.println(volunteer2.getFullName()+" can pick up the donation from "+donor2.getName()+".");
	}else if(donor2.donationPickUp(volunteer2,20) == false){
		System.out.println(volunteer2.getFullName()+" cannot pick up the donation from "+donor2.getName()+".");
	}
	
	System.out.println("(c)");
	volunteer2.setDayAvailable("Friday");
	System.out.println("Repeating (a) as part of (c)");
	if(donor2.donationPickUp(volunteer1,20) == true) {
		System.out.println(volunteer1.getFullName()+" can pick up the donation from "+donor2.getName()+".");
	}else if(donor2.donationPickUp(volunteer1,20) == false){
		System.out.println(volunteer1.getFullName()+" cannot pick up the donation from "+donor2.getName()+".");
	}
	
	System.out.println("(d)");
	volunteer1.signUp(org1);
	volunteer2.signUp(org2);
	
	System.out.println("(e)");
	volunteer1.cancelSignup();
	}
}