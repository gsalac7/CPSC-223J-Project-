/* Angelo Salac
 * Ray Ahmadnia
 * Exam 1
 * Part 1
 * Purpose: Store information in a class and find the oldest person and the lowest gpa person.
 */
public class Part3 {
	public static void main(String [] args) {
		//create an array of structures for person.
		Person [] name = new Person[6];
		//assign the people based on the given exam through constructors
		name[0] = new Person("Donavan", 33, 3.3);
		name[1] = new Person("Michael", 22, 2.2);
		name[2] = new Person("David", 17, 1.7);
		name[3] = new Person("Tevin", 34, 3.4);
		name[4] = new Person("Felipe", 27, 2.7);
		name[5] = new Person("Simin", 14, 1.4);
		
		//find oldest person function
		findOldest(name);
		
		//find lowest gpa function
		lowestGPA(name);
	}	
	
	public static void findOldest(Person[] n) {
		int max;
		max = n[0].getAge();
		//find the max age
		for (int i = 0; i < n.length; i++) {
			if (max < n[i].getAge()) {
				max = n[i].getAge();
			}
		}
		//once max age is found print the name
		for (int i = 0;i < n.length; i++) {
			if (max == n[i].getAge()) {
				System.out.println("The oldest person is " + n[i].getName());
				
			}
		}
	}
	public static void lowestGPA(Person []n) {
		double min;
		
		min = n[0].getGpa();
		//find the lowest gpa
		for (int i = 0; i < n.length; i++) {
			if (min > n[i].getGpa()) {
				min = n[i].getGpa();
			}
		}
		//once lowest gpa is founds output the name and age
		for (int i = 0; i < n.length; i++) {
			if (min == n[i].getGpa()) {
				System.out.println("The Person with the lowest gpa is " + n[i].getName() + " who is " + n[i].getAge() + " years old");
			}
		}
		
	}
}

//person class
class Person {
	//holds a string name, integer age, and double gpa
	String name;
	int age;
	double gpa;
	//constructor to assign variables in the class
	Person(String name, int age, double d) {
		this.name = name;
		this.age = age;
		this.gpa = d;
	}
	String getName() {
		return name;
	}
	int getAge() {
		return age;
	}
	double getGpa() {
		return gpa;
	}
}

/*output:
 * The oldest person is Tevin
The Person with the lowest gpa is Simin who is 14 years old
 */
