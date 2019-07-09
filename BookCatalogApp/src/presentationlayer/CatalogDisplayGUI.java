package presentationlayer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businesslayer.Book;
import businesslayer.BooksCatalogImpl;
import javax.swing.JToolBar;

public class CatalogDisplayGUI {

	private JFrame frame;
	private JTextField textTitle;
	private JTextField textAuthor;
	private JTextField textGenre;
	private JTextField textPublisher;
	private JTextField textDescription;
	private JTextField textDate;
	private JTable table;
	private JScrollPane scrollPane;
	private BooksCatalogImpl books;
	private JTextField textSearchYear;
	private JTextField textSearchGenre;
	private JTextField textSearchAuthor;
	private JTextField textSearchPublisher;
	private JLabel lblSearchGenre;
	private JLabel lblSearchPublisher;
	private JTextField textDeleteBook;
	private JTextField textUpdateBook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatalogDisplayGUI window = new CatalogDisplayGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CatalogDisplayGUI() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		books = new BooksCatalogImpl();
		frame = new JFrame();
		frame.setBounds(100, 100, 915, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					Book recordBook = new Book(textTitle.getText(), textAuthor.getText(), textDate.getText(),
							textGenre.getText(), textPublisher.getText(), textDescription.getText());
					books.createBook(recordBook);
					JOptionPane.showMessageDialog(null, "Book Added");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Save unsuccessfull, duplicate entry?");
				}
				DefaultTableModel model = books.readAllBooks();
				table = new JTable(model);
				frame.getContentPane().add(scrollPane);
				scrollPane.setViewportView(table);

			}
		});

		JButton btnRefreshTable = new JButton("Refresh Table");
		btnRefreshTable.setBounds(241, 54, 153, 23);
		frame.getContentPane().add(btnRefreshTable);
		btnRefreshTable.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel model = books.readAllBooks();
					table = new JTable(model);
					frame.getContentPane().add(scrollPane);
					scrollPane.setViewportView(table);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});

		btnAddBook.setBounds(114, 297, 117, 23);
		frame.getContentPane().add(btnAddBook);

		JLabel lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBookTitle.setBounds(10, 88, 65, 14);
		frame.getContentPane().add(lblBookTitle);

		JLabel lblBookAuthor = new JLabel("Book Author");
		lblBookAuthor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBookAuthor.setBounds(10, 113, 80, 14);
		frame.getContentPane().add(lblBookAuthor);

		JLabel lblDate = new JLabel("Date Published");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(10, 138, 89, 14);
		frame.getContentPane().add(lblDate);

		JLabel lblGenre = new JLabel("Book Genre");
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGenre.setBounds(10, 163, 89, 14);
		frame.getContentPane().add(lblGenre);

		JLabel lblPublisher = new JLabel("Book Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPublisher.setBounds(10, 188, 89, 14);
		frame.getContentPane().add(lblPublisher);

		JLabel lblBookDescription = new JLabel("Book \r\nDescription");
		lblBookDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBookDescription.setBounds(10, 213, 100, 23);
		frame.getContentPane().add(lblBookDescription);

		textTitle = new JTextField();
		textTitle.setBounds(100, 85, 131, 20);
		frame.getContentPane().add(textTitle);
		textTitle.setColumns(10);

		textAuthor = new JTextField();
		textAuthor.setColumns(10);
		textAuthor.setBounds(100, 110, 131, 20);
		frame.getContentPane().add(textAuthor);

		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(100, 135, 131, 20);
		frame.getContentPane().add(textDate);

		textGenre = new JTextField();
		textGenre.setColumns(10);
		textGenre.setBounds(100, 160, 131, 20);
		frame.getContentPane().add(textGenre);

		textPublisher = new JTextField();
		textPublisher.setColumns(10);
		textPublisher.setBounds(100, 185, 131, 20);
		frame.getContentPane().add(textPublisher);

		textDescription = new JTextField();
		textDescription.setBounds(10, 232, 221, 54);
		frame.getContentPane().add(textDescription);
		textDescription.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(241, 88, 630, 200);
		DefaultTableModel modelBooks = books.readAllBooks();
		table = new JTable(modelBooks);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);

		JLabel lblSearchAuthor = new JLabel("Search Author");
		lblSearchAuthor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSearchAuthor.setBounds(251, 297, 89, 14);
		frame.getContentPane().add(lblSearchAuthor);

		textSearchYear = new JTextField();
		textSearchYear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel model = books.readBooksByYearPublished(textSearchYear.getText());
					table = new JTable(model);
					frame.getContentPane().add(scrollPane);
					scrollPane.setViewportView(table);
					JOptionPane.showMessageDialog(null, "Search Complete");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		textSearchYear.setBounds(402, 322, 120, 20);
		frame.getContentPane().add(textSearchYear);
		textSearchYear.setColumns(10);

		textSearchGenre = new JTextField();
		textSearchGenre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel model = books.readBooksByGenre(textSearchGenre.getText());
					table = new JTable(model);
					frame.getContentPane().add(scrollPane);
					scrollPane.setViewportView(table);
					JOptionPane.showMessageDialog(null, "Search Complete");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		textSearchGenre.setColumns(10);
		textSearchGenre.setBounds(657, 294, 153, 20);
		frame.getContentPane().add(textSearchGenre);

		textSearchAuthor = new JTextField();
		textSearchAuthor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel model = books.readBooksByAuthor(textSearchAuthor.getText());
					table = new JTable(model);
					frame.getContentPane().add(scrollPane);
					scrollPane.setViewportView(table);
					JOptionPane.showMessageDialog(null, "Search Complete");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		textSearchAuthor.setColumns(10);
		textSearchAuthor.setBounds(339, 294, 183, 20);
		frame.getContentPane().add(textSearchAuthor);

		textSearchPublisher = new JTextField();
		textSearchPublisher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel model = books.readBooksByPublisher(textSearchPublisher.getText());
					table = new JTable(model);
					frame.getContentPane().add(scrollPane);
					scrollPane.setViewportView(table);
					JOptionPane.showMessageDialog(null, "Search Complete");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		textSearchPublisher.setColumns(10);
		textSearchPublisher.setBounds(657, 322, 153, 20);
		frame.getContentPane().add(textSearchPublisher);

		JLabel lblSearchByYear = new JLabel("Search By Year Published");
		lblSearchByYear.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSearchByYear.setBounds(250, 325, 153, 14);
		frame.getContentPane().add(lblSearchByYear);

		lblSearchGenre = new JLabel("Search Genre");
		lblSearchGenre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSearchGenre.setBounds(546, 297, 79, 14);
		frame.getContentPane().add(lblSearchGenre);

		lblSearchPublisher = new JLabel("Search Publisher");
		lblSearchPublisher.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSearchPublisher.setBounds(546, 325, 105, 14);
		frame.getContentPane().add(lblSearchPublisher);

		JLabel lblBookDeleteId = new JLabel("Book ID To Delete");
		lblBookDeleteId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBookDeleteId.setBounds(10, 369, 105, 14);
		frame.getContentPane().add(lblBookDeleteId);

		textDeleteBook = new JTextField();
		textDeleteBook.setBounds(10, 388, 100, 20);
		frame.getContentPane().add(textDeleteBook);
		textDeleteBook.setColumns(10);

		JButton btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					System.out.println(textDeleteBook.getText());
					books.deleteBook(Integer.parseInt(textDeleteBook.getText()));
					JOptionPane.showMessageDialog(null, "Book Deleted");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
				DefaultTableModel model = books.readAllBooks();
				table = new JTable(model);
				frame.getContentPane().add(scrollPane);
				scrollPane.setViewportView(table);
			}
		});
		btnDeleteBook.setBounds(114, 387, 117, 23);
		frame.getContentPane().add(btnDeleteBook);

		JButton btnUpdateBook = new JButton("Update Book");
		btnUpdateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Book recordBook = new Book(Integer.parseInt(textUpdateBook.getText()), textTitle.getText(),
							textAuthor.getText(), textDate.getText(), textGenre.getText(), textPublisher.getText(),
							textDescription.getText());
					books.updateBook(recordBook);
					JOptionPane.showMessageDialog(null, "Book Updated");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Save unsuccessfull");
				}
				DefaultTableModel model = books.readAllBooks();
				table = new JTable(model);
				frame.getContentPane().add(scrollPane);
				scrollPane.setViewportView(table);

			}
		});
		btnUpdateBook.setBounds(114, 341, 117, 23);
		frame.getContentPane().add(btnUpdateBook);

		textUpdateBook = new JTextField();
		textUpdateBook.setBounds(10, 342, 100, 20);
		frame.getContentPane().add(textUpdateBook);
		textUpdateBook.setColumns(10);

		JLabel lblUpdateBook = new JLabel("Book ID to Update");
		lblUpdateBook.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUpdateBook.setBounds(10, 325, 110, 14);
		frame.getContentPane().add(lblUpdateBook);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 899, 28);
		frame.getContentPane().add(toolBar);

		JButton btnExitProgram = new JButton("Exit Program");
		btnExitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		toolBar.add(btnExitProgram);

		JButton btnHelpSection = new JButton("Help Section");
		btnHelpSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(null, "Please Contact GOR08152809@serc.ac.uk For Assistance.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		toolBar.add(btnHelpSection);

	}
}
