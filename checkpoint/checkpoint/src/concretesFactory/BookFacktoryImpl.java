package concretesFactory;

import entity.Book;
import entity.Loan;
import entity.Student;

public class BookFacktoryImpl {
	public Book createBook(String title, String author, String isbn, int quantity) {
        return new Book(title, author, isbn, quantity);
    }

    public Loan createLoan(Book book, Student student) {
        return new Loan(book, student);
    }
}
