package course.academy;

import course.academy.dao.BookRepository;
import course.academy.dao.impl.BookRepositoryJdbc;
import course.academy.jdbc.JdbcSimpleDemo;
import course.academy.service.BookService;
import course.academy.service.impl.BookServiceImpl;
import course.academy.util.BookValidator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static course.academy.util.JdbcUtils.closeConnection;
import static course.academy.util.JdbcUtils.createDbConnection;

public class Main {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        // Read app properties from file
        Properties props = new Properties();
        String dbConfigPath = JdbcSimpleDemo.class.getClassLoader()
                .getResource("jdbc.properties").getPath();
        props.load(new FileInputStream(dbConfigPath));

        // Create DB Connection
        Connection conn = createDbConnection(props);
        BookRepository bookRepo = new BookRepositoryJdbc(conn);
        BookService bookService = new BookServiceImpl(bookRepo, new BookValidator());
        var books = bookService.getAllBooks();
        books.forEach(System.out::println);

        // Close DB connection
        closeConnection(conn);

    }
}
