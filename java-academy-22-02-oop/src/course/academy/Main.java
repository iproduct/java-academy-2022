package course.academy;

import course.academy.dao.BookRepository;
import course.academy.dao.DaoFactory;
import course.academy.dao.impl.DaoFactoryMemoryImpl;
import course.academy.exception.ConstraintViolationException;
import course.academy.exception.InvalidEntityDataException;
import course.academy.exception.NonexistingEntityException;
import course.academy.model.Book;
import course.academy.model.MockBooks;
import course.academy.service.BookService;
import course.academy.service.impl.BookServiceImpl;
import course.academy.view.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        DaoFactory daoFactory = new DaoFactoryMemoryImpl();
        BookRepository bookRepository = daoFactory.createBookRepository();

        BookService bookService = new BookServiceImpl(bookRepository);

        for (Book book : MockBooks.MOCK_BOOKS) {
            try {
                bookService.addBook(book);
            } catch (InvalidEntityDataException e) {
                e.printStackTrace();
            }
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        var invalidBook = new Book("T", "Bruce Eckel", LocalDate.parse("10.02.2023", dtf),
                "Pearson", -35.5, "Detailed introduction to Java programming.");
        try {
            bookService.addBook(invalidBook);
        } catch (InvalidEntityDataException ex) {
            var sb = new StringBuilder(ex.getMessage());
            if (ex.getCause() instanceof ConstraintViolationException) {
                sb.append(", invalid fields:\n");
                var violations = ((ConstraintViolationException) ex.getCause()).getFieldViolations();
                sb.append(violations.stream().map(v -> String.format(" - %s.%s [%s] - %s",
                                v.getType().substring(v.getType().lastIndexOf(".") + 1),
                                v.getField(),
                                v.getInvalidValue(),
                                v.getErrorMessage())
                        ).collect(Collectors.joining("\n"))
                );
            }
            System.out.println(sb);
        }

        // delete books 2 and 4
        try {
            bookService.deleteBookById(2L);
        } catch (NonexistingEntityException e) {
            e.printStackTrace();
        }
//        bookService.deleteBookById(4L);
        // print books
        var pubDateCompDesc = Comparator.comparing(Book::getPublishingDate).reversed();
        bookService.getAllBooks(pubDateCompDesc).forEach(System.out::println);
//                Comparator.<Book, LocalDate>comparing(book -> book.getPublishingDate()).reversed()
//                (book, other) -> other.getPublishingDate().compareTo(book.getPublishingDate())
//        ).forEach(book -> System.out.println(book));

//        Iterator<Book> iter = bookService.getAllBooks().iterator();
//        while(iter.hasNext()){
//            System.out.println(">>> " + iter.next());
//        }
        System.out.println();

        // find book by id
        Book thirdBook = null;
        try {
            thirdBook = bookService.getBookById(3L);
        } catch (NonexistingEntityException e) {
            e.printStackTrace();
        }
        System.out.println(thirdBook);

        // find by id already deleted boook
        try {
            System.out.println(bookService.getBookById(4L));
        } catch (NonexistingEntityException ex) {
            ex.printStackTrace();
        }

        // update thirdBook
        System.out.println();
        thirdBook.setTitle("Third Book");
        thirdBook.setPrice(42);
        try {
            bookService.updateBook(thirdBook);
        } catch (NonexistingEntityException | InvalidEntityDataException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(bookService.getBookById(3L));
        } catch (NonexistingEntityException e) {
            e.printStackTrace();
        }
        System.out.println("Program finished normally.");

        // Create and show main menu
        var menu = new Menu("Main Menu", List.of(
                new Menu.Option("Load Books", new Menu.Command() {
                    @Override
                    public String execute() {
                        System.out.println("Loading books ...");
                        return "Books loaded successfully.";
                    }
                }),
                new Menu.Option("Save Books", new Menu.Command() {
                    @Override
                    public String execute() {
                        System.out.println("Saving books ...");
                        return "Books saved successfully.";
                    }
                })
        ));
//        var exitCommand = menu.new ExitCommand();
//        System.out.println(exitCommand.execute());
        menu.show();
        Stack<Integer> stack = new Stack<Integer>();
    }
}















