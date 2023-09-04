package interfaces;

import entity.Book;
import entity.Loan;
import entity.Student;

public interface BookFactry {
	 Book createBook(String title, String author, String isbn, int quantity);
	 Loan createLoan(Book book, Student student);
}
