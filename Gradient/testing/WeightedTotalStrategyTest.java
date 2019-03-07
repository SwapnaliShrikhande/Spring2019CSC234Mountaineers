package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import entity.Grade;
import entity.SizeException;
import entity.WeightedTotalStrategy;

class WeightedTotalStrategyTest {

	@Test
	public void testGradesListNull() {
		WeightedTotalStrategy weightedTotalStrategy = new WeightedTotalStrategy();
		List<Grade> grade = null;
		Exception exception = assertThrows(SizeException.class, () -> weightedTotalStrategy.calculate("Course Grade", grade));
		assertEquals("WeightedTotalStrategy passed null or empty grade object", exception.getMessage());
	}
	
	@Test
	public void testEmptyGradesList() {
		WeightedTotalStrategy weightedTotalStrategy = new WeightedTotalStrategy();
		List<Grade> grade = new ArrayList<Grade>();
		Exception exception = assertThrows(SizeException.class, () -> weightedTotalStrategy.calculate("Course Grade", grade));
		assertEquals("WeightedTotalStrategy passed null or empty grade object", exception.getMessage());
	}
	
	@Test
	public void testOutput() throws SizeException {
		WeightedTotalStrategy weightedTotalGrades = new WeightedTotalStrategy();
		Map<String, Double> courseWeights = null;
		
		List<Grade> summedGrades = new ArrayList<Grade>();
		summedGrades.add(new Grade("PAs", 93.0));
		summedGrades.add(new Grade("HWs", 50.0));
		summedGrades.add(new Grade("Midterm", 80.0));
		summedGrades.add(new Grade("Final", 75.0));
		
		assertEquals("Course Grade, 80.7", weightedTotalGrades.calculate("Course Grade", summedGrades).toString());
	}

}
