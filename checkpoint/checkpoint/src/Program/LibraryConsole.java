package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import concretesFactory.BookFacktoryImpl;
import entity.Book;
import entity.Loan;
import entity.Student;


public class LibraryConsole {
    public static void main(String[] args) {
    	BookFacktoryImpl factory = new BookFacktoryImpl();
        List<Book> books = new ArrayList<>();
        List<Loan> loans = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Biblioteca Fiap");
            System.out.println("1. Registrar um livro");
            System.out.println("2. Empréstimo de livro");
            System.out.println("3. Devolução de livro");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha após a escolha

            switch (choice) {
                case 1:
                    System.out.print("Título do livro: ");
                    String title = scanner.nextLine();
                    System.out.print("Autor do livro: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN do livro: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Quantidade disponível: ");
                    int quantity = scanner.nextInt();
                    Book newBook = factory.createBook(title, author, isbn, quantity);
                    books.add(newBook);
                    System.out.println("Livro registrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome do aluno: ");
                    String studentName = scanner.nextLine();
                    System.out.print("ISBN do livro a ser emprestado: ");
                    String loanIsbn = scanner.nextLine();

                    Student student = new Student(studentName);
                    Book loanBook = findBookByIsbn(books, loanIsbn);

                    if (loanBook != null && loanBook.getQuantity() > 0) {
                        Loan newLoan = factory.createLoan(loanBook, student);
                        loans.add(newLoan);
                        loanBook.setQuantity(loanBook.getQuantity() - 1);
                        System.out.println("Empréstimo realizado com sucesso!");
                    } else {
                        System.out.println("Livro não disponível para empréstimo.");
                    }
                    break;

                case 3:
                    System.out.print("ISBN do livro a ser devolvido: ");
                    String returnIsbn = scanner.nextLine();

                    Loan loanToReturn = findLoanByIsbn(loans, returnIsbn);

                    if (loanToReturn != null) {
                        Book returnedBook = loanToReturn.getBook();
                        returnedBook.setQuantity(returnedBook.getQuantity() + 1);
                        loans.remove(loanToReturn);
                        System.out.println("Livro devolvido com sucesso!");
                    } else {
                        System.out.println("Empréstimo não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static Book findBookByIsbn(List<Book> books, String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    private static Loan findLoanByIsbn(List<Loan> loans, String isbn) {
        for (Loan loan : loans) {
            if (loan.getBook().getIsbn().equals(isbn)) {
                return loan;
            }
        }
        return null;
    }
}
