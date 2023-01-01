package icecream.model.event;

import java.sql.Date;

public class Event {
	private int eventCode;
	private String eventName;
	private Date eventStartTerm;
	private Date eventEndTerm;
	
	public int getEventCode() {
		return eventCode;
	}
	public void setEventCode(int eventCode) {
		this.eventCode = eventCode;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date getEventStartTerm() {
		return eventStartTerm;
	}
	public void setEventStartTerm(Date eventStartTerm) {
		this.eventStartTerm = eventStartTerm;
	}
	public Date getEventEndTerm() {
		return eventEndTerm;
	}
	public void setEventEndTerm(Date eventEndTerm) {
		this.eventEndTerm = eventEndTerm;
	}
	
	
}
