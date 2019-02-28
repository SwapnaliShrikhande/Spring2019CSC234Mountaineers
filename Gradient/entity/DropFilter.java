package entity;

import java.util.List;

/*
 * Author: Swapnali Shrikhande
 * Date Created: 27th February 2019
 * */

public class DropFilter implements Filter {
	boolean shouldDropLowest;
	boolean shouldDropHighest;
	
	DropFilter() {}
	
	DropFilter(boolean shouldDropLowest, boolean shouldDropHighest) {}

	@Override
	public List<Grade> apply() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
