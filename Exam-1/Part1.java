/* Angelo Salac
 * Ray Ahmadnia
 * Exam 1
 * Part 1
 * Purpose: To create a program to practice addition and subtraction with numbers less than 100.
 */

import java.util.Scanner;

public class Part1 {
	public static void main(String [] args) {
		Scanner read = new Scanner(System.in);
		char choice;
		displayMenu();
		//user chooses what to practice
		choice = read.next().charAt(0);
		
		//goes to addition if a
		if (choice == 'a') {
			addition();
		}
		//goes to subtraction if b
		else if (choice == 'b') {
			subtraction();
		}
		
		
		
		read.close();
	}
	//display the menu
	public static void displayMenu() {
		System.out.println("---------Menu---------");
		System.out.println("a. Addition");
		System.out.println("b. Subtraction");
		System.out.print("Enter your choice: ");
	}
	
	public static void addition() {
		Scanner read = new Scanner(System.in);
		int sum, answer;
		int correct = 0, wrong = 0;
		char repeat;
		
		do {
			int i = (int)(Math.random() * 100); //find random numbers up to 100
			int j = (int) (Math.random() * 100);
			sum = i + j; //puts them into the sum
			System.out.print(i + " + " + j + " = ");
			answer = read.nextInt();//gets user's answer
			if (answer == sum) { //checks if the answer is correct
				System.out.println("CORRECT");
				correct++;
			}
			else {
				System.out.println("WRONG");
				wrong++;
			}
			System.out.print("Continue(y/n)? ");
			repeat = read.next().charAt(0);
		} while(repeat == 'y');
		System.out.println("Number of correct answers: " + correct);//display the number of right and wrong answers
		System.out.println("Number of wrong answers: " + wrong);
		
	}
	
	public static void subtraction() {
		Scanner read = new Scanner(System.in);
		int difference, answer;
		int correct = 0, wrong = 0;
		char repeat;
		
		do {
			int i = (int)(Math.random() * 100);//finds random numbers
			int j = (int) (Math.random() * 100);
			difference = i - j; //puts them into the difference
			System.out.print(i + " - " + j + " = ");
			answer = read.nextInt();//user inputs his or her answer
			if (answer == difference) { //checks if the answer is correct
				System.out.println("CORRECT");
				correct++;
			}
			else {
				System.out.println("WRONG");
				wrong++;
			}
			System.out.print("Continue(y/n)? ");
			repeat = read.next().charAt(0);
		} while(repeat == 'y');
		System.out.println("Number of correct answers: " + correct);//display the number of right and wrong answers
		System.out.println("Number of wrong answers: " + wrong);
	}
}

/* Output:
---------Menu---------
a. Addition
b. Subtraction
Enter your choice: a
12 + 51 = 63
CORRECT
Continue(y/n)? y
1 + 23 = 24
CORRECT
Continue(y/n)? y
30 + 59 = 23
WRONG
Continue(y/n)? y
38 + 43 = 14
WRONG
Continue(y/n)? y
62 + 59 = 4
WRONG
Continue(y/n)? n
Number of correct answers: 2
Number of wrong answers: 3
*/
