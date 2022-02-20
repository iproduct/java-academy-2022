package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.dao.exception.InvalidRepositoryStateException;
import course.academy.model.Book;

import java.util.Arrays;

public class BookRepositoryMemoryImpl implements BookRepository {
    public static final int MAX_BOOKS = 5;
    private static int nextId = 0;
    private Book[] books = new Book[MAX_BOOKS];
    private int len = 0;

    @Override
    public Book[] findAll() {
        return Arrays.copyOf(books, len);
    }

    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public Book create(Book book) throws InvalidRepositoryStateException {
        if(len < books.length){
            book.setId(++nextId);
            books[len] = book;
            len++;
            return book;
        } else {
            throw new InvalidRepositoryStateException(
                    "Repository full (capacity=" + books.length + ")");
        }
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public Book deleteById(int id) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
