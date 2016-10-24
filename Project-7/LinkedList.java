public class LinkedList {	
	node ordered;
	LinkedList() {
		ordered = null;
	}
	
	public void insert(int val) {
		node temp = new node(val);
		node p,q;
		 p = q = ordered;
		while (p != null && p.data < val) {
			q = p;
			p = p.next;
		}
		
		if (p == ordered) {
			temp.next = p;
			ordered =temp;
		}
		else if (p == null) {
			q.next = temp;
		}
		else  {
			temp.next = p;
			q.next = temp;
		}
				
	}
	
	public int length() {
		node p = ordered;
		int count = 0;
		while (p != null) {
			count++;
			p = p.next;
		}
		
		return count;
	}
	
	public void removeDuplicates() {
		node p = ordered;
		while (p != null) {
			if (p.next == null) {
				break;
			}
			if (p.data == p.next.data) {
				p.next = p.next.next;
			}
			p = p.next;
		}
	}
	
	public void remove() {
		node p = ordered;
		p = p.next;
		ordered = p;
	}
	
	public void display() {
		node p = ordered;
		while (p != null) {
			System.out.print(p.data + "-->");
			p = p.next;
		}
		System.out.println("null");
	}
}

/*class node {
	int data;
	node next;
	node(int data) {
		this.data = data;
		next = null;
	}
}*/
