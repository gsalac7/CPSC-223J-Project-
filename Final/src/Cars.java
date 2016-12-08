import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Cars extends Applet implements ActionListener {
	Image img1, img2, img3, selectImg1, selectImg2, selectImg3;
	int car1 = 0, car2 = 0, car3 = 0;
	Label 
		title = new Label("Avis Rent a Car"),
		type = new Label("Type of Cars"),
		subcompacts = new Label("Subcompacts (Hyundai Accent or similar). $24.95/day"),
		intermediate = new Label("Intermediate (Chev. Cruze or similar). $30.95/day"),
		full = new Label("Full Size (Chrysler, Impala or similar). $35.95/day"),
		selected = new Label("Selected car"),
		days = new Label("Number of days (1 - 7)");
	Button
		next1 = new Button("Next car"),
		next2 = new Button("Next car"),
		next3 = new Button("Next car"),
		reserve1 = new Button("Reserve"),
		reserve2 = new Button("Reserve"),
		reserve3 = new Button("Reserve"),
		reportBtn = new Button("Press to see report");
	
	Choice numDays = new Choice();
	
	TextArea info = new TextArea("", 10, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);
	
	String [] sub = {"Subcompacts/NissanVersa.png", "Subcompacts/NissanVersaNote.jpg", "Subcompacts/HondaFit.png"};
	String [] inter = {"Intermediate/Kia.jpg", "Intermediate/Hyundai.png", "Intermediate/Nissan.png"};
	String [] fullSize = {"Full Size/Red.jpg", "Full Size/Nissan.png", "Full Size/White.png"};
	
	String carType = "", model = "", num, pay = "", text = "";
	double amount = 0.0;
	
	public void init() {
		setLayout(null);
		
		resize(800, 1000);
		
		Font f = new Font("Ariel", Font.BOLD, 16);
		title.setFont(f);
		title.setBounds(340, 20, 160, 30);	add(title);
	
		type.setFont(f);
		type.setBounds(10, 30, 100, 30);	add(type);
		
		//first subcompacts
		subcompacts.setBounds(10, 60, 300, 30);	add(subcompacts);
		selected.setBounds(550, 60, 100, 30);	add(selected);
		img1 = getImage(getDocumentBase(), sub[0]);
		next1.setBounds(340, 90, 60, 30);	add(next1);
		reserve1.setBounds(340, 130, 60, 30);	add(reserve1);
		
		//second intermediate
		intermediate.setBounds(10, 300, 300, 30);	add(intermediate);
		img2 = getImage(getDocumentBase(), inter[0]);
		next2.setBounds(340, 330, 60, 30);	add(next2);
		reserve2.setBounds(340, 370, 60, 30);	add(reserve2);
		
		//third Full size
		full.setBounds(10, 510, 300, 30);	add(full);	
		img3 = getImage(getDocumentBase(), fullSize[0]);
		next3.setBounds(340, 540, 60, 30);	add(next3);
		reserve3.setBounds(340, 580, 60, 30);	add(reserve3);
		
		
		String [] day = {"1", "2", "3", "4", "5", "6", "7"};
		for (int i = 0; i < day.length; i++) {
			numDays.add(day[i]);
		}
		
		days.setBounds(10, 800, 160, 30);	add(days);
		numDays.setBounds(20, 830, 60, 20);	add(numDays);
		
		reportBtn.setBounds(100, 830, 150, 30);	add(reportBtn);
		
		info.setBounds(300, 830, 400, 150);	add(info);
		//action listener
		next1.addActionListener(this);
		next2.addActionListener(this);
		next3.addActionListener(this);
		reserve1.addActionListener(this);
		reserve2.addActionListener(this);
		reserve3.addActionListener(this);
		reportBtn.addActionListener(this);
	}



	public void actionPerformed(ActionEvent e) {		
		if (e.getSource() == next1) {
			car1 += 1;
			if (car1 == 3) {
				car1 = 0;
			}
			img1 = getImage(getDocumentBase(), sub[car1]);
			repaint();
		}
		else if (e.getSource() == next2) {
			car2 += 1;
			if (car2 == 3) {
				car2 = 0;
			}
			img2 = getImage(getDocumentBase(), inter[car2]);
			repaint();
		}
		else if (e.getSource() == next3) {
			car3 += 1;
			if (car3 == 3) {
				car3 = 0;
			}
			img3 = getImage(getDocumentBase(), fullSize[car3]);
			repaint();
		}
		else if (e.getSource() == reserve1) {
			selectImg1 = img1;
			repaint();
			carType = "Car Type: Subcompact";
			amount = 24.95;
			if (car1 == 0) {
				model = "Car Model: Honda Fit";
			}
			else if (car1 == 1) {
				model = "Car Model: Nissan Versa";
			}
			else if (car1 == 2) {
				model = "Car Model: Nissan Versa Note";
			}
		}
		else if (e.getSource() == reserve2) {
			selectImg2 = img2;
			repaint();
			carType = "Car Type: Intermediate";
			amount = 30.95;
			if (car2 == 0) {
				model = "Car Model: Hyundai";
			}
			else if (car2 == 1) {
				model = "Car Model: Kia";
			}
			else if (car2 == 2) {
				model = "Car Model: Nissan";
			}
		}
		else if (e.getSource() == reserve3) {
			selectImg3 = img3;
			repaint();
			carType = "Car Type: Full Size";
			amount = 35.95;
			if (car3 == 0) {
				model = "Car Model: Nissan";
				
			}
			else if (car3 == 1) {
				model = "Car Model: Red";
			}
			else if (car3 == 2) {
				model = "Car Model: White";
			}
		}
		else if (e.getSource() == reportBtn) {
			int d; double s;
			num = numDays.getSelectedItem();
			d = Integer.parseInt(num);
			s = amount * d;
			pay = Double.toString(s);
			text += carType + "\n" + model + "\n" + "No. of days: " + num + "\n" + "Total Pay: $" + pay;
			info.setText(text);
		}
 		
	}
	
	public void paint(Graphics g) {
		g.drawImage(img1, 10, 90, 300, 180, this);
		g.drawImage(img2, 10, 320, 300, 180, this);
		g.drawImage(img3, 10, 540, 300, 180, this);
		g.drawImage(selectImg1, 410, 90, 300, 180, this);
		g.drawImage(selectImg2, 410, 320, 300, 180, this);
		g.drawImage(selectImg3, 410, 540, 300, 180, this);
	}
}
