import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TicketBox extends Applet implements ActionListener, AdjustmentListener
{
	Button
		buyBtn = new Button("Buy Ticket(s)");
	Label
		title = new Label("Chip Tickets Agency"),
		depart = new Label("Depart"),
		arrive = new Label("Arrive"),
		cityAirport = new Label("City/Airport"),
		cityAirport1 = new Label("City/Airport"),
		name = new Label("Name"),
		phone = new Label("Phone number"),
		tickets = new Label("Number of tickets"),
		type = new Label("Type of tickets"),
		conformation = new Label("Conformation");
	TextField
		txtName = new TextField(),
		txtNumber = new TextField(),
		txtTickets = new TextField();
	TextArea
		txtList = new TextArea("", 10, 20, TextArea.SCROLLBARS_VERTICAL_ONLY);
	Scrollbar
		sb1 = new Scrollbar(0, 10, 10, 0, 30);

	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox chkFirst = new Checkbox("First Class", cbg, false),
			chkEconomy = new Checkbox("Economy Class", cbg, false),
			chkBusiness = new Checkbox("Business Class", cbg, false);
	
	List listDep = new List(5);
	List listArr = new List(5);
	
	
	public void init() 
	{
		setLayout(null);
		
		listDep.setBounds(20, 120, 100, 100); add(listDep);
		listArr.setBounds(140, 120, 100, 100);add(listArr);
		title.setBounds(150, 20, 300, 30); add(title);
		
		depart.setBounds(20, 50, 70, 30); add(depart);
		arrive.setBounds(140, 50, 70, 30); add(arrive);
		cityAirport.setBounds(20, 90, 90, 30); add(cityAirport);
		cityAirport1.setBounds(140, 90, 90, 30); add(cityAirport1);
		
		
		title.setFont(new Font("Ariel", Font.BOLD, 25));
		depart.setFont(new Font("Ariel", Font.BOLD, 17));
		arrive.setFont(new Font("Ariel", Font.BOLD, 17));
		cityAirport.setFont(new Font("Ariel", Font.BOLD, 15));
		cityAirport1.setFont(new Font("Ariel", Font.BOLD, 15));
		
		String[] cities = {"LAX", "Ontario", "John Wayne", "JFK", "Fullerton", "La Verne", "New York", "Paris", "London", "Hawaii", "Dallas", "Seattle", "Portland", "Las Vegas", "Tokyo", "Seoul", "Miami", "Houston", "Rome", "Vancouver"};
		
		java.util.Arrays.sort(cities);
		for (int i = 0; i < cities.length; i++)
		{
			listDep.add(cities[i]);
			listArr.add(cities[i]);
		}
		
		name.setBounds(260, 120, 80, 30); add(name);
		phone.setBounds(260, 170, 150, 30); add(phone);
		
		txtName.setBounds(260, 150, 150, 23); add(txtName);
		txtNumber.setBounds(260, 200, 150, 23); add(txtNumber);
		
		name.setFont(new Font("Ariel", Font.BOLD, 16));
		phone.setFont(new Font("Ariel", Font.BOLD, 16));
		
		tickets.setBounds(20, 250, 150, 20); add(tickets);
		sb1.setBounds(200, 250, 150, 20); add(sb1);
		txtTickets.setBounds(420, 250, 30, 23); add(txtTickets);
		type.setBounds(20, 300, 200, 20); add(type);
		
		tickets.setFont(new Font("Ariel", Font.BOLD, 16));
		type.setFont(new Font("Ariel", Font.BOLD, 16));
		
		chkFirst.setBounds(20, 330, 100, 20); add(chkFirst);
		chkEconomy.setBounds(20, 360, 150, 20); add(chkEconomy);
		chkBusiness.setBounds(20, 390, 150, 20); add(chkBusiness);
		buyBtn.setBounds(40, 410, 100, 30); add(buyBtn);
		
		chkFirst.setFont(new Font("Ariel", Font.PLAIN, 15));
		chkEconomy.setFont(new Font("Ariel", Font.PLAIN, 15));
		chkBusiness.setFont(new Font("Ariel", Font.PLAIN, 15));
		
		conformation.setBounds(280, 290, 150, 20); add(conformation);
		txtList.setBounds(200, 320, 280, 180); add(txtList);
		
		conformation.setFont(new Font("Ariel", Font.BOLD, 16));
		
		buyBtn.addActionListener(this);
		sb1.addAdjustmentListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		txtList.setText("");
		if (e.getSource() == buyBtn)
		{
			String name = txtName.getText().trim();
			String num = txtNumber.getText().trim();
			
			txtList.append("Name: " + name + "\n" + "Phone No. " + num + "\n");
			
			String deptCity = listDep.getSelectedItem();
			String arrCity = listArr.getSelectedItem();
			
			txtList.append("Dept City: " + deptCity + "\n" + "Arrival City: " + arrCity + "\n");
			if (chkFirst.getState() == true)
			{
				txtList.append("Ticket Type: First Class\n");
			}
			else if (chkEconomy.getState() == true)
			{
				txtList.append("Ticket Type: Economy Class\n");
			}
			else if (chkBusiness.getState()== true)
			{
				txtList.append("Ticket Type: Business Class\n");
			}
			
			String tickets = txtTickets.getText().trim();
			txtList.append("Number of tickets: " + tickets);
		}
		
		txtName.requestFocus();
	}
	
	public void adjustmentValueChanged(AdjustmentEvent a)
	{
		if (a.getSource() == sb1)
		{
			txtTickets.setText(Integer.toString(sb1.getValue()));
		}
	}
		
	
}
