package course.academy.model;

import course.academy.dao.Identifiable;

import java.io.Serializable;

public class Book implements Comparable<Book>, Identifiable<Long>, Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String title;
    private String authors;
    private int year;
    private String publisher;
    private double price;
    private String description;

    // Overloaded constructors
    // No args constructor
    public Book() {
    }

    public Book(Long id) {
        this.id = id;
    }

    // Required args constructor
    public Book(String title, String author, int publishingDate, String publisher, double price) {
        this.title = title;
        this.authors = author;
        this.year = publishingDate;
        this.publisher = publisher;
        this.price = price;
    }

    public Book(String title, String author, int publishingDate, String publisher, double price, String description) {
        this(title, author, publishingDate, publisher, price);
        this.description = description;
    }

    public Book(Long id, String title, String authors, int year, String publisher, double price, String description) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.publisher = publisher;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
        if(description == null){
            description = "id=" + id +
                    ", title='" + title + '\'' +
                    ", author='" + authors + '\'' +
                    ", publishingDate=" + year +
                    ", publisher='" + publisher + '\'' +
                    ", price=" + price;
        }
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
                ", author='" + authors + '\'' +
                ", publishingDate=" + year +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", description='" + getDescription() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        return getId() != null ? getId().equals(book.getId()) : book.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public int compareTo(Book other) {
        return getId() < other.getId() ? -1 : getId() == other.getId() ? 0 : 1;
//        return Long.compare(getId(), other.getId());
    }
}
