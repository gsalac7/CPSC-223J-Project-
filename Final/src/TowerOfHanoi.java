/* Angelo Salac
 * Ray Ahmadnia
 * Final Exam part 3
 * 12/15/16
 * Purpose: Create the Tower of Hanoi
 */

/* I am almost confident that this should work.
 * Except for some reason i need to find a way to fix
 * the topDisk Bug.
 */

import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.applet.*;

public class TowerOfHanoi extends Applet implements ActionListener{
	
	//initial variables for interface
	Button start = new Button("Press to Start");
	Label enter = new Label("Enter the number of disks(<= 7)");
	TextField number = new TextField();
	
	int begin;
	
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
		resize(610, 250);
		
		//we assign the variables for each disk in its initial state, all in the first peg.
		for (int i = 0; i < 7; i++) {
			disks[i] = new Disk(10 + i * xPos, 175 - i * yPos, 130 - i * diskWidthAdjust, 10); 
		}
		
		
		height[0] = new Stack(0); //first peg
		height[1] = new Stack(0); //second peg
		height[2] = new Stack(0); //third peg
		
		
		begin = 0;
		
		
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
			begin = 1;
			
			
			try {				
				height[0].changeHeight(numDisks);
				begin = 2;
				towerOfHanoi(numDisks, 0, 2, 1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	//initialize the pegs; first thing called when applet starts
	public void paint	(Graphics g) {
	
		g.setColor(Color.BLUE);
		g.fillRect(20, 190, 560, 10); //base
		g.fillRect(70, 60, 10, 150); //first peg
		g.fillRect(300, 60, 10, 150); //second peg
		g.fillRect(530, 60, 10, 150); //third peg
		
		//create the painting based on the amount of disks, starting with the biggest disk.	
		//when this is repainted, it will draw the new disks in different pegs with different coordinates
		draw(g);
	}	
	
	//function used to draw the pegs based on the x and y positions,
	//x and y positions change according to the moveTo function.
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		for (int i = 0; i < numDisks; i++) {
			g.fillRect(disks[i].xPos, disks[i].yPos, disks[i].width, 10);
			
		}
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	//redraw the frame with the new x and y positions
	
	
	public void towerOfHanoi(int N, int from, int to, int temp) throws InterruptedException {
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
	public void moveTo(int from, int to, int diskNum) throws InterruptedException {		
		System.out.println(from + "->" + to);
			
		//adjust the disk number to match the indexing of the way I 
		//used the disk number.
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
		
		
		//diskNum += height[from].height;
		System.out.println("Disk moving is disk # " + diskNum);
		topDisk = diskNum;
		
		height[from].pop();
		height[to].push();

		System.out.println("Height of Peg 1: " + height[0].height);
		System.out.println("Height of Peg 2: " + height[1].height);
		System.out.println("Height of Peg 3: " + height[2].height);
		/* we can do this the hard way and calculate the xPos and yPos
		 * We might just have to create the disk1 - disk7 each with its own widths, every disk 
		 * has the same height. Every disk has its own xPos and yPos.
		 * when we do that, we will then need to calculate the appropriate xPos for each..
		 * but how do we calculate the yPos????? 
		 * yPos is calculated based on the height of the pegs...
		 * So now how do we calculate what the top disk number is?
		 *  
		*/	
		
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
			} else if (height[1].height == 7) {
				disks[topDisk].yPos = 105;
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
			} else if (height[2].height == 7) {
				disks[topDisk].yPos = 105;
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
			} else if (height[2].height == 7) {
				disks[topDisk].yPos = 105;
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
			} else if (height[0].height == 7) {
				disks[topDisk].yPos = 105;
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
			} else if (height[0].height == 7) {
				disks[topDisk].yPos = 105;
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
			} else if (height[1].height == 7) {
				disks[topDisk].yPos = 105;
			}
		}
		Thread.sleep(700);
		repaint();
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
	int height, topDiskNum;
	Stack(int height) {
		this.height = height;
	}
	void push() {height += 1;}
	void pop() {height -=1;}
	void changeHeight(int height) {	this.height = height;}
	void setTopDisk(int topDisk) {this.topDiskNum = topDisk;}
}