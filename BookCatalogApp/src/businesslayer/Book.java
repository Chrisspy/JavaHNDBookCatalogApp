package businesslayer;
//Currently not being used.

public class Book {
	private int bookId;
	private String title;
	private String author;
	private String year;
	private String genre;
	private String publisher;
	private String description;

	public Book(String title, String author, String year, String genre, String publisher,
			String description) {
		this.setTitle(title);
		this.setAuthor(author);
		this.setYear(year);
		this.setGenre(genre);
		this.setPublisher(publisher);
		this.setDescription(description);
	}

	public Book(int bookId, String title, String author, String year, String genre, String publisher,
			String description) {
		this.setBookId(bookId);
		this.setTitle(title);
		this.setAuthor(author);
		this.setYear(year);
		this.setGenre(genre);
		this.setPublisher(publisher);
		this.setDescription(description);

	}

	// Getters and Setters:
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
