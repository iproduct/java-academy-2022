package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.model.Book;

public class BookRepositoryMemoryImpl extends AbstractPersistableRepository<Long, Book>
        implements BookRepository {
    public BookRepositoryMemoryImpl(IdGenerator<Long> idGenerator) {
        super(idGenerator);
    }

    @Override
    public void load() {
    }

    @Override
    public void save() {
    }
}
