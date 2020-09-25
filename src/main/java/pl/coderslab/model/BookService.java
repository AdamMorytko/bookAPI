package pl.coderslab.model;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();
    void addBook(Book book);
    void updateBook(Book book);
    Optional<Book> getBookById(Long id);
    void deleteBook(long id);
}
