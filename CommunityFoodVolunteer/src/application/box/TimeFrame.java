package application.box;
/**
 * Class TimeFrame
 * author: June Noblitt
 * createdL 03/10/2025
 */
public class TimeFrame{
	private int hourStart;
	private int minuteStart;
	private int hourEnd;
	private int minuteEnd;
	
	//overloaded constructors
	//constructor with only hours, sets minutes to zerp
	public TimeFrame(int he, int hs, int ms) {
		this.hourStart = hs;
		this.hourEnd = he;
		this.minuteEnd = 0;
		this.minuteStart = 0;
	}
	//constructor with hours and minutes, minutes are unchanged
	public TimeFrame(int he, int hs, int me, int ms) {
		this.hourStart = hs;
		this.hourEnd = he;
		this.minuteStart = ms;
		this.minuteEnd = me;
	}
	//getters
	public int getHourStart() {
		if(hourStart > 23 || hourStart < 0) {
			hourStart = 8;
		}
		return hourStart;
	}
	
	public int getMinuteStart() {
		if(minuteStart > 59 || minuteStart < 0) {
			minuteStart = 0;
		}
		return minuteStart;
	}
	
	public int getHourEnd() {
		if(hourEnd > 23 || hourEnd < 0) {
			hourEnd = 8;
		}
		return hourEnd;
	}
	
	public int getMinuteEnd() {
		if(minuteEnd > 59 || minuteEnd < 0) {
			minuteEnd = 0;
		}
		return minuteEnd;
	}
	//setters
	public void setHourStart(int getHourStart) {
		this.hourStart = getHourStart;
	}
	
	public void setMinuteStart(int getMinuteStart) {
		this.minuteStart = getMinuteStart;
	}
	
	public void setHourEnd(int getHourEnd) {
		this.hourEnd = getHourEnd;
	}
	
	public void setMinuteEnd(int getMinuteEnd) {
		this.minuteEnd = getMinuteEnd;
	}
	//timeFrameMatch method
	//a is the available time
	public Boolean timeFrameMatch(TimeFrame time) {
		//convert time to minutes from midnight for user's available time
		int availableStart = this.hourStart * 60 + this.minuteStart;
		int availableEnd = this.hourEnd * 60 + this.minuteEnd;
		
		//convert time to minutes from midnight for the food pantry time
		int pantryStart = this.getHourStart() * 60 + time.getMinuteStart();
		int pantryEnd = this.getHourEnd() * 60 + time.getMinuteEnd();
		
		//checks if the start of pantry time is less than or equal to start of available time AND end of pantry time is greater than or equal to end of available time
		return (pantryStart <= availableStart && pantryEnd >= availableEnd);
		}
	}