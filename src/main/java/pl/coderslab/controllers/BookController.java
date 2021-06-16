package pl.coderslab.controllers;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class);
    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "books/all";
    }

    @GetMapping("/{id}")
    Book getBook(@PathVariable long id){
        Optional<Book> book = bookService.getBookById(id);
        return book.orElse(null);
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
