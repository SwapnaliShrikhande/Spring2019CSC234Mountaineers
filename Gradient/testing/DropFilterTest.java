package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import entity.DropFilter;
import entity.Grade;
import entity.SizeException;

/*
*Author: Behnam Salamati
*
*/

class DropFilterTest {
	@Test
	public void testSizeExceptionNull() {
		List<Grade> grades = new ArrayList<Grade>();
		DropFilter dropFilter = new DropFilter();
		Exception exception = assertThrows( SizeException.class, () -> { dropFilter.apply(grades); } );
		assertEquals("grades passed to DropFilter null", exception.getMessage());
	}
	@Test
	public void testSizeExceptionNull2() {
		DropFilter dropFilter = new DropFilter();
		List<Grade> grades = null;
		Exception exception = assertThrows(SizeException.class, () -> dropFilter.apply(grades));
		assertEquals("grades passed to DropFilter null", exception.getMessage());
	}
	@Test
	public void testSizeExceptionOntwoArg() {
		List<Grade> grades = new ArrayList<Grade>();
		DropFilter dropFilterImpl = new DropFilter(true,true);
		Grade grade1 = new Grade("H.W", 10.0);
		Grade grade2 = new Grade("H.W", 11.0);
		grades.add(grade1);
		grades.add(grade1);
		Exception exception = assertThrows( SizeException.class, () -> { dropFilterImpl.apply(grades); } );
		assertEquals("grades list contains same number of elements that are to be dropped", exception.getMessage().toString());
	}

	@Test
	public void testSizeExceptionOne() {
		DropFilter dropFilter = new DropFilter();
		Grade grade1 = new Grade("H.W", 10.0);
		List<Grade> grades = new ArrayList<Grade>();
		grades.add(grade1);
		Exception exception = assertThrows( SizeException.class, () -> { dropFilter.apply(grades); } );
		assertEquals("grades list contains fewer elements than that are to be dropped", exception.getMessage());
	}

	@Test
	public void testEliminateLowest2() throws SizeException {
		DropFilter dropFilter = new DropFilter(true,false);
		List<Grade> grades;
		grades = new ArrayList<Grade>();
		Grade grade;
		double[] arr = new double[] {10.0,2.0,3.0,6.0,8.0,9.0};
		for (int i=0; i<6; i++) 
		{
			grade = new Grade("PA"+i, arr[i]);
			grades.add(grade);
		}
		assertEquals("[PA0:  10.0, PA2:   3.0, PA3:   6.0, PA4:   8.0, PA5:   9.0]", dropFilter.apply(grades).toString());
	}
	
	@Test
	public void testEliminateHighest() throws SizeException {
		DropFilter dropFilter = new DropFilter(false,true);
		List<Grade> grades;
		grades = new ArrayList<Grade>();
		Grade grade;
		double[] arr = new double[] {10.0,2.0,3.0,6.0,8.0,9.0};
		for (int i=0; i<6; i++) 
		{
			grade = new Grade("PA"+i, arr[i]);
			grades.add(grade);
		}
		assertEquals("[PA1:   2.0, PA2:   3.0, PA3:   6.0, PA4:   8.0, PA5:   9.0]", dropFilter.apply(grades).toString());
	}

}
