import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		String input = " ";
		String repeat;
		Scanner read = new Scanner(System.in);
		char [] arr;
		LinkedList list = new LinkedList();
	
		
		do {
			System.out.print("Enter a phrase");
			
			input = read.nextLine();
			arr = input.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				list.insertQueue(arr[i]);
				list.insertStack(arr[i]);
			}
			
			list.deleteWhiteSpace();
			list.display(list.queue);
			list.display(list.stack);
			
			
			
			if (list.isEquals(list.stack, list.queue) == true) {
				System.out.println("It's a palindrome");
			}
			else {
				System.out.println("Its not a palindrome");
			}
			System.out.print("Continue?(y/n)");
			
			repeat = read.nextLine();
			
			list.deleteQueue();
			list.deleteStack();
			
			
		} while (repeat != "y");
		
		
		read.close();
	}
}
