package entity;

import java.util.List;
import java.util.Map;

/*
 * Calculates midterm grades
 * @author Mohini Patil, Swapnali Shrikhande
 * @datecreated 3rd March 2019
 * */
public class WeightedTotalStrategy implements GradingStrategy   {
	List<Grade> managedGrade;
	Map<String, Double> courseWeights;
	Grade individualGrade;
	Double weightedTotal = 0.0, weightage = 0.0;
	
	public WeightedTotalStrategy() {
		//initialize courseWeights map to null
		courseWeights = null;
	}
	
	public WeightedTotalStrategy(Map<String, Double> weights) {
		courseWeights = weights;
	}
	
	/*
	 * calculates grades total of list of Grade objects passed
	 * @referenceDoc Glossary_Gradient.pdf
	 * @weightedtotal = summation ()
	 * @param key = course grade, PAs, HWs
	 * @return Grade = key (course grade, PAs, HWs), corresponding WEIGHTED total grade
	 * throws SizeException
	 * */
	public Grade calculate(String key, List<Grade> grade) throws SizeException {
		managedGrade = grade;
		
		//handle grade cases
		if (grade == null || grade.size() == 0) throw new SizeException("WeightedTotalStrategy passed null or empty grade object");
		
		//calculate weighted total
		for (int i = 0; i < grade.size(); i++) {
			individualGrade = grade.get(i);
			
			//courseWeights null checks
			if (courseWeights != null || individualGrade.getKey() != null) {
				if (courseWeights.get(individualGrade.getKey()) == null)
					weightage = 1.0;
				else if (weightage < 0.0) 
					weightage = 0.0;
				else
					weightage = courseWeights.get(individualGrade.getKey());
			}
			
			weightedTotal += (Missing.doubleValue(individualGrade.getValaue())) * (weightage);
		}
		
		//return the weightedTotal grade
		return new Grade(key, weightedTotal);
	}
}