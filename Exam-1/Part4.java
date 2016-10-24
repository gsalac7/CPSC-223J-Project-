/* Angelo Salac
 * Ray Ahmadnia
 * Exam 1
 * Part 1
 * Purpose: Recursively calculate 3^2 + 3^3.... + 3^n for n = 15.
 */
public class Part4 {
	public static void main(String [] args) {
		int n = 15;
		
		System.out.println(threeToTheN(n));
	}
	
	public static int threeToTheN(int n) {
		//base case if n = 2, return 3^2
		if (n == 2) {
			return (int) Math.pow(3, n);
		}
		//recursively call itself otherwise
		else {
			return threeToTheN(n - 1) + (int)Math.pow(3, n);
		}
	}
}

//output: 21523356
