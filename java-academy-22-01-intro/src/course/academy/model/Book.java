package course.academy.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class Book {
    private int id;
    private String title;
    private String author;
    private LocalDateTime publishingDate;
    private String publisher;
    private double price;
    private String description;

    public Book(int id, String title, String author, LocalDateTime publishingDate, String publisher, double price, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingDate = publishingDate;
        this.publisher = publisher;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishingDate() {
        return Date.from(publishingDate.toInstant(ZoneOffset.UTC));
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = LocalDateTime.ofInstant(publishingDate.toInstant(), ZoneOffset.UTC);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishingDate=" + publishingDate +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        return getId() == book.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    public static void main(String[] args) {

    }
}
