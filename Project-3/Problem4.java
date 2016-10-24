/*Angelo Salac, Arianne Arcebal 
 *Project 3, part 4
 *  
 * Ray Ahmadnia
 * Due: 9/15/2016
 * 
 * Purpose: A class with the main function to test the triangle class
 */

import java.util.Scanner;

public class Problem4 {
	public static void main(String [] args) {
		double a, b, c;//create variables for the sides
		
		Scanner read = new Scanner(System.in);
		//ask user to input sides
		System.out.print("Enter sides a, b, and c "); 
		
		a = read.nextDouble();
		b = read.nextDouble();
		c = read.nextDouble();
		
		//calculate using methods of the created Tringle class
		System.out.printf("%8.2f", Triangle.computePerimeter(a, b, c));
		System.out.printf("%8.2f", Triangle.computeArea(a, b, c));
		
		read.close(); 
	}
}

/*Enter sides a, b, and c 3 5 6
7.00    7.48
*/
