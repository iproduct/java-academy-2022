package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.dao.DaoFactory;
import course.academy.dao.Repository;
import course.academy.dao.UserRepository;

public class DaoFactoryMemoryImpl implements DaoFactory {
    @Override
    public BookRepository createBookRepository() {
        return new BookRepositoryMemoryImpl(new Repository.LongIdGenerator());
    }

    @Override
    public UserRepository createUserRepository() {
        return null;
    }
}
