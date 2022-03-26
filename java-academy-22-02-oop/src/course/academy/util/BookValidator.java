package course.academy.util;

import course.academy.exception.ConstraintViolation;
import course.academy.exception.ConstraintViolationException;
import course.academy.model.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookValidator {
    public void validate(Book book) throws ConstraintViolationException {
        List<ConstraintViolation> violations = new ArrayList<>();
        var titleLength = book.getTitle().trim().length();
        if(titleLength < 2 || titleLength > 50){
            violations.add(
                    new ConstraintViolation(book.getClass().getName(), "title", book.getTitle(),
                            "Book title length should be between 2 and 50 characters"));
        }
        if(book.getPublishingDate().isAfter(LocalDate.now())){
            violations.add(
                    new ConstraintViolation(book.getClass().getName(), "publishingDate", book.getPublishingDate(),
                            "Publishing date: '" + book.getPublishingDate() + "' should be in the past"));
        }
        if(book.getPrice() < 0){
            violations.add(
                    new ConstraintViolation(book.getClass().getName(), "price", book.getPrice(),
                            "Book price can not be negative"));
        }
        if(violations.size() > 0) {
            throw new ConstraintViolationException("Invalid book field", violations);
        }
    }
}
