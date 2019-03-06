package entity;

import java.util.List;

import entity.Grade;
import entity.SizeException;

/*
Author: Behnam Salamati

*/

public interface GradingStrategy {
	
	Grade calculate(String key, List<Grade> grades) throws SizeException;
}
