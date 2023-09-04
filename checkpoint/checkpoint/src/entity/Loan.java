package entity;

public class Loan {
	private Book book;
    private Student student;

    public Loan(Book book, Student student) {
        this.book = book;
        this.student = student;
    }

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
