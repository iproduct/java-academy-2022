package course.academy;

import course.academy.dao.BookRepository;
import course.academy.dao.impl.BookRepositoryJdbc;
import course.academy.jdbc.JdbcSimpleDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static Connection createDbConnection(Properties props) throws IOException, ClassNotFoundException, SQLException {
        // 1. Load DB Driver
        try {
            Class.forName(props.getProperty("driver"));
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        // 2. Create DB Connection and 3.Create Statement
        return DriverManager.getConnection(props.getProperty("url"), props);
    }

    public static  void closeConnection(Connection connection) throws SQLException {
        if(connection != null && !connection.isClosed()){
            connection.close();
        }
    }
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        // Read app properties from file
        Properties props = new Properties();
        String dbConfigPath = JdbcSimpleDemo.class.getClassLoader()
                .getResource("jdbc.properties").getPath();
        props.load(new FileInputStream(dbConfigPath));

        // Create DB Connection
        Connection conn = createDbConnection(props);
        BookRepository bookRepo = new BookRepositoryJdbc(conn);

        // Close DB connection
        closeConnection(conn);
    }
}
