
import static org.junit.Assert.*;

import org.junit.Test;

public class BubbleSortTest{
	private int[] input = new int[] {1,6,2,2,5};
	private int[] expected = new int[] {1,2,2,5,6};
	
	@Test
	public void test() {
		assertArrayEquals(this.expected, BubbleSort.BubbleSort(input));
	}
}
