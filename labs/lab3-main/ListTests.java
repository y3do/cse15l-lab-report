import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class ListTests {

	
	@Test
	public void testCorrect() {
		List<String> result = new ArrayList<>();
		result.add("Test1");
		result.add("Test2");
		assertEquals(result, ListExamples.filter(result, null));
		
	}
}
