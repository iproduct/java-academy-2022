package course.academy.dao.impl;

import course.academy.dao.*;

public class DaoFactoryMemoryImpl implements DaoFactory {
    @Override
    public BookRepository createBookRepository() {
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
