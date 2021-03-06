package course.academy.service.impl;

import course.academy.dao.BookRepository;
import course.academy.exception.ConstraintViolationException;
import course.academy.exception.InvalidEntityDataException;
import course.academy.exception.NonexistingEntityException;
import course.academy.model.Book;
import course.academy.service.BookService;
import course.academy.util.BookValidator;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepo;
    private final BookValidator bookValidator;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepo = bookRepository;
        this.bookValidator = new BookValidator();
    }

    public BookServiceImpl(BookRepository bookRepository, BookValidator bookValidator) {
        this.bookRepo = bookRepository;
        this.bookValidator = bookValidator;
    }

    @Override
    public void loadData() {
        bookRepo.load();
    }

    @Override
    public Collection<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public List<Book> getAllBooks(Comparator<Book> comp) {
        return bookRepo.findAllSorted(comp);
    }

    @Override
    public List<Book> getAllBooksByDate(boolean ascending) {
        return bookRepo.findAllSortedByDate(ascending);
    }

    @Override
    public Book getBookById(Long id) throws NonexistingEntityException{
        var book = bookRepo.findById(id);
        if(book == null) {
            throw new NonexistingEntityException("Book with ID='" + id + "' does not exist.");
        }
        return book;
    }

    @Override
    public Book addBook(Book book) throws InvalidEntityDataException {
        try {
            bookValidator.validate(book);
        } catch (ConstraintViolationException ex) {
            throw new InvalidEntityDataException(
                    String.format("Error creating book '%s'", book.getTitle()),
                    ex
            );
        }
        var newBook = bookRepo.create(book);
        bookRepo.save();
        return newBook;
    }

    @Override
    public Book updateBook(Book book) throws NonexistingEntityException, InvalidEntityDataException {
        try {
            bookValidator.validate(book);
        } catch (ConstraintViolationException ex) {
            throw new InvalidEntityDataException(
                    String.format("Error creating book '%s'", book.getTitle()),
                    ex
            );
        }
        var updated = bookRepo.update(book);
        bookRepo.save();
        return updated;
    }

    @Override
    public Book deleteBookById(Long id) throws NonexistingEntityException {
        var deleted = bookRepo.deleteById(id);
        bookRepo.save();
        return deleted;
    }

    @Override
    public long count() {
        return bookRepo.count();
    }
}
