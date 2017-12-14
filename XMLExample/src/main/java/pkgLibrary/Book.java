package pkgLibrary;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Book {

	private String id;
	private String author;
	private String title;
	private String genre;
	private double price;
	private Date publish_date;
	private String description;
	private double cost;
	

	public Book(String id, String author, String title, String genre, double price, Date publish_date, String description
			,double cost)
	
	{
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.genre = genre;		
		this.price = price;
		this.publish_date = publish_date;
		this.description = description;
		this.cost = cost;
		
	}
	
	public Book(Catalog cat, String BookID) throws BookException {
		Book Book = null;
		
		for (Book b : cat.getBooks()) {
			if (b.getId().equals(BookID)) {
				Book = b;
				break;
			}
		}
		if (Book == null) {
			
			System.out.println("book DNE");
			throw new Exception(BookID);
		}
		
		this.id = Book.getId();
		this.author = Book.getAuthor();
		this.title = Book.getTitle();
		this.genre = Book.getGenre();
		this.price = Book.getPrice();
		this.publish_date = Book.getPublish_date();
		this.description = Book.getDescription();
		this.cost = Book.getCost();
	
	}
	
	public static Catalog ReadXMLFile() {

		Catalog cat = null;
		
		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\XMLExample\\src\\main\\resources\\XMLFiles\\Books.xml";
		
		System.out.println(basePath);
		
		
		
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return cat;
	}
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getId() {
		return id;
	}

	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	@XmlElement
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	@XmlElement
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

}
