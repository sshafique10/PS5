package pkgEmpty;

import static org.junit.Assert.*;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pkgException.BookException;
import pkgLibrary.Book;
import pkgLibrary.Catalog;

public class BookTest {
	private static Book b = new Book("bk100", "jk, row", "Cisc", "Science", 4.95, new Date(2003,1,5), 
			"How to code", 3.56);
	@Test
	public void GetBookTest() throws BookException {
		Book b = new Book("bk200");
		assertEquals("Computer", b.getGenre());
		
	}
	
	@Test
	public void GetBookTest2() throws BookException {
		Book b = new Book("bk300");
		assertEquals("J, Kim", b.getAuthor());
	}
	
	@Test
	public void AddBookTest() throws BookException{
		Catalog cat = pkgLibrary.Book.ReadXMLFile();
		cat.AddBook(new Book("bk400","Kid, Jason", "B-Ball","Biography", 50.0, new Date(2005,5,1),
			"Assist king", 2.10));
		Book b = new Book("bk400");
		assertEquals("Assist King",b.getDescription());
	}
	@Test
	public void AddBookTest1() throws BookException {
		Catalog cat = pkgLibrary.Book.ReadXMLFile();
		cat.AddBook(new Book("bk100", "jk, row", "Cisc", "Science", 4.95, new Date(2003,1,5), 
				"How to code", 3.56));
		Book b = new Book("bk400");
		assertEquals("Cisc", new Book("bk100").getTitle());
	}

}