package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import entity.Grade;
import entity.GradingStrategy;
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
		
		HashMap<String, Double> courseWeights = new HashMap<String, Double>();
		courseWeights.put("PAs",     0.4);
		courseWeights.put("HWs",     0.1);
		courseWeights.put("Midterm", 0.2);
		courseWeights.put("Final",   0.3);
		GradingStrategy courseStrategy = new WeightedTotalStrategy(courseWeights);

		List<Grade> summedGrades = new ArrayList<Grade>();
		summedGrades.add(new Grade("PAs", 93.0));
		summedGrades.add(new Grade("HWs", 50.0));
		summedGrades.add(new Grade("Midterm", 80.0));
		summedGrades.add(new Grade("Final", 75.0));
		assertEquals("Course Grade:  80.7", courseStrategy.calculate("Course Grade", summedGrades).toString());
	}
	@Test
	public void testOutput1() throws SizeException {
		HashMap<String, Double> courseWeights = new HashMap<String, Double>();
		WeightedTotalStrategy courseStrategy;
		courseStrategy = new WeightedTotalStrategy(courseWeights);
		List<Grade> summedGrades = new ArrayList<Grade>();
		summedGrades.add(new Grade("PAs", 93.0));
		summedGrades.add(new Grade("HWs", 50.0));
		summedGrades.add(new Grade("Midterm", 80.0));
		summedGrades.add(new Grade("Final", 75.0));
		assertEquals("Course Grade: 298.0", courseStrategy.calculate("Course Grade", summedGrades).toString());
	}
	@Test
	public void testOutput2() throws SizeException {
		HashMap<String, Double> courseWeights = new HashMap<String, Double>();
		courseWeights.put("PAs",     -0.4);
		courseWeights.put("HWs",     0.1);
		courseWeights.put("Midterm", 0.2);
		courseWeights.put("Final",   0.3);
		WeightedTotalStrategy courseStrategy;
		courseStrategy = new WeightedTotalStrategy(courseWeights);
		List<Grade> summedGrades = new ArrayList<Grade>();
		summedGrades.add(new Grade("PAs", 93.0));
		summedGrades.add(new Grade("HWs", 50.0));
		summedGrades.add(new Grade("Midterm", 80.0));
		summedGrades.add(new Grade("Final", 75.0));
		assertEquals("Course Grade:  43.5", courseStrategy.calculate("Course Grade", summedGrades).toString());
	}

}
