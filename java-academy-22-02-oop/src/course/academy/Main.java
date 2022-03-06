package course.academy;

import course.academy.dao.BookRepository;
import course.academy.dao.impl.BookRepositoryMemoryImpl;
import course.academy.model.Book;
import course.academy.model.MockBooks;

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

        // delete books 2 and 4
        bookRepository.deleteById(2);
        bookRepository.deleteById(4);
        // print books
        for(Book book : bookRepository.findAll()) {
            System.out.println(book);
        }
        System.out.println();

        // find book by id
        Book thirdBook = bookRepository.findById(3);
        System.out.println(thirdBook);

        // find by id already deleted boook
        System.out.println(bookRepository.findById(4));

        // update thirdBook
        System.out.println();
        thirdBook.setTitle("Third Book");
        thirdBook.setPrice(42);
        bookRepository.update(thirdBook);
        System.out.println(bookRepository.findById(3));
    }
}
