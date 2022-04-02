package course.academy.dao;

public interface DaoFactory {
    BookRepository createBookRepositoryMemory();

    BookRepository createBookRepositoryFile(String dbFileNAme);

    UserRepository createUserRepository();
}
