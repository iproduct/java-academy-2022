package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.dao.exception.InvalidRepositoryStateException;
import course.academy.model.Book;

import java.util.Arrays;

class BookRepositoryMemoryImpl implements BookRepository {
    public static final int INITIAL_CAPACITY = 8;
    private static long nextId = 0;
    private Book[] books;
    private int len = 0;

    public BookRepositoryMemoryImpl() {
        books = new Book[INITIAL_CAPACITY];
    }

    public BookRepositoryMemoryImpl(int initialCapacity) {
        books = new Book[initialCapacity];
    }

    @Override
    public Book[] findAll() {
        return Arrays.copyOf(books, len);
    }

    @Override
    public Book findById(Long id) {
        int index = findIndexById(id);
        if (index < 0) return null;
        return books[index];
    }

    @Override
    public Book create(Book book) throws InvalidRepositoryStateException {
        if (len >= books.length) {
            resizeRepository();
//            throw new InvalidRepositoryStateException(
//                    "Repository full (capacity=" + books.length + ")");
        }
        book.setId(++nextId);
        books[len] = book;
        len++;
        return book;
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

    private int findIndexById(Long id) {
        return Arrays.binarySearch(books, new Book(id));
    }

    private void resizeRepository() {
        books = Arrays.copyOf(books, 2 * books.length);
        System.out.println("Repository buffer resized. New size: " + books.length);
    }
}










