package day15.Demo12_Big_Decimal;

import java.math.BigDecimal;

/**
 * BigDeciaml is used for super accurate float number
 * @author patrickyu
 *
 */
public class Demo12_Big_Decimal {
	
	public static void main(String[] args) {
		/**
		 * BigDecimal support to construct a new object with float number in string
		 * just like the example as follow
		 */
		BigDecimal d1 = new BigDecimal("1.90823948019284902384901283094821384902381432");
		BigDecimal d2 = new BigDecimal("3.01793874912073849127384712074832107483974108");
		
		/**
		 * BigDecimal support math operations
		 * its return type is still a BigDecimal
		 */
		 BigDecimal d3 = d1.subtract(d2);
		 System.out.println(d3);
		 /**
		  * add()
		  * multiply()
		  * divide() : you might get infinite decimal, so you need to give it a limit
		  * subtract()
		  * 
		  * 
		  * divide()
		  * para1: divide by?
		  * para2: how many decimal you want to reserve?
		  * para3: how to round up your number?
		  */
		 d3 = d1.divide(d2,100,BigDecimal.ROUND_HALF_UP);
		 System.out.println(d3);
	}
	
}
