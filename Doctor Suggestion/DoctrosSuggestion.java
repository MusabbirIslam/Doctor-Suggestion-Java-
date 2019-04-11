import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DoctrosSuggestion extends JFrame implements ActionListener{
	
	//Level
	private JLabel doctorSuggestion;
	//Button
	private JButton back;
	private FirstPage previousFrame;
	private JTextArea suggestionArea;
	private String quary;
public DoctrosSuggestion(FirstPage p ,String quary) {
	
	previousFrame=p;
	this.quary=quary;
	//label
	doctorSuggestion=new JLabel("Doctor's Suggestion : ");
	doctorSuggestion.setBounds(20,20,150,100);
	
	//Text area
	suggestionArea = new JTextArea(quary);
	suggestionArea.setFont(new Font("Serif", Font.ITALIC, 16));
	suggestionArea.setLineWrap(true);
	suggestionArea.setWrapStyleWord(true);
	suggestionArea.setEditable(false);
	
	JScrollPane suggestionScrollPane = new JScrollPane(suggestionArea);
	suggestionScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	suggestionScrollPane.setPreferredSize(new Dimension(250, 250));
	suggestionScrollPane.setBounds(40,150,500,300);
	
	//button
	back = new JButton("Back");
	
	//ACTION LISTENER
	back.addActionListener(this);	
	back.setBounds(200,500,100,45);
	
	add(doctorSuggestion);
	add(back);
	add(suggestionScrollPane);
	
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
		if (e.getSource()==back) {
			previousFrame.setVisible(true);
			this.dispose();
		}
}			
}
	