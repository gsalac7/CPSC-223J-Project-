package GUI;

import java.awt.*;
import javax.swing.*;

public class Part1 {
	public static void main(String [] args) {
		int width = 500;
		int height = 400;
		JFrame frame = new JFrame("Project 8");
		frame.setSize(width, height);
		
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
		g.drawString("Ovals", 70, 90);
		g.drawString("Polygons", 370, 90);
		//draw next 4 lines from the polygons
		g.drawLine(70, 100, 70, 150);
		g.drawLine(20, 130, 140, 130);
		g.drawLine(20, 130, 20, 160);
		g.drawLine(140, 130, 140, 180);
		
		//draw next 4 lines from the ovals
		g.drawLine(400, 100, 400, 120);
		g.drawLine(340, 120, 430, 120);
		g.drawLine(340, 120, 340, 150);
		g.drawLine(430, 120, 430, 150);
		
		//draw Polygons
		
		
		//draw Ovals
	}
}
