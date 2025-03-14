package tqs;

import java.util.Date;

public class Book {

    private final String author;
    private final String title;
    private final Date published;

    public Book(String title, String author, Date published) {
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

    public Date getPublished() {
        return published;
    }

    @Override
    public String toString() {
        return title + ", by " + author + ", published in " + published + ".";
    }

}
