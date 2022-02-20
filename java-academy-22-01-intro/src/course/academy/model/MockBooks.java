package course.academy.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MockBooks {
    public static final Book[] MOCK_BOOKS;
    static {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        MOCK_BOOKS = new Book[]{
                new Book("Thinking in Java", "Bruce Eckel", LocalDate.parse("10.02.2006", dtf),
                        "Pearson", 35.5, "Detailed introduction to Java programming."),
                new Book("Effective Java", "Joshua Bloch", LocalDate.parse("27.12.2017", dtf),
                        "Addison-Wesley Professional", 35.5, "In depth Java book."),
                new Book("Java: The Complete Reference", "Herbert Schildt ",
                        LocalDate.parse("12.12.2018", dtf), "McGraw-Hill Education", 51.85),
                new Book("Thinking in Java", "Bruce Eckel", LocalDate.parse("10.02.2006", dtf),
                        "Pearson", 35.5, "Detailed introduction to Java programming."),
                new Book("Effective Java", "Joshua Bloch", LocalDate.parse("27.12.2017", dtf),
                        "Addison-Wesley Professional", 35.5, "In depth Java book."),
                new Book("Java: The Complete Reference", "Herbert Schildt ",
                        LocalDate.parse("12.12.2018", dtf), "McGraw-Hill Education", 51.85),
                new Book("Thinking in Java", "Bruce Eckel", LocalDate.parse("10.02.2006", dtf),
                        "Pearson", 35.5, "Detailed introduction to Java programming."),
                new Book("Effective Java", "Joshua Bloch", LocalDate.parse("27.12.2017", dtf),
                        "Addison-Wesley Professional", 35.5, "In depth Java book."),
                new Book("Java: The Complete Reference", "Herbert Schildt ",
                        LocalDate.parse("12.12.2018", dtf), "McGraw-Hill Education", 51.85)
        };
    }
}
