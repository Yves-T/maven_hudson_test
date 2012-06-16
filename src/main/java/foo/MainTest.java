package foo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {

	@Test
	public void testMultiply() {
		foo.AppMain tester = new foo.AppMain();
		assertEquals("Result", 50, tester.multiply(10, 5));
	}
}
