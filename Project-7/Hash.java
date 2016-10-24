public class Hash {
	node [] H = new node[5];
	public Hash() {
		for (int i = 0; i < H.length; i++) {
			H[i] = null;
		}
	}
	
	public int HashFun(int val) {
		return val%5;
	}
	
	//inserted as hash
	public void insertHash(Person val) {
		int i = HashFun(val.acc);
		node temp = new node(val);
		temp.next = H[i];
		H[i] = temp;
		
	}
	
	public void display(int accNum) {
		int i = HashFun(accNum);
		node p;
		
		//go to the key where the array is stored
		p = H[i];
		while(p.data.acc != accNum) { 
			p = p.next;
		}
		
		System.out.println(p.data.name + " your current balance is " + p.data.balance);
	}
	
	public void deposit(int accNum, double amount) {
		int i  = HashFun(accNum);
		node p = H[i];
		
		while (p.data.acc != accNum) {
			p = p.next;
		}
		
		p.data.balance += amount;
		H[i] = p;
		
		System.out.println("Your new balance is " + p.data.balance);
	}
	
	public void withdraw(int accNum, double amount) {
		int i = HashFun(accNum);
		node p = H[i];
		
		while (p.data.acc != accNum) {
			p = p.next;
		}
		
		p.data.balance -= amount;
		H[i] = p;
		
		System.out.println("Your new balance is " + p.data.balance);
	}
	
	public void display() {
		node p;
		for (int i = 0; i < 5;  i++) {
			p = H[i];
			while (p != null) {
				System.out.print("H[" + i + "] --> ");
				p.data.display();
				System.out.print("-->");
				p = p.next;
			}
			System.out.println("null");
		}
	}
	
}

class node {
	Person data;
	node next;
	node(Person data) {
		this.data = data;
		next = null;
	}
}

class Person {
	int acc;
	String name;
	float balance;
	Person(int acc, String name, float balance) {
		this.acc = acc;
		this.name = name;
		this.balance = balance;
	}
	void display() {
		System.out.print(acc + ", " + name + ", " + balance);
	}
}
