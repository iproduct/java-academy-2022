package course.academy;

import course.academy.dao.BookRepository;
import course.academy.dao.impl.BookRepositoryMemoryImpl;
import course.academy.model.Book;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepositoryMemoryImpl();
    }
}
