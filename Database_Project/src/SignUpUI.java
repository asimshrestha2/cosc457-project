import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class SignUpUI extends JFrame implements ActionListener{
	private JTextField emailText, passwordText, cpasswordText, fName, midInitial, lName,
	 adstreet, adcity, adzip, adState, phoneNumber, addPhoneNumber, birthDate, anniDate;
	
	private JLabel errorL;
	
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
        
		textFieldPanel.add(new JLabel("Email:") {
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(emailText);
		textFieldPanel.add(new JLabel("Password:"){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(passwordText);
		textFieldPanel.add(new JLabel("Confirm Password:"){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(cpasswordText);
		textFieldPanel.add(new JLabel("First Name:"){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(fName);
		textFieldPanel.add(new JLabel("Middle Initial:"){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(midInitial);
		textFieldPanel.add(new JLabel("Last Name:"){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(lName);
		textFieldPanel.add(new JLabel("Street:"){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(adstreet);
		textFieldPanel.add(new JLabel("City:"){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(adcity);
		textFieldPanel.add(new JLabel("Zip Code:"){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(adzip);
		textFieldPanel.add(new JLabel("State:"){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(adState);
		textFieldPanel.add(new JLabel("Phone Number:"){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(phoneNumber);
		textFieldPanel.add(new JLabel("Additional Phone Number:"){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(addPhoneNumber);
		textFieldPanel.add(new JLabel("Birth Date:"){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(birthDate);
		textFieldPanel.add(new JLabel("Anniversary Date:"){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
		});
		textFieldPanel.add(anniDate);
		textFieldPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		
		textFieldPanel.setBackground(SessionData.getBgColor());
		listPane.setBackground(SessionData.getBgColor());
		setBackground(SessionData.getBgColor());
		
		listPane.add(textFieldPanel);
		
		JButton signUpBtn = new JButton("Sign Up");
		signUpBtn.addActionListener(this);
		signUpBtn.setActionCommand("signupmain");
                
        JButton backBtn = new JButton("Back");
		backBtn.addActionListener(this);
		backBtn.setActionCommand("backback");
		
		listPane.add(backBtn);
		listPane.add(signUpBtn);
		
		errorL = new JLabel(" ", SwingConstants.CENTER);
        errorL.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        errorL.setForeground(Color.RED);
		
		listPane.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
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
			DBConnection db = new DBConnection();
			Boolean allowE = false;
			String emailTextS = emailText.getText()
					, passwordTextS = passwordText.getText()
					, cpasswordTextS = cpasswordText.getText()
					, fNameS = fName.getText()
					, midInitialS = midInitial.getText()
					, lNameS = lName.getText()
					, adstreetS = adstreet.getText()
					, adcityS = adcity.getText()
					, adzipS = adzip.getText()
					, adStateS = adState.getText()
					, phoneNumberS = phoneNumber.getText()
					, addPhoneNumberS = addPhoneNumber.getText()
					, birthDateS = birthDate.getText()
					, anniDateS = anniDate.getText();
			
			
			if(emailText.getText() != "" && passwordText.getText() != "" && cpasswordTextS.equals(passwordTextS) &&
			   fName.getText() != "" && midInitial.getText() != "" && lName.getText() != "" &&
			   adstreet.getText() != "" && adcity.getText() != "" && adzip.getText() != "" && adState.getText() != "" &&
			   phoneNumber.getText() != "" && addPhoneNumber.getText() != "" && 
			   birthDate.getText() != "" && anniDate.getText() != ""){
				allowE = true;
			} else {
				errorL.setText("Please Complete the Form.");
			}
			
			if(allowE){
				try {
					db.executeUpdate("INSERT INTO Cust (`Fname`, `Lname`, `MiddleInt`, `Street`, `City`, `Zip`, `State`, `Phone1`, `Phone2`, `Email`, `DOB`, `RewardTot`)"
							+ " VALUES ('"+fNameS+"', '" + lNameS +"', '"+midInitialS+"', '"+adstreetS+"',"
							+ " '"+adcityS+"', '"+adzipS+"', '"+adStateS+"', '"+phoneNumberS+"', '"+addPhoneNumberS+"', '"+emailTextS+"', '"+birthDateS+"', '0');");
					ResultSet rels = db.executeQuary("select Customer_ID from Cust where Email='"+ emailTextS +"';");
					
					String userID = null;
			        if(rels.next()){
		        	   userID = rels.getString(1);
		        	}
					
					db.executeUpdate("INSERT INTO Clogin(`Customer_ID`, `Password`) VALUES('"+ userID +"','" + passwordTextS + "')");
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		}
        if(cmd.equals("backback")){
            //Go back
        	dispose();
        }
	}
}
