import javax.swing.*;
import javax.swing.event.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CheckIn extends Applet implements ActionListener {
	Label
		lblName = new Label("Name"),
		lblAdd = new Label("Address"),
		lblNum = new Label("Phone Number");
	TextField
		txtName = new TextField(),
		txtAdd = new TextField(),
		txtNum = new TextField();
	Button
		listBtn = new Button("Add to the list");
	TextArea
		txtGuests = new TextArea("Name\t\t\tAddress\t\t\t\tPhone Number", 4, 40, TextArea.SCROLLBARS_BOTH);
	
	
	public void init() {
		setLayout(null);
		lblName.setBounds(10, 10, 70, 20);	add(lblName);
		txtName.setBounds(200, 10, 300, 20);add(txtName);
		lblAdd.setBounds(10, 40, 70, 20);	add(lblAdd);
		txtAdd.setBounds(200, 40, 300, 20);	add(txtAdd);
		lblNum.setBounds(10, 70, 140, 20);	add(lblNum);
		txtNum.setBounds(200, 70, 300, 20);	add(txtNum);
		listBtn.setBounds(320, 140, 120, 40);	add(listBtn);
		txtGuests.setBounds(10, 190, 670, 200);	add(txtGuests);
		
		listBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String line, strName, strAdd, strNum;
		strName = txtName.getText();
		strAdd = txtAdd.getText();
		strNum = txtNum.getText();
		
		line = strName + "\t\t" + strAdd + "\t\t" + strNum;
		txtGuests.append("\n" + line);

		txtName.setText(" ");
		txtAdd.setText(" ");
		txtNum.setText(" ");
		
	
	}
}
