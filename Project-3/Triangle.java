/*Angelo Salac, Arianne Arcebal 
 *Project 3, part 4
 *  
 * Ray Ahmadnia
 * Due: 9/15/2016
 * 
 * Purpose: A triangle class to calculate the area and perimeter using the given formula
 */

public class Triangle {
	public static double computeArea(double a, double b, double c) {
		//create variables for area perimeter and the return answer
		double area, p, answer;
		
		p = computePerimeter(a, b, c); //compute perimeter using function
		answer = (p - a); //use the formula given
		answer *= (p - b);
		answer *= (p - c);
		answer *= p;
		area = Math.sqrt(answer);
		
		return area; //return the area
	}
		
	public static double computePerimeter(double a, double b, double c) { 
		double perimeter; //create perimeter variable
		
		perimeter = (a + b + c)/2.0; //compute using given formula
		return perimeter;  //return perimeter
	}
}
