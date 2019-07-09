package businesslayer;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dataaccesslayer.BookCatalogDAO;

public class BooksCatalogImpl implements BooksCatalog {
	private BookCatalogDAO dao;
	private ResultSet rs;
	private DefaultTableModel model;

	public BooksCatalogImpl() {
		dao = new BookCatalogDAO();
	}

	@Override
	public DefaultTableModel readAllBooks() {
		// TODO Auto-generated method stub
		try {
			rs = dao.readAllBooks();
			model = buildTableModel(rs);
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
		return model;
	}

	@Override
	public DefaultTableModel readBooksByAuthor(String author) {
		try {
			rs = dao.readBooksByAuthor(author);
			model = buildTableModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
		return model;
	}

	@Override
	public DefaultTableModel readBooksByYearPublished(String bookDate) {
		try {
			rs = dao.readBooksByYear(bookDate);
			model = buildTableModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
		return model;
	}

	@Override
	public DefaultTableModel readBooksByGenre(String genre) {
		try {
			rs = dao.readBooksByGenre(genre);
			model = buildTableModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
		return model;
	}

	@Override
	public DefaultTableModel readBooksByPublisher(String publisher) {
		try {
			rs = dao.readBooksByPublisher(publisher);
			model = buildTableModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
		return model;
	}

	@Override
	public void createBook(Book book) {
		// TODO Auto-generated method stub
		dao.createBook(book);

	}

	@Override
	public void readBook() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		dao.updateBook(book);
	}

	@Override
	public void deleteBook(int bookID) throws SQLException {
		// TODO Auto-generated method stub
		dao.deleteBook(bookID);
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void accessHelp() {
		// TODO Auto-generated method stub

	}

	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);

	}

}
