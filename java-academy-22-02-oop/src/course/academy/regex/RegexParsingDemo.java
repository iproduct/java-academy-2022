package course.academy.regex;


import course.academy.model.Book;

import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static course.academy.model.MockBooks.MOCK_BOOKS;

public class RegexParsingDemo {
    public static void main(String[] args) {
        var dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        StringBuilder sb = new StringBuilder();
        for (Book book : MOCK_BOOKS) {
            String data = String.format("Published: %d, Book '%s' [%1$s].", book.getYear(), book.getTitle());
            Pattern pattern = Pattern.compile("(?<day>\\d{2}).(?<month>\\d{2}).(?<year>\\d{4})");
            Matcher matcher = pattern.matcher(data);
//            int from = 0;
            while(matcher.find(/*from*/)) {
                System.out.print(data+ ": ");
                for(int i = 0; i <= matcher.groupCount(); i++)
                    System.out.printf("%d -> %s [%d, %d],  ", i, matcher.group(i), matcher.start(i), matcher.end(i));
                System.out.println();
//                from = matcher.end();
//                sb.append(String.format("| %-30.30s | %2s | %2s | %4s |%n",
//                        book.getTitle(), matcher.group("day"),
//                        matcher.group("month"), matcher.group("year")));
            }
        }
        System.out.println(sb.toString());
    }
}
