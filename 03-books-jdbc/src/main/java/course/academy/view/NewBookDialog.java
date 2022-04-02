package course.academy.view;

import course.academy.model.Book;

import java.time.LocalDate;
import java.util.Scanner;

public class NewBookDialog implements EntityDialog<Book> {
    public static Scanner sc = new Scanner(System.in);

    @Override
    public Book input() {
        var book = new Book();
        while (book.getTitle() == null) {
            System.out.println("Tile:");
            var ans = sc.nextLine();
            if (ans.length() < 3) {
                System.out.println("Error: The book title should be at least 3 characters long.");
            } else {
                book.setTitle(ans);
            }
        }
        while (book.getAuthors() == null) {
            System.out.println("Authors (comma separated):");
            var ans = sc.nextLine();
            if (ans.length() < 3) {
                System.out.println("Error: The book authors should be at least 3 characters long.");
            } else {
                book.setAuthors(ans);
            }
        }
        while (book.getYear() == 0) {
            System.out.println("Publishing date (ex. 12.03.2022):");
            String ans;
            int year = 0;
            ans = sc.nextLine();
            try {
                year = Integer.parseInt(ans);
            } catch (NumberFormatException ex) {
                System.out.println("Error: Invalid year format - numbers only.");
            }
            if (year < 1500 || year > LocalDate.now().getYear()) {
                System.out.println("Error: Invalid year - try again.");
            } else {
                book.setYear(year);
            }
        }
        return book;
    }
}
