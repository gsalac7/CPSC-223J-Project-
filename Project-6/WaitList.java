import java.io.*;
import java.util.Scanner;

public class WaitList {
	public static void main(String [] args) {
		String fname = "C:\\Users\\gsala_000\\Desktop\\WaitingSheet.txt";
		List waitList = new List();
		
		try {
			readData(fname, waitList);
		} catch(IOException ex) {
			System.out.println("Error");
		}
		waitList.display();
		
		do {
			waitList.removeLowest();
			waitList.display();
			if (List.nodeCounter() == 1) {
				waitList.removeLowest();
				System.out.println("empty");
				break;
			}
		} while(waitList.isEmpty() != true);
	
		
		
		System.out.println("All served :)");
	}
	
	public static void readData(String fname, List list) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(fname));
		int i = 0;
		String line;
		while ((line = in.readLine()) != null) {
			String [] token = line.split(" ");
			Student s = new Student(token[0], Integer.parseInt(token[1]));
			list.insertQueue(s);
			i++;
		}
		
		in.close();
	}
}

/* output:
Bob, 10 --> Mary, 7 --> Bill, 5 --> Tom, 15 --> Jack, 3 --> null
Jack is served, now the queue is 
Bob, 10 --> Mary, 7 --> Bill, 5 --> Tom, 15 --> null
Bill is served, now the queue is 
Bob, 10 --> Mary, 7 --> Tom, 15 --> null
Mary is served, now the queue is 
Bob, 10 --> Tom, 15 --> null
Bob is served, now the queue is 
Tom, 15 --> null
Tom is served, now the queue is 
empty
All served :)
*/
