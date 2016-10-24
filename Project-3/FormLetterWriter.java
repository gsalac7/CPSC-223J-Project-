/*Angelo Salac, Arianne Arcebal 
 *Project 3, part 2
 *  
 * Ray Ahmadnia
 * Due: 9/15/2016
 * 
 * Purpose: Program that addresses a person based on their name and gender
 */

import java.util.Scanner;

public class FormLetterWriter {
	public static void main(String [] args) { 
		//Create variables for names and gender character
		Scanner read = new Scanner(System.in);
		String firstName, lastName;
		char gender;
		
		//ask user to input their name and gender
		System.out.print("Enter your last name and gender: ");
		lastName = read.next();
		gender = read.next().charAt(0);
		displaySalutation(lastName, gender); //display message based on name and gender
		
		System.out.println();
		
		//ask user to input name and last name
		System.out.print("Enter your last name then first name: ");
		lastName = read.next();
		firstName = read.next();
		displaySalutation(firstName, lastName); //display message based on name and last name
		
		read.close();
		
	}
	
	public static void displaySalutation(String lastName, char gender) {
		if (gender == 'f') { //if user is female go to mrs.
			System.out.println("Dear Mrs. " + lastName);
			System.out.print("Thank you for your order. ");
		}
		else if (gender == 'm') { //if user is male go to mr.
			System.out.println("Dear Mr. " + lastName);
			System.out.print("Thank you for your order. ");
		}
	}
	
	public static void displaySalutation(String firstName, String lastName) {
		System.out.println("Dear " + firstName + " " + lastName); //user parameters to display first and last name
		System.out.print("Thank you for your order. ");
	}
}

/*output:
Enter your last name and gender: Salac m
Dear Mr. Salac
Thank you for your order. 
Enter your last name then first name: Salac Gabe
Dear Gabe Salac
Thank you for your order. 
*/
