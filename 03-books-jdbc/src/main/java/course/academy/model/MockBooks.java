package course.academy.model;

import java.time.format.DateTimeFormatter;

public class MockBooks {
    public static final Book[] MOCK_BOOKS;
    static {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        MOCK_BOOKS = new Book[]{
                new Book("Thinking in Java", "Bruce Eckel", 2006,
                        "Pearson", 35.5, "Detailed introduction to Java programming."),
                new Book("Effective Java", "Joshua Bloch",2017,
                        "Addison-Wesley Professional", 35.5, "In depth Java book."),
                new Book("Java: The Complete Reference", "Herbert Schildt ",
                       2018, "McGraw-Hill Education", 51.85),
                new Book("Thinking in Java", "Bruce Eckel", 2006,
                        "Pearson", 35.5, "Detailed introduction to Java programming."),
                new Book("Effective Java", "Joshua Bloch", 2017,
                        "Addison-Wesley Professional", 35.5, "In depth Java book."),
                new Book("Java: The Complete Reference", "Herbert Schildt ",
                        2018, "McGraw-Hill Education", 51.85),
                new Book("Thinking in Java", "Bruce Eckel", 2006,
                        "Pearson", 35.5, "Detailed introduction to Java programming."),
                new Book("Effective Java", "Joshua Bloch",2017,
                        "Addison-Wesley Professional", 35.5, "In depth Java book."),
                new Book("Java: The Complete Reference", "Herbert Schildt ",
                        2018, "McGraw-Hill Education", 51.85),
                new Book("Java: The Complete Reference", "Herbert Schildt ",
                        2018, "McGraw-Hill Education", 51.85),
                new Book("Thinking in Java", "Bruce Eckel",2006,
                        "Pearson", 35.5, "Detailed introduction to Java programming."),
                new Book("Effective Java", "Joshua Bloch", 2017,
                        "Addison-Wesley Professional", 35.5, "In depth Java book."),
                new Book("Java: The Complete Reference", "Herbert Schildt ",
                        2018, "McGraw-Hill Education", 51.85)
        };
    }
}
