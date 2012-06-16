package foo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTest {

	@Test
	public void testMultiply() {
		foo.Test tester = new foo.Test();
		assertEquals("Result", 50, tester.multiply(10, 5));
	}
}
