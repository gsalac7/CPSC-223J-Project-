public class List {
	static node queue;
	List() {
		queue = null;
	}
	
	public void insertQueue(Student value) {
		node temp = new node(value);
		node p;
		if (queue == null) {
			queue = temp;
		} 
		else {
			p = queue;
			while (p.next != null) {
				p = p.next;
			} 
			p.next = temp;
		}
	}	
	
	public void removeLowest() {
		node p = queue;
		int min = p.info.time;
		//find minimum
		while (p != null) {
			if (min > p.info.time) {
				min = p.info.time;
			}
			p = p.next;
		}
		
		p = queue;
		//traverse the array to find that minimum
		while (p != null) {
			if (min == p.info.time) {
				System.out.println(p.info.name + " is served, now the queue is ");
				
				if (p.next != null) {
					p.info = p.next.info;
					p.next = p.next.next;
					
				}
				else if (List.nodeCounter() == 1) {
					queue = null;
				}
				else if (p.next == null){
					p = queue;
					while(p != null) {
						if (p.next.next == null) {
							p.next = null;
							
						}
						p = p.next;
					}
				}
				break;
			}
			p = p.next;
		}		
		
		p = queue;
	}
	
	public static int nodeCounter() {
		node p = queue;
		int counter = 0;
		while (p != null) {
			counter++;
			p = p.next;
		}
		return counter;
	}
	
	public void display() {
		node p = queue;
		
		while (p != null) {
			p.info.display();
			System.out.print("--> ");
			p = p.next;
		}
		
		System.out.println("null");
	}
	
	public boolean isEmpty() {
		if (queue == null) {
			return true;
		}
		return false;
	}
	
}
	
class node {
	Student info;
	node next;
	public node (Student val) {
		info = val;
		next = null;
	}	
}

class Student {
	String name;
	int time;
	Student(String name, int time) {
		this.name = name;
		this.time = time;
	}
	void display() {
		System.out.print(this.name + ", " + this.time + " ");
	}
}
