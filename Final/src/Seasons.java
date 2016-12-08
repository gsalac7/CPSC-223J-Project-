import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Seasons extends Applet implements ActionListener {
	
	
	Image img;
	String [] pics = {"Seasons Images/Fall.jpg", "Seasons Images/Spring.jpg", "Seasons Images/Summer.jpg", "Seasons Images/Winter.jpg"};
	
	Frame frmMenu = new Frame("Seasons");
	
	JLabel Image = new JLabel();
	
	MenuBar mnuMain = new MenuBar();
	Menu mnuSummer = new Menu("Summer");
	Menu mnuSpring = new Menu("Spring");
	Menu mnuFall = new Menu("Fall");
	Menu mnuWinter = new Menu("Winter");
	
	MenuItem mnuSummer1 = new MenuItem("July"),
			mnuSummer2 = new MenuItem("August"),
			mnuSummer3 = new MenuItem("September"),
			mnuSpring1 = new MenuItem("April"),
			mnuSpring2 = new MenuItem("May"),
			mnuSpring3 = new MenuItem("June"),
			mnuFall1 = new MenuItem("October"),
			mnuFall2 = new MenuItem("November"),
			mnuFall3 = new MenuItem("December"),
			mnuWinter1 = new MenuItem("January"),
			mnuWinter2 = new MenuItem("February"),
			mnuWinter3 = new MenuItem("March");
	JTextArea info = new JTextArea();
	
	

	
	public static void main(String [] args) {
		Seasons myMenuApp = new Seasons();
		myMenuApp.createInterface();
	}
	
	
	public void createInterface() {
		//add summer
		mnuMain.add(mnuSummer); mnuSummer.addActionListener(this);
		mnuSummer.add(mnuSummer1); 
		mnuSummer.addSeparator();
		mnuSummer.add(mnuSummer2);
		mnuSummer.addSeparator();
		mnuSummer.add(mnuSummer3);
		
		//add spring
		mnuMain.add(mnuSpring); mnuSpring.addActionListener(this);
		mnuSpring.add(mnuSpring1); 
		mnuSpring.addSeparator();
		mnuSpring.add(mnuSpring2);
		mnuSpring.addSeparator();
		mnuSpring.add(mnuSpring3);
		
		//add Fall
		mnuMain.add(mnuFall); mnuFall.addActionListener(this);
		mnuFall.add(mnuFall1); 
		mnuFall.addSeparator();
		mnuFall.add(mnuFall2);
		mnuFall.addSeparator();
		mnuFall.add(mnuFall3);
		
		//add Winter
		mnuMain.add(mnuWinter); mnuWinter.addActionListener(this);
		mnuWinter.add(mnuWinter1);
		mnuWinter.addSeparator();
		mnuWinter.add(mnuWinter2);
		mnuWinter.addSeparator();
		mnuWinter.add(mnuWinter3);
		
		frmMenu.setMenuBar(mnuMain);
		
		//info.setBounds(130, 30, 50, 50);	frmMenu.add(info);
		
		frmMenu.setVisible(true);
		frmMenu.setSize(500, 700);
		
	}
	


	
	public void actionPerformed(ActionEvent e) {
		String menuItem = e.getActionCommand();
		String text = "";
		
		if (menuItem.equals("April")) {
			Image.setIcon(new ImageIcon(getClass().getResource(pics[1])));
			repaint();
		}
		else if (menuItem.equals("May")) {
			Image.setIcon(new ImageIcon(getClass().getResource(pics[1])));
			repaint();
		}
		else if (menuItem.equals("June")) {
			Image.setIcon(new ImageIcon(getClass().getResource(pics[1])));
			repaint();
		}
		else if (menuItem.equals("July")) {
			Image.setIcon(new ImageIcon(getClass().getResource(pics[2])));
			repaint();
		}
		else if (menuItem.equals("August")) {
			Image.setIcon(new ImageIcon(getClass().getResource(pics[2])));
			repaint();
		}
		else if (menuItem.equals("September")) {
			Image.setIcon(new ImageIcon(getClass().getResource(pics[2])));
			repaint();
		}
		else if (menuItem.equals("October")) {
			Image.setIcon(new ImageIcon(getClass().getResource(pics[0])));
			repaint();
		}
		else if (menuItem.equals("November")) {
			Image.setIcon(new ImageIcon(getClass().getResource(pics[0])));
			repaint();
		}
		else if (menuItem.equals("December")) {
			Image.setIcon(new ImageIcon(getClass().getResource(pics[0])));
			repaint();
		}
		else if (menuItem.equals("January")) {
			Image.setIcon(new ImageIcon(getClass().getResource(pics[3])));
			repaint();
		}
		else if (menuItem.equals("February")) {
			Image.setIcon(new ImageIcon(getClass().getResource(pics[3])));
			repaint();
		}
		else if (menuItem.equals("March")) {
			Image.setIcon(new ImageIcon(getClass().getResource(pics[3])));
			repaint();
		}		
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, 20, 100, 100, 100, this);
	}

}
