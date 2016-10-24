import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		LinkedList [] sets = new LinkedList[3];
		sets[0] = new LinkedList();
		sets[1] = new LinkedList();
		sets[2] = new LinkedList();
		
		readData(sets);
		
		sets[0].remove();
		sets[1].remove();
		sets[2].remove();
		sets[2].remove();
		sets[2].removeDuplicates();
		
		System.out.print("Set A = ");
		sets[0].display();
		 
		System.out.print("Set B = ");
		sets[1].display(); 
		
		System.out.print("Set AUB = ");
		sets[2].display();
	}
	
	public static void readData(LinkedList[] sets) {
		Scanner read = new Scanner(System.in);
		int i;
		
		System.out.print("Enter positive numbers for set A(-1 to stop reading): ");
		do {
			i = read.nextInt();
			sets[0].insert(i);
			sets[2].insert(i);
		} while(i != -1);
		
		System.out.print("Enter positive numbers for set B(-1 to stop reading): ");
		do {
			i = read.nextInt();
			sets[1].insert(i);
			sets[2].insert(i);
		} while(i != -1);
		
	}
}

/*OutputEnter positive numbers for set A(-1 to stop reading): 9 2 7 3 -1
Enter positive numbers for set B(-1 to stop reading): 2 8 7 3 31 10 -1
Set A = 2-->3-->7-->9-->null
Set B = 2-->3-->7-->8-->10-->31-->null
Set AUB = 2-->3-->7-->8-->9-->10-->31-->null
*/
