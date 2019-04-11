import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.text.*;
class FirstPage extends JFrame implements ActionListener{
	
	//Level
	private JLabel headerLabel;
	private JLabel ageLabel;
	private JLabel genderLabel;
	private JLabel sicknessLabel;
	private JLabel adminLabel;
	
	//Button
	private JRadioButton male;
	private JRadioButton female;
	private JButton submitButton;
	private JScrollPane agePane; 
	
	//checkbox
	private JCheckBox [] symptomps;
	
	//combobox
	private JComboBox ageCombo ;
	
	private ButtonGroup radioButtonGroup;
public FirstPage() {
	
	int levelX=150;
	int levelY=100;
	int levelW=70;
	int levelH=100;
		
	headerLabel = new JLabel ("Please Fill up this form");
	ageLabel = new JLabel ("Age : ");
	genderLabel = new JLabel ("Gender : ");
	sicknessLabel= new JLabel ("Sickness type : ");
	
	headerLabel.setBounds(200,20,300,levelW);
	ageLabel.setBounds(levelX,levelY,levelH,levelW);
		
	//age combo box;
    String [] ageRange = {"0-12","13-22","22-40"};
	ageCombo = new JComboBox(ageRange);    
    ageCombo.setSelectedIndex(0);
	agePane = new JScrollPane(ageCombo);
	agePane.setBounds(levelX+50,levelY+20,200,30);;
	
	genderLabel.setBounds(levelX,levelY+50,levelH,levelW);
	sicknessLabel.setBounds(levelX,levelY+100,levelH,levelW);
	
	//admin lavel
	adminLabel = new JLabel("Admin");
	adminLabel.setBounds(510,0,levelH,levelW);
	adminLabel.setForeground(Color.red);
	adminLabel.setToolTipText("Log in as ADMIN.");
	adminLabel.addMouseListener(new MouseAdapter()  
	{  
		public void mouseClicked(MouseEvent e)  
		{
			setVisible(false);
			Admin admin=new Admin();
		}  
	});

	
	//radio button
	male=new JRadioButton("Male");
	male.setActionCommand("Male");	
	male.setSelected(true);
	male.setBounds(levelX+100,levelY+50,100,levelW);
	female=new JRadioButton("Female");  
	female.setActionCommand("Female");
	female.setBounds(levelX+200,levelY+50,levelH,levelW);
	
	levelY=levelY+150;
	
	String [] symptompsName={"Shivering","Loss of Appetite","Abdonominal Pain","Dehydradion","Headache","Watery Stool","Mild coughing","Runny Nose","Vomiting","Fatigue","Muscle Pain","Lathergy"};
	
	int size=symptompsName.length;
	int column=3;
	int row=(size/column);
	//Symptomps checkboxes
	symptomps=new JCheckBox[size];
	
	for(int i=0;i<=row;i++)
	{
		for(int j=0;j<column;j++)
		{
			int index=(i*column)+j;
			
			if(!(index<size))
			break;
			String text="<html>"+symptompsName[index]+"</html>";
			symptomps[index]=new JCheckBox(text);
			symptomps[index].setBounds(levelX+(100*j),levelY,levelH,levelW);
			add(symptomps[index]);
		}
			levelY=levelY+70;
	}
	
	//button group
	radioButtonGroup=new ButtonGroup();  
	radioButtonGroup.add(male);
	radioButtonGroup.add(female);
	
	levelY=levelY+30;
	//submit button
	submitButton = new JButton("Submit");
	submitButton.setBounds(200,levelY,100,45);
	
	//ACTION LISTENER
	
	submitButton.addActionListener(this);	
	
	//adding in frame
	add(headerLabel);
	add(ageLabel);
	add(genderLabel);
	add(male);
	add(female);
	add(submitButton);
	add(sicknessLabel);
	add(agePane);
	add(adminLabel);
	
	
	//window close 
	addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
	        System.exit(0);
         }        
      });   
	
	setTitle("Smart Doctor");
	setSize(800,800);
	setLayout(null);
	setVisible(true);
}
public void actionPerformed(ActionEvent e){
	
	if (e.getSource()==submitButton) {
		String quary="SELECT * FROM Suggestion WHERE gender='"+radioButtonGroup.getSelection().getActionCommand()+"' and age='"+ageCombo.getSelectedItem()+"' " ;
		int size=symptomps.length;
		boolean firstSymptomps=true;
		for(int i=0;i<size;i++)
		{
			if(symptomps[i].isSelected()){
				int index=symptomps[i].getText().indexOf("</html>");
				String symptompName=symptomps[i].getText().substring(6, index);
				if(firstSymptomps)
				{
					
					quary=quary+" and symptomps LIKE '%"+symptompName+"%'";
					firstSymptomps=false;
				}	
				else
				{
					quary=quary+" and symptomps LIKE '%"+symptompName+"%' ";
				}
			}
		}
		System.out.println(quary);
		DoctrosSuggestion doctrosSuggestion=new DoctrosSuggestion(this,quary);
		this.setVisible(false);
		}
}
}
	
