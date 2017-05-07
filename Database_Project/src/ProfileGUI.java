import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ProfileGUI extends JFrame implements ActionListener {

	private JTextField name = new JTextField(), street = new JTextField(), city = new JTextField()
			, zip = new JTextField(), phone1 = new JTextField(), phone2 = new JTextField()
			, email = new JTextField(), rewardPoints = new JTextField();
	JButton editapply;
	private DBConnection db = new DBConnection();
	private String fontName = "Arial";
	private boolean editProfile = false;
	
	private String userID = null;
	public ProfileGUI(String userID) {
		// TODO Auto-generated constructor stub
		super("Profile");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.userID = userID;
		
		JPanel listPane = new JPanel();
        listPane.setBackground(SessionData.getBgColor());
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));
		
		name.setEditable(false);
		street.setEditable(false);
		city.setEditable(false);
		zip.setEditable(false);
		phone1.setEditable(false);
		phone2.setEditable(false);
		email.setEditable(false);
		rewardPoints.setEditable(false);
		
		setUpTextColors();
		listPane.add(name);
		listPane.add(rewardPoints);
		listPane.add(new JLabel("Basic Information: "){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
			
			@Override
			public void setFont(Font font) {
				// TODO Auto-generated method stub
				super.setFont(new Font(fontName, Font.PLAIN, 12));
			}
		});
		listPane.add(street);
		listPane.add(city);
		listPane.add(zip);
		listPane.add(new JLabel("Contact Information: "){
			@Override
			public void setForeground(Color fg) {
				// TODO Auto-generated method stub
				super.setForeground(Color.WHITE);
			}
			
			public void setFont(Font font) {
				// TODO Auto-generated method stub
				super.setFont(new Font(fontName, Font.PLAIN, 12));
			}
			
		});
		listPane.add(phone1);
		listPane.add(phone2);
		listPane.add(email);
		
		listPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		listPane.setBackground(SessionData.getBgColor());
		
		getUserData();
		
		JPanel btnPanel = new JPanel();
		JButton close = new JButton("Close");
		editapply = new JButton("Edit");
		
		close.addActionListener(this);
		editapply.addActionListener(this);
		close.setActionCommand("close");
		editapply.setActionCommand("editapply");
		
		btnPanel.add(close, JButton.LEFT_ALIGNMENT);
		btnPanel.add(editapply, JButton.LEFT_ALIGNMENT);
		
		close.setAlignmentY(LEFT_ALIGNMENT);
		editapply.setAlignmentY(LEFT_ALIGNMENT);
		
		btnPanel.setBackground(SessionData.getBgColor());
		listPane.add(btnPanel);
		
		add(listPane);
		pack();
		setVisible(true);
        setLocationRelativeTo(null);		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String cmd = ae.getActionCommand();
		System.out.println(cmd);
		switch (cmd) {
		case "close":
			dispose();
			break;
		case "editapply":
			System.out.println(editProfile);
			if(editProfile){ 
				//After Pressing Apply
				setEditable(editProfile);
				try {
					db.executeUpdate("UPDATE Cust SET `Street`='" + street.getText() +"', "
							+ "`City`='" + city.getText() + "', `Zip`='" + zip.getText() + "', `Phone1`='" + phone1.getText() + "', "
							+ "`Phone2`='" + phone2.getText() + "', `Email`='" + email.getText() + "' WHERE `Customer_ID`='" + userID + "';");
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				editapply.setText("Edit");
				editProfile = false;
			} else {
				//After Pressing Edit
				setEditable(editProfile);
				editapply.setText("Apply");
				editProfile = true;
			}
			
			break;
		default:
			break;
		}
	}
	
	private void getUserData(){
		try {
			ResultSet result = db.executeQuary("select * from Cust where Customer_ID='"+userID+"';");
			result.last();
	        int size = result.getRow();
	        result.beforeFirst();
	        if(size == 1){
	        	if(result.next()){
		        	name.setText(result.getString("Fname") + " " + result.getString("MiddleInt") + " " + result.getString("Lname"));
		        	street.setText(result.getString("Street"));
		        	city.setText(result.getString("City"));
		        	zip.setText(result.getString("Zip"));
		        	phone1.setText(result.getString("Phone1"));
		        	phone2.setText(result.getString("Phone2"));
		        	email.setText(result.getString("Email"));
		        	rewardPoints.setText("Your Current Reward Points: " + result.getString("RewardTot"));	
	        	}
	        } else {
	        	//Display Error Returning Data
	        }
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setEditable(boolean editable){
		if(editable){
			street.setEditable(false);
			city.setEditable(false);
			zip.setEditable(false);
			phone1.setEditable(false);
			phone2.setEditable(false);
			email.setEditable(false);	
			
			street.setForeground(Color.WHITE);
			city.setForeground(Color.WHITE);
			zip.setForeground(Color.WHITE);
			phone1.setForeground(Color.WHITE);
			phone2.setForeground(Color.WHITE);
			email.setForeground(Color.WHITE);
			
			street.setBackground(SessionData.getBgColor());
			city.setBackground(SessionData.getBgColor());
			zip.setBackground(SessionData.getBgColor());
			phone1.setBackground(SessionData.getBgColor());
			phone2.setBackground(SessionData.getBgColor());
			email.setBackground(SessionData.getBgColor());
		} else {
			street.setEditable(true);
			city.setEditable(true);
			zip.setEditable(true);
			phone1.setEditable(true);
			phone2.setEditable(true);
			email.setEditable(true);	
			
			street.setForeground(Color.BLACK);
			city.setForeground(Color.BLACK);
			zip.setForeground(Color.BLACK);
			phone1.setForeground(Color.BLACK);
			phone2.setForeground(Color.BLACK);
			email.setForeground(Color.BLACK);
			
			street.setBackground(Color.WHITE);
			city.setBackground(Color.WHITE);
			zip.setBackground(Color.WHITE);
			phone1.setBackground(Color.WHITE);
			phone2.setBackground(Color.WHITE);
			email.setBackground(Color.WHITE);
		}
	}
	
	private void setUpTextColors(){
		
		name.setForeground(Color.WHITE);
		name.setPreferredSize(new Dimension(400, 40));
		name.setFont(new Font(fontName, Font.ITALIC, 14));
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setBorder(BorderFactory.createEmptyBorder());
		name.setBackground(SessionData.getBgColor());
		
		street.setForeground(Color.WHITE);
		street.setPreferredSize(new Dimension(400, 30));
		street.setFont(new Font(fontName, Font.PLAIN, 12));
		street.setHorizontalAlignment(SwingConstants.RIGHT);
		street.setBorder(BorderFactory.createEmptyBorder());
		street.setBackground(SessionData.getBgColor());
		
		city.setForeground(Color.WHITE);
		city.setPreferredSize(new Dimension(400, 30));
		city.setFont(new Font(fontName, Font.PLAIN, 12));
		city.setHorizontalAlignment(SwingConstants.RIGHT);
		city.setBorder(BorderFactory.createEmptyBorder());
		city.setBackground(SessionData.getBgColor());
		
		zip.setForeground(Color.WHITE);
		zip.setPreferredSize(new Dimension(400, 30));
		zip.setFont(new Font(fontName, Font.PLAIN, 12));
		zip.setHorizontalAlignment(SwingConstants.RIGHT);
		zip.setBorder(BorderFactory.createEmptyBorder());
		zip.setBackground(SessionData.getBgColor());
		
		phone1.setForeground(Color.WHITE);
		phone1.setPreferredSize(new Dimension(400, 30));
		phone1.setFont(new Font(fontName, Font.PLAIN, 12));
		phone1.setHorizontalAlignment(SwingConstants.RIGHT);
		phone1.setBorder(BorderFactory.createEmptyBorder());
		phone1.setBackground(SessionData.getBgColor());
		
		phone2.setForeground(Color.WHITE);
		phone2.setPreferredSize(new Dimension(400, 30));
		phone2.setFont(new Font(fontName, Font.PLAIN, 12));
		phone2.setHorizontalAlignment(SwingConstants.RIGHT);
		phone2.setBorder(BorderFactory.createEmptyBorder());
		phone2.setBackground(SessionData.getBgColor());
		
		email.setForeground(Color.WHITE);
		email.setPreferredSize(new Dimension(400, 30));
		email.setFont(new Font(fontName, Font.PLAIN, 12));
		email.setHorizontalAlignment(SwingConstants.RIGHT);
		email.setBorder(BorderFactory.createEmptyBorder());
		email.setBackground(SessionData.getBgColor());
		
		rewardPoints.setForeground(Color.WHITE);
		rewardPoints.setPreferredSize(new Dimension(400, 30));
		rewardPoints.setFont(new Font(fontName, Font.PLAIN, 12));
		rewardPoints.setHorizontalAlignment(SwingConstants.CENTER);
		rewardPoints.setBorder(BorderFactory.createEmptyBorder());
		rewardPoints.setBackground(SessionData.getBgColor());		
	}
}
