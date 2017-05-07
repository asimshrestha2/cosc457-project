import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class HistoryGUI extends JFrame {
	private String userID = null;
	public HistoryGUI(String userID){
		super("Your Purchused History");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.userID = userID;
		System.out.println(this.userID);
		
		Vector<String> columnNames = new Vector<String>();
	    columnNames.addElement("Item Name");
	    columnNames.addElement("Street");
	    columnNames.addElement("Time");
	    columnNames.addElement("Price");
	    JTable table = new JTable(getDataForTable(), columnNames){
	    	@Override
	    	public boolean isCellEditable(int row, int column) {
	    		// TODO Auto-generated method stub
	    		return false;
	    	}
	    };
	    JScrollPane scrollPane = new JScrollPane(table);
	    add(scrollPane, BorderLayout.CENTER);
	    pack();
	    setPreferredSize(new Dimension(400, 600));
	    setVisible(true);
	}
	
	private Vector<Vector> getDataForTable(){
		DBConnection db = new DBConnection();
		ResultSet result;
		Vector<Vector> rowData = new Vector<Vector>();
		try {
			result = db.executeQuary("select MenuItem.ItemName, Location.Street, MenuItem.Price, Buys.Time "
					+ "from Buys, Location, MenuItem "
					+ "where Buys.Item_ID = MenuItem.Item_ID and Buys.Loc_ID = Location.Loc_ID and Buys.Customer_ID='"+userID+"';");
			while(result.next()){
				 Vector<String> row = new Vector<String>();
				 row.addElement(result.getString(1));
				 row.addElement(result.getString(2));
				 row.addElement(result.getString(4));
				 row.addElement("$"+result.getString(3)+".00");
				 System.out.println(row.toString() + " " + result.getString(1));
				 rowData.addElement(row);
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(rowData.toString());
		return rowData;
	}
}
