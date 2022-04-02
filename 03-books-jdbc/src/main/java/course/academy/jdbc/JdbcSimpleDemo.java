package course.academy.jdbc;

import course.academy.model.Book;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Slf4j
public class JdbcSimpleDemo {
    public static final String SELECT_BOOK_PRICE_LOWER_THAN =
            "select * from `book` where price <= ? ;";
    public void run() throws IOException, ClassNotFoundException, SQLException {
        Properties props = new Properties();
        String dbConfigPath = JdbcSimpleDemo.class.getClassLoader()
                .getResource("jdbc.properties").getPath();
        props.load(new FileInputStream(dbConfigPath));
        log.info("jdbc.properties: {}", props);

        // 1. Load DB Driver
        try {
            Class.forName(props.getProperty("driver"));
        } catch (ClassNotFoundException ex) {
            log.error("DB driver class not found", ex);
            throw ex;
        }
        log.info("DB driver loaded successfully: {}", props.getProperty("driver"));

        // 2. Create DB Connection and 3.Create Statement
        try (var con = DriverManager.getConnection(props.getProperty("url"), props);
             var stmt = con.prepareStatement(SELECT_BOOK_PRICE_LOWER_THAN)) {
            log.info("DB Connection established successfully to schema: {}", con.getCatalog());
            // 4. Set params and execute SQL query
            stmt.setDouble(1, 40.0);
            var rs = stmt.executeQuery();
            // 5. Transform ResultSet to Book
            for(var book : toBooks(rs)){
                System.out.println(book);
            }
        } catch (SQLException ex) {
            log.error("Error creating connection to DB", ex);
            throw ex;
        }

    }

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

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        var demo = new JdbcSimpleDemo();
        demo.run();
    }
}
