// Old Version of the Impl

/*
 * package businesslayer;
 * 
 * import java.sql.ResultSet; import java.sql.ResultSetMetaData; import
 * java.sql.SQLException; import java.util.Vector;
 * 
 * import javax.swing.table.DefaultTableModel; import
 * dataaccesslayer.BookCatalogDAO;
 * 
 * public class BooksCatalogImplOld { private BookCatalogDAO dao; private
 * ResultSet rs; private DefaultTableModel model;
 * 
 * public BooksCatalogImplOld() { dao = new BookCatalogDAO(); }
 * 
 * public DefaultTableModel allBooks() { System.out.println("Entered allBooks");
 * 
 * try { rs = dao.allBooks(); model = buildTableModel(rs); return model; } catch
 * (SQLException e) { e.printStackTrace(); }
 * 
 * return null; }
 * 
 * public static DefaultTableModel buildTableModel(ResultSet rs) throws
 * SQLException {
 * 
 * ResultSetMetaData metaData = rs.getMetaData();
 * 
 * // names of columns Vector<String> columnNames = new Vector<String>(); int
 * columnCount = metaData.getColumnCount(); for (int column = 1; column <=
 * columnCount; column++) { columnNames.add(metaData.getColumnName(column)); }
 * 
 * // data of the table Vector<Vector<Object>> data = new
 * Vector<Vector<Object>>(); while (rs.next()) { Vector<Object> vector = new
 * Vector<Object>(); for (int columnIndex = 1; columnIndex <= columnCount;
 * columnIndex++) { vector.add(rs.getObject(columnIndex)); } data.add(vector); }
 * 
 * return new DefaultTableModel(data, columnNames);
 * 
 * } }
 */