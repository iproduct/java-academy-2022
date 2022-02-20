package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.model.Book;

public class BookRepositoryMemoryImpl implements BookRepository {
    @Override
    public Book[] findAll() {
        return new Book[0];
    }

    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public Book create(Book book) {
        return null;
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
