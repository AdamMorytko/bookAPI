package pl.coderslab.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService implements BookService{
    private List<Book> books;
    private static Long nextId = 0L;

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(++nextId, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(++nextId, "9788324627738", "Rusz glowa	Java.", "Sierra Kathy, Bates Bert", "Helion",
                "programming"));
        books.add(new Book(++nextId, "9780130819338", "Java 2. Podstawy", "Cay	Horstmann, Gary Cornell", "Helion",
                "programming"));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }
}
