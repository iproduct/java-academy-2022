package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.exception.EntityPersistenceException;
import course.academy.exception.NonexistingEntityException;
import course.academy.jdbc.JdbcSimpleDemo;
import course.academy.model.Book;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Slf4j
public class BookRepositoryJdbc implements BookRepository {
    public static final String SELECT_ALL_BOOKS =
            "select * from `book`;";
    private Connection connection;

    public BookRepositoryJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> findAllSortedByDate(boolean ascending) {
        return null;
    }

    @Override
    public void load() {
    }

    @Override
    public void save() {
    }

    @Override
    public Collection<Book> findAll() throws EntityPersistenceException {
        try(var stmt = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            // 4. Set params and execute SQL query
            var rs = stmt.executeQuery();
            // 5. Transform ResultSet to Book
           return toBooks(rs);
        } catch (SQLException ex) {
            log.error("Error creating connection to DB", ex);
            throw new EntityPersistenceException("Error executing SQL query: " + SELECT_ALL_BOOKS, ex);
        }
    }

    @Override
    public List<Book> findAllSorted(Comparator<Book> comparator) {
        return null;
    }

    @Override
    public Book findById(Long id) {
        return null;
    }

    @Override
    public Book create(Book entity) {
        return null;
    }

    @Override
    public void addAll(Collection<Book> entities) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Book update(Book entity) throws NonexistingEntityException {
        return null;
    }

    @Override
    public Book deleteById(Long id) throws NonexistingEntityException {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    // utility methods
    public List<Book> toBooks(ResultSet rs) throws SQLException {
        List<Book> results = new ArrayList<>();
        while (rs.next()) {
            results.add(new Book(
                    rs.getLong(1),
                    rs.getString("title"),
                    rs.getString("authors"),
                    rs.getInt("year"),
                    rs.getString("publisher"),
                    rs.getDouble("price"),
                    rs.getString("description")
            ));
        }
        return results;
    }

}
