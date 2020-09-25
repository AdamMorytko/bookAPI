package pl.coderslab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class);
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    List<Book> getList() {
        List<Book> list = bookService.getBooks();
        logger.info("Returning books: {}",list);
        return list;
    }

    @PostMapping("")
    void addBook(@RequestBody Book book) {
        bookService.addBook(book);
        logger.info("Created new book");
    }

    @PutMapping("")
    void updateBook(@RequestBody Book book) {
        logger.info("Updating book: {} with {}",bookService.getBookById(book.getId()),book);
        bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable long id) {
        logger.info("Deleting book: {}", bookService.getBookById(id));
        bookService.deleteBook(id);
    }


}
