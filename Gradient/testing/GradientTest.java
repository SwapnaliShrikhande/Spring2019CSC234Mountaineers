package testing;

/*
 * Calculates midterm grades
 * @author Mohini Patil
 * */

import org.junit.jupiter.api.Test;

import src.app.Gradient;


class GradientTest {

	@Test
	public void testMain() {
		Gradient G  = new Gradient();
        //String [] args = null;
        //exit.expectSystemExitWithStatus(1);
        Gradient.main(null);
    }
	@Test
	public void testMain2() {
		Gradient G  = new Gradient();
        String [] args = {"20","18","5","15","20","20","20","0","5","10","15","80","75"};
        Gradient.main(args);
    }
	
}
