package birthdayGui;

import java.sql.*;

import javax.swing.JOptionPane;

public class DbConnector {

	Connection conn = null;
	
	public static Connection dbCon() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "java", "1");
			JOptionPane.showMessageDialog(null, "Conneciton Successful!");
			return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
