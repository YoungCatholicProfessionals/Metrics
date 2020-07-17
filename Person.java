
public class Person {
	String firstName;
	String lastName;
	String email;
	String mobile;
	String industry;
	String status;
	
	public Person(String fn, String ln, String em, String mob, String ind, String stat) {
		firstName = fn;
		lastName = ln;
		email = em;
		mobile = mob;
		industry = ind;
		status = stat;
	}
	
	public String toString() {
		return firstName +","+ lastName +","+ email +","+ mobile+","+industry+","+status;
	}
	

}
