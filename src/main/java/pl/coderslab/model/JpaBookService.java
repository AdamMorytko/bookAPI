package pl.coderslab.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.coderslab.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteBook(long id) {

    }
}
