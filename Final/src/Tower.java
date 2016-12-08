import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Tower extends Applet implements ActionListener{
	
	Button start = new Button("Press to Start");
	Label enter = new Label("Enter the number of disks(<= )");
	TextField number = new TextField();
	
	
	
	int [] disks;
	String num;
	public static void main(String [] args) {
		towerOfHanoi(5, 1, 3, 2);
	}
	
	public static void towerOfHanoi(int N, int from, int to, int temp) {
		if (N == 1) {
			moveTo(from, to);
		}
		else {
			towerOfHanoi(N - 1, from, temp, to);
			moveTo(from, to);
			towerOfHanoi(N - 1, temp, to, from);
		}
	}
	
	public static void moveTo(int from, int to) {
		System.out.println(from + "->" + to);
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == start) {
			num = number.getText().trim();	
		}
	}
}
