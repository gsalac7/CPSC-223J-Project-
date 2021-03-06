/* Angelo Salac
 * Ray Ahmadnia
 * Final Exam, Part 3
 * 12/15/16
 * Purpose: Tower of Hanoi animation.
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class TowerOfHanoi extends Applet implements ActionListener, Runnable{
	
	/* The way I built this program relied on the repaint function instantly 
	 * repainting the frame on each iteration of the recursive function.
	 * The x and y positions were calculated by the number of the peg, and 
	 * the height of the pegs respectively.  The new thread T, was made
	 * for multithreading purposes... The first thread would create the 
	 * interface and hold the paint function, but the T thread would call the function and
	 * would be able to repaint during the iteration.  Without the T thread, calling 
	 * towerOfHanoi function wouldn't work. 
	 */
	
	
	//this thread will be used to call the function, towerOfHanoi
	Thread T; 
	
	//initial variables for interface
	Button start = new Button("Press to Start");
	Label enter = new Label("Enter the number of disks(<= 7)");
	TextField number = new TextField();
	
	Disk [] disks = new Disk[7]; //an array of disks to represent the disks, up to a max of seven
	Stack [] height = new Stack[3]; //stack used to determine the height of the pegs
	
	int xPos = 10;
	int yPos = 10;
	int diskWidthAdjust = 20;
	int []diskNumbers = new int[7];

	String num; //only for the action listener
	int numDisks; //used only to get the number of disks
	
	int topDisk = 0; //this will be used to find the top Disk number

	public void init() {
		//initialize applet with labels and buttons
		setLayout(null);
		resize(640, 250);
		
		//we assign the variables for each disk in its initial state, all in the first peg.
		for (int i = 0; i < 7; i++) {
			disks[i] = new Disk(10 + i * xPos, 175 - i * yPos, 130 - i * diskWidthAdjust, 10); 
		}
		
		height[0] = new Stack(0); //first peg
		height[1] = new Stack(0); //second peg
		height[2] = new Stack(0); //third peg
			
		enter.setBounds(10, 10, 180, 20);	add(enter);
		number.setBounds(200, 10, 25, 20);	add(number);
		start.setBounds(260, 10, 80, 20);	add(start);
		
		start.addActionListener(this);
	}
	
	//new thread
	public void run() {
		repaint();
		towerOfHanoi(numDisks, 0, 2, 1);
		stop();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			//I recreate a new thread every single time, so I dont
			//have to restart the program to enter a different number
			T = new Thread(this); //create new thread
			for (int i = 0; i < 7; i++) {
				disks[i] = new Disk(10 + i * xPos, 175 - i * yPos, 130 - i * diskWidthAdjust, 10); 
			}
			num = number.getText().trim();	
			numDisks = Integer.parseInt(num);
									
			height[0].changeHeight(numDisks); //first peg
			height[1] = new Stack(0); //second peg
			height[2] = new Stack(0); //third peg
			//start the new thread...start run function
			T.start();	
		}
	}
	
	
	//initialize the pegs; first thing called when applet starts
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(20, 190, 560, 10); //base
		g.fillRect(70, 60, 10, 150); //first peg
		g.fillRect(300, 60, 10, 150); //second peg
		g.fillRect(530, 60, 10, 150); //third peg
		
		//create the painting based on the amount of disks, starting with the biggest disk.	
		//when this is repainted, it will draw the new disks in different pegs with different coordinates
		g.setColor(Color.RED);
		for (int i = 0; i < numDisks; i++) {
			g.fillRect(disks[i].xPos, disks[i].yPos, disks[i].width, 10);
		}
	}
	
	public void towerOfHanoi(int N, int from, int to, int temp) {
		if (N == 1) {
			moveTo(from, to, N);
		}
		else {
			towerOfHanoi(N - 1, from, temp, to);
			moveTo(from, to, N);
			towerOfHanoi(N - 1, temp, to, from);
		}
	}
	
	//change move to function move disks from 1st stack to the 3rd stack
	public void moveTo(int from, int to, int diskNum) {		
		System.out.println(from + "->" + to);
			
		//adjust the disk number to match the indexing of the way I 
		//used the disk number, as an index of arrays starting from
		//the bottom up at 0.
		if (numDisks == 1) {
			if (diskNum == 1) {	diskNum = 0;}
		}
		else if (numDisks == 2) {
			if (diskNum == 1) {diskNum = 1; }
			else if (diskNum == 2) {diskNum = 0; }
		}
		else if (numDisks == 3) {
			if (diskNum == 1) {	diskNum = 2;}
			else if (diskNum == 2) {diskNum = 1;}
			else if (diskNum == 3) {diskNum = 0;}
		}
		else if (numDisks == 4) {
			if (diskNum == 1) {	diskNum = 3;}
			else if (diskNum == 2) {diskNum = 2;}
			else if (diskNum == 3) {diskNum = 1;}
			else if (diskNum == 4) {diskNum = 0;}
		}
		else if (numDisks == 5) {
			if (diskNum == 1) {	diskNum = 4;}
			else if (diskNum == 2) {diskNum = 3;}
			else if (diskNum == 3) {diskNum = 2;}
			else if (diskNum == 4) {diskNum = 1;}
			else if (diskNum == 5) {diskNum = 0;}
		}
		else if (numDisks == 6) {
			if (diskNum == 1) {	diskNum = 5;}
			else if (diskNum == 2) {diskNum = 4;}
			else if (diskNum == 3) {diskNum = 3;}
			else if (diskNum == 4) {diskNum = 2;}
			else if (diskNum == 5) {diskNum = 1;}
			else if (diskNum == 6) {diskNum = 0;}
		}
		else if (numDisks == 7) {
			if (diskNum == 1) {	diskNum = 6;}
			else if (diskNum == 2) {diskNum = 5;}
			else if (diskNum == 3) {diskNum = 4;}
			else if (diskNum == 4) {diskNum = 3;}
			else if (diskNum == 5) {diskNum = 2;}
			else if (diskNum == 6) {diskNum = 1;}
			else if (diskNum == 7) {diskNum = 0;}
		}	
		
		
		/*These outputs are just for debugging purposes*/
		System.out.println("Disk moving is disk # " + diskNum);
		topDisk = diskNum;
		
		height[from].pop();
		height[to].push();

		System.out.println("Height of Peg 1: " + height[0].height);
		System.out.println("Height of Peg 2: " + height[1].height);
		System.out.println("Height of Peg 3: " + height[2].height);
		
		/*Im not sure why, but the repaint function ends, to be here
		 * otherwise the thread may get to overloaded...
		 * Thread.sleep() is the function used to delay in milliseconds.
		 */
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
		
		/* Okay, so I made individual functions for each disk's movement from
		 * peg i to peg j... these if statements just calls which function for
		 * the disk to do by what peg i and peg j is. And the y positions for 
		 * the disk to return to is dependent on the height of peg j. 
		 */
		
		if (from == 0 && to == 1) { //adjust the new xPos
			disks[topDisk].from0to1(); //change xPos
			if (height[1].height == 0) { //adjusts the new yPos
				disks[topDisk].yPos = 185;
			} else if (height[1].height == 1) {
				disks[topDisk].yPos = 175;
			} else if (height[1].height == 2) {
				disks[topDisk].yPos = 165;
			} else if (height[1].height == 3) {
				disks[topDisk].yPos = 155;
			} else if (height[1].height == 4) {
				disks[topDisk].yPos = 145;
			} else if (height[1].height == 5) {
				disks[topDisk].yPos = 135;
			} else if (height[1].height == 6) {
				disks[topDisk].yPos = 125;
			} else if (height[1].height == 7) {
				disks[topDisk].yPos = 115;
			}
		} else if (from == 1 && to == 2) {
			disks[topDisk].from1to2();
			if (height[2].height == 0) { //adjusts the new yPos
				disks[topDisk].yPos = 185;
			} else if (height[2].height == 1) {
				disks[topDisk].yPos = 175;
			} else if (height[2].height == 2) {
				disks[topDisk].yPos = 165;
			} else if (height[2].height == 3) {
				disks[topDisk].yPos = 155;
			} else if (height[2].height == 4) {
				disks[topDisk].yPos = 145;
			} else if (height[2].height == 5) {
				disks[topDisk].yPos = 135;
			} else if (height[2].height == 6) {
				disks[topDisk].yPos = 125;
			} else if (height[2].height == 7) {
				disks[topDisk].yPos = 115;
			}
		} else if (from == 0 && to == 2) {
			disks[topDisk].from0to2();
			if (height[2].height == 0) { //adjusts the new yPos
				disks[topDisk].yPos = 185;
			} else if (height[2].height == 1) {
				disks[topDisk].yPos = 175;
			} else if (height[2].height == 2) {
				disks[topDisk].yPos = 165;
			} else if (height[2].height == 3) {
				disks[topDisk].yPos = 155;
			} else if (height[2].height == 4) {
				disks[topDisk].yPos = 145;
			} else if (height[2].height == 5) {
				disks[topDisk].yPos = 135;
			} else if (height[2].height == 6) {
				disks[topDisk].yPos = 125;
			} else if (height[2].height == 7) {
				disks[topDisk].yPos = 115;
			}
		} else if (from == 1 && to == 0) {
			disks[topDisk].from1to0();
			if (height[0].height == 0) { //adjusts the new yPos
				disks[topDisk].yPos = 185;
			} else if (height[0].height == 1) {
				disks[topDisk].yPos = 175;
			} else if (height[0].height == 2) {
				disks[topDisk].yPos = 165;
			} else if (height[0].height == 3) {
				disks[topDisk].yPos = 155;
			} else if (height[0].height == 4) {
				disks[topDisk].yPos = 145;
			} else if (height[0].height == 5) {
				disks[topDisk].yPos = 135;
			} else if (height[0].height == 6) {
				disks[topDisk].yPos = 125;
			} else if (height[0].height == 7) {
				disks[topDisk].yPos = 115;
			}
		} else if (from == 2 && to == 0) {
			disks[topDisk].from2to0();
			if (height[0].height == 0) { //adjusts the new yPos
				disks[topDisk].yPos = 185;
			} else if (height[0].height == 1) {
				disks[topDisk].yPos = 175;
			} else if (height[0].height == 2) {
				disks[topDisk].yPos = 165;
			} else if (height[0].height == 3) {
				disks[topDisk].yPos = 155;
			} else if (height[0].height == 4) {
				disks[topDisk].yPos = 145;
			} else if (height[0].height == 5) {
				disks[topDisk].yPos = 135;
			} else if (height[0].height == 6) {
				disks[topDisk].yPos = 125;
			} else if (height[0].height == 7) {
				disks[topDisk].yPos = 115;
			}
		} else if (from == 2 && to == 1) {
			disks[topDisk].from2to1();
			if (height[1].height == 0) { //adjusts the new yPos
				disks[topDisk].yPos = 185;
			} else if (height[1].height == 1) {
				disks[topDisk].yPos = 175;
			} else if (height[1].height == 2) {
				disks[topDisk].yPos = 165;
			} else if (height[1].height == 3) {
				disks[topDisk].yPos = 155;
			} else if (height[1].height == 4) {
				disks[topDisk].yPos = 145;
			} else if (height[1].height == 5) {
				disks[topDisk].yPos = 135;
			} else if (height[1].height == 6) {
				disks[topDisk].yPos = 125;
			} else if (height[1].height == 7) {
				disks[topDisk].yPos = 115;
			}
		}		
	}
}


