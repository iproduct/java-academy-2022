package course.academy;

import course.academy.dao.BookRepository;
import course.academy.dao.DaoFactory;
import course.academy.exception.InvalidEntityDataException;
import course.academy.exception.NonexistingEntityException;
import course.academy.dao.impl.DaoFactoryMemoryImpl;
import course.academy.model.Book;
import course.academy.model.MockBooks;
import course.academy.service.BookService;
import course.academy.service.impl.BookServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws NonexistingEntityException {
        DaoFactory daoFactory = new DaoFactoryMemoryImpl();
        BookRepository bookRepository = daoFactory.createBookRepository();

        BookService bookService = new BookServiceImpl(bookRepository);

        for(Book book : MockBooks.MOCK_BOOKS){
            try {
                bookService.addBook(book);
            } catch (InvalidEntityDataException e) {
                e.printStackTrace();
            }
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        var invalidBook = new Book("Thinking in Java", "Bruce Eckel", LocalDate.parse("10.02.2036", dtf),
                "Pearson", 35.5, "Detailed introduction to Java programming.");
        try {
            bookService.addBook(invalidBook);
        } catch (InvalidEntityDataException e) {
            e.printStackTrace();
        }

        // delete books 2 and 4
        bookService.deleteBookById(2L);
        bookService.deleteBookById(4L);
        // print books
        for(Book book : bookService.getAllBooks()) {
            System.out.println(book);
        }
        System.out.println();

        // find book by id
        Book thirdBook = bookService.getBookById(3L);
        System.out.println(thirdBook);

        // find by id already deleted boook
        try {
            System.out.println(bookService.getBookById(4L));
        } catch (NonexistingEntityException ex) {
            ex.printStackTrace();
        }

        // update thirdBook
        System.out.println();
        thirdBook.setTitle("Third Book");
        thirdBook.setPrice(42);
        bookService.updateBook(thirdBook);
        System.out.println(bookService.getBookById(3L));
        System.out.println("Program finished normally.");
    }
}
