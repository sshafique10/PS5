package pkgLibrary;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;

import pkgException.BookException;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;	
	
	@XmlElement(name="book")
	ArrayList<Book> books;
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public void AddBook(Book Book) throws BookException {
		System.out.println(books);
		for (Book b : books) {
			if (b.getId().equals(Book.getId())) {
				System.out.println("this book is already in the catalog");
				throw new BookException(Book);
			}
		}
		books.add(Book);
		pkgLibrary.Catalog.WriteXMLFile(this);
		}
		
	
	
		private static void WriteXMLFile(Catalog cat) {
			try {

				String basePath = new File("").getAbsolutePath();
				basePath = basePath + "\\XMLExample\\src\\main\\resources\\XMLFiles\\Books.xml";
				File file = new File(basePath);

				JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				/
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

				jaxbMarshaller.marshal(cat, file);
				jaxbMarshaller.marshal(cat, System.out);

			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
}
