import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.text.*;
import java.util.Arrays;
class AdminPanel extends JFrame implements ActionListener{
	
	private JButton SHowDataButton;
public AdminPanel()
{
	//button
	
	SHowDataButton=new JButton("Show Data");
	SHowDataButton.addActionListener(this);	
	SHowDataButton.setBounds(50,50,100,45);
	add(SHowDataButton);
	
	
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
		if (e.getSource()==SHowDataButton) {
			//AddDisease a = new AddDisease();
		}
}	
	
}