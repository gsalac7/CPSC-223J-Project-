import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

//issues cannot get picture to display

public class Macys extends Applet implements ActionListener, ItemListener {
	Image img;
	
	
	Button
		chooseBtn = new Button(">>>"),
		returnBtn = new Button("<<<"),
		issueBtn = new Button("Issue Report");
	Label
		title = new Label("Macy's Department Store"),
		shoes = new Label("Shoes on Sale"),
		chooseLbl = new Label("choose/return"),
		cartLbl = new Label("Your Shopping Cart"),
		report = new Label("Report");
	
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox red = new Checkbox("red", cbg, true);
	Checkbox black = new Checkbox("blue", cbg, true);
	Checkbox brown = new Checkbox("Brown", cbg, true);
	
	List
		shoeList = new List(7);
		
	TextArea
		cartTxt = new TextArea("", 10, 10, TextArea.SCROLLBARS_BOTH),
		reportTxt = new TextArea("", 10, 10, TextArea.SCROLLBARS_BOTH);
	
	Font f = new Font("Ariel", Font.BOLD, 17);
	
	public void init() {
		setLayout(null);
		img = getImage(getDocumentBase(), "f1.jpg");
		
		//set labels		
		title.setFont(f);
		title.setBounds(400, 20, 300, 40);	add(title);
		shoes.setFont(f);
		shoes.setBounds(100, 100, 300, 30);	add(shoes);
		chooseLbl.setFont(f);
		chooseLbl.setBounds(400, 100, 300, 30);	add(chooseLbl);
		cartLbl.setFont(f);
		cartLbl.setBounds(750, 100, 300, 30);	add(cartLbl);
		report.setFont(f);
		report.setBounds(800, 300, 300, 30);	add(report);
		//set list
		String[] shoes = {"Winter shoes", "Sandals", "Boots", "Sneakers", "Calf boots", "Alaskan boots", "Lucky Brand"};
		String[] prices = {"$100.25", "$75.99", "$55.50", "$23.99", "$69.99", "$85.50", "$220.90"};
		for (int i = 0; i < shoes.length; i++) {
			shoeList.add(shoes[i]);
		}
		shoeList.setBounds(50, 130, 300, 300); add(shoeList);
		
		//set the text areas
		reportTxt.setBounds(700, 330, 250, 150);	add(reportTxt);
		cartTxt.setBounds(700, 150, 250, 130);	add(cartTxt);		
		
		//set buttons
		chooseBtn.setBounds(400, 140, 70, 30);	add(chooseBtn);
		returnBtn.setBounds(500, 140, 70, 30);	add(returnBtn);
		issueBtn.setBounds(400, 400, 140, 40);	add(issueBtn);
		
		
		//set checkboxes
		red.setBounds(400, 370, 50, 30);	add(red);
		black.setBounds(450, 370, 50, 30);	add(black);
		brown.setBounds(500, 370, 50, 30);	add(brown);
		
		
		//set pictures - trouble setting pictures
		
		
		
		//action listeners
		chooseBtn.addActionListener(this);
		returnBtn.addActionListener(this);
		issueBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (shoeList.getSelectedItem().equals("Winter shoes")) {
			reportTxt.setText("Hello");
			img = getImage(getDocumentBase(), "f1.jpg");
			repaint();
		}
		// TODO Auto-generated method stub
		if (e.getSource() == chooseBtn && red.getState() == true) {
			String item = shoeList.getSelectedItem();
			cartTxt.append(item + "\t" + "Red\n");
		}
		else if (e.getSource() == chooseBtn && black.getState() == true) {
			String item = shoeList.getSelectedItem();
			cartTxt.append(item + "\t" + "Black\n");
		}
		else if (e.getSource() == chooseBtn && brown.getState() == true) {
			String item = shoeList.getSelectedItem();
			cartTxt.append(item + "\t" + "Brown\n");
		}
		
		if (e.getSource() == issueBtn) {
			String items = cartTxt.getText().trim();
			reportTxt.setText(items);
			reportTxt.append("\nTotal Bill");
		}
		
	}
	
	
	
	public void paint(Graphics g) {
		g.drawImage(img, 400, 200, 100, 100, this);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == shoeList) {
			if (shoeList.getSelectedItem().equals("Winter shoes")) {
				reportTxt.setText("Hello");
				img = getImage(getDocumentBase(), "f1.jpg");
				repaint();
			}
		}
		
	}
	
	
}
