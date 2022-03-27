package course.academy.service;

import course.academy.exception.InvalidEntityDataException;
import course.academy.exception.NonexistingEntityException;
import course.academy.model.Book;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface BookService {
    void loadData();
    Collection<Book> getAllBooks();
    List<Book> getAllBooks(Comparator<Book> comp);

    List<Book> getAllBooksByDate(boolean ascending);

    Book getBookById(Long id) throws NonexistingEntityException;
    Book addBook(Book book) throws InvalidEntityDataException;
    Book updateBook(Book book) throws NonexistingEntityException, InvalidEntityDataException;
    Book deleteBookById(Long id) throws NonexistingEntityException;
    long count();
}
