import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		String peopleFile = "/Users/justin/Google Drive File Stream/My Drive/Metrics Project/Test Data/people-metrics-table_2020_7_11_12_3.csv";
		String eventFile = "/Users/justin/Google Drive File Stream/My Drive/Metrics Project/Test Data/metrics-attendee-table-v1_2020_7_11_12_14.csv";
		
		PeopleReader pr = new PeopleReader(peopleFile);
		EventReader er = new EventReader(eventFile);
		ArrayList<Person> people = pr.getItems();
		ArrayList<Event> events = er.getItems();
		printArrayList(people);
		printArrayList(events);
		
	}
	
	static public void printArrayList(ArrayList list){
		for(int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
