import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends Applet implements ActionListener{
	Button btnLogin = new Button("Login");
	
	Button
		btnInventory = new Button("Inventory"),
		btnOrder = new Button("Orders"),
		btnEmployee = new Button("Employees"),
		btnVendor = new Button("Vendors"),
		btnMenu = new Button("Main Menu");
	
	TextField
		username = new TextField(),
		password = new TextField();
	
	Label 
		welcome = new Label("Welcome"), 
		user = new Label("Username"), 
		pass = new Label("Password"),
		lblMenu;
	
	Label
		titleInventory = new Label("Product Manager"),
		titleVendor = new Label("Vendor Manager"),
		titleEmployee = new Label("Employee Manager"),
		titleOrder = new Label("Order Reports");
	
	Label
		pName = new Label("Name"),
		pID = new Label("ID"),
		pPrice = new Label("Price"),
		pQuantity = new Label("Quantity");
	
	TextField
		textProductName = new TextField(),
		textProductID = new TextField(),
		textProductPrice = new TextField(),
		textProductQuantity= new TextField();
	Button
		addProduct = new Button("Add");
	
	TextArea 
		products = new TextArea("Name\t\tID\t\tPrice\t\tQuantity", 10, 20, TextArea.SCROLLBARS_BOTH),
		employees = new TextArea("Name\t\tAddress\t\tPhone Number\t\tEmail", 10, 20, TextArea.SCROLLBARS_BOTH),
		vendors = new TextArea("Name\t\tAddress\t\tPhone Number\t\tEmail", 10, 20, TextArea.SCROLLBARS_BOTH);
	
	Font titleFont = new Font("Ariel", Font.BOLD, 20);
	public void init() {
		setLayout(null);
		resize(300, 300);
		setBackground( Color.lightGray );
		
		Font font = new Font("Ariel", Font.BOLD, 17);
		welcome.setFont(font);
		welcome.setBounds(100, 20, 100, 50); add(welcome);
		
		user.setBounds(100, 90, 80, 40); add(user);
		username.setBounds(100, 140, 130, 23); add(username);
		
		pass.setBounds(100, 180, 80, 40); add(pass);
		password.setBounds(100, 220, 130, 23); add(password);
		
		btnLogin.setBounds(130, 260, 50, 20); add(btnLogin);
		
		btnLogin.addActionListener(this);
		
		btnInventory.addActionListener(this);
		btnOrder.addActionListener(this);
		btnVendor.addActionListener(this);
		btnEmployee.addActionListener(this);
		btnMenu.addActionListener(this);
		addProduct.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnLogin) {
			setLayout(null);
			resize(400, 300);
			String userName = username.getText().trim();
			
			lblMenu = new Label("Welcome " + userName);
			
			
			Font btnFont = new Font("Ariel", Font.BOLD, 16);
			
			Font font = new Font("Ariel", Font.BOLD, 20);				
			lblMenu.setFont(font);
			lblMenu.setBounds(10, 10, 300, 100); add(lblMenu);	
			
			btnInventory.setFont(btnFont); btnInventory.setBounds(50, 150, 100, 60); add(btnInventory);
			btnOrder.setFont(btnFont); btnOrder.setBounds(180, 150, 100, 60); add(btnOrder);
			btnEmployee.setFont(btnFont); btnEmployee.setBounds(50, 230, 100, 60); add(btnEmployee);
			btnVendor.setFont(btnFont); btnVendor.setBounds(180, 230, 100, 60); add(btnVendor);
			
			remove(welcome);
			remove(user);
			remove(username);
			remove(pass);
			remove(btnLogin);
			remove(password);
		}
		if (e.getSource() == btnInventory) {
			setLayout(null);
			setLocation(200, 100);
			resize(500, 400);
			
			titleInventory.setFont(titleFont);
			
			titleInventory.setBounds(160, 20, 200, 30); add(titleInventory);
			products.setBounds(50, 70, 400, 200); add(products);
			
			pName.setBounds(20, 300, 60, 30); add(pName);
			textProductName.setBounds(20, 340, 100, 23); add(textProductName);
			pID.setBounds(150, 300, 60, 30); add(pID);
			textProductID.setBounds(150, 340, 100, 23); add(textProductID);
			pPrice.setBounds(2400, 300, 60, 30); add(pPrice);
			textProductPrice.setBounds(240, 340, 100, 23); add(textProductPrice);
			pQuantity.setBounds(310, 300, 60, 30); add(pQuantity);
			textProductQuantity.setBounds(310, 340, 100, 23); add(textProductQuantity);
			
			
			btnMenu.setBounds(20, 380, 75, 20); add(btnMenu);
			
			remove(lblMenu);
			remove(btnInventory);
			remove(btnOrder);
			remove(btnEmployee);
			remove(btnVendor);
		}
		else if (e.getSource() == btnOrder) {
			setLayout(null);
			setLocation(200, 100);
			resize(500, 400);
			
			titleInventory.setBounds(160, 20, 200, 30); add(titleInventory);
			products.setBounds(50, 70, 400, 200); add(products);
			
			btnMenu.setBounds(20, 360, 75, 20); add(btnMenu);
			remove(lblMenu);
			remove(btnInventory);
			remove(btnOrder);
			remove(btnEmployee);
			remove(btnVendor);
		}
		else if (e.getSource() == btnVendor) {
			setLayout(null);
			setLocation(200, 100);
			resize(500, 400);
			
			titleVendor.setFont(titleFont);
			titleVendor.setBounds(160, 20, 200, 30); add(titleVendor);
			vendors.setBounds(50, 70, 400, 200); add(vendors);
			
			btnMenu.setBounds(20, 360, 75, 20); add(btnMenu);
			remove(lblMenu);
			remove(btnInventory);
			remove(btnOrder);
			remove(btnEmployee);
			remove(btnVendor);
		}
		else if (e.getSource() == btnEmployee) {
			setLayout(null);
			setLocation(200, 100);
			resize(500, 400);
			
			titleEmployee.setFont(titleFont);
			titleEmployee.setBounds(160, 20, 200, 30); add(titleEmployee);
			employees.setBounds(50, 70, 400, 200); add(employees);
			
			btnMenu.setBounds(20, 360, 75, 20); add(btnMenu);
			remove(lblMenu);
			remove(btnInventory);
			remove(btnOrder);
			remove(btnEmployee);
			remove(btnVendor);
		}
		if (e.getSource() == btnMenu) {
			setLayout(null);
			resize(400, 300);
			
			remove(titleInventory);
			remove(btnMenu);
			remove(products);
			remove(titleEmployee);
			remove(employees);
			remove(titleVendor);
			remove(vendors);
			
			
			String userName = username.getText().trim();
			
			lblMenu = new Label("Welcome " + userName);
			
			
			Font btnFont = new Font("Ariel", Font.BOLD, 16);
			
			Font font = new Font("Ariel", Font.BOLD, 20);				
			lblMenu.setFont(font);
			lblMenu.setBounds(10, 10, 300, 100); add(lblMenu);	
			
			btnInventory.setFont(btnFont); btnInventory.setBounds(50, 150, 100, 60); add(btnInventory);
			btnOrder.setFont(btnFont); btnOrder.setBounds(180, 150, 100, 60); add(btnOrder);
			btnEmployee.setFont(btnFont); btnEmployee.setBounds(50, 230, 100, 60); add(btnEmployee);
			btnVendor.setFont(btnFont); btnVendor.setBounds(180, 230, 100, 60); add(btnVendor);
		}
		
	}
	
}
