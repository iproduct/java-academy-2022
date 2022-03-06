package course.academy.service.impl;

import course.academy.dao.BookRepository;
import course.academy.dao.DaoFactory;
import course.academy.exception.InvalidEntityDataException;
import course.academy.exception.NonexistingEntityException;
import course.academy.model.Book;
import course.academy.service.BookService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.regex.Pattern;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepo;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepo = bookRepository;
    }

    @Override
    public Collection<Book> getAllBooks() {
        return bookRepo.findAll();
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
        var titleLength = book.getTitle().trim().length();
        if(titleLength < 2 || titleLength > 50){
            throw new InvalidEntityDataException("Book title length should be between 2 and 50 characters.");
        }
        if(book.getPublishingDate().isAfter(LocalDate.now())){
            throw new InvalidEntityDataException("Book publishing date: '" + book.getPublishingDate() + "' should be in the past.");
        }
        if(book.getPrice() < 0){
            throw new InvalidEntityDataException("Book price can not be negative.");
        }
        return bookRepo.create(book);
    }

    @Override
    public Book updateBook(Book book) throws NonexistingEntityException {
        return bookRepo.update(book);
    }

    @Override
    public Book deleteBookById(Long id) throws NonexistingEntityException {
        return bookRepo.deleteById(id);
    }

    @Override
    public long count() {
        return bookRepo.count();
    }
}
