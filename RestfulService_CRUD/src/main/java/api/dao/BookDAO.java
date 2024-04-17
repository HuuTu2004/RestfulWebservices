package api.dao;

import java.util.List;

import api.entities.Book;

public interface BookDAO {
	public List<Book> getBooks();
	public Book getBookById(String isbn);
	public boolean insertBook(Book b);
	public boolean updateBook(Book b);
	public boolean deleteBook(String isbn);
	public List<Book> getBooksByName(String bookName);
}
