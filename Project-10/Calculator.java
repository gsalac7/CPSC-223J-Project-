import javax.swing.*;
import javax.swing.event.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends Applet implements ActionListener{
	Button
		oneBtn = new Button("1"),
		twoBtn = new Button("2"),
		threeBtn = new Button("3"),
		fourBtn = new Button("4"),
		fiveBtn = new Button("5"),
		sixBtn = new Button("6"),
		sevenBtn = new Button("7"),
		eightBtn = new Button("8"),
		nineBtn = new Button("9"),
		zeroBtn = new Button("0"),
		
		subBtn = new Button("-"),
		multBtn = new Button("*"),
		divBtn = new Button("/"),
		addBtn = new Button("+"),
		factBtn = new Button("n!"),
		signBtn = new Button("+/-"),
		eqBtn = new Button("="),
		clearBtn = new Button("Clear");
	TextField
		txtWin = new TextField();
	
	String n = " ", n1st, n2nd, operation;
	int n1, n2;
	
	public void init() {
		
		setLayout(null);
		
		txtWin.setBounds(30, 10, 240, 90);	add(txtWin);
		
		//first row
		sevenBtn.setBounds(30, 120, 50, 50); add(sevenBtn);
		eightBtn.setBounds(90, 120, 50, 50); add(eightBtn);
		nineBtn.setBounds(150, 120, 50, 50); add(nineBtn);
		addBtn.setBounds(220, 120, 50,  50); add(addBtn);
		
		//second row
		fourBtn.setBounds(30, 180, 50, 50); add(fourBtn);
		fiveBtn.setBounds(90, 180, 50, 50); add(fiveBtn);
		sixBtn.setBounds(150, 180, 50, 50); add(sixBtn);
		subBtn.setBounds(220, 180, 50, 50); add(subBtn);
		
		//third row
		oneBtn.setBounds(30, 240, 50, 50); add(oneBtn);
		twoBtn.setBounds(90, 240, 50, 50); add(twoBtn);
		threeBtn.setBounds(150,240, 50, 50); add(threeBtn);
		multBtn.setBounds(220, 240, 50, 50); add(multBtn);
		
		//fourth row
		zeroBtn.setBounds(30, 300, 50, 50); add(zeroBtn);
		eqBtn.setBounds(90, 300, 110, 50); add(eqBtn);
		divBtn.setBounds(220, 300, 50, 50); add(divBtn);
		
		//fifth row
		signBtn.setBounds(30, 360, 50, 50); add(signBtn);
		clearBtn.setBounds(90, 360, 110, 50); add(clearBtn);
		factBtn.setBounds(220, 360, 50, 50); add(factBtn);
		
		oneBtn.addActionListener(this);
		twoBtn.addActionListener(this);
		threeBtn.addActionListener(this);
		fourBtn.addActionListener(this);
		fiveBtn.addActionListener(this);
		sixBtn.addActionListener(this);
		sevenBtn.addActionListener(this);
		eightBtn.addActionListener(this);
		nineBtn.addActionListener(this);
		zeroBtn.addActionListener(this);
		subBtn.addActionListener(this);
		multBtn.addActionListener(this);
		divBtn.addActionListener(this);
		factBtn.addActionListener(this);
		signBtn.addActionListener(this);
		addBtn.addActionListener(this);
		eqBtn.addActionListener(this);
		clearBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == oneBtn)
		{ n += "1"; txtWin.setText(n);}
		else if(e.getSource() == twoBtn) 
		{ n += "2"; txtWin.setText(n);}
		else if (e.getSource() == threeBtn) 
		{ n+= "3"; txtWin.setText(n);}
		else if (e.getSource() == fourBtn)
		{ n+= "4"; txtWin.setText(n);}
		else if (e.getSource() == fiveBtn)
		{ n+= "5"; txtWin.setText(n);}
		else if(e.getSource() == sixBtn)
		{ n+= "6"; txtWin.setText(n);}
		else if(e.getSource() == sevenBtn)
		{ n+= "7"; txtWin.setText(n);}
		else if (e.getSource() == eightBtn)
		{ n += "8"; txtWin.setText(n);}
		else if (e.getSource() == nineBtn)
		{ n+= "9"; txtWin.setText(n);}
		else if (e.getSource() == zeroBtn)
		{ n+= "0"; txtWin.setText(n);}
		
		else if(e.getSource() == subBtn) {
			operation = "-";
			n = txtWin.getText().trim();
			n1 = Integer.parseInt(n);
			n = " ";
			txtWin.setText(" ");
		}
		else if (e.getSource() == addBtn) {
			operation = "+";
			n = txtWin.getText().trim();
			n1 = Integer.parseInt(n);
			n = " ";
			txtWin.setText(" ");
		}
		else if (e.getSource() == multBtn) {
			operation = "*";
			n = txtWin.getText().trim();
			n1 = Integer.parseInt(n);
			n = " ";
			txtWin.setText(" ");
		}
		else if (e.getSource() == divBtn) {
			operation = "/";
			n = txtWin.getText().trim();
			n1 = Integer.parseInt(n);
			n = " ";
			txtWin.setText(" ");
		}
		else if (e.getSource() == factBtn) {
			n = txtWin.getText().trim();
			n1 = Integer.parseInt(n);
			txtWin.setText(Integer.toString(factorial(n1)));
		}
		else if (e.getSource() == eqBtn) {
			n = txtWin.getText().trim();
			n2 = Integer.parseInt(n);
			n = " ";
			n1st = Integer.toString(n1);
			n2nd = Integer.toString(n2);
			
			if (operation.equals("+")) {
				txtWin.setText(n1st + " + " + n2nd + " = " + Integer.toString(n1 + n2));
			}
			else if (operation.equals("-")) {
				txtWin.setText(n1st + " - " + n2nd + " = " + Integer.toString(n1 - n2));
			}
			else if(operation.equals("*")) {
				txtWin.setText(n1st + " * " + n2nd + " = " + Integer.toString(n1 * n2));
			}
			else if (operation.equals("/")) {
				txtWin.setText(n1st + " / " + n2nd + " = " + Integer.toString(n1 / n2));
			}
		}
		else if (e.getSource() == signBtn) {
			n = txtWin.getText().trim();
			if (n.charAt(0) == '-') {
				
				txtWin.setText(n.substring(1, n.length()));
			}
			else {
				txtWin.setText("-" + n);
			}
		}
		else if (e.getSource() == clearBtn){
			txtWin.setText(" ");
			n = " ";
		}
		
	}
	
	public int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		else if (n == 1) {
			return 1;
		}
		else {
			return factorial(n - 1) * n;
		}
	}
}
