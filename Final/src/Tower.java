/* Angelo Salac
 * Ray Ahmadnia
 * Final Exam part 3
 * 12/15/16
 * Purpose: Create the Tower of Hanoi
 */
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Tower extends Applet implements ActionListener{
	
	Button start = new Button("Press to Start");
	Label enter = new Label("Enter the number of disks(<= 7)");
	TextField number = new TextField();
	
	Graphics g;
	int diskWidth; //base width, is 100, subtracts by 10, up to 30.
	int diskHeight; //height is constant
	int xPos;
	int yPos;
		
	static Stack [] height = new Stack[3];
	
	//static int [] height; //number of disks on a peg i starting peg 0
					//0 is 1st peg, 1 is 2nd peg, 2 is 3rd peg
	String num; //only for the action listener
	int numDisks; //used only to get the number of disks
	
	
	public void init() {
		//initialize applet with labels and buttons
		setLayout(null);
		resize(600, 250);
		
		g = getGraphics();
		
		height[0] = new Stack(0); //3rd peg
		height[1] = new Stack(0); //first peg
		height[2] = new Stack(0); //second peg
		
		xPos = 0;
		yPos = 0;
		diskWidth = 100;
		diskHeight = 10;
		numDisks = 0;
		enter.setBounds(10, 10, 180, 20);	add(enter);
		number.setBounds(200, 10, 25, 20);	add(number);
		start.setBounds(260, 10, 80, 20);	add(start);
		
		start.addActionListener(this);
	}
	
	
	public void towerOfHanoi(int N, int from, int to, int temp) throws InterruptedException {
		if (N == 1) {
			moveTo(from, to);
		}
		else {
			towerOfHanoi(N - 1, from, temp, to);
			moveTo(from, to);
			towerOfHanoi(N - 1, temp, to, from);
		}
	}
	
	//change move to function move disks from 1st stack to the 3rd stack
	public void moveTo(int from, int to) throws InterruptedException {	
		/*TimeUnit.SECONDS.sleep((long) 0.2);
		System.out.println("Height of peg: " + from + " is " + height[from].disks); //initial height of peg 0
		height[from].pop();
		height[to].push();
		System.out.println("Height of peg: " + from + " is " + height[from].disks); //show the heights for each peg changing
		System.out.println("Height of peg: " + to + " is " + height[to].disks);
		*/
		
		height[from].pop();
		height[to].push();
		
		//to associate the peg numbers with disks, 
		//we will use the xPos, and yPos. 70 = 1st peg, 
		//300 = 2nd peg, 530 = 3rd peg
		
		
		if (from == 0) { //remove top disk, and add to the to peg
			g.clearRect(10 + 2 * xPos, 175 - 2 * yPos, 130 - 2 * diskWidth, 10);
		}
		
		
		//System.out.println(from + "->" + to);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			num = number.getText().trim();	
			numDisks = Integer.parseInt(num);
			xPos = 10; //adjust values of the position
			yPos = 10;
			
			height[0].changeHeight(numDisks); //change the height of the first peg
			height[1].changeHeight(0);
			height[2].changeHeight(0);
			
			diskWidth = 20; //change the disk's width to match the previous one accordingly
			repaint(); //repaint the picture to add the initial disks
			
			try {
				towerOfHanoi(numDisks, 0, 2, 1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	//initialize the pegs; first thing called when applet starts
	public void paint(Graphics ge) {
		ge.setColor(Color.BLUE);
		ge.fillRect(20, 190, 560, 10); //base
		ge.fillRect(70, 60, 10, 150); //first peg
		ge.fillRect(300, 60, 10, 150); //second peg
		ge.fillRect(530, 60, 10, 150); //third peg

		//create the painting based on the input, starting with the biggest disk.
		ge.setColor(Color.RED);
		for (int i = 0; i < numDisks; i++) { //numDisks is equal to the initial height.
			//xPos and yPos are to adjust the positions of every new disk
			//disk width shrinks the disk's size
			ge.fillRect(10 + i * xPos, 175 - i * yPos, 130 - i * diskWidth, 10);	
		}
	
		
	}
}

//stack represents pegs....display the height of pegs
class Stack {
	public int disks;

	Stack(int height) {
		disks = height;
	}
	
	void push() {
		disks += 1;
	}
	
	void pop() {
		disks -=1;
	}
	
	void changeHeight(int height) {
		disks = height;
	}
}
