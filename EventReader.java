
public class EventReader extends CSVReader {

	public EventReader(String filename) {
		super(filename);
	}

	@Override
	protected Event parseEntry(String l) {
		String[] parts = l.split(",", -1); //normal split leaves off trailing blanks
		//System.out.println(parts.length);
		if(parts.length != 6) {
			System.out.println(l);
			for(int i = 0; i < parts.length; i++) {
				System.out.println(parts[i]);
			}
		}
		boolean attended = false;
		if(parts[4].equals("TRUE")) {
			attended = true;
		}
		return new Event(parts[0], parts[1],
				parts[2], parts[3], attended, parts[5]);
	}

}
