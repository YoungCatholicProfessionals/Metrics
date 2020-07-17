import static org.junit.Assert.*;

import org.junit.Test;

public class CommaRemoverTests {
	PeopleReader pr = new PeopleReader("/Users/justin/Google Drive File Stream/My Drive/Metrics Project/Test Data/people-metrics-table_2020_7_11_12_3.csv");
	@Test
	public void TestCommatedValues1() {
		String test = "6, hello, \"Mr, Don\", Dave";
		String desired = "6, hello, Mr Don, Dave";
		String actual = pr.removeCommatedValues(test);
		System.out.println(actual);
		assert(desired.equals(actual));
	}
	@Test
	public void TestCommatedValues2() {
		String test = "\"Mr, Don\", 6, \"hello\", Dave";
		String desired = "Mr Don, 6, hello, Dave";
		String actual = pr.removeCommatedValues(test);
		System.out.println(actual);
		assert(desired.equals(actual));
	}
}
