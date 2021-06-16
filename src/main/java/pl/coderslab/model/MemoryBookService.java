package pl.coderslab.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService implements BookService {
    private List<Book> books;
    private static Long nextId = 0L;

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(++nextId, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(++nextId, "9788324627738", "Rusz glowa Java.", "Sierra Kathy, Bates Bert", "Helion",
                "programming"));
        books.add(new Book(++nextId, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
                "programming"));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return books.stream()
                .filter(b -> b.getId().equals(id)).findFirst();
    }

    @Override
    public void deleteBook(long id) {
        books.removeIf(b -> b.getId().equals(id));
    }

    @Override
    public void addBook(Book book) {
        book.setId(++nextId);
        books.add(book);
    }

    @Override
    public void updateBook(Book book) {
        Long id = book.getId();
        Optional<Book> bookToUpdate = books.stream()
                .filter(b -> b.getId().equals(id)).findFirst();
        bookToUpdate.ifPresent(b -> b.setTitle(book.getTitle()));
        bookToUpdate.ifPresent(b -> b.setAuthor(book.getAuthor()));
        bookToUpdate.ifPresent(b -> b.setType(book.getType()));
        bookToUpdate.ifPresent(b -> b.setPublisher(book.getPublisher()));
    }

}
