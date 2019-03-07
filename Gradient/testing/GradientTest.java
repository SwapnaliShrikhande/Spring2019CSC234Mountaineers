package testing;


import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

/*
 * Calculates midterm grades
 * @author Mohini Patil
 * */

import org.junit.jupiter.api.Test;

import src.app.Gradient;


class GradientTest {

	@Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
	
	@Test
	public void testMain1() {
        String [] args = {"20","18","5","15","20","20","20","0","5","10","15","80","75"};
        System.out.println("\n");
        Gradient.main(args);
    }
	@Test
	public void testMain2() {
        String [] args = {"20","20","20","20","20","20","20","20","20","20","20","100","100"};
        System.out.println("\n");
        Gradient.main(args);
    }
	@Test
	public void testMain3() {
        String [] args = {"10","10","5","15","5","20","20","0","0","10","15","60","45"};
        System.out.println("\n");
        Gradient.main(args);
    }
	@Test
	public void testMain4() {
        String [] args = {null,null,null,null,null,null,null,null,null,null,null,null,null};
        System.out.println("\n");
        Gradient.main(args);
    }
	@Test
	public void testMain5() {
        String [] args = {"NA","NA","NA","NA","NA","NA","NA","NA","NA","NA","NA","NA","NA"};
        System.out.println("\n");
        Gradient.main(args);
    }
	@Test
	public void testMain6() {
        String [] args = {"20","18","5","15","20","20","20","NA","5","10","15","80","75"};
        System.out.println("\n");
        Gradient.main(args);
    }
	@Test
	public void testMain7() {
        String [] args = {"20","18","5","15","NA","20","20","5","0","NA","15","NA","NA"};
        System.out.println("\n");
        Gradient.main(args);
    }
	@Test
	public void testMain8() {
        String [] args = {"NA","20","5","15","NA","NA","20","NA","0","NA","15","NA","NA"};
        System.out.println("\n");
        Gradient.main(args);
    }


}
