package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import entity.Grade;
import entity.SizeException;
import entity.WeightedTotalStrategy;

class WeightedTotalStrategyTest {

	@Test
	void testGradesListNull() {
		WeightedTotalStrategy weightedTotalStrategy = new WeightedTotalStrategy();
		List<Grade> grade = null;
		Exception exception = assertThrows(SizeException.class, () -> weightedTotalStrategy.calculate("Course Grade", grade));
		assertEquals("WeightedTotalStrategy passed null or empty grade object", exception.getMessage());
	}
	
	@Test
	void testEmptyGradesList() {
		WeightedTotalStrategy weightedTotalStrategy = new WeightedTotalStrategy();
		List<Grade> grade = new ArrayList<Grade>();
		Exception exception = assertThrows(SizeException.class, () -> weightedTotalStrategy.calculate("Course Grade", grade));
		assertEquals("WeightedTotalStrategy passed null or empty grade object", exception.getMessage());
	}

}
