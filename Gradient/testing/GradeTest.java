package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Formatter;

import org.junit.jupiter.api.Test;

import entity.Grade;

/*
*Author: Behnam Salamati
*
*/

public class GradeTest {

	@Test
	public void testIllegalException() {
		Exception exception = assertThrows( IllegalArgumentException.class, () -> { Grade grade = new Grade(null, 9.0); } );
		assertTrue(exception.getMessage().equals("Key can't be null"));
	}
	@Test
	public void testIllegalException2() {
		Exception exception = assertThrows( IllegalArgumentException.class, () -> { Grade grade =new Grade("",9.0); } );
		assertTrue(exception.getMessage().equals("Key can't be null"));
	}
	@Test
	public void gradeConstructor() {
		Grade grade = new Grade("PA");
		assertEquals(0.0, grade.getValaue().doubleValue());
	}
	@Test
	public void gradeConstructor2() {
		Grade grade = new Grade("PA");
		assertEquals("PA", grade.getKey());
	}
	@Test
	public void toStringTest() {
		Grade grade = new Grade("HW",8.0);
		assertEquals("HW:   8.0",grade.toString());
	}
	@Test
	public void toStringTest2() {
		Grade grade = new Grade("PA",null);
		assertEquals("PA:  NA", grade.toString());
	}
	@Test
	public void compareC1() {
		Grade grade1 = new Grade("H.W",10.0);
		Grade grade2 = new Grade("H.W",null);
		assertEquals(-1,grade2.compareTo(grade1));
	}
	@Test
	public void compareC2() {
		Grade grade3 = new Grade("H.W",null);
		Grade grade4 = new Grade("H.W",null);
		assertEquals(0,grade3.compareTo(grade4));	
	}
	@Test
	public void compareC3() {
		Grade grade5 = new Grade("H.W",10.0);
		Grade grade6 = new Grade("H.W",null);
		assertEquals(1,grade5.compareTo(grade6));
	}
	@Test
	public void compareC4() {
		Grade grade5 = new Grade("H.W",10.0);
		Grade grade6 = new Grade("H.W",12.0);
		assertEquals(-1,grade5.compareTo(grade6));
	}
	

}
