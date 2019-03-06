package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import entity.Grade;
import entity.SizeException;
import entity.TotalStrategy;

/*
*Author: Behnam Salamati
*
*/

class TotalStrategyTest {

	@Test
	public void testSizeException() {
		ArrayList<Grade> grades = new ArrayList<Grade>();
		TotalStrategy ts= new TotalStrategy();
		Exception exception = assertThrows( SizeException.class, () -> {  ts.calculate( "H.W" , grades); } );
		assertEquals("List cant be empty", exception.getMessage());
	}
	@Test
	public void testSizeException2() {
		List grades = null;
		TotalStrategy ts= new TotalStrategy();
		Exception exception = assertThrows( SizeException.class, () -> {  ts.calculate( "H.W" , grades ); } );
		assertEquals("List cant be empty", exception.getMessage());
	}
	@Test
	public void testTotal() throws SizeException {
		ArrayList<Grade> grades;
		grades = new ArrayList<Grade>();
		Grade grade;
		double[] arr = new double[] {1.0,2.0,3.0,6.0,7.0,9.0};
		for (int i=0; i<6; i++) 
		{
			grade = new Grade("PA"+i, arr[i]);
			grades.add(grade);
		}
		TotalStrategy ts= new TotalStrategy();
		assertEquals("PA:  28.0", ts.calculate("PA", grades).toString());
		}
}