class Disk {
	int width, height, xPos, yPos;

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
	int height, topDiskNum;
	Stack(int height) {
		this.height = height;
	}
	void push() {height += 1;}
	void pop() {height -=1;}
	void changeHeight(int height) {	this.height = height;}
	void setTopDisk(int topDisk) {this.topDiskNum = topDisk;}
}

/*
Output in Console:
0->2
Disk moving is disk # 2
Height of Peg 1: 2
Height of Peg 2: 0
Height of Peg 3: 1
0->1
Disk moving is disk # 1
Height of Peg 1: 1
Height of Peg 2: 1
Height of Peg 3: 1
2->1
Disk moving is disk # 2
Height of Peg 1: 1
Height of Peg 2: 2
Height of Peg 3: 0
0->2
Disk moving is disk # 0
Height of Peg 1: 0
Height of Peg 2: 2
Height of Peg 3: 1
1->0
Disk moving is disk # 2
Height of Peg 1: 1
Height of Peg 2: 1
Height of Peg 3: 1
1->2
Disk moving is disk # 1
Height of Peg 1: 1
Height of Peg 2: 0
Height of Peg 3: 2
0->2
Disk moving is disk # 2
Height of Peg 1: 0
Height of Peg 2: 0
Height of Peg 3: 3
*/