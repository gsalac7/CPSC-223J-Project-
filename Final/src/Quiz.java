import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Quiz extends Applet implements ActionListener{
	Calendar c = Calendar.getInstance();
	int month = c.get(Calendar.MONTH);
	int day = c.get(Calendar.DATE);
	int year = c.get(Calendar.YEAR);
	
	String currentDate = Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
	
	Image img, img2;
	
	Label 
		title = new Label("Domino's Pizza"),
		pizza = new Label("Choose your pizza (Basic $7.00)"),
		date = new Label("Today's date: " + currentDate),
		crust = new Label("Select the Crust (0.50 extra)"),
		size = new Label("Select size($1.00, $2.00, $3.00 extra)"),
		num = new Label("Number of Pizzas"),
		name = new Label("Your name"),	
		phone = new Label("Phone Number");
	Choice
		chCrust = new Choice(),
		chNum = new Choice();
	
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox size10 = new Checkbox("10", cbg, true);
	Checkbox size12 = new Checkbox("12", cbg, true);
	Checkbox size14 = new Checkbox("14", cbg, true);
	
	TextField
		numText = new TextField(),
		nameText = new TextField(),
		phoneText = new TextField();
	
	Button
		nextBtn = new Button("Next"),
		addBtn = new Button(">>>"),
		backBtn = new Button("<<<"),
		orderBtn = new Button("Click to order");
	
	TextArea
		finalTxt = new TextArea("", 10, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);
	int type = 1;
	
	String []imageLoc = {"Quiz Images/f1.jpg", "Quiz Images/f2.jpg", "Quiz Images/f3.jpg"};
	
	public void init() {
		
		setLayout(null);
		resize(600, 800);
		//set fonts for the labels
		Font t = new Font("Ariel", Font.BOLD, 16);
		Font f = new Font("Ariel", Font.BOLD, 12);
		
		title.setFont(t);
		date.setFont(t);
		pizza.setFont(t);
		
		title.setBounds(240, 10, 150, 30);	add(title);
		date.setBounds(200,  40, 210, 30);	add(date);
		pizza.setBounds(150, 70, 260, 30);	add(pizza);
		
		img = getImage(getDocumentBase(), imageLoc[type]); 
		nextBtn.setBounds(80, 90, 50, 30);	add(nextBtn);
		
		addBtn.setBounds(230, 120, 60, 30);	add(addBtn);
		numText.setBounds(250, 160, 20, 20);	add(numText);
		numText.setText(Integer.toString(type));
		backBtn.setBounds(230, 190, 60, 30);	add(backBtn);
		
		crust.setFont(f);
		size.setFont(f);
		crust.setBounds(60, 280, 200, 30);	add(crust);
		size.setBounds(330, 280, 250, 30);	add(size);
		
		String [] crustTypes = {"Thin Crust", "Hand Tossed", "Cheesy Crust", "Thick Crust"};
		for (int j = 0; j < crustTypes.length; j++) {
			chCrust.add(crustTypes[j]);
		}
		
		chCrust.setBounds(80, 310, 100, 30);	add(chCrust);
		size10.setBounds(330, 310, 30, 30);	add(size10);
		size12.setBounds(370, 310, 30, 30);	add(size12);
		size14.setBounds(410, 310, 30, 30);	add(size14);
		
		num.setFont(f);
		name.setFont(f);
		phone.setFont(f);
		num.setBounds(100, 360, 110, 30);	add(num);
		name.setBounds(220, 360, 100, 30);	add(name);
		phone.setBounds(330, 360, 100, 30);	add(phone);
		
		int [] ten = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		for (int k = 0; k < ten.length; k++) {
			chNum.add(Integer.toString(ten[k]));
		}
		
		chNum.setBounds(90, 390, 100, 30);	add(chNum);
		
		nameText.setBounds(200, 390, 100, 25);	add(nameText);
		phoneText.setBounds(310, 390, 100, 25);	add(phoneText);
		
		orderBtn.setBounds(90, 430, 300, 30);	add(orderBtn);
		finalTxt.setBounds(90, 480, 300, 200);	add(finalTxt);
		addBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		backBtn.addActionListener(this);
		orderBtn.addActionListener(this);
	}
	 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == orderBtn) {
			String phoneNum = phoneText.getText().trim();
			String name = nameText.getText().trim();
			String num = numText.getText().trim();
			String crust = chCrust.getSelectedItem();
			String numPizzas = chNum.getSelectedItem();
			String total = "";
			double sum = 0;
			
			String text = name + ", " + phoneNum + "\n";
			text += "Basic pizza type " + num + ":     $7.00\n";
			text += "Crust: " + crust + " $0.50" + "\n";
			sum = Integer.parseInt(numPizzas) * 7.50;
			total = Double.toString(sum);
			
			if (size10.getState() == true) {
				text += "Size:  10 inches\n";
				text += "Number of Pizzas: " + numPizzas + "\n";
				text += "Total: $" + total;
				finalTxt.setText(text);
			}
			else if (size12.getState() == true) {
				text += "Size:  12 inches\n";
				text += "Number of Pizzas: " + numPizzas + "\n";
				text += "Total: $" + total;
				finalTxt.setText(text);
			}
			else if (size14.getState() == true) {
				text += "Size:  14 inches\n";
				text += "Number of Pizzas: " + numPizzas + "\n";
				text += "Total: $" + total;
				finalTxt.setText(text);
			}
		}
		else if (e.getSource() == nextBtn) {
			type += 1;
			if (type == 4) {
				type = 1;
			}
			numText.setText(Integer.toString(type));
			img = getImage(getDocumentBase(), imageLoc[type - 1]); repaint();
		}
		else if (e.getSource() == addBtn) {
			img2 = img;
			repaint();
		}
		else if (e.getSource() == backBtn) {
			img2 = null;
			repaint();
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, 80, 120, 130, 130, this);
		g.drawImage(img2, 360, 120, 130, 130, this);
	}
	
}