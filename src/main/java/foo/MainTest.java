package foo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MainTest {

	@Test
	public void testMultiply() {
		AppMain tester = new AppMain();
		assertEquals("Result", 57, tester.multiply(10, 5));
	}

	@Test
	public void testForNul() {
		AppMain tester = new AppMain();
		assertNotNull("result", tester);
	}
}
