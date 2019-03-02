
package entity;
import java.util.List;
import entity.Grade;

/*
 * Author: Anisha Desai
 * */

public class TotalStrategy implements GradingStrategy  {
	double total = 0.0;
	Grade grade;
	
	TotalStrategy(){
		
	}

	@Override
	public entity.Grade calculate(String key, List<entity.Grade> grades) throws SizeException {
		// TODO Auto-generated method stub
		
		switch(key) {
			case "total":
				for (int i = 0; i < grades.size(); i++) {
					total += grades.get(i).getValaue();	
				}
				new Grade(key, total);
				break;
		
			default:
				new Grade(key, 0.0);
				
		}
		
		return grade;
		
	}

}
