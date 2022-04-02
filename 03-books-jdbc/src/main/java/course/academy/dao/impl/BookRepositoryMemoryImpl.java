package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.dao.IdGenerator;
import course.academy.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class BookRepositoryMemoryImpl extends AbstractPersistableRepository<Long, Book>
        implements BookRepository {
    private NavigableMap<Integer, List<Book>> booksByDate = new TreeMap<>();

    public BookRepositoryMemoryImpl(IdGenerator<Long> idGenerator) {
        super(idGenerator);
    }

    @Override
    public Book create(Book entity) {
        booksByDate.putIfAbsent(entity.getYear(), new ArrayList<>());
        booksByDate.get(entity.getYear()).add(entity); // index each book by date
        return super.create(entity);
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
