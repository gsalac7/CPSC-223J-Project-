import java.util.Scanner;
import java.io.*;

public class Menu {
	public static void main(String [] args) { 
		run();	
	}
	
	public static void run() {
		Scanner read = new Scanner(System.in);
		String file = "C://Users/gsala_000/Desktop/data.txt";
		Hash table = new Hash();
		char choice;
		
		try {
			readData(file, table);
		} catch (IOException ex) {
			System.out.println("Error");
		}
		
		do {
			displayMenu();
			choice = read.next().charAt(0);
			if (choice == '1') {
				System.out.print("Enter your account number: ");
				int account;
				account = read.nextInt();
				
				table.display(account);
				
			}
			else if (choice == '2') {
				System.out.print("Enter your account number: ");
				int account;
				double amount;
				account = read.nextInt();
				System.out.print("Enter the amount to deposit: ");
				amount = read.nextDouble();
				
				table.deposit(account, amount);
			}
			else if (choice == '3') {
				System.out.print("Enter your account number: ");
				int account;
				double amount;
				account = read.nextInt();
				System.out.print("Enter the amount to depost: ");
				amount = read.nextDouble();
				
				table.withdraw(account, amount);
			}
			else if (choice == '4') {
				table.display();
			}
			else {
				System.out.print("Not an option");
			}
			System.out.print("Continue (y/n): ");
			choice = read.next().charAt(0);
		} while(choice == 'y');
			
		System.out.print("Goodbye");
		read.close();
	}
	
	public static void displayMenu() {
		System.out.println("--------Menu---------");
		System.out.println("1. Show my balance");
		System.out.println("2. Deposit in my account");
		System.out.println("3. Withdraw from my account");
		System.out.println("4. Show me all");
	}
	
	public static void readData(String fname, Hash table) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(fname));
		String line;
		int a;
		float d;
		Person i;
		
		while ((line = in.readLine()) != null) {
			String [] token = line.split(" ", 3);
			String name = token[1];
			a = Integer.parseInt(token[0]);
			d = Float.parseFloat(token[2]);
			i = new Person(a, name, d);
			table.insertHash(i);
		}		
		in.close();
	}	
}
