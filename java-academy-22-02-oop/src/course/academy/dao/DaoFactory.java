package course.academy.dao;

import course.academy.dao.BookRepository;
import course.academy.dao.UserRepository;

public interface DaoFactory {
    BookRepository createBookRepository();
    UserRepository createUserRepository();
}
