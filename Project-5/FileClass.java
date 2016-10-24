/* Angelo Salac, Arianne Arcebal
 * Ray Ahmadnia
 * Project 5
 * Due: 9/29/2016
 * Purpose: Take data from a text file and store it into an array. Also has functions to calculate gpa and age functions and display array things. 
 */

import java.io.*;

public class FileClass {
	public static void main(String [] args) {
		Person [] a = new Person[6];
		
		String file = "C://Users/gsala_000/Desktop/data.txt";
		
		try {
			copyData(file, a);
		} catch(IOException Ex) {
			System.out.print("Error no file found");
		}
		
		display(a);
		
		display(computeAgeAverage(a), computeGPAAverage(a));
		
		display(a, computeGPAAverage(a));
	}
	
	//take data from the txt file and organize it into the array
	public static void copyData(String fname, Person [] a) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(fname));
		String line;
		int i = 0;
		int age;
		float gpa;
		while ((line = in.readLine()) != null) {
			String[] token = line.split(" ", 3);
			age = Integer.parseInt(token[1]);
			gpa = Float.parseFloat(token[2]); 
			a[i] = new Person(token[0], age, gpa);
			i++;
		}
		
		in.close();
	}
	
	//display the people who are only teenagers
	public static void display(Person[] a) {
		System.out.println("The teenagers are ");
		for (int i = 0; i < a.length; ++i) {
			if (a[i].getAge() >= 13 && a[i].getAge() <= 19) {
				System.out.println("Name: " + a[i].getName() + "\nAge: " + a[i].getAge() + "\nGPA: " + a[i].getGpa() + "\n");
				
			}
			else {
				continue;
			}
		}
	}
	
	//calculate and return the average age
	public static double computeAgeAverage(Person[] a)  { 
		double total = 0, average;
		for (int i = 0; i < a.length; ++i) {
			total += (double)a[i].getAge();
		}
		
		average = total/a.length;
		return average;
	}
	
	//calculate the average gpa and return the value
	public static double computeGPAAverage(Person [] a) {
		double total = 0, average;
		for (int i = 0; i < a.length; ++i) {
			total += (double)a[i].getGpa();
		}
		
		average = total/a.length;
		return average;
	}
	
	//display the age average and gpa average
	public static void display(double ageAverage, double GPAaverage) {
		System.out.printf("The average age is: %.2f",ageAverage);
		System.out.println();
		System.out.printf("The average GPA is: %.2f",GPAaverage);
		System.out.println();
	}
	
	//display the person array and the gpa average
	public static void display(Person [] a, double GpaAve)  {
		for (int i = 0; i < a.length; ++i) {
			System.out.println("Name: " + a[i].getName() + "\nAge: " + a[i].getAge() + "\nGPA: " + a[i].getGpa() + "\n");
		}
		
		System.out.printf("The average gpa is: %.2f", computeGPAAverage(a));
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			if (a[i].getGpa() < computeGPAAverage(a)) {
				continue;
			}
			else {
				System.out.print(a[i].getName() + ", ");
			}
		}
		
		System.out.print(" have an above average gpa");
	}	
}

/*Output
The teenagers are 
Name: Matthew
Age: 16
GPA: 3.1
Name: Kim
Age: 19
GPA: 1.9
The average age is: 20.33
The average GPA is: 2.43
Names	Ages	GPA
Name: Maria
Age: 21
GPA: 2.1
Name: Jeffery
Age: 20
GPA: 2.0
Name: Douglas
Age: 22
GPA: 3.1
Name: Matthew
Age: 16
GPA: 3.1
Name: Kim
Age: 19
GPA: 1.9
Name: Monique
Age: 24
GPA: 2.4
The average gpa is: 2.43
Douglas, Matthew,  have an above average gpa
 */
