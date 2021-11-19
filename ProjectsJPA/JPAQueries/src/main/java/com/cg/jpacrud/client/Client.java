package com.cg.jpacrud.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/* Run BOOKS.SQL to create table and add rows before executing
 * this program
 */
import com.cg.jpacrud.entities.Book;
import com.cg.jpacrud.service.BookService;
import com.cg.jpacrud.service.BookServiceImpl;
import com.cg.jpacrud.util.JpaUtil;

public class Client {

	public static void main(String[] args) {
		
		createObjects();

		BookService service = new BookServiceImpl();

		System.out.println("************Listing total number of books*************");
		System.out.println("Total books:" + service.getBookCount());

		System.out.println("************Listing book with id 105*************");
		System.out.println("Boo with ID 106:" + service.getBookById(105));

		System.out.println("************Listing All books*************");
		for (Book book : service.getAllBooks()) {
			System.out.println(book);
		}

		System.out.println("************Listing book written by Danny Coward*************");
		for (Book book : service.getAuthorBooks("Danny Coward")) {
			System.out.println(book);
		}

		System.out.println("************Listing book on Android*************");
		for (Book book : service.getBookByTitle("Android")) {
			System.out.println(book);
		}

		System.out.println("************Listing All books between 500 and 600*************");
		for (Book book : service.getBooksInPriceRange(500, 600)) {
			System.out.println(book);
		}

	}

	static void createObjects() {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();

		em.persist(new Book(101, "Java Closures and Lambda", "Robert Fischer", 460.0));
		em.persist(new Book(102, "Pro Java 8 Programming", "Brett Spell", 600.0));
		em.persist(new Book(103, "Java for Android, Second Edition", "Budi Kurniawan", 680.0));
		em.persist(new Book(105, "Java EE 7: The Big Picture", "Danny Coward", 340.0));
		em.persist(new Book(104, "Java: The Complete Reference", "Herbert Schildt", 700.0));
		em.persist(new Book(106, "Beginning Java with WebSphere", "Robert W. Janson", 550.0));

		em.getTransaction().commit();
	}
}
