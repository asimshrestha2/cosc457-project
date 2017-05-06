
import java.sql.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Dbstart extends JFrame implements ActionListener{
    DBConnection dbconnection = new DBConnection();
    JTextField userText;
    JPasswordField passWord;
    JLabel errorL;
    JRadioButton customerBtn;
    JRadioButton employeeBtn;
    String[] userType = {"",""};
	
	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		/* This how to execute quary and get the result:
		 * DBConnection dbconnection = new DBConnection();
		 * ResultSet rels = dbconnection.executeQuary("select * from Staff;");
		 * while(rels.next()){
		 * System.out.print(rels.getString("fname"));
		 * System.out.print("\t");
		 * System.out.print(rels.getString("lname")+"\n");
		 * }
		*/
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Dbstart().setVisible(true);
			}
		});
	}
	
	public Dbstart() {
		// TODO Auto-generated method stub
		super("Paramount Perks");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setPreferredSize(new Dimension(500, 500));

        // Add a layout manager so that the button is not placed on top of the label
		JPanel inputPanel = new JPanel(new GridLayout(0, 1));
		
        inputPanel.setBackground(SessionData.getBgColor());
                
        setLayout(new BorderLayout(5,5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        // Add a label and a button
        userText = new JTextField(12);
        passWord = new JPasswordField(12);
        
        JButton loginBtn = new JButton("Login");
        JButton signupBtn = new JButton("Sign Up");
        JButton menuBtn = new JButton("Menu");
        JButton infoBtn = new JButton("Info");
        
        errorL = new JLabel(" ", SwingConstants.CENTER);
        errorL.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        errorL.setForeground(Color.RED);
        errorL.setBackground(SessionData.getBgColor());

        //Setting Up the RadioButtons
        customerBtn = new JRadioButton("Customer");
        employeeBtn = new JRadioButton("Employee");
        
        customerBtn.setForeground(Color.WHITE);
        employeeBtn.setForeground(Color.WHITE);
        customerBtn.setBackground(SessionData.getBgColor());
        employeeBtn.setBackground(SessionData.getBgColor());

        customerBtn.addActionListener(this);
        employeeBtn.addActionListener(this);
        
        customerBtn.setActionCommand("Customer");
        employeeBtn.setActionCommand("Employee");
        
        ButtonGroup group = new ButtonGroup();
		group.add(customerBtn);
		group.add(employeeBtn);
		
		JPanel radioPanel = new JPanel(new GridLayout(1, 0));
        radioPanel.add(customerBtn);
        radioPanel.add(employeeBtn);
        
        JPanel btnPanel = new JPanel(new GridLayout(1, 0, 10, 10));
        btnPanel.setBackground(SessionData.getBgColor());

        btnPanel.add(loginBtn);
        btnPanel.add(signupBtn);
        btnPanel.add(menuBtn);
        btnPanel.add(infoBtn);
        
        loginBtn.addActionListener(this);
        loginBtn.setActionCommand("login");
        
        signupBtn.addActionListener(this);
        signupBtn.setActionCommand("signup");
        
        menuBtn.addActionListener(this);
        menuBtn.setActionCommand("menu");
        
        infoBtn.addActionListener(this);
        infoBtn.setActionCommand("info");
        
        inputPanel.add(new JLabel("Username: "){
        	public void setForeground(Color fg) {
        		super.setForeground(Color.WHITE);
        	}
        });
        inputPanel.add(userText);
        inputPanel.add(new JLabel("Password: "){
        	public void setForeground(Color fg) {
        		super.setForeground(Color.WHITE);
        	}
        });
        inputPanel.add(passWord);
        inputPanel.add(radioPanel);
        inputPanel.add(btnPanel);

        // Arrange the components inside the window
        add(inputPanel, BorderLayout.CENTER);
        add(errorL, BorderLayout.PAGE_END);
        setBackground(SessionData.getBgColor());
        pack();
        setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		switch (cmd) {
		case "login":
			if(userText.getText().equals("") || passWord.getText().equals("")){
				errorL.setText("Username or Password Missing!");
			} else {
				//Checks for user in DB
				try {
					ResultSet rels;
					if(userType[1].equals("Customer")){
						rels = dbconnection.executeQuary("select Cl.Customer_ID " +
														"from Cust C inner join Clogin Cl " + 
														"on C.Customer_ID = Cl.Customer_ID " +
														"where Email='"+userText.getText()+"' and Password='"+ passWord.getText() + "';");
						rels.last();
				        int size = rels.getRow();
				        rels.beforeFirst();
				        String userID = null;
				        if(rels.next()){
			        	   userID = rels.getString(1);
			        	}
				        if(size == 1){
							dispose();
							new CustomerGUI(userText.getText(), userID);
						} else {
							errorL.setText("Username or password is Incorrect.");
						}
					} else if(userType[1].equals("Employee")){
						rels = dbconnection.executeQuary("select * from Elogin where Employee_ID=" + userText.getText() + " and password='"+ passWord.getText() +"';");
						rels.last();
				        int size = rels.getRow();
				        rels.beforeFirst();
						System.out.println(size);
						if(size == 1){
							dispose();
							new EmployeeGUI(userText.getText());
						} else {
							errorL.setText("Username or password is Incorrect.");
						}
					} else {
						errorL.setText("Please select 'Customer' or 'Employee'.");
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			break;
		case "Customer":
			userType[0] = "Clogin";
			userType[1] = "Customer";
			break;
		case "Employee":
			userType[0] = "Elogin";
			userType[1] = "Employee";
			break;
		case "signup":
			new SignUpUI();
			break;
        case "menu":
            new MenuGUI();
            break;
        case "info":
            new InfoGUI();
            break;
		default:
			break;
		}
	}

}
