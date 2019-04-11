import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.text.*;
import java.util.Arrays;
class Admin extends JFrame implements ActionListener{
	
	private JPasswordField passwordField;
	private	JLabel passwordLavel;
	private JButton submitButton;
	private char []  password;
	private JLabel massageLabel;
public Admin()
{
	//password
	password=new char[] {'s','h','a','m','i','k'};
	
	//label
	
	massageLabel = new JLabel ("Wrong Password");
	massageLabel.setBounds(250,320,100,20);
	massageLabel.setVisible(false);
	add(massageLabel);
	
	passwordLavel=new JLabel("Password : ");
	passwordLavel.setBounds(150,200,100,20);
	add(passwordLavel);
	
	
	//password
	passwordField = new JPasswordField(20);
	passwordField.setBounds(250,200,100,25);
	add(passwordField);
	
	//button
	
	submitButton=new JButton("Submit");
	submitButton.addActionListener(this);	
	submitButton.setBounds(220,250,100,45);
	add(submitButton);
	
	
	//window close 
	addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
	        System.exit(0);
         }        
      });   
	
	setTitle("Smart Doctor");
	setSize(600,600);
	setLayout(null);
	setVisible(true);
	
}


	
public void actionPerformed(ActionEvent e){
	if (e.getSource()==submitButton){
		if (Arrays.equals(password, passwordField.getPassword())) {
			AdminPanel a=new AdminPanel();			
		}
		else {
			massageLabel.setVisible(true);
		}
	}
}
	
}