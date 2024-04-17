package api.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import api.dao.impl.BookDAOImpl;
import api.entities.Book;

@Path("/book-service/")
public class BookService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getBooks() {
		List<Book> books = new BookDAOImpl().getBooks();
		Gson son = new Gson();
		return son.toJson(books);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{isbn}")
	public String getBook(@PathParam("isbn")String isbn) {
		Book book = new BookDAOImpl().getBookById(isbn);
		Gson son = new Gson();
		return son.toJson(book);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertBook(String jsonBook) {
		Gson son = new Gson();
		Book book = son.fromJson(jsonBook, Book.class);
		boolean blInsert = new BookDAOImpl().insertBook(book);
		return son.toJson(blInsert);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateBook(String jsonBook) {
		Gson son = new Gson();
		Book book = son.fromJson(jsonBook, Book.class);
		boolean blUpdate = new BookDAOImpl().updateBook(book);
		return son.toJson(blUpdate);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{isbn}")
	public String deleteBook(@PathParam("isbn")String isbn) {		
		boolean blDelete = new BookDAOImpl().deleteBook(isbn);
		Gson son = new Gson();
		return son.toJson(blDelete);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/searchByName/{bookName}")
	public String getBooksByName(@PathParam("bookName")String bookName) {
		List<Book> books = new BookDAOImpl().getBooksByName(bookName);
		Gson son = new Gson();
		return son.toJson(books);
	}
}
