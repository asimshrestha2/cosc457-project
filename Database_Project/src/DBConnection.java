import java.sql.*;

public class DBConnection {
	static final String USERNAME="kbride1";//put your MySQL user name
    static final String PASSWORD="Cosc*2f2y";//put your MySQL password
    private static Connection connection=null;
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException
     */
	public DBConnection(){
		
	}
	
	public ResultSet executeQuary(String quary) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3360/kbride1db", USERNAME, PASSWORD);// Please use your database name here
        Statement queryStatement = connection.createStatement();
        ResultSet results = queryStatement.executeQuery(quary);
        return results;
	}
	
	public void executeUpdate(String quary) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/kbride1db", USERNAME, PASSWORD);
        PreparedStatement update = connection.prepareStatement(quary);
        update.executeUpdate();
	}
}
