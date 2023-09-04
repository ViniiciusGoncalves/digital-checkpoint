package concretesFactory;

import entity.Book;
import entity.Loan;
import entity.Student;

public class BookLoggingFactory {
	public Book createBook(String title, String author, String isbn, int quantity) {
        Book book = new Book(title, author, isbn, quantity);
        return book;
	}
	
	public Loan createLoan(Book book, Student student) {
        Loan loan = new Loan(book, student);
        return loan;
    }
}
