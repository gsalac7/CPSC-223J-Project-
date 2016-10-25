import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Interface {
	public static void main(String [] args) {
		JFrame frame = new JFrame("Project 9");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLocation(50, 50);
		frame.setVisible(true);
		
		Container cPane = frame.getContentPane();
		Graphics g = cPane.getGraphics();
		
		g.clearRect(0, 0, (int)cPane.getSize().getWidth(), (int)cPane.getSize().getHeight());
		String option;
		
		do {
			displayMenu(g);
			option = JOptionPane.showInputDialog("Enter your option");
			//clear the window
			g.clearRect(0, 0, (int)cPane.getSize().getWidth(), (int)cPane.getSize().getHeight());
			
			if (option.equals("a")) {
				triangles(g);
			}
			else if (option.equals("b")) {
				ellipses(g);
			}
			else if (option.equals("c")) {
				polygons(g);
			}
			else {
				JOptionPane.showMessageDialog(null, "Error not an option", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			option = JOptionPane.showInputDialog("Continue(y/n)");
			g.clearRect(0, 0, (int)cPane.getSize().getWidth(), (int)cPane.getSize().getHeight());
		} while(option.equals("y"));
		
	}
	
	
	public static void displayMenu(Graphics g) {
		g.drawString("-------------------Menu----------------", 100, 100);
		g.drawString("a.Compute the area of triangles", 100, 120);
		g.drawString("b.Compute the area of an eclipse", 100, 140);
		g.drawString("c.Compute the area of polygons", 100, 160);
	}
	
	//make triangle but what do we ask from the user?
	//do we ask side lengths or coordinates?
	public static void triangles(Graphics g) {
		String s1, s2, s3;
		int side1, side2, side3;
		
		s1 = JOptionPane.showInputDialog("Enter the value of side 1");
		s2 = JOptionPane.showInputDialog("Enter the value of side 2");
		s3 = JOptionPane.showInputDialog("Enter the value of side 3");
		
		side1 = Integer.parseInt(s1);
		side2 = Integer.parseInt(s2);
		side3 = Integer.parseInt(s3);
		
		g.drawString("Area = 1/2 * b * h = ", 200, 200);
	}
	
	public static void ellipses(Graphics g) {
		g.drawString("Please enter ellipse info", 10, 10);
		String major, minor;
		
		major = JOptionPane.showInputDialog("Enter the length of the major axis");
		minor = JOptionPane.showInputDialog("Enter the length of the minor axis");
		
		//solve for the area
		int maj, min;
		maj = Integer.parseInt(major);
		min = Integer.parseInt(minor);
		
		double area;
		
		area = Math.PI * (maj/2) * (min/2);
		//display everything
		int x = 100, y = 100;
		g.setColor(Color.BLACK);
		g.fillOval(x, y, maj, min);
		
		String a = String.valueOf(area);
		//display text
		g.drawString("Major axis = ", 100, y + 50);
		g.drawString(major, 170, y + 50);
		g.drawString("Minor axis = ", 100, y + 70);
		g.drawString(minor, 170, 170);
		g.drawString("Area = Math.PI * (major/2) * (minor/2) = ", 100, 190);
		g.drawString(a, 320, 190);
	}
	
	//draw a polygon...but how do you find area given only coordinates? do use distance formula?
	// do we make up coordinates or ask for side lengths?
	public static void polygons(Graphics g) {
		String width, height;
		
		g.drawString("Enter the info of the polgon", 10, 10);
		width = JOptionPane.showInputDialog("Enter the length of the width");
		height = JOptionPane.showInputDialog("Enter the length of the height");
		
		g.setColor(Color.blue);
		g.fillRect(100, 100, Integer.parseInt(width), Integer.parseInt(height));
		g.drawString("Width = ", 100, 250);
		g.drawString(width, 150, 250);
		g.drawString("Height = ", 100, 270);
		g.drawString(height, 150, 270);
		g.drawString("Area = b * h = ", 100, 290);
		
		int area = Integer.parseInt(width) * Integer.parseInt(height);
		
		String a = String.valueOf(area);
		
		g.drawString(a, 170, 290);
	}
}

