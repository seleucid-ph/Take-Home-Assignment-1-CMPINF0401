package application.box;

public class TimeFrame{
	private int hourStart;
	private int minuteStart;
	private int hourEnd;
	private int minuteEnd;
	
	//overloaded constructors
	//constructor with only hours, sets minutes to zerp
	public TimeFrame(int he, int hs) {
		
	}
	//constructor with hours and minutes, minutes are unchanged
	public TimeFrame(int he, int hs, int me, int ms) {
		
	}
	//getters
	public int getHourStart() {
		return hourStart;
	}
	
	public int getMinuteStart() {
		return minuteStart;
	}
	
	public int getHourEnd() {
		return hourEnd;
	}
	
	public int getMinuteEnd() {
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
	//public Boolean timeFrameMatch() {
		
	}
//}