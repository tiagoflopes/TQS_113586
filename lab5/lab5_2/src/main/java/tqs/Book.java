package tqs;

import java.time.LocalDateTime;

public class Book {

    private final String author;
    private final String title;
    private final LocalDateTime published;

    public Book(String author, String title, LocalDateTime published) {
        this.author = author;
        this.title = title;
        this.published = published;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getPublished() {
        return published;
    }

    @Override
    public String toString() {
        return title + ", by " + author + ", published in " + published + ".";
    }

}
