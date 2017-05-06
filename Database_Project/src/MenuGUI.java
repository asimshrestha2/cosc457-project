
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class MenuGUI extends JFrame implements ActionListener{
    
    DBConnection dbconnection = new DBConnection();

    public MenuGUI() {
        super("Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
        JButton backBtn = new JButton("Back");
		backBtn.addActionListener(this);
		backBtn.setActionCommand("backback");
		
		JPanel listPane = new JPanel();
        listPane.setBackground(SessionData.getBgColor());
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));

        JEditorPane editor = new JEditorPane();
        editor.setEditable(false);
        editor.setContentType("text/html");
		editor.setText(getMenuHTML());
        editor.setBackground(SessionData.getBgColor());
        
        JScrollPane editorScrollPane = new JScrollPane(editor);
        editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setPreferredSize(new Dimension(400, 500));
        editorScrollPane.setMinimumSize(new Dimension(400, 200));
        editor.setBorder(BorderFactory.createEmptyBorder());
        
        listPane.add(new JLabel("Menu"){
        	public void setForeground(Color fg) {
        		super.setForeground(Color.WHITE);
        	}
        	
        	public void setFont(Font font) {
        		super.setFont(new Font("Arial", Font.PLAIN, 20));
        	}
        	
        	@Override
        	public void setAlignmentX(float alignmentX) {
        		super.setAlignmentX(Component.CENTER_ALIGNMENT);
        	}
        });
        listPane.add(editorScrollPane);
        add(listPane);
        setMinimumSize(new Dimension(400, 200));
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String getMenuHTML(){
    	String menuhtml = "<html><head><style>"
    			+ "table, th, td {border: 0; font-family: Arial; font-size: 12px; border-spacing: 0px; color:#FFFFFF; } "
    			+ "th, td { padding: 5px; } "
    			+ "th{ font-style: italic; } "
    			+ "</style></head>"
    			+ "<body style=\"font-family: Arial; font-size: 12px; text-align: center; background: #333333; color: #FFFFFF;\">"
    			+ "<table><tr><th>Item Name</th><th>Type</th><th>Price</th></tr>";
    	try {
			ResultSet rlts = dbconnection.executeQuary("SELECT * FROM MenuItem join MenuType where MenuItem.Type_ID = MenuType.Type_ID and StartDate <= curdate() and EndDate >= curdate();");
			while(rlts.next()){
				menuhtml += "<tr><td>" + rlts.getString("ItemName") + "</td><td>" + rlts.getString("TypeName") + "</td><td>$" + rlts.getString("Price") + ".00</td></tr>";
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	menuhtml += "</table></body></html>";  
    	return menuhtml;
    }
    
}
