
public class Event {
	String eventName;
	String date;
	String attendeeName;
	String phoneNumber;
	Boolean attended;
	String email;
	
	public Event(String en, String ed, String an, String pn, Boolean att, String em) {
		eventName = en;
		date = ed;
		attendeeName = an;
		phoneNumber = pn;
		attended = att;
		email = em;
	}
	
	public String toString() {
		return eventName +","+ date +","+ attendeeName +","+ phoneNumber+","+attended+","+email;
	}
}
