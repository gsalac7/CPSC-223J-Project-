import java.awt.*;
import javax.swing.*;

public class Shapes extends JPanel{
	public static void main(String [] args) {		
		JFrame frame = new JFrame("Project 8");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLocation(500,500);		
		frame.setVisible(true);
		
		Container cPane = frame.getContentPane();
		Graphics g = cPane.getGraphics();
		
		
		g.drawString("Geometric shapes", 200, 20);
		//draw first 4 lines
		g.drawLine(250, 25, 250, 40);
		g.drawLine(100, 40, 400, 40);
		g.drawLine(100, 40, 100, 70);
		g.drawLine(400, 40, 400, 70);
		//draw more text
		g.drawString("Polygons", 85, 90);
		g.drawString("Ovals", 380, 90);
		//draw next 4 lines from polygons
		g.drawLine(100, 100, 100, 160);
		g.drawLine(20, 130, 180, 130);
		g.drawLine(20, 130, 20, 160);
		g.drawLine(180, 130, 180, 160);
		
		//draw next 4 lines from ovals
		g.drawLine(400, 100, 400, 120);
		g.drawLine(340, 120, 430, 120);
		g.drawLine(340, 120, 340, 150);
		g.drawLine(430, 120, 430, 150);
	
		//draw Polygons
		//draw rectangle left most
		displayPolygons(g);
		
		
		//draw Ovals
		displayOvals(g);
		
		frame.setVisible(true);
	}
	
	static void displayPolygons(Graphics g) {
		int width = 30, height = 15;
		
		//display rectangle
		g.setColor(Color.red);
		g.fillRect(10, 165, width, height);
		
		//display triangle
		int []x = {100, 90, 115};
		int []y = {160, 180, 180};	
		g.fillPolygon(x, y, x.length);
		
		//display last polygon
		int []x1 = {150, 170, 220, 230};
		int []y1 = {200, 160, 160, 200};
		g.fillPolygon(x1, y1, y1.length);
		
	}
	
	static void displayOvals(Graphics g) {
		int w = 30, h = 27;
		
		g.setColor(Color.red);
		g.fillOval(330, 160, w, h);
		
		w = 60;
		h = 20;
		g.fillOval(410, 160, w, h);
	}
}

//Output: https://gyazo.com/650baf2d6cfaef4e2302d4647ac230fa
