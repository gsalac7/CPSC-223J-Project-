import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {	
		displayMenu();
		BST T = new BST();
		String fname = "C:/Users/gsala_000/Desktop/data.txt";
		Scanner read = new Scanner(System.in);
		
		try {
			readData(fname, T);
		} catch(IOException ex) {
			System.out.println("Error");
		}
		char choice;
		
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
				System.out.println(name + " your new balance is " + balance);
			}
			else if (choice == 'b') {
				int ID;
				double amount;
				System.out.print("Enter the ID: ");
				ID = read.nextInt();
				System.out.print("Enter the amount to deposit: ");
				amount = read.nextDouble();
				double balance = T.getInfo(T.root, ID).info.balance;
				String name = T.getInfo(T.root, ID).info.name;
				
				balance -= amount;
				System.out.println(name + " your new balance is " + balance);
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
