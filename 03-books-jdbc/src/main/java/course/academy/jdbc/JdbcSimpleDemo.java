package course.academy.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
public class JdbcSimpleDemo {
    public void run() throws IOException, ClassNotFoundException, SQLException {
        Properties props = new Properties();
        String dbConfigPath = JdbcSimpleDemo.class.getClassLoader()
                .getResource("jdbc.properties").getPath();
        props.load(new FileInputStream(dbConfigPath));
        log.info("jdbc.properties: {}", props);

        // 1. Load DB Driver
        try{
            Class.forName(props.getProperty("driver"));
        } catch (ClassNotFoundException ex) {
            log.error("DB driver class not found", ex);
            throw ex;
        }
        log.info("DB driver loaded successfully: {}", props.getProperty("driver"));

        // 2. Create DB Connection
        try(var con = DriverManager.getConnection(props.getProperty("url"), props)) {
            log.info("DB Connection established successfully to schema: {}", con.getCatalog());
        } catch (SQLException ex) {
            log.error("Error creating connection to DB", ex);
            throw ex;
        }

    }
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        var demo = new JdbcSimpleDemo();
        demo.run();
    }
}
