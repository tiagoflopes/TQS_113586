package tqs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Library {

    private final List<Book> store = new ArrayList<>();

    public void addBook(Book book) {
        store.add(book);
    }

    public List<Book> findBooks(Date start, Date end) {
        return store.stream().filter(b -> b.getPublished().after(start) & b.getPublished().before(end)).toList();
    }

    public List<Book> findBooksByAuthor(String author) {
        return store.stream().filter(b -> b.getAuthor().equalsIgnoreCase(author)).toList();
    }

    public List<Book> findBooksByTitle(String title) {
        return store.stream().filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase())).toList();
    }

}
