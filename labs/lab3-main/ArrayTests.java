import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
	@Test
	public void testReverseInPlace1() {
		int[] input1 = { 0 };
		ArrayExamples.reverseInPlace(input1);
		assertArrayEquals(new int[] {0}, input1);
	}

	@Test
	public void testReversed1() {
		int[] input1 = {0};
		assertArrayEquals(new int[] {0}, ArrayExamples.reversed(input1));
	}

	// MY METHODS------------------------------------------------------
	
	@Test
	public void testReverseInPlace2() {
		int[] input1 = {0, 1};
		ArrayExamples.reverseInPlace(input1);
		assertArrayEquals(new int[] {1, 0}, input1);
	}
	
	@Test
	public void testReverseInPlace3() {
		int[] input1 = {0, 1, 2};
		ArrayExamples.reverseInPlace(input1);
		assertArrayEquals(new int[] {2, 1, 0}, input1);
	}
	
	@Test
	public void testReverseInPlace4() {
		int[] input1 = {0, 1, 2, 3};
		ArrayExamples.reverseInPlace(input1);
		assertArrayEquals(new int[] {3, 2, 1, 0}, input1);
	}
	
	@Test
	public void testReversed2() {
		int[] input1 = {0, 1};
		assertArrayEquals(new int[] {1, 0}, ArrayExamples.reversed(input1));
	}
	
	@Test
	public void testReversed3() {
		int[] input1 = {0, 1, 2};
		assertArrayEquals(new int[] {2, 1, 0}, ArrayExamples.reversed(input1));
	}
	
	@Test
	public void testReversed4() {
		int[] input1 = {0, 1, 2, 3};
		assertArrayEquals(new int[] {3, 2, 1, 0}, ArrayExamples.reversed(input1));
	}
	
	@Test
	public void testAverageWithoutLowest1() {
		double[] input1 = {0, 1, 2, 0, 4, 5};
		assertEquals(3, ArrayExamples.averageWithoutLowest(input1), 0);
	}
	
}
