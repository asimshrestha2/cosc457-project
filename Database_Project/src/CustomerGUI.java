import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class CustomerGUI extends JFrame implements ActionListener
{
	private String username = "";
	private String userID = null;
    public CustomerGUI(String username, String userID)
    {
        super("Welcome!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.username = username;
        this.userID = userID;
        setTitle("Welcome "+ username + "!");
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(SessionData.getBgColor());
        setBackground(SessionData.getBgColor());
        
        setLayout(new GridLayout(0, 1));
        listPanel.add(new JLabel("Welcome, " + username + "!"){
        	@Override
        	public void setForeground(Color fg) {
        		// TODO Auto-generated method stub
        		super.setForeground(Color.WHITE);
        	}
        	@Override
        	public void setAlignmentX(float alignmentX) {
        		// TODO Auto-generated method stub
        		super.setAlignmentX(Component.CENTER_ALIGNMENT);
        	}
        }, SwingConstants.CENTER);
        
        //Funtion Btns
        JButton profileBtn = new JButton("Profile");        
        JButton rewardsBtn = new JButton("Rewards"); 
        JButton takeoutBtn = new JButton("Take Out"); 
        JButton historyBtn = new JButton("History");
        
        profileBtn.addActionListener(this);
        rewardsBtn.addActionListener(this);
        takeoutBtn.addActionListener(this);
        historyBtn.addActionListener(this);
        
        profileBtn.setActionCommand("profile");
        rewardsBtn.setActionCommand("rewards");
        takeoutBtn.setActionCommand("takeout");
        historyBtn.setActionCommand("history");
        
        JPanel funcBtns = new JPanel(new GridLayout(2, 2, 10, 10));
        funcBtns.add(profileBtn);
        funcBtns.add(rewardsBtn);
        funcBtns.add(takeoutBtn);
        funcBtns.add(historyBtn);
        funcBtns.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        funcBtns.setBackground(SessionData.getBgColor());
        
        listPanel.add(funcBtns);
        
        //Exit Btn
        JButton exitBtn = new JButton("Exit");
        exitBtn.setPreferredSize(new Dimension(200, 40));
        exitBtn.setBackground(new Color(46,49,146));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener(this);
        exitBtn.setActionCommand("exitApp");
        exitBtn.setAlignmentX(CENTER_ALIGNMENT);
        exitBtn.setMaximumSize(new Dimension(200, 40));
        
        listPanel.add(exitBtn);
        listPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(listPanel);
        setPreferredSize(new Dimension(400, 200));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		switch(cmd) {
		case "profile":
			new ProfileGUI(userID);
			break;
		case "rewards":
			new RewardsUI(userID);
			break;
		case "takeout":
			
			break;
		case "history":
			new HistoryGUI(userID);
			break;
		case "exitApp":
			dispose();
			System.exit(1);
			break;
		default:
			break;
		}
	}
}