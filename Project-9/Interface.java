/* Arianne Arcebal, Angelo Salac
Project 9 Part 2
Ray Ahmadnia
Purpose: 
*/

package GUI;

import javax.swing.*;
import java.awt.*;

public class Interface{
	public static void main(String[] arg){
		JFrame frame = new JFrame("Project 9 Part 2");
		String option;
		int width, height;

		//frame
		frame.setSize(700, 700);
		frame.setLocation(0, 0);
		frame.setVisible(true);

		Container cPane = frame.getContentPane();
		Graphics g      = cPane.getGraphics();
		width           = (int)cPane.getSize().getWidth();
		height          = (int)cPane.getSize().getHeight();

		do {
			//display menu
			displayMenu(g);
			option = JOptionPane.showInputDialog("Enter your option");
			g.clearRect(0, 0, width, height);

			//calculate shape areas
			if(option.equals("a")) {
				triangle(g);
			}
			else if(option.equals("b")){
				ellipse(g);
			}
			else if (option.equals("c")){
				polygon(g);
			}
			else {
				JOptionPane.showMessageDialog(null, "Error not a choice", "Error", JOptionPane.WARNING_MESSAGE);
			}

			//ask user if they want to start again
			option = JOptionPane.showInputDialog("Continue(y/n)?");
			g.clearRect(0, 0, width, height);
		} while(option.equals("y"));
	}

	static void displayMenu(Graphics g){
		g.drawString("-------------Menu-------------", 50, 50);
		g.drawString("a. Compute the area of triangles", 50, 70);
		g.drawString("b. Compute the area of ellipses", 50, 90);
		g.drawString("c. Compute the area of polygons", 50, 110);
	}

	static void triangle(Graphics g){
		String temp;
		int base, height;

		//get triangle values
		temp   = JOptionPane.showInputDialog("What is the length of the base?");
		base   = Integer.parseInt(temp);
		temp   = JOptionPane.showInputDialog("What is the length of the height?");
		height = Integer.parseInt(temp);

		//display triangle & values
		int[] x = {50+(base/2), 50, 50+base};
		int[] y = {50, 50+height, 50+height};
		g.fillPolygon(x, y, 3);
		g.drawString("Base = " + base, 50, height+70);
		g.drawString("Height = " + height, 50, height+90);
		g.drawString("Area = base*height/2 = " + base*height/2, 50, height+110);
	}

	static void ellipse(Graphics g){
		String temp;
		int minor, major;
		float area;

		//get ellipse values
		temp  = JOptionPane.showInputDialog("What is the length of the major axis?");
		major = Integer.parseInt(temp);
		temp  = JOptionPane.showInputDialog("What is the length of the minor axis?");
		minor = Integer.parseInt(temp);
		area  = (float)(Math.PI * (major/2) * (minor/2));

		//display ellipse & values
		g.fillOval(50, 50, major, minor);
		g.drawString("Major axis: " + major, 50, minor+80);
		g.drawString("Minor axis: " + minor, 50, minor+100);
		g.drawString("Area = pi*(major/2)*(minor/2) = " + area, 50, minor+120);
		
	}

	static void polygon(Graphics g){
		//pre-defined polygon
		int [] x = {10, 60, 100, 150};
		int [] y = {200, 60, 70, 100};
		
		g.setColor(Color.blue);
		g.fillPolygon(x, y, x.length);
		
		double area;
		area = 0.5 * ((600 - 1200) + (1300 - 6000) + (10000 - 10500) + (30000 - 10000));
		g.drawString("x coordinates = {10, 60, 100, 150}", 10, y[0] + 50);
		g.drawString("y coordinates = {200, 60, 70, 100}", 10, y[0] + 70);
		g.drawString("Area = " + area, 10, y[0] + 90);
	}
}