package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.model.Book;

import java.time.LocalDate;
import java.util.*;

public class BookRepositoryMemoryImpl extends AbstractPersistableRepository<Long, Book>
        implements BookRepository {
    private NavigableMap<LocalDate, List<Book>> booksByDate = new TreeMap<>();

    public BookRepositoryMemoryImpl(IdGenerator<Long> idGenerator) {
        super(idGenerator);
    }

    @Override
    public Book create(Book book) {
        booksByDate.putIfAbsent(book.getPublishingDate(), new ArrayList<>());
        booksByDate.get(book.getPublishingDate()).add(book); // index each book by date
        return super.create(book);
    }

    @Override
    public List<Book> findAllSortedByDate(boolean ascending) { // O(1)
        var valuesMap =  booksByDate;
        if(!ascending) {
           valuesMap = valuesMap.descendingMap();
        }
        System.out.println("Book.findAllSorted() called.");
        List<Book> results = new ArrayList<>();
        for(List<Book> listByDate: valuesMap.values()){
            results.addAll(listByDate);
        }
        return results;
    }

    @Override
    public void load() {
    }

    @Override
    public void save() {
    }
}
