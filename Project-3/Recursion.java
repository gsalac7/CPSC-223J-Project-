/*Angelo Salac, Arianne Arcebal
 *Project 3
 * 
 * 
 * 
 */

import java.util.Scanner;

public class Recursion {
	public static void main(String [] args) {
		Scanner read = new Scanner(System.in);
		int n;
		n = read.nextInt();
		
		System.out.print(recursion(n));
		
		read.close();
		
	}
	public static int recursion(int n) {
		if (n == 3) {
			return (int) Math.pow(3, n);
		}
		else {
			return (int) Math.pow(3, n) + recursion(n - 1);
		}
	}
}
