import java.sql.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Dbstart extends JFrame implements ActionListener{
	
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
		super("Simple GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(400, 400);
        // Add a layout manager so that the button is not placed on top of the label
        setLayout(new GridLayout(5,1));
        // Add a label and a button
        JTextField userText = new JTextField(8);
        JPasswordField passWord = new JPasswordField(8);
        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        loginBtn.setActionCommand("login");
        add(userText);
        add(passWord);
        add(loginBtn);
        
        // Arrange the components inside the window
        pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if(cmd.equals("login")){
			dispose();
			new CustomerGUI();
		}
	}

}
