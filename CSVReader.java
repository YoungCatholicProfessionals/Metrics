import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Abstract class which readers of specific csvs can inherit from
 * All the functionality except parse is filled in. Parse will vary
 * per object
 */
public abstract class CSVReader<J> {
	Scanner scan;
	ArrayList<String> lines = new ArrayList<>();
	
	public CSVReader(String filename) {
		File file = new File(filename);
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void skipLine() {
		scan.nextLine();
	}
	
	protected void printFile() {
		scan.reset();
		while(scan.hasNext()) {
			System.out.println(scan.nextLine());
		}
	}
	/*
	 * goes through the file and returns a list of types
	 */
	ArrayList<J> getItems(){
		ArrayList<J> entries = new ArrayList<J>();
		skipLine();
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String editedLine = removeCommatedValues(line);
			J jitem = parseEntry(line);
			entries.add(jitem);
		}
		
		return entries;
	}
	
	/*
	 * Removes cells which themselves have commas e.g. a name "Wilks, John Sr." 
	 * becomes "Wilks John Sr."
	 */
	public String removeCommatedValues(String line) {
		String rv = "";
		// if it does not contain quotes, return it
		if(!line.contains("\"")) {
			return line;
		}
		//otherwise find the commas within the quotes and remove them
		else {
			boolean insideQuotes = false; // flag for tracking loc in a line.
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == '"') {
					insideQuotes = !insideQuotes; // flip the flag
				}
				// don't copy commas inside quotes or quotes
				if(insideQuotes && line.charAt(i) == ',' || line.charAt(i) == '"') {
					continue;
				}
				//do copy all other chars
				else {
					rv += line.charAt(i);
				}
			}
		}
		
		return rv;
	}

	/*
	 * Does the work of turning a line of data into an object
	 */
	protected abstract J parseEntry(String l);
	

}
