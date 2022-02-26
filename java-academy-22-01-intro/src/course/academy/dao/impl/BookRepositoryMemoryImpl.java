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
        int index = findIndexById(id);
        if(index < 0) return null;
        return books[index];
    }

    @Override
    public Book create(Book book) throws InvalidRepositoryStateException {
        if(len < MAX_BOOKS){
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
        int index = findIndexById(book.getId());
        if(index < 0) {
            return null;
        }
        books[index] = book;
        return book;
    }

    @Override
    public Book deleteById(int id) {
        int index = findIndexById(id);
        if(index < 0) {
            return null;
        }
        Book removed = books[index];
        for(;index < len-1; index ++) {
            books[index] = books[index + 1];
        }
        len --;
        return removed;
    }

    @Override
    public int count() {
        return len;
    }

    private int findIndexById(int id){
        return Arrays.binarySearch(books, new Book(id));
    }
}










