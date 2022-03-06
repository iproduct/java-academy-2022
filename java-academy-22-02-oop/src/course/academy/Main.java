package course.academy;

import course.academy.dao.BookRepository;
import course.academy.dao.DaoFactory;
import course.academy.dao.exception.NonexistingEntityException;
import course.academy.dao.impl.DaoFactoryMemoryImpl;
import course.academy.model.Book;
import course.academy.model.MockBooks;

public class Main {
    public static void main(String[] args) throws NonexistingEntityException {
        DaoFactory daoFactory = new DaoFactoryMemoryImpl();

        BookRepository bookRepository = daoFactory.createBookRepository();
        for(Book book : MockBooks.MOCK_BOOKS){
                bookRepository.create(book);
        }

        // delete books 2 and 4
        bookRepository.deleteById(2L);
        bookRepository.deleteById(4L);
        // print books
        for(Book book : bookRepository.findAll()) {
            System.out.println(book);
        }
        System.out.println();

        // find book by id
        Book thirdBook = bookRepository.findById(3L);
        System.out.println(thirdBook);

        // find by id already deleted boook
        System.out.println(bookRepository.findById(4L));

        // update thirdBook
        System.out.println();
        thirdBook.setTitle("Third Book");
        thirdBook.setPrice(42);
        bookRepository.update(thirdBook);
        System.out.println(bookRepository.findById(3L));
    }
}
