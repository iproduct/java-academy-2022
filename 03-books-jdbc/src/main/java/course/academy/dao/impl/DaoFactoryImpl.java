package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.dao.DaoFactory;
import course.academy.dao.LongIdGenerator;
import course.academy.dao.UserRepository;

public class DaoFactoryImpl implements DaoFactory {
    @Override
    public BookRepository createBookRepositoryMemory() {
        return new BookRepositoryMemoryImpl(new LongIdGenerator());
    }

    @Override
    public BookRepository createBookRepositoryFile(String dbFileNAme) {
        return new BookRepositoryFileImpl(new LongIdGenerator(), dbFileNAme);
    }

    @Override
    public UserRepository createUserRepository() {
        return null;
    }
}
