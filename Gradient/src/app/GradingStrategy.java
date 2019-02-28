package src.app;

import java.util.List;

import entity.Grade;
import entity.SizeException;

public interface GradingStrategy {
	
	Grade calculate(String key, List<Grade> grades) throws SizeException;
}
