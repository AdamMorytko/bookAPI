package pl.coderslab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class);

    @RequestMapping("/helloBook")
    public Book helloBook() {
        Book newBook = new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
        logger.info("Returning new book: {}",newBook);
        return newBook;
    }


}
