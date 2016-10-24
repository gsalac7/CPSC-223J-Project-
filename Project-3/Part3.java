/*Angelo Salac, Arianne Arcebal 
 *Project 3, part 3
 *  
 * Ray Ahmadnia
 * Due: 9/15/2016
 * 
 * Purpose: A program to compute books and its bill based on if theres a coupon or not
 */

import java.util.Scanner;

public class Part3{
	public static void main(String[] args){
		//create variables
		int quantity;
		char coupon, cont;
		double price, couponAmt = 0.0, total = 0.0;
		Scanner read = new Scanner(System.in);

		do {
			//ask user for the number of books
			//ask user for the price and for any coupons
			//user inputs information
			System.out.print("Enter the number of books: ");
			quantity = read.nextInt();
			System.out.print("Enter the price of each book: ");
			price = read.nextDouble();
			System.out.print("Any coupons?(y/n) ");
			coupon = read.next().charAt(0);
			//ask coupon discount
			if (coupon == 'Y' || coupon == 'y'){
				System.out.print("How much? ");
				couponAmt = read.nextDouble();
			}
			
			//calculate coupon if input is y
			if (coupon == 'y' || coupon == 'Y')
				total = Billing.computeBill(price, quantity, couponAmt);
			else if (coupon == 'n' || coupon == 'N')
				total = Billing.computeBill(price, quantity);
			
			//output total pay
			System.out.printf("Your total pay is %.2f\n", total);
			System.out.print("Continue?(y/n) ");
			cont = read.next().charAt(0);
		} while(cont == 'y' || cont == 'Y');
		
		read.close();
	}
}

class Billing{
	//method to compute the bill based on price
	static double computeBill(double price){
		return price + (price * 0.08);
	}
	//method to compute bill based on price and quantity
	static double computeBill(double price, int quantity){
		return computeBill(price) * quantity;
	}
	//methods to compute bill based on price, quantity, anc coupon discount

	static double computeBill(double price, int quantity, double coupon){
		return computeBill(price, quantity) - (computeBill(price, quantity) * coupon);
	}
}

/*output:
Enter the number of books: 5
Enter the price of each book: 23.66
Any coupons?(y/n) n
Your total pay is 127.76
Continue?(y/n) y
Enter the number of books: 5
Enter the price of each book: 23.66
Any coupons?(y/n) y
How much? 0.10
Your total pay is 114.99
Continue?(y/n) n
*/
