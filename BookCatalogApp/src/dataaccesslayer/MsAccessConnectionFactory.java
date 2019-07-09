package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MsAccessConnectionFactory {

	private Connection connection = null;
	private String dbURLPrefix = "jdbc:ucanaccess://";

	public Connection getConnection(String dbPath) {

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String dbURL = dbURLPrefix + dbPath;
			connection = DriverManager.getConnection(dbURL);
			JOptionPane.showMessageDialog(null, "Database connection successful");

			return connection;

		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
			System.out.println("Error");
			return null;
		}

	}

}
