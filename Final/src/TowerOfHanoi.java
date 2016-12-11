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

public class TowerOfHanoi extends Applet implements ActionListener{
	
	//initial variables for interface
	Button start = new Button("Press to Start");
	Label enter = new Label("Enter the number of disks(<= 7)");
	TextField number = new TextField();
	
	
	boolean begin = false;
	Disk [] disks = new Disk[7];
	Stack [] height = new Stack[3];
	int xPos = 10;
	int yPos = 10;
	int diskWidthAdjust = 20;
	
	//static int [] height; //number of disks on a peg i starting peg 0
					//0 is 1st peg, 1 is 2nd peg, 2 is 3rd peg
	String num; //only for the action listener
	int numDisks; //used only to get the number of disks
	
	int topDisk = 0; //this will be used to find the top Disk number
	
	
	
	public void init() {
		//initialize applet with labels and buttons
		setLayout(null);
		resize(600, 250);
		
		//we assign the variables for each disk in its initial state, all in the first peg.
		for (int i = 0; i < 7; i++) {
			disks[i] = new Disk(10 + i * xPos, 175 - i * yPos, 130 - i * diskWidthAdjust, 10); 
		}
		
		
		height[0] = new Stack(0); //first peg
		height[1] = new Stack(0); //second peg
		height[2] = new Stack(0); //third peg
		
		
		begin = false;
		
		
		enter.setBounds(10, 10, 180, 20);	add(enter);
		number.setBounds(200, 10, 25, 20);	add(number);
		start.setBounds(260, 10, 80, 20);	add(start);
		
		start.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			num = number.getText().trim();	
			numDisks = Integer.parseInt(num);
			
			repaint();
			//start the tower of hanoi function catch block used because of the delay function
			try {
				begin = true;
				towerOfHanoi(numDisks, 0, 2, 1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	//initialize the pegs; first thing called when applet starts
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);
		g.fillRect(20, 190, 560, 10); //base
		g.fillRect(70, 60, 10, 150); //first peg
		g.fillRect(300, 60, 10, 150); //second peg
		g.fillRect(530, 60, 10, 150); //third peg
		
		
		drawInit(g);
		
		System.out.println(begin);
		
		System.out.println(height[0].height);
		//create the painting based on the input, starting with the biggest disk.
		if (begin == true) {
			height[0].changeHeight(numDisks);
			begin = false;
		}
	
	}	
	
	//draws the initial disks
	public void drawInit(Graphics g) {
		g.setColor(Color.RED);
		
		for (int i = 0; i < numDisks; i++) {
			g.fillRect(disks[i].xPos, disks[i].yPos, disks[i].width, 10);
			
		}
	}
	
	public void towerOfHanoi(int N, int from, int to, int temp) throws InterruptedException {
		//Thread.sleep(500);
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
		
		
		/* So here we might just cheap it out and try to do every possibility 
		 * like from peg 0 - peg 2 or peg 1 to peg 0 etc.
		 * ORRR we can do this the hard way and calculate the xPos and yPos
		 * We might just have to create the disk1 - disk7 each with its own widths, every disk 
		 * has the same height. Every disk has its own xPos and yPos.
		 * when we do that, we will then need to calculate the appropriate xPos for each..
		 * but how do we calculate the yPos????? hmmmmm...
		 * yPos is calculated based on the height of the pegs...
		 * 
		*/
		repaint();
		
		//the top disk is the disk number based on the height of the peg
		topDisk = height[from].height - 1;
		
		/*
		if (from == 0 && to == 1) { //adjust the new xPos
			disks[topDisk].from0to1(); //change xPos
			if (height[1].height == 0) { //adjusts the new yPos
				disks[topDisk].yPos = 175;
			} else if (height[1].height == 1) {
				disks[topDisk].yPos = 165;
			} else if (height[1].height == 2) {
				disks[topDisk].yPos = 155;
			} else if (height[1].height == 3) {
				disks[topDisk].yPos = 145;
			} else if (height[1].height == 4) {
				disks[topDisk].yPos = 135;
			} else if (height[1].height == 5) {
				disks[topDisk].yPos = 125;
			} else if (height[1].height == 6) {
				disks[topDisk].yPos = 115;
			}
		} else if (from == 1 && to == 2) {
			disks[topDisk].from1to2();
			if (height[2].height == 0) { //adjusts the new yPos
				disks[topDisk].yPos = 175;
			} else if (height[2].height == 1) {
				disks[topDisk].yPos = 165;
			} else if (height[2].height == 2) {
				disks[topDisk].yPos = 155;
			} else if (height[2].height == 3) {
				disks[topDisk].yPos = 145;
			} else if (height[2].height == 4) {
				disks[topDisk].yPos = 135;
			} else if (height[2].height == 5) {
				disks[topDisk].yPos = 125;
			} else if (height[2].height == 6) {
				disks[topDisk].yPos = 115;
			}
		} else if (from == 0 && to == 2) {
			disks[topDisk].from0to2();
			if (height[2].height == 0) { //adjusts the new yPos
				disks[topDisk].yPos = 175;
			} else if (height[2].height == 1) {
				disks[topDisk].yPos = 165;
			} else if (height[2].height == 2) {
				disks[topDisk].yPos = 155;
			} else if (height[2].height == 3) {
				disks[topDisk].yPos = 145;
			} else if (height[2].height == 4) {
				disks[topDisk].yPos = 135;
			} else if (height[2].height == 5) {
				disks[topDisk].yPos = 125;
			} else if (height[2].height == 6) {
				disks[topDisk].yPos = 115;
			}
		} else if (from == 1 && to == 0) {
			disks[topDisk].from1to0();
			if (height[0].height == 0) { //adjusts the new yPos
				disks[topDisk].yPos = 175;
			} else if (height[0].height == 1) {
				disks[topDisk].yPos = 165;
			} else if (height[0].height == 2) {
				disks[topDisk].yPos = 155;
			} else if (height[0].height == 3) {
				disks[topDisk].yPos = 145;
			} else if (height[0].height == 4) {
				disks[topDisk].yPos = 135;
			} else if (height[0].height == 5) {
				disks[topDisk].yPos = 125;
			} else if (height[0].height == 6) {
				disks[topDisk].yPos = 115;
			}
		} else if (from == 2 && to == 0) {
			disks[topDisk].from2to0();
			if (height[0].height == 0) { //adjusts the new yPos
				disks[topDisk].yPos = 175;
			} else if (height[0].height == 1) {
				disks[topDisk].yPos = 165;
			} else if (height[0].height == 2) {
				disks[topDisk].yPos = 155;
			} else if (height[0].height == 3) {
				disks[topDisk].yPos = 145;
			} else if (height[0].height == 4) {
				disks[topDisk].yPos = 135;
			} else if (height[0].height == 5) {
				disks[topDisk].yPos = 125;
			} else if (height[0].height == 6) {
				disks[topDisk].yPos = 115;
			}
		} else if (from == 2 && to == 1) {
			disks[topDisk].from2to1();
			if (height[1].height == 0) { //adjusts the new yPos
				disks[topDisk].yPos = 175;
			} else if (height[1].height == 1) {
				disks[topDisk].yPos = 165;
			} else if (height[1].height == 2) {
				disks[topDisk].yPos = 155;
			} else if (height[1].height == 3) {
				disks[topDisk].yPos = 145;
			} else if (height[1].height == 4) {
				disks[topDisk].yPos = 135;
			} else if (height[1].height == 5) {
				disks[topDisk].yPos = 125;
			} else if (height[1].height == 6) {
				disks[topDisk].yPos = 115;
			}
		}
			*/	
		repaint(); //redraw the frame
		
		System.out.println(from + "->" + to);
		///System.out.println(disks[topDisk].yPos + " " +disks[topDisk].xPos);
	}
	
	
	
}


class Disk {
	int width, height, xPos, yPos;
	
	Disk() {
		width = 100;
		height = 10;
	}
	
	Disk(int xPos, int yPos, int width, int height) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}
	
	/*change the horizontal position of the disks according to the pegs
	 * every peg is 230 pixels apart along x axis, y position is dependent
	 * on the height of the stack.
	 */
	void from1to2 () {this.xPos += 230;}
	void from0to1() {this.xPos += 230;}
	void from0to2() {this.xPos += 460;}
	void from1to0() {this.xPos -= 230;}
	void from2to0(){this.xPos -= 460;}
	void from2to1() {this.xPos -= 230;}
}

//stack represents pegs....display the height of pegs
class Stack {
	int height;
	Stack(int height) {
		this.height = height;
	}
	void push() {height += 1;}
	void pop() {height -=1;}
	void changeHeight(int height) {	this.height = height;}
}