class Person {
	int ID;
	String name;
	double balance;
	Person(int ID, String name, double balance) {
		this.ID = ID;
		this.name = name;
		this.balance = balance;
	}
	public void display() {
		System.out.println(ID + " " + name + " " + balance);
	}
}

class node {
	Person info;
	node left;
	node right;
	node(Person info) {
		this.info = info;
		left = null;
		right = null;
	}
}
public class BST {
	node root;
	public BST() {
		root = null;
	}
	
	public void insert(Person val) {
		node p = new node(val);
		
		//if the tree is empty
		if (root == null) {
			root = p;
		}
		else {
			node current = root;
			node parent = null;
			
			//insert in left subtree
			while(true) {
				parent = current;
				if (val.ID < current.info.ID) { 
					current = current.left;
					if (current == null) {
						parent.left = p;
						return;
					}
				}
				//insert in right subtree
				else {
					current = current.right;
					if (current == null) {
						parent.right = p;
						return;
					}
				}
			}
		}
	}
	
	public void displayInorder(node p) {
		if (p != null) {
			displayInorder(p.left);
			p.info.display();
			displayInorder(p.right);
		}
	}
	
	public void displayPostOrder(node p) {
		if (p != null) {
			displayInorder(p.left);
			displayInorder(p.right);
			System.out.print(p.info + "-->");
		}
	}
	
	public void displayPreOrder(node p) {
		if (p != null) {
			System.out.print(p.info + "-->");
			displayInorder(p.left);
			displayInorder(p.right);
		}
	}
	
	public int countNodes(node p) {
		if (p == null) {
			return 0;
		}
		//1 including root node
		else {
			return 1 + countNodes(p.left) + countNodes(p.right);
		}
	}
	
	public void displaySideway(node p, int s) {
		if (p != null) {
			displaySideway(p.right, s + 5);
			for (int i = 1; i < 5; i++) {
				System.out.print(" ");
			}
			
			System.out.println(p.info);
			displaySideway(p.left, s);
		}
	}
	
	
	//traverse tree to find the node
	public node getInfo(node p, int ID) {
		if (p != null) {
			if (p.info.ID == ID) {
				return p;
			}
			else {
				node q = getInfo(p.left, ID);
				if (q == null) {
					q = getInfo(p.right, ID);
				}
				return q;
			}
		}
		else {
			return null;
		}
	}
	
	public int countHeight(node p) {
		if (p == null) {
			return 0;
		}
		else {
			return 1 + max(countHeight(p.left), countHeight(p.right));
		}
	}
	
	public static int max(int a, int b) {
		if (a > b) {
			return a;
		}
		else {
			return b;
		}
	}	
}
