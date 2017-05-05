import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SignUpUI extends JFrame implements ActionListener{
	private JTextField emailText, passwordText, cpasswordText, fName, midInitial, lName,
	 adstreet, adcity, adzip, adState, phoneNumber, addPhoneNumber, birthDate, anniDate;
	
	public SignUpUI(){
		super("Sign Up");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setLayout(new GridLayout(0, 1));
        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));
        JPanel textFieldPanel = new JPanel(new GridLayout(0, 2, 15, 10));
        //All the sign up fields
		emailText = new JTextField(12);
		passwordText = new JTextField(12);
		cpasswordText = new JTextField(12);
		fName = new JTextField(12);
		midInitial = new JTextField(12);
		lName = new JTextField(12);
		adstreet = new JTextField(12);
		adcity = new JTextField(12);
		adzip = new JTextField(12);
		adState = new JTextField(12);
		phoneNumber = new JTextField(12);
		addPhoneNumber = new JTextField(12);
		birthDate = new JTextField(12);
		anniDate = new JTextField(12);
		
		textFieldPanel.add(new JLabel("Email:"));
		textFieldPanel.add(emailText);
		textFieldPanel.add(new JLabel("Password:"));
		textFieldPanel.add(passwordText);
		textFieldPanel.add(new JLabel("Confirm Password:"));
		textFieldPanel.add(cpasswordText);
		textFieldPanel.add(new JLabel("First Name:"));
		textFieldPanel.add(fName);
		textFieldPanel.add(new JLabel("Middle Initial:"));
		textFieldPanel.add(midInitial);
		textFieldPanel.add(new JLabel("Last Name:"));
		textFieldPanel.add(lName);
		textFieldPanel.add(new JLabel("Street:"));
		textFieldPanel.add(adstreet);
		textFieldPanel.add(new JLabel("City:"));
		textFieldPanel.add(adcity);
		textFieldPanel.add(new JLabel("Zip Code:"));
		textFieldPanel.add(adzip);
		textFieldPanel.add(new JLabel("State:"));
		textFieldPanel.add(adState);
		textFieldPanel.add(new JLabel("Phone Number:"));
		textFieldPanel.add(phoneNumber);
		textFieldPanel.add(new JLabel("Additional Phone Number:"));
		textFieldPanel.add(addPhoneNumber);
		textFieldPanel.add(new JLabel("Birth Date:"));
		textFieldPanel.add(birthDate);
		textFieldPanel.add(new JLabel("Anniversary Date:"));
		textFieldPanel.add(anniDate);
		textFieldPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		
		listPane.add(textFieldPanel);
		
		JButton signUpBtn = new JButton("Sign Up");
		signUpBtn.addActionListener(this);
		signUpBtn.setActionCommand("signupmain");
		
		listPane.add(signUpBtn);
		add(listPane);
		
		pack();
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String cmd = ae.getActionCommand();
		System.out.println(cmd);
		if(cmd.equals("signupmain")){
			
		}
	}
}
