package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.dao.exception.NonexistingEntityException;
import course.academy.model.Book;

import java.util.*;

class BookRepositoryMemoryImpl implements BookRepository {
    private static long nextId = 0;
    private Map<Long, Book> books = new HashMap<>(); // O(1) find by ID


    @Override
    public Collection<Book> findAll() {
        return books.values();
    }

    @Override
    public Book findById(Long id) {
        return books.get(id);
    }

    @Override
    public Book create(Book book) {
        book.setId(++nextId);
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Book update(Book book) throws NonexistingEntityException {
        Book old = findById(book.getId());
        if(old == null) {
            throw new NonexistingEntityException("Book with ID='" + book.getId() + "' does not exist.");
        }
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Book deleteById(Long id) throws NonexistingEntityException {
        Book old = books.remove(id);
        if(old == null) {
            throw new NonexistingEntityException("Book with ID='" + id + "' does not exist.");
        }
        return old;
    }

    @Override
    public long count() {
        return books.size();
    }
}










