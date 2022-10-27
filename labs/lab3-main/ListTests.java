import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class ListTests {

	
//	@Test
//	public void testCorrect() {
//		List<String> result = new ArrayList<>();
//		result.add("Test1");
//		result.add("Test2");
//		assertEquals(result, ListExamples.filter(result, null));
//		
//	}
	
	@Test
	public void testLong() {
		List<String> original = new ArrayList<>();
		original.add("moreThanFour");
		original.add("no");
		original.add("noo");
		original.add("Yeeees");
		original.add("Yeeahs");
		List<String> expected = new ArrayList<>();
		expected.add("moreThanFour");
		expected.add("Yeeees");
		expected.add("Yeeahs");
		List<String> result = ListExamples.filter(original, new ListExamples());
		assertEquals(expected, result);
		
	}
}
