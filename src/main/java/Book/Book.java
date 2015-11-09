package Book;

import org.springframework.data.annotation.Id;

public class Book {

	@Id
	private String id;
	private String author;
	private String isbn;


	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return isbn;
	}

	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
}