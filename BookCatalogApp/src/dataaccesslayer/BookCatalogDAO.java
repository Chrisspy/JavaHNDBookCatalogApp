package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import businesslayer.Book;

public class BookCatalogDAO {

	private String dbPath = "C:\\Users\\GOR08152809\\BookDatabase.accdb";

	/**
	 * Due to working on two different Developer machines, My personal computer and
	 * the college's computers I will need to change the dbPath to the location
	 * which the "BookDatabase" is saved on either computers. Note to make sure to
	 * save the DB on the colleges C Drive due to access issues. The best location
	 * is "C:\\Users\\GOR08152809\\BookDatabase.accdb";" for SERC and "E:\\Java
	 * Assignment 2\\BookDatabase.accdb" for personal work station. Connect to
	 * Memory stick because program doesn't like "Documents folder" for some reason.
	 * Also: You will also need to re-upload the JAR files in the Build Path too.
	 */
	private MsAccessConnectionFactory factory;

	public BookCatalogDAO() {
		factory = new MsAccessConnectionFactory();
	}

	public ResultSet readAllBooks() throws SQLException {
		Connection connection = factory.getConnection(dbPath);
		Statement sqlStatement = connection.createStatement();
		ResultSet rs = sqlStatement.executeQuery("SELECT * FROM Book");
		System.out.println(rs);
		return rs;
	}

	public ResultSet readBooksByAuthor(String author) throws SQLException {
		Connection connection = factory.getConnection(dbPath);
		Statement sqlStatement = connection.createStatement();
		ResultSet rs = sqlStatement.executeQuery("SELECT * FROM Book WHERE author = '" + author + "'");
		System.out.println(rs);
		return rs;
	}

	public ResultSet readBooksByYear(String bookDate) throws SQLException {
		Connection connection = factory.getConnection(dbPath);
		Statement sqlStatement = connection.createStatement();
		ResultSet rs = sqlStatement.executeQuery("SELECT * FROM Book WHERE bookDate = '" + bookDate + "'");
		System.out.println(rs);
		return rs;
	}

	public ResultSet readBooksByGenre(String genre) throws SQLException {
		Connection connection = factory.getConnection(dbPath);
		Statement sqlStatement = connection.createStatement();
		ResultSet rs = sqlStatement.executeQuery("SELECT * FROM Book WHERE genre = '" + genre + "'");
		System.out.println(rs);
		return rs;
	}

	public ResultSet readBooksByPublisher(String publisher) throws SQLException {
		Connection connection = factory.getConnection(dbPath);
		Statement sqlStatement = connection.createStatement();
		ResultSet rs = sqlStatement.executeQuery("SELECT * FROM Book WHERE publisher = '" + publisher + "'");
		System.out.println(rs);
		return rs;
	}

	public void createBook(Book book) {
		try {
			Connection connection = factory.getConnection(dbPath); // What connects to the database. need it for
																	// services.
			String sql = "INSERT INTO Book" + "(title, author, bookDate, genre, publisher, description) VALUES"
					+ "(?,?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getYear());
			pstmt.setString(4, book.getGenre());
			pstmt.setString(5, book.getPublisher());
			pstmt.setString(6, book.getDescription());
			pstmt.executeUpdate();
			try (ResultSet rs = pstmt.getGeneratedKeys();) {
				if (rs.next()) {
					book.setBookId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
	}

	public void deleteBook(int bookID) {
		// TODO Auto-generated method stub
		try {
			Connection connection = factory.getConnection(dbPath);
			String sql = "DELETE FROM Book WHERE ID = '" + bookID + "'";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		try {
			Connection connection = factory.getConnection(dbPath);
			String sql = "UPDATE Book SET title = '" + book.getTitle() + "',author = '" + book.getAuthor()
					+ "',bookDate = '" + book.getYear() + "',genre = '" + book.getGenre() + "',publisher = '"
					+ book.getPublisher() + "',description = '" + book.getDescription() + "'WHERE ID = '"
					+ book.getBookId() + "'";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
}