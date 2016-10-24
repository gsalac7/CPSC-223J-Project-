/* Arianne Arcebal, Angelo Salac
Project 8 Part 2
Ray Ahmadnia
Purpose: Use a tree data structure to Organize a list and access the info in the tree.
*/

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {	
		BST T = new BST();
		String fname = "C:/Users/gsala_000/Desktop/data.txt";
		Scanner read = new Scanner(System.in);
		
		try {
			readData(fname, T);
		} catch(IOException ex) {
			System.out.println("Error");
		}
		char choice;
		
		T.displayInorder(T.root);
		System.out.println();
		displayMenu();
		do {
			choice = read.next().charAt(0);
			if (choice == 'a') {
				int ID;
				double amount;
				System.out.print("Enter the ID: ");
				ID = read.nextInt();
				System.out.print("Enter the amount to deposit: ");
				amount = read.nextDouble();
				double balance = T.getInfo(T.root, ID).info.balance;
				String name = T.getInfo(T.root, ID).info.name;
				
				balance += amount;
				T.getInfo(T.root, ID).info.balance = balance;
				System.out.print(name);
				System.out.print(", your new balance is ");
				System.out.printf("%.2f", balance);
				System.out.println();
			}
			else if (choice == 'b') {
				int ID;
				double amount;
				System.out.print("Enter the ID: ");
				ID = read.nextInt();
				System.out.print("Enter the amount to withdraw: ");
				amount = read.nextDouble();
				double balance = T.getInfo(T.root, ID).info.balance;
				String name = T.getInfo(T.root, ID).info.name;
				
				balance -= amount;
				T.getInfo(T.root, ID).info.balance = balance;
				System.out.print(name);
				System.out.print(", your new balance is ");
				System.out.printf("%.2f", balance);
				System.out.println();
			}
			else if (choice == 'c') {
				int ID;
				System.out.print("Enter the ID to view the information: ");
				ID = read.nextInt();
				T.getInfo(T.root, ID).info.display();
			}
			
			System.out.print("Contnue(y/n): ");
			choice = read.next().charAt(0);
		} while (choice == 'y');
		
		T.displayInorder(T.root);
		
		read.close();
	} 
	
	public static void readData(String fname, BST T) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(fname));
		
		String line;
		while((line = in.readLine()) != null) {
			String [] token = line.split(" ", 3);
			int a = Integer.parseInt(token[0]);
			double b = Float.parseFloat(token[2]);
			String name = token[1];
			Person p = new Person(a, name, b);
			T.insert(p);
		}		
		in.close();
		
	}
	
	public static void displayMenu() {
		System.out.println("-----Menu-----");
		System.out.println("a. Enter ID number to deposit");
		System.out.println("b. Enter ID number to withdraw");
		System.out.println("c. Enter ID number to see your balance");
	}
}

/*
Output:
10   Richard_Nixon   777.77
20   Ronald_Reagan   999.25
30   Gerald_Ford     222.44
40   George_W_Bush   789.10
50   John_Smith      123.45
60   Barack_Obama    688.90
70   Bill_Clinton    456.78
90   George_Bush     793.22
-----Menu-----
a. Enter ID number to deposit
b. Enter ID number to withdraw
c. Enter ID number to see your balance
a
Enter the ID: 10
Enter the amount to deposit: 100
Richard_Nixon, your new balance is 877.77
Contnue(y/n): y
b
Enter the ID: 10
Enter the amount to withdraw: 200
Richard_Nixon, your new balance is 677.77
Contnue(y/n): y
c
Enter the ID to view the information: 10
10   Richard_Nixon   677.77
Contnue(y/n): n
10   Richard_Nixon   677.77
20   Ronald_Reagan   999.25
30   Gerald_Ford     222.44
40   George_W_Bush   789.10
50   John_Smith      123.45
60   Barack_Obama    688.90
70   Bill_Clinton    456.78
90   George_Bush     793.22
*/
