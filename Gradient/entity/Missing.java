package entity;


/*
 * Author: Mohini Patil
 */

public class Missing{
	

	    private static double Missing_Value = 0.0;
	  
	   public static double doubleValue(Double number)
	   {
	       if(number == null)
	       {
	           
	           return Missing_Value;
	       }
	       else
	       {
	           return number *2;
	       }
	   }
	   public static double doubleValue(Double number, double missingValue)
	   {
	       if(number == null)	       {
	           return missingValue;
	       }
	       else
	       {
	           return missingValue * number;
	       }
	   }
	  
	}