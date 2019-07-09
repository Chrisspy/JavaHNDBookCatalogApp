package businesslayer;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public interface BooksCatalog {
	
	public DefaultTableModel readAllBooks();
	public DefaultTableModel readBooksByAuthor(String author);
	public DefaultTableModel readBooksByYearPublished(String bookDate);
	public DefaultTableModel readBooksByGenre(String genre);
	public DefaultTableModel readBooksByPublisher(String publisher);
	
	public void createBook(Book book);
	public void readBook();
	public void updateBook(Book book);
	public void deleteBook(int bookID) throws SQLException;
	public void exit();
	public void accessHelp();
	
}
