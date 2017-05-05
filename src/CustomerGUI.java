//lol
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomerGUI extends JFrame implements ActionListener
{
	private String username = "";
	private String userID = null;
    public CustomerGUI(String username, String userID)
    {
        super("Welcome!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.username = username;
        setTitle("Welcome "+ username + "!");
        setLayout(new GridLayout(0, 1));
        add(new JLabel("Welcome, " + username + "!"));
        
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
        
        add(funcBtns);
        
        //Exit Btn
        JButton exitBtn = new JButton("Exit");
        exitBtn.setBorder(BorderFactory.createEmptyBorder());
        exitBtn.setPreferredSize(new Dimension(120, 40));
        exitBtn.setBackground(new Color(46,49,146));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener(this);
        exitBtn.setActionCommand("exitApp");
        add(exitBtn);
        pack();
        setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		switch (cmd) {
		case "profile":
			new RewardsUI(userID);
			break;
		case "rewards":
			
			break;
		case "takeout":
			
			break;
		case "history":
			
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