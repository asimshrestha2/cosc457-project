import java.sql.*;

import javax.swing.*;

public class RewardsUI extends JFrame{
	DBConnection dbconnection = new DBConnection();
	public RewardsUI(String userID) {
		// TODO Auto-generated constructor stub
		super("Welcome!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JEditorPane editor = new JEditorPane();
        editor.setEditable(false);
        editor.setContentType("text/html");
        
        //This creates the Table
        String htmlTable = null;
        try{
        	htmlTable = "<table><tr><th>Date</th><th>Points Earned</th><th>Total Point</th></tr>";
	        ResultSet rels = dbconnection.executeQuary("select * from Staff;");
	        //Loops From the Data returned
			while(rels.next()){
				System.out.print(rels.getString("fname"));
				System.out.print("\t");
				System.out.print(rels.getString("lname")+"\n");
			}
	        htmlTable += "</table>";        
        } catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace(System.err);
		}
        //This shows the HTML table on the GUI
        editor.setText("<html><body>" + htmlTable + "</body></html>");
        
        add(editor);
        
        pack();
        setVisible(true);
	}
}

