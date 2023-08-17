package csci318.demo.controller;

import csci318.demo.controller.dto.LibraryDto;
import csci318.demo.model.Book;
import csci318.demo.model.Library;
import csci318.demo.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    List<Book> allBooks() {
        return bookService.getAllBooks();
    }


    @GetMapping("/books/{isbn}")
    Book findBook(@PathVariable String isbn){
        return bookService.getBook(isbn);
    }

    @GetMapping("/books/{isbn}/available")
    List<LibraryDto> availableLibraries(@PathVariable String isbn) {
        List<LibraryDto> libraryDtos = new ArrayList<>();
        List<Library> libraries = bookService.getAvailableLibraries(isbn);
        for (Library library: libraries) {
            libraryDtos.add(new LibraryDto(library));
        }
        return libraryDtos;
    }
}
