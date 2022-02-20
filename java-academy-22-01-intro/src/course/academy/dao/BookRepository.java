package course.academy.dao;

import course.academy.model.Book;

/**
 * Public interface for managing lifecycle of Book objects
 */
public interface BookRepository {
    /**
     * Find all books in repository
     * @return array of all books
     */
    Book[] findAll();

    /**
     * Find book by id
     * @param id the book id
     * @return the book with given id, or null if id not found in repository
     */
    Book findById(int id);
    Book create(Book book);
    Book update(Book book);
    Book deleteById(int id);
    int count();
}
