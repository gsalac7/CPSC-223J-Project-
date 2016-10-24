/* Angelo Salac, Arianne Arcebal
 * Ray Ahmadnia
 * Project 5
 * Due: 9/29/2016
 * Purpose: Class for a person storing a name, age, and gpa
 */
public class Person {
	private String name;
	private int age;
	private float gpa;
	
	Person(String n, int a, float g) {
		name = n;
		age = a;
		gpa = g;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public float getGpa() {
		return gpa;
	}
}
