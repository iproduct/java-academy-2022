package course.academy;

import course.academy.dao.BookRepository;
import course.academy.dao.exception.InvalidRepositoryStateException;
import course.academy.dao.impl.BookRepositoryMemoryImpl;
import course.academy.model.Book;
import course.academy.model.MockBooks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepositoryMemoryImpl();
        for(Book book : MockBooks.MOCK_BOOKS){
            try {
                bookRepository.create(book);
            } catch (InvalidRepositoryStateException e) {
                e.printStackTrace();
                break;
            }
        }

        bookRepository.deleteById(2);
        bookRepository.deleteById(4);
        for(Book book : bookRepository.findAll()) {
            System.out.println(book);
        }
        System.out.println();
        Book thirdBook = bookRepository.findById(3);
        System.out.println(thirdBook);
        System.out.println(bookRepository.findById(4));

        // update thirdBook
        System.out.println();
        thirdBook.setTitle("Third Book");
        thirdBook.setPrice(42);
        bookRepository.update(thirdBook);
        System.out.println(bookRepository.findById(3));
    }
}
