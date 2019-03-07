package testing;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Author: Anisha Desai
 */

import org.junit.jupiter.api.Test;

import entity.Missing;

class MissingTest {

	@Test
	public void test() {
		assertEquals(0.0, Missing.doubleValue(null));
		
	}
	@Test
	public void test2() {
		assertEquals(2.0, Missing.doubleValue(2.0));
	}
	@Test
	public void test3() {
		assertEquals(3.0, Missing.doubleValue(null, 3.0));
	}
	@Test
	public void test4() {
		assertEquals(4.0,  Missing.doubleValue(4.0, 3.0));
	}
	
}
