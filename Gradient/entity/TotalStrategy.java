
package entity;
import java.util.List;
import entity.Grade;

/*
 * Author: Anisha Desai
 * */

public class TotalStrategy implements GradingStrategy  {
	double total = 0.0;
	Grade grade;
	
	public TotalStrategy(){
		
	}

	@Override
	public Grade calculate(String key, List<entity.Grade> grades) throws SizeException {
		// TODO Auto-generated method stub
		double number;
		if(grades.equals(null) || grades.size()==0)
			throw new SizeException("List cant be empty");
		else {
				for (int i = 0; i < grades.size(); i++) {
					number=Missing.doubleValue(grades.get(i).getValaue());
						
					total += number;
				}
			grade =	new Grade(key, total);		
		}
		return grade;

		}
	}


