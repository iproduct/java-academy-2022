package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.dao.IdGenerator;
import course.academy.model.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class BookRepositoryFileImpl extends PersistableRepositoryFileImpl<Long, Book>
        implements BookRepository {
    private NavigableMap<LocalDate, List<Book>> booksByDate = new TreeMap<>();

    public BookRepositoryFileImpl(IdGenerator<Long> idGenerator, String dbFileName) {
        super(idGenerator, dbFileName);
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
}
