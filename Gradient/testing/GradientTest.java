package testing;


/*
 * Calculates midterm grades
 * @author Mohini Patil
 * */

import org.junit.jupiter.api.Test;

import src.app.Gradient;


class GradientTest extends Gradient {

	
	@Test
	public void testMain2() {
        String [] args = {"20","18","5","15","20","20","20","0","5","10","15","80","75"};
        System.out.println("\n");
        Gradient.main(args);
    }
	@Test
	public void testMain3() {
        String [] args = {"20","18","5","15","20","20","20","0","5","10","15","80",null};
        System.out.println("\n");
        Gradient.main(args);
    }
	@Test
	public void testMain4() {
        String [] args = {"20","18","5","15","20","20","20","0","5","10","15","80","start"};
        System.out.println("\n");
        Gradient.main(args);
    }
	@Test
	public void testMain5() {
		String[] args = null;
		 System.out.println("\n");
        Gradient.main(args);
    }
}
