package course.academy.service;

import course.academy.exception.InvalidEntityDataException;
import course.academy.exception.NonexistingEntityException;
import course.academy.model.Book;

import java.util.Collection;

public interface BookService {
    Collection<Book> getAllBooks();
    Book getBookById(Long id) throws NonexistingEntityException;
    Book addBook(Book book) throws InvalidEntityDataException;
    Book updateBook(Book book) throws NonexistingEntityException;
    Book deleteBookById(Long id) throws NonexistingEntityException;
    long count();
}
