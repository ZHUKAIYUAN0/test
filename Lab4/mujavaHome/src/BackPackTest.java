import static org.junit.Assert.*;

import org.junit.Test;

public class BackPackTest {
	private int input1 = 10;
	private int input2 = 3;
	private int[] input3 = new int[] {3,4,5};
	private int[] input4 = new int[] {4,5,6};
	
	
	@Test
	public void test() {
		assertArrayEquals(BackPack.BackPack_Solution(input1,input2,input3,input4), BackPack.BackPack_Solution(input1,input2,input3,input4));
	}
}
