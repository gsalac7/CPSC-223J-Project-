/* Angelo Salac
 * Ray Ahmadnia
 * Exam 1
 * Part 2
 * Purpose: Take names from a text file and put them into a String array then output them in alphabetical order then find one of the names in the array.
 */
import java.io.*;

public class Part2 {
	public static void main(String [] args) {
		String fname = "c://Users/gsalac7/Desktop/data.txt";
		//create a string array to store the names
		String [] names = new String[6];
		
		try {
			readData(fname, names);
		} catch(IOException ex) {
			System.out.println("Error");
		}
		
		System.out.println("These are the names in the data.txt file");
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		System.out.println();
		//alphabetically sort the names of the array
		java.util.Arrays.sort(names);
		System.out.println("These are the names in alphabetical order");
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		System.out.println();
		//use binary search to find a name in the list and his location
		if (java.util.Arrays.binarySearch(names, "Tran,Justin") < 0) {
			System.out.print("Tran,Justin is not in the list");
		}
		else {
			System.out.print("Tran,Justin is in the list. He is located in position " + (java.util.Arrays.binarySearch(names, "Tran,Justin") + 1));
		}
	}
	//reads the data from the file
	public static void readData(String fname, String[] n) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(fname));
		
		//reads in all the information from the file
		//no spaces in between the names in the file as given in the exam
		for (int i = 0; i < n.length; i++) {
			n[i] = in.readLine(); //reads in each line and stores the string into the array
		}
		
		in.close();
		
	}
}

/*output:
These are the names in the data.txt file
Medina,Christian
Tran,Justin
Rai,Varun
Vu,Tyler
Ho,Holly
Bui,Emily
These are the names in alphabetical order
Bui,Emily
Ho,Holly
Medina,Christian
Rai,Varun
Tran,Justin
Vu,Tyler
Tran,Justin is in the list. He is located in position 5
*/
