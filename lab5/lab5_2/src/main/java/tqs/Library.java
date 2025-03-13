package tqs;

import java.time.LocalDateTime;
import java.util.List;

public class Library {

    private List<Book> store;

    public List<Book> findBooksByAuthor(String author) {
        return store.stream().filter(b -> b.getAuthor().equals(author)).toList();
    }

    public void addBook(Book book) {
        store.add(book);
    }

    public List<Book> findBooks(LocalDateTime start, LocalDateTime end) {
        return store.stream().filter(b -> b.getPublished().isAfter(start) & b.getPublished().isBefore(end)).toList();
    }

}
