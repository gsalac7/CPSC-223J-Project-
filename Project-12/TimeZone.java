import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TimeZone extends Applet implements ActionListener, ItemListener {
	Calendar c = Calendar.getInstance();
	int hour = c.get(Calendar.HOUR);
	int minute = c.get(Calendar.MINUTE);
	int second = c.get(Calendar.SECOND);
	 
	Image img, img2;
	String []pic = {"Time Zone Images/f1.gif", "Time Zone Images/f2.png", "Time Zone Images/f3.gif", "Time Zone Images/f4.gif"};
	String []pics = {"Time Zone Images/GoldenGateBridge.jpg", "Time Zone Images/MountanRushmore.jpg", "Time Zone Images/SearsTower.jpg", "Time Zone Images/Liberty.jpg"};
	Choice times = new Choice();
	
	Label
		title = new Label("Welcome to the United States of America"),
		select = new Label("Select time zone"),
		time = new Label("Time");
	
	TextField
		zoneField = new TextField(),
		timeField = new TextField();
	
	
	Button
		showBtn = new Button("Show Info");
	

	public void init() {
		setLayout(null);
		resize(900, 400);
		
		img = getImage(getDocumentBase(), pic[0]);
		img2 = getImage(getDocumentBase(), pics[0]);
		
		String []zones = {"Pacific", "Mountain", "Central", "Eastern"};
		for (int i = 0; i < zones.length; i++) {
			times.add(zones[i]);
		}
		
		Font f = new Font("Ariel", Font.BOLD, 17);
		title.setFont(f);
		title.setBounds(200, 20, 400, 30);	add(title);
		
		select.setBounds(40, 100, 100, 30);	add(select);
		
		times.setBounds(20, 130, 100, 20);	add(times);
		
		time.setBounds(40, 180, 100, 20);	add(time);
		
		timeField.setBounds(20, 200, 100, 20);	add(timeField);
		showBtn.setBounds(20, 230, 100, 40);	add(showBtn);
		showBtn.addActionListener(this);
		times.addItemListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Label zone = new Label("zones");
		if (e.getSource() == showBtn) {
			if (times.getSelectedItem().equals("Pacific")) {
				remove(zone);
				img = getImage(getDocumentBase(), pic[0]);
				img2 = getImage(getDocumentBase(), pics[0]);
				zone = new Label("Pacific Zone");
				zone.setBounds(260, 60, 200, 30);	add(zone);
				timeField.setText(Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(second));
				repaint();
			}
			else if (times.getSelectedItem().equals("Mountain")) {
				img = getImage(getDocumentBase(), pic[2]);
				img2 = getImage(getDocumentBase(), pics[1]);
				zone = new Label("Mountain Zone");
				zone.setBounds(260, 60, 200, 30);	add(zone);
				hour += 1;
				timeField.setText(Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(second));
				repaint();
			}
			else if(times.getSelectedItem().equals("Central")) {
				img = getImage(getDocumentBase(), pic[3]);
				img2 = getImage(getDocumentBase(), pics[2]);
				zone = new Label("Midwest Zone");
				zone.setBounds(260, 60, 200, 30);	add(zone);
				timeField.setText(Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(second));
				repaint();
			}
			else if (times.getSelectedItem().equals("Eastern")) {
				img = getImage(getDocumentBase(), pic[1]);
				img2 = getImage(getDocumentBase(), pics[3]);
				Label eastern = new Label("Eastern Zone");
				eastern.setBounds(260, 60, 200, 30);	add(eastern);
				hour = hour + 3;
				timeField.setText(Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(second));
				repaint();
			}
		}
	}


	public void paint(Graphics g) {
		g.drawImage(img, 200, 90, 230, 300, this);
		g.drawImage(img2, 600, 90, 230, 300, this);
	}

	
	public void itemStateChanged(ItemEvent e) {
		
	}
	
	
}
