package entity;

/*
 * Author: Mohini Patil
 */

import java.util.*;

public class WeightedTotalStrategy extends TotalStrategy{

	Map<String, Double> GradeWeight;//Constructor
	
	public WeightedTotalStrategy() {
		GradeWeight = null;
		
	}
	
	public WeightedTotalStrategy(Map<String,Double>GivenWeight) {
		
		GradeWeight = GivenWeight; 
	}
	
	public double calculate(String key, List<Grade> grades) throws SizeException {
		double localW = 0.0;
		double Average = 0.0;
		TotalStrategy ts=new TotalStrategy();
		  if (grades.equals(null)) {
	           throw new SizeException("Map of weights given is null");
	       } else if(GradeWeight.isEmpty()) {
	           throw new SizeException("map of wieghts is empty. Size = 0");
	       }else {
	    	   
	    	Grade gradesTotal;
	    	//gradesTotal= ts.calculate("total", grades);
	           
			for(int i=0 ;i < grades.size(); i++) {
	               //if user's key exist in weight map, use key's weight accordingly.
	               if (grades.contains(grades.get(i).getKey())) {
	                   
	            	   localW = GradeWeight.get(grades.get(i).getKey());
	                   if (localW < 0.0)
	                   {
	                       localW = 0;
	                   }
	               }
	               //No weight = assume 1.0
	               else {      
	                   localW = 1.0;
	                   // Here missing class is used to obtain missing value
	               		}
	               
	               int missingGradeVal = 0;
	               double total = 0.0;
	               
	               //calculate average
	             /*  if (grades.get(i).getValaue() == 0.0) {
	            	   missingGradeVal = Missing.doubleValue(grades.get(i).getValaue());
	               } 
	               */
	               //Average = gradesTotal / grades;
	               
	               /*
	               // Total(Grade Value * weight) / weight  calculated
	               if (grades.get(i).getValaue() == 0.0) {
	                   Average += Missing.doubleValue(grades.get(i).getValaue());
	               } else {
	                   Average += grades.get(i).getValaue() * localW / localW;
	               }
	               */
	           }
			
			if (total == 0.0) {
				Average += Missing.doubleValue(total);
			}
			else {
			}
			Average += total* localW / localW;
	       }
	        /*  
			for(int i=0 ;i < grades.size(); i++) {
			Grade gradedTotal = new Grade(grades.get(i).getKey(),Average);
	           return gradedTotal;
	       }
	      */
			//change later!!
			
			return Average;
	
		
		
	}

	}}
