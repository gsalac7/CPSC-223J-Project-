import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Album extends Applet implements ActionListener, AdjustmentListener {
	String []pics = {"Album Images/f1.jpg", "Album Images/f2.jpg", "Album Images/f3.jpg", "Album Images/f4.jpg"};
	int width = 50, height = 50;
	Scrollbar sb = new Scrollbar(0, 10, 10, 0, 210);
	int counter = 0;
	Image img;
	
	Button
		back = new Button("<<<"),
		next = new Button(">>>"),
		show = new Button("Show description");
	Label
		familyLbl = new Label("My Family Album"),
		descrip = new Label("Image Description");
	TextArea
		description = new TextArea("", 10, 10, TextArea.SCROLLBARS_HORIZONTAL_ONLY);
	
	
	public void init() {
		setLayout(null);
		resize(600, 300);
		img = getImage(getDocumentBase(), pics[0]);
		back.setBounds(10, 10, 90, 30);	add(back);
		next.setBounds(110, 10, 90, 30);	add(next);
		
		sb.setBounds(10, 50, 180, 30);  add(sb);
		
		show.setBounds(240, 100, 140, 30);	add(show);
		
		description.setBounds(400, 100, 190, 100);	add(description);
		
		familyLbl.setFont(new Font("Ariel", Font.BOLD, 17));
		familyLbl.setBounds(400, 40, 160, 30);	add(familyLbl);
		
		descrip.setFont(new Font("Ariel", Font.BOLD, 15));
		descrip.setBounds(400,  70, 160, 30);	add(descrip);
		show.addActionListener(this);
		back.addActionListener(this);
		next.addActionListener(this);
		sb.addAdjustmentListener(this);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == next && counter == 0) {
			counter += 1;
			System.out.print(counter);
			img = getImage(getDocumentBase(), pics[1]);
			repaint();
		}
		else if (e.getSource() == next && counter == 1) {
			counter += 1;
			System.out.print(counter);
			img = getImage(getDocumentBase(), pics[2]);
			repaint();
		}
		else if (e.getSource() == next && counter == 2) {
			counter += 1;
			System.out.print(counter);
			img = getImage(getDocumentBase(), pics[3]);
			repaint();
		}
		else  if (e.getSource() == next && counter == 3){
			counter = 0;
			System.out.print(counter);
			img = getImage(getDocumentBase(), pics[0]);
			repaint();
		}
		else if (e.getSource() == back && counter == 3) {
			counter--;
			img = getImage(getDocumentBase(), pics[3]);
			repaint();
		}
		else if (e.getSource() == back && counter == 2) {
			counter--;
			img = getImage(getDocumentBase(), pics[2]);
			repaint();
		}
		else if (e.getSource() == back && counter == 1) {
			counter--;
			img = getImage(getDocumentBase(), pics[1]);
			repaint();
		}
		else if (e.getSource() == back && counter == 0) {
			counter = 3;
			img = getImage(getDocumentBase(), pics[0]);
			repaint();
		}
		
		else if (e.getSource() == show) {
			if (img == getImage(getDocumentBase(), pics[0])) {
				description.setText("This is Mt. Rushmore located in North Dakota");
			}
			else if (img == getImage(getDocumentBase(), pics[1])) {
				description.setText("This is the Statue of Liberty in New york city");
			}
			else if(img == getImage(getDocumentBase(), pics[2])) {
				description.setText("This is the Golden Gate Bridge in San francisco");
			}
			else if(img == getImage(getDocumentBase(), pics[3])) {
				description.setText("This is the Empire state building in Manhattan");
			}
			
		}
		
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		if (e.getSource() == sb) {
			width = sb.getValue();
			height = sb.getValue();
			repaint();
		}
		
	}
	
	public void paint(Graphics g ) {
		g.drawImage(img, 20, 100, width, height, this);
	}
	
}
