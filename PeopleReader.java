
public class PeopleReader extends CSVReader {

	public PeopleReader(String filename) {
		super(filename);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see CSVReader#parseEntry(java.lang.String)
	 * A person csv should be FirstName, LastName, Email, Mobile, Industry, Status
	 */
	protected Person parseEntry(String l) {
		String[] parts = l.split(",", -1); //normal split leaves off trailing blanks
		//System.out.println(parts.length);
		Person person = new Person(parts[0], parts[1],
				parts[2], parts[3], parts[4], parts[5]);
		return person;
	}

}
