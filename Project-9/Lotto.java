import javax.swing.*;
import java.awt.*;


public class Lotto {
	public static void main(String [] args) {
		JFrame frame = new JFrame("Quiz");
		frame.setSize(500, 500);
		frame.setLocation(50, 50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Container cPane = frame.getContentPane();
		Graphics g = cPane.getGraphics();
		
		//display Circle
		int width = 100, height = 100;
		g.setColor(Color.orange);
		g.drawOval(30, 30, width, height);
		g.fillOval(30, 30, width, height);
		
		//display Lotto
		int []x = {50, 50, 80, 80};
		int []y = {20, 200, 20, 200};
		g.setColor(Color.blue);
		//g.fillRect(50,  10, 30, 200);
		g.fillPolygon(x, y, x.length);
		
		int []x1 = {80, 80, 200, 200};
		int []y2 = {200, 140, 200, 140};
		g.setColor(Color.blue);
		g.fillPolygon(x1,  y2, x1.length);
		
		//display California lotto
		g.drawString("California Lotto", 230, 400);
	}
	
public static void circle(Graphics g) {
		
		int width = 100, height = 100;
		g.setColor(Color.orange);
		g.drawOval(30, 30, width, height);
		g.fillOval(30, 30, width, height);
		
		
	}
	
	public void lotto(Graphics g) {
		int []x = {50, 50, 80, 80};
		int []y = {10, 90, 10, 90};
		g.setColor(Color.blue);
		//g.fillRect(50,  10, 30, 200);
		g.fillPolygon(x, y, x.length);
		
		int []x1 = {80, 80, 200, 200};
		int []y2 = {120, 140, 120, 140};
		g.setColor(Color.blue);
		g.fillPolygon(x1,  y2, x1.length);
	}
	
	
	
	public void display(Graphics g) {
		circle(g);
		lotto(g);
		g.drawString("California Lotto", 230, 400);
	}
}
